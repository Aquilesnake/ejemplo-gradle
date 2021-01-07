# Getting Started

## Windows

### Tasks List
* gradle task

### Compile Code/Test/Jar
* gradle clean build

### Test Code
* gradle test

### Run Jar
* Local:      gradle bootRun
* Background: start gradle bootRun

### Testing Application
* Abrir navegador: http://localhost:8082/rest/mscovid/estadoMundial

## Linux

### Compile Code
* ./mvnw clean compile -e

### Test Code
* ./mvnw clean test -e

### Jar Code
* ./mvnw clean package -e

### Run Jar
* Local:      ./mvnw spring-boot:run 
* Background: nohup bash mvnw spring-boot:run &

### Testing Application
* curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'
