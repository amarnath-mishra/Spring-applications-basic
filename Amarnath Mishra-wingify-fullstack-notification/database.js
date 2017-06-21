var mysql       = require("mysql");
var express     = require("express");
var application         = express();
var http        = require("http").Server(application);
var socket      = require("socket.io")(http);
var conn = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',   //please enter your MySQL username here
  password : '',    //please enter your MySQL password here
  database : 'notificationApp'    //please enter your database name here
});

module.exports = conn;
