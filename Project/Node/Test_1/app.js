var http = require('http');

var server = http.createServer(function(req,res) {
    /*
        HTTP 헤더 전송
        HTTP Status : 200 (성공)
        COntent Type : text/plain
    */
    res.writeHead(200, {'Content-Type' : 'text/plain'});
    
    /*
        Response Body 에 "Hello World"
    */
    res.end('Hello World');
});

server.listen(8000);
