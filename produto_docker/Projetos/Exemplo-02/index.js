var express = require('express');
var cors = require('cors');
var app = express();

app.use(cors());

app.get('/listUsers', function (req, res) {
   let user = {
    nome: "José",
    data: new Date()
   }
   res.end(JSON.stringify(user));
})

var server = app.listen(8080, function () {
   var host = server.address().address
   var port = server.address().port
   console.log("Example app listening at http://%s:%s", host, port)
})