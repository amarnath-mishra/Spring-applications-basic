
mainApp.controller('studentController',['$scope','$http', function($scope,$http)
{                              /*This is App's Controller for module declared in MyAppModules.js */
  var socket = io();
  $scope.notiArray = [];   //Array to store all notifications.
  $scope.notiArrayLen = 0;

  /*Start listening for server sent event -"Add_NewNotification" and trigger the attached callback function when this event is recieved. */
  socket.on('Add_NewNotification', function(data){

    var newNoti  = data.username+" "+data.action + " " + data.target+" at "+ data.dateandtime;
    //Using splice, inserting the new notification in front of notiArray, so that it will be shown at top.
    $scope.notiArray.splice(0,0,{data: newNoti, color: {'background-color':'#e1e6ed'},imgURL:data.image});
    $scope.notiArrayLen = $scope.notiArrayLen + 1;
    $scope.$apply();

  //  console.log($scope.notiArray);
});


var flag=0;

/* This functions gets triggered when the bell is clicked ,and it sets the bell count again to Zero, 
 marks all unread notifications to again read, and changes their background-color a bit darker.*/ 
$scope.ChangeToRead_SetCountZero = function(l,lenArray) {
      lenArray = lenArray - 1;
      console.log(l + " " + lenArray);
      for (var i = 0; i < lenArray; i++) {
        console.log(i + "in loop " );
        v = $scope.notiArray[i].color;
        if(v["background-color"] =='#e1e6ed')
        {
            v["background-color"] = "#adbdce";    //changing the background-color from unread to read.
          }
          else{
            i=lenArray;
          }
      }
    $http({
         method : "POST",              /* Sending HTTP post request to server to set notification as read in the database  */
         url : "/ChangeNotificationStatus"
       }).then(function mySucces(response) {
           $scope.notiArrayLen = 0;
         }, function myError(response) {
           console.log(" got Error while sending request to server ");
       });
}

/*This functions gets triggered whenever a new client joins and then if no (or < 5 ) notifications
are their in database, then it shows some example default notifications to the client first till new notifications arrives.(For better experience) */

var IfNoNotification_GetIt = function() {
 var i=$scope.notiArray.length;
  if(i<5)        /* Adding 5 example defalut new notifications in beggining of notiArray (if no (or < 5 ) notification are their in database initially) */
  {
   $scope.notiArray.splice(0,0,{data: "Narendra Modi shared your question at 16:16:8", color: {'background-color':'#adbdce'},imgURL:"/images/NarendraModiPic.jpg"});
   $scope.notiArray.splice(0,0,{data: "Saina Nehwal shared your dance at 15:36:4", color: {'background-color':'#adbdce'},imgURL:"/images/SainaNehwalPic.jpg"});
   $scope.notiArray.splice(0,0,{data: "Bill Gates upvoted your question at 15:20:2", color: {'background-color':'#adbdce'},imgURL:"/images/BillGates_pic.jpg"});
   $scope.notiArray.splice(0,0,{data: "Mark Zuckerberg liked your profile at 15:10:4", color: {'background-color':'#adbdce'},imgURL:"/images/MarkZuckerbergPic.jpg"});
   $scope.notiArray.splice(0,0,{data: "Saina Nehwal liked your badminton at 14:36:4", color: {'background-color':'#adbdce'},imgURL:"/images/SainaNehwalPic.jpg"});
   i=5;
  }
}

IfNoNotification_GetIt();


/*This Function gets triggered whenever a new clients joins and pushes all already stored notifications in database in
 beggining of notiArray and shows it to clients*/
var getAllStoredNotificationOnce = function() {
       $.ajax({                          /* Sending an ajax request to server to get all notifications stored */
           url   : "/getAllStoredNotification",
            dataType : 'json',
            type : 'GET',
           success  : function(response) {
          //   console.log("got response");
            for(var i=0; i<response.length; i++) {
            var newNoti  = response[i].username+" "+response[i].action + " " + response[i].target+" at "+ response[i].dateandtime;
              $scope.notiArray.splice(0,0,{data: newNoti, color: {'background-color':'#adbdce'},imgURL:response[i].image});
              if(response[i].status==1)
              {
                $scope.notiArrayLen = $scope.notiArrayLen + 1;   /* Setting bell count as number of unread messages exists in database */
              //  console.log( "len is " + $scope.notiArrayLen );
              }
              }
           }
       });
   }

        getAllStoredNotificationOnce();

/* This function gets triggered whenever client hover their mouse over any notification */
         $scope.mouseOverX = function(thing) {
                 $scope.msgg =  thing;
             }
}
]);