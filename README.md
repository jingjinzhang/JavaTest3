1.git clone https://github.com/jingjinzhang/JavaTest3.git
2.进入JavaTest3
3.执行sh build.sh(已导入sql,但是还没执行) 我是手动进入 docker exec 进入mysql
mysql -u root -p
没有密码
 然后
mysql < /mysql/sakila-schema.sql;
mysql < /mysql/sakila-data.sql;
4.start.sh
