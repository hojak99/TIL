/**
 * require('express') : express 모듈 사용
 * require('bodyParser') : bodyParser 모듈 사용 - POST 요청 데이터 추출 할 수 있도록 해줌. req 에 body 프로퍼티 사용 가능
 * require('method-override') : HTTP 메소드 재정의를 위함
 * require('mysql') : mysql 연결을 위한 모듈
 */

var express = require('express');       
var bodyParser = require('body-parser');
var methodOverride = require('method-override');
var mysql_dbc = require('../Board_Example/db/config/db_con')();

var app = express();
var connection = mysql_dbc.init();

// Server setting
var server = app.listen(3000, function() {
    var host = server.address.address;
    var port = server.address.port;

    console.log('앱은 http://%s:%s 에서 작동 중입니다.', host, port);
    mysql_dbc.connection(connection);
});

// Routes
app.get('/', function(req, res) {
    res.send('Hello World');
});