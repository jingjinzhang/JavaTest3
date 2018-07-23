FROM registry.saas.hand-china.com/tools/mysql:5.6

#设置免密登录
ENV MYSQL_ALLOW_EMPTY_PASSWORD yes

#将所需文件放到容器中
COPY docker/mysql/setup.sh /mysql/setup.sh
COPY docker/mysql/sakila-data.sql /mysql/sakila-data.sql
COPY docker/mysql/sakila-schema.sql /mysql/sakila-schema.sql

ENV MYSQL_USER root MYSQL_PASS 123456

EXPOSE 3306


