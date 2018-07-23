docker build -t docker-mysql .

docker run -d --name mysqltest -p 3306:3306 -d docker-mysql





