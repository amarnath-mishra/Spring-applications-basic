var express     = require("express");
var bodyParser  = require("body-parser");
var mysql       = require("mysql");
var application    = express();
var http        = require("http").Server(application);
var socket      = require("socket.io")(http);
var respTime    = require("response-time");
var debug = require('debug')('mynotifyapp:server');
var statsD      = require("node-statsd");
var DB_connection  = require('./database');          /* To get the exported module of database.js */



var date = new Date();      // to get current hour, minute and second of posted notification
var id_num=1;
var statsVariable = new statsD();
var current_hour = date.getHours();

                          // Finally connecting to database declared in database.js
DB_connection.connect(function(err) {
    if(err){
          console.log("Error while connecting to database: ", err);
      }
    else{
        console.log("Database is connected !!");

        socket.on('connection', function(sock) {
            console.log("Client Connected !!");
            (function repeat_itself() {
                setTimeout(function() {
				        var newnoti = getNewNotification();

         /*Getting the new newNotification generated in function getNewNotification and stroing it new a varibale newNotification
         in such a manner so that it can be inserted to our MySQL table */

 var newNotification= {id: id_num++,username: newnoti.user.name,action:newnoti.action,target:newnoti.target,dateandtime:newnoti.timestamp, status: 1,image:newnoti.user.imageLocation}
              /*  Table name is - notitable   */
 DB_connection.query('insert into notitable set ?', newNotification, function(err, result) {
                if(err) {
                             console.log("Error inserting data to table: ", err);
                         }
                  else {
                            console.log("New notification added in database ");
                            /* Emitting the newly added notification for which client is also listening for this event on other side */
                            socket.emit('Add_NewNotification', newNotification);
                        }
                     });repeat_itself();   // Calling back the same function
                }, 6000);                  //6000 mili seconds
            }());
        });
    }

});



//generating a random number between 0 and 3 to select random polling data
var getRandomNo = function(){
    return Math.floor(Math.random() * 4);
};


// Eaxh time new notification is generated by choosing random user (to get their name and image ),action and targets from this notification
	var Data_NewNotification = {
	    users : [
        {
				    imageLocation: "/images/BillGates_pic.jpg",    //stored under images directory
		        name: "Bill Gates"
		    },
		    {
				    imageLocation: "/images/NarendraModiPic.jpg",
		        name: "Narendra Modi"
		    },
		    {
		        name: "Saina Nehwal",
		        imageLocation: "/images/SainaNehwalPic.jpg"
		    },
        {
		        name: "Mark Zuckerberg",
		        imageLocation: "/images/MarkZuckerbergPic.jpg"
		    }
	    ],

        TargetOfAction: ["your dance","your answer", "your post", "your question"],
	      actionDone: ["upvoted ","shared ", "promoted " ,"liked, shared "]

	};


	//generates new notifications using objects and returns data for a new notification
	var getNewNotification = function(){
		var userId = getRandomNo();
    var TargetId = getRandomNo();
		var actionId = getRandomNo();
		var new_Notification = {
			user: Data_NewNotification.users[userId],
      target: Data_NewNotification.TargetOfAction[TargetId],
			action: Data_NewNotification.actionDone[actionId],
			timestamp: date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()
		}
		return new_Notification;
	};   /* To send all notification prevoisly stored in Database to new connected client */
application.get("/getAllStoredNotification", function(req, res) {
    DB_connection.query('select * from notitable', function(err, rows) {
        if(err) {
          console.log("Error while sending all notifications  :" + err);
          res.json({"code" : err.code, "status": err.status});
          return;
        }
        else {
            res.json(rows);
        }
    });
});


application.use(express.static(__dirname+ '/'));   /* Setting the dafault place from where the application will look for path of different
                                suppoerted files like CSS , JavaScript , images etc*/
application.get("/", function(req, res) {
    res.sendFile(__dirname + '/index.html');
});


/* This will be invoked when bell is clicked and server will get a post request from client side
 changing all notifications status from 1 to 0, means unread to read */
application.post('/ChangeNotificationStatus', function(req, res) {

    DB_connection.query('update notitable SET status = 0', function(err, row) {
        if(err) {
              console.log(err);
              res.json({"code" : err.code, "status": err.status});
        }
         else {
          console.log('Notification count is set to zero !!');
          res.json({"code": 200, "status": "OK"});
        }
        return;
    });
});

/* Parsing incoming request bodies in middleware using body-parser (Node.js body parsing middleware) */
application.use(bodyParser.urlencoded({ extended: false }));
application.use(bodyParser.json());

/* for recording the response time for request in our HTTP Server  */
 application.use(respTime(function(req, res, time) {
     var s = (req.method + req.url).toLowerCase().replace(/[:\.]/g, '').replace(/\//g, '_');
     statsVariable.timing(s, time);
 }));

 /* Finally Setting up our server to listen at port 3000  */
var myserver = http.listen(3000, function () {
   var host = myserver.address().address
   var port = myserver.address().port
   console.log("App listening at http://%s:%s", host, port)

});