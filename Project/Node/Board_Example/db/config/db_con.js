var mysql = require('mysql');

module.exports = function() {
    return {
        init : function () {
            return mysql.createConnection({
                host: 'localhost',
                port: '3306',
                user: 'root',
                password : '0430',
                database : 'board_node'
            })
        },

        connection: function(con) {
            con.connect(function(err) {
                if(err) {
                    console.log('mysql connection error : '+ err);
                } else {
                    console.log('mysql is connected successfully');
                }
            })
        }
    }
};