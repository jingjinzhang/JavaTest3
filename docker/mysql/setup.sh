#!/bin/bash

service mysql start

mysql < /mysql/sakila-schema.sql;

mysql < /mysql/sakila-data.sql;

