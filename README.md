# Adansa

Adansa is an attempt for a simple yet robust application covering mostly basic business function.

### Prerequisite
1. Git 
2. MySQL
3. JDK 8
4. Apache Maven
5. OPTIONAL: Spring Tool Suite / Eclipse with STS Plugin 3.7

### Installation
#### 1. Install Database
Create Login Role with following attributes:
* Username : adansa
* Password : adansa

After that, create also a database with the same name:  adansa

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
