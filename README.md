# BookShop

This project simulate a book shop; where you can add, view, update, delete and purchase the books.
The technologies used are:
Java
Servlet
JSP
Html
Bootstrap

Reqirements:
1. JDK 8 or above.
2. Apache Tomcat server v8.5 or above.
3. MySql 5 or above database with Username: root and Password: root

How to run:
-> This is a Eclipse IDE project.
-> It can be cloned and imported directly into the Eclipse.
-> Add the server.
-> In MySql database, execute quries given bellow:
    (a) create schema test;
    (b) use test;
    (c) create table books(
        id int primary key,
          name varchar(50),
          author varchar(50),
          price int,
          quantity int,
          course text
        );
 -> Click on project and select 'Run as' then 'Run on Server', Select the added server and click Finish.
 -> After some processing, you will be redirected to the book upload page of the project.
