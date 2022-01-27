# TeamProject2022_21
## Stack
* Back-end: Java
* Front-end: HTML + CSS + Javascript
* Database: Postgres SQL
* Package manager: Maven
* Framework: Spring

## Software installation requirements
* Java - version 11 or later
* Maven - version 3.8.4 or later (preferred - earlier version may work.)
* Postgres SQL - version 12 or later 

## Installation guide 
* Ensure that the required software are installed in the machine.
* open a new terminal at the sql folder ("cd .../sql").
  * log into your postgres account.
  * import schema.sql file in postgres using the command "\i schema.sql".
* update the application properties file in the resources with the database url, username and password.
* open a new terminal in the project folder.
  * run the command "mvn spring-boot:run"
* view the webpages on the web address "http://localhost:8080/" in the browser.
