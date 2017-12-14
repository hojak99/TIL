var express = require('express');
var mysql_dbc = require('../Board_Example/db/db_con')();
var app = express();
var connection = mysql_dbc.init();

app.get('/', function(req, res) {
    res.send('Hello World');
});

var server = app.listen(3000, function() {
    var host = server.address.address;
    var port = server.address.port;

    console.log('앱은 http://%s:%s 에서 작동 중입니다.', host, port);
});

mysql_dbc.test_open(connection);