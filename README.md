# Adansa [![Build Status](https://secure.travis-ci.org/anteknik/adansa.png?branch=master)](https://travis-ci.org/anteknik/adansa)
Adansa is an attempt for a simple yet robust application covering mostly basic business function.

### Prerequisite
1. Git 
2. MySQL
3. JDK 8
4. Apache Maven
5. OPTIONAL: Spring Tool Suite / Eclipse with STS Plugin 3.7

### Installation
#### Install Database
        
 Create a database with the same name:  adansa

Login Role with following attributes:
* Username : admin
* Password : admin

You can use command-line for starter, but it is highly recommended to use Eclipse / STS as your IDE.
* 2.1 Command Line
Clone the project:
```sh
$ git clone https://github.com/anteknik/adansa.git
```
Go to your project directory and type:
```sh
$ mvn spring-boot:run -Dspring.profiles.active=liquibase
```
* 4.s Eclipse / STS 3.7
