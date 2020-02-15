# BookShop

This project simulate a book shop; where you can add, view, update, delete and purchase the books.
The technologies used are:
1. Java
2. Servlet
3. JSP
4. Html
5. Bootstrap

Reqirements:
1. JDK 8 or above.
2. Apache Tomcat server v8.5 or above.
3. MySql 5 or above database with Username: root and Password: root

How to run:
1. This is a Eclipse IDE project.
2. It can be cloned and imported directly into the Eclipse.
3. Add the server.
4. In MySql database, execute quries given bellow:
    1. create schema test;
    2. use test;
    3. create table books(
        id int primary key,
          name varchar(50),
          author varchar(50),
          price int,
          quantity int,
          course text
        );
 5. Click on project and select 'Run as' then 'Run on Server', Select the added server and click Finish.
 6. After some processing, you will be redirected to the book upload page of the project.
