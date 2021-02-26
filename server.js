var http = require('http');
http.createServer(function(req,res){
        res.writeHead(200, { 'Content-Type': 'text/plain' });
        res.end('Hello World ! this is a simple node js application');
}).listen(8070);
console.log('Server started on localhost:8080; press Ctrl-C to terminate...!');
