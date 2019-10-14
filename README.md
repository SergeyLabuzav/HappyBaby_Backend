#Happy Baby Backend Structure

**Modules**

###### Infrastructure modules:
* Eureka Service
* Zuul Proxy

###### Custom modules:
* Auth Service
* Baby Service

**Lombok configuration for IntelliJ IDEA:**
1) Install Lombok Plugin

Settings (Ctrl + Alt + S) / Plugin / Browse repositories / Type 'Lombok Plugin' and install it

2) Enable annotation processing 

Settings (Ctrl + Alt + S) / Build, Execution, Deployment / Compiler / Annotation Processors / Enable annotation processing 

**Postgresql Configuration:**
1) Create *`auth`* database: `create database auth;`
2) Create *`baby`* database: `create database baby;`

**Project Configuration:**
1) Update **_username_**, **_password_** fields in `application.yml`
