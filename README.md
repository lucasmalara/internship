
# INTERNSHIP ADB

<p align="justify">
This repository contains projects that are outcome of my work placement 
(as a part of my first-cycle studies) in <b>ADB POLSKA SP. Z O.O. (ZIELONA GORA OFFICE)</b> 
that took place in <b>July 2021</b>. In the process of work placement I have been introduced to foundations of 
<code>Spring framework</code>. The culmination of work was to implement an example of simple <code>REST API</code>.</p>

<p align="justify">
Note that this is not original repository I was working on during work placement. Projects included here has been 
improved in terms of code quality after self-reviewing the code. However, the general idea of the projects remained the same. 
Dependencies were updated since the creation of each project, but only up to a certain point.
</p>

## LIST OF PROJECTS

- EX1-BEANS
- EX2-BEANS
- EX3-SCHEDULING
- EX4-STREAM-API-JUNIT-TESTS
- EX5-EXPERIMENTAL-GET-MAPPING
- EX6-H2-STUDENTS
- EX7-RESTAPI-H2-BUSSES

## TABLE OF CONTENT

- **EX1-BEANS**
  - Project Details
  - Dependencies
- **EX2-BEANS**
  - Project Details
  - Dependencies
- **EX3-SCHEDULING**
  - Project Details
  - Dependencies
- **EX4-STREAM-API-JUNIT-TESTS**
  - Project Details
  - Class Hierarchy Tree
  - Dependencies
- **EX5-EXPERIMENTAL-GET-MAPPING**
  - Project Details
  - API Reference
  - RegEx Details
  - About Further Formatting `name`
  - API Response Examples
  - Dependencies
- **EX6-H2-STUDENTS**
  - Project Details
  - Screenshots
  - Dependencies
- **EX7-RESTAPI-H2-BUSSES**
  - Project Details
  - API Reference
  - RegEx Details
  - API Response Examples
  - Screenshots
  - Dependencies


## EX1-BEANS

<p align="justify">
This project was focused on presentation of application of <code>inversion of control (IoC)</code> using simple 
<b>Spring Beans</b> that were managed by a <b>Spring Container</b> implemented as a 
<b>AnnotationConfigApplicationContext class</b>. The application is also writing in and reading out specific information 
to/from a created <b>properties file</b> at app running. The file looks as follows:
</p>

```properties
#Wed Jul 07 09:31:52 CEST 2021
date=2021-07-07
java-version=11.0.11
program-version=1.0
```

where `date` is computed locally by current date - `java.time.LocalDate().now` and `java-version` is an `sdk` version.

### Table Of Content

- Project Details
- Dependencies

### Project Details

- `Java 11 (LTS)`
- `Spring 5`
- `Maven`
- Properties file: [custom.properties](./internship-adb/EX1-BEANS/src/main/resources/custom.properties)

### Dependencies

|                                           ArtifactId                                           | Version |
|:----------------------------------------------------------------------------------------------:|:-------:|
| [spring-context](https://mvnrepository.com/artifact/org.springframework/spring-context/5.3.23) | 5.3.23  |


## EX2-BEANS

<p align="justify">
This project was focused on using <code>dependency injection</code> in action by defining a <b>Spring Bean</b> 
with a priority using <code>@Primary</code> annotation and also by specifying beans' name attribute. 
The injection takes place in a method parameter of the other bean. The project also presented an idea of two 
<b>cooling systems implementations</b>: <code>Fridge class</code> and <code>Air Conditioning class</code>.
</p>

### Table Of Content

- Project Details
- Dependencies

### Project Details

- `Java 11 (LTS)`
- `Spring Boot 2`
- `Maven`

### Dependencies

|                                                        ArtifactId                                                        | Version |
|:------------------------------------------------------------------------------------------------------------------------:|:-------:|
|       [spring-boot-starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter/2.7.5)       |  2.7.5  |
| [spring-boot-autoconfigure](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-autoconfigure/2.7.5) |  2.7.5  |


## EX3-SCHEDULING

<p align="justify">
This project has shown how to <b>schedule</b> a task with <b>Spring</b> using <code>@Scheduled</code> <b>annotation</b>. 
The task was focused on sending <code>GET</code> requests to chosen <code>Web API</code> and process each response. <br>
</p>

<h3 align="center">UPDATE 12.11.2023: API seems to be no longer maintained.</h3>

<br>

- (Expected) Processed response:

```text
    RANDOM_FACT_HERE
```

> Random facts are printed on console every **8s**.

### Table Of Content

- Project Details
- Dependencies

### Project Details

- `Java 11 (LTS)`
- `Spring Boot 2` 
- `Maven`
- [API Docs](https://dukengn.github.io/Dog-facts-API/)

### Dependencies

|                                                        ArtifactId                                                        | Version |
|:------------------------------------------------------------------------------------------------------------------------:|:-------:|
|       [spring-boot-starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter/2.7.5)       |  2.7.5  |
| [spring-boot-autoconfigure](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-autoconfigure/2.7.5) |  2.7.5  |

## EX4-STREAM-API-JUNIT-TESTS

<p align="justify">
This project was focused on both usage of <code>stream API</code> and <b>unit testing</b> with 
<code>JUnit Jupiter</code> framework. The purpose of the project has been satisfied based on an <b>abstract</b> 
implementation of <b>dogs</b> and <b>cats</b>.
</p>

### Table Of Content

- Project Details
- Class Hierarchy Tree
- Dependencies

### Project Details

- `Java 11 (LTS)`
- `Maven`
- [Unit tests](./internship-adb/EX4-STREAM-API-JUNIT-TESTS/src/test/java/StreamTest.java)

### Class Hierarchy Tree

- Object (java.lang)
    - Enum (java.lang)
        - Hairiness
        - CatHunterSense
        - DogCommand
    - Animal
        - Cat
        - Dog
    - AnimalUtils
    - AbstractCollection (java.util)
        - AbstractList (java.util)
            - ArrayList (java.util)
                - CustomizedArrayList

### Dependencies

|                                                  ArtifactId                                                  | Version |
|:------------------------------------------------------------------------------------------------------------:|:-------:|
|                                     [lombok](https://projectlombok.org/)                                     | 1.18.24 |
|    [JUnit Jupiter API](https://junit.org/junit5/docs/5.9.0/api/org.junit.jupiter.api/module-summary.html)    |  5.9.0  |
| [JUnit Jupiter Params](https://junit.org/junit5/docs/5.9.0/api/org.junit.jupiter.params/module-summary.html) |  5.9.0  |

## EX5-EXPERIMENTAL-GET-MAPPING

<p align="justify">
This project started as an experiment. It was focused on creating first basic <code>Web API</code>. 
Mapping was only provided for <code>GET</code> method. The concept of the project can be described as:
</p>

- User sends a request with a parameter key `name` and (optionally) defined value.
- _API_ sends a response determined by the provided value of the key.
- If the value of the key is `undefined`, equals to `stranger` or it **DOES NOT MATCH** specified `regex`, 
`API` returns general response (or error response in some cases).
- Personalized responses' `ids` are **incremented** by **1** and all general responses' `ids` are always **0**.
- Incrementation is stopped being followed once application has been shut down.
- Values of the key are being **formatted** before the `API` returns a response. Read further for details.

> The general idea is that user can introduce themselves in a request and then API returns welcome message as a response.

The application **produces** data in `json` format.

### Table Of Content

- Project Details
- API Reference
- RegEx Details
- About Further Formatting `name`
- API Response Examples
- Dependencies


### Project Details

- `Java 11 (LTS)`
- `Spring Boot 2` 
- `Maven`
- Runs `Tomcat` on default configuration (port 8080)

### API Reference

```text
  GET /meeting
```

```text
  GET /meeting?name=String
```

| Key    | Value    | Description                                     |
|:-------|:---------|:------------------------------------------------|
| `name` | `String` | **Optional**. Your name. `stranger` by default. |  

### RegEx Details

`RegEx` to match for the key `name`

```regexp
^(?!.*[\r\n])[\da-zA-Z ]+$
```

To match this `regex` it is necessary that:

- Provided _String_ **IS NOT BLANK**.
- Provided _String_ contains only **latin** letter(s) in **lower** or **UPPER** case or/and
  number(s) between **0** and **9** or/and space character(s).
- Provided _String_ has a single line.

### About Further Formatting `name`

- Let's say we provide value: `%20L%20u%20%20c%20%20%20as%20%20`
  where `%20` is encoding for a space character.
- Value is being validated. In this case, validation is successful.
- Now it's time for formatting. To simplify how it works, it can be said that:
    - We **split** validated _String_ to multiple strings by each occurred space character.
    - We take each _String_ that **DOES NOT** contain a space character, and we append it to the output.
    - After each, **EXCEPT LAST** appended _String_, we append a singular space character additionally.
    - Formatted output looks like this: <code>L&nbsp;u&nbsp;c&nbsp;as</code>.

> In short, it can be said that every formatted value starts and ends with a latin letter or with a number,
and between any pair (if exists) of the space characters, there is at least one latin letter or a number.

### API Response Examples

General:

```json
{
  "id": 0,
  "message": "Hello stranger. It's nice to meet you."
}
```

Examples:

- `GET /meeting?name=L%20u%20c%20as`

```json
{
  "id": 1,
  "message": "Hello L u c as. It's nice to meet you."
}
```

- `GET /meeting?name=0Lucas3`

```json
{
  "id": 2,
  "message": "Hello 0Lucas3. It's nice to meet you."
}
```

- `GET /meeting?name=10`

```json
{
  "id": 3,
  "message": "Hello 10. It's nice to meet you."
}
```

> Note that it is still possible to force the API to return an error response.

### Dependencies

|                                                        ArtifactId                                                        | Version |
|:------------------------------------------------------------------------------------------------------------------------:|:-------:|
|                                           [lombok](https://projectlombok.org/)                                           | 1.18.24 |
|   [spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web/2.7.5)   |  2.7.5  |
| [spring-boot-autoconfigure](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-autoconfigure/2.7.5) |  2.7.5  |


## EX6-H2-STUDENTS

<p align="justify">
This project was focused on defining <code>Entity class</code> and <code>Spring Data JPA</code> repositories implementation.
It was built additionally with <b>Spring Component class</b>, <b>Spring Configuration class</b> and 
<b>Spring Service class</b>. Configuration class implements <code>CommandLineRunner interface</code> and 
its method for providing execution of <b>business logic</b> defined in the service class, while the component class
is responsible for <code>value injection</code> from <b>properties file</b> using <code>@Value</code> annotation. 
The value is used to define a number of students to create and add to the repository. Each student is created randomly 
using data from <code>Datafaker</code> library. For the presentation needs of <code>findBySurname(String)</code> method, 
it has been guaranteed that for <b>n-students</b>, there are exactly <code>&lfloor;0,3*n&rfloor; students</code> named <b>Lopez</b>. 
Each student <code>id</code> is <b>autogenerated</b> during entity creation. Created entities can be managed by 
<code>H2 DBMS</code>. <b>Properties file</b> for this project looks as follows:
</p>

```properties
instances.number=15

server.port=8080

spring.jpa.open-in-view=false

spring.h2.console.enabled=true
spring.h2.console.path=/h2

spring.datasource.url=jdbc:h2:mem:students
spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa
spring.datasource.password=
```

## Table Of Content

- Project Details
- Screenshots
- Dependencies


### Project Details

- `Java 11 (LTS)`
- `Spring Boot 2` 
- `Maven`
- Runs `Tomcat` on port:`8080`
- Properties file: [application.properties](./internship-adb/EX6-H2-STUDENTS/src/main/resources/application.properties)

### Screenshots

![h2 login window](./Screenshots/EX6/login.jpg)

![database structure](./Screenshots/EX6/structure.png)

![students records](./Screenshots/EX6/records.jpg)

![information on console](./Screenshots/EX6/console.jpg)

### Dependencies:

|                                                           ArtifactId                                                           | Version |
|:------------------------------------------------------------------------------------------------------------------------------:|:-------:|
|                             [datafaker](https://www.datafaker.net/documentation/getting-started/)                              |  1.7.0  |
|                                              [lombok](https://projectlombok.org/)                                              | 1.18.24 |
|                 [spring-context](https://mvnrepository.com/artifact/org.springframework/spring-context/5.3.23)                 | 5.3.23  |
|                  [spring-boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot/2.7.5)                  |  2.7.5  |
|      [spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web/2.7.5)      |  2.7.5  |
| [spring-boot-starter-data-jpa](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/2.7.5) |  2.7.5  |
|                               [h2](https://mvnrepository.com/artifact/com.h2database/h2/2.1.214)                               | 2.1.214 |

## EX7-RESTAPI-H2-BUSSES

<p align="justify">
This project was focused on simple <code>REST API</code> implementation. The project is built from following components:
</p>

- Spring Configuration class
- Spring Rest Controller class
- Spring Service class
- Spring Data JPA repositories
- Spring Rest Controller Adviser class
- Exception classes
- Response Body class
- Model class
- Entity class
- Utility classes

**Utility classes** delivers following functionalities:

- Bus conversion. Mapping **entities** to **model** representation (and vice versa).
- Data generator for busses.
- Validation for `String` values.
- Shuffling data to ensure **pseudo-random** results.

**Handled exceptions** using `@ExceptionsHandler` annotation:

- BusNotFound</b> - thrown, if it could not find a bus with given <code>id</code>.
- BusAlreadyExists</b> - thrown, if it could not add a bus with given <code>id</code> (id already taken)

The application **consumes** and **produces** data in `json` format.

## Table Of Content

- Project Details
- API Reference
- RegEx Details
- API Response Examples
- Screenshots
- Dependencies

### Project Details

- `Java 11 (LTS)`
- `Spring Boot 2` 
- `Maven`
- Runs `Tomcat` on port:`8080`
- Properties file: [application.properties](./internship-adb/EX7-RESTAPI-H2-BUSSES/src/main/resources/application.properties)

### API Reference

**1. GET**

```text
  GET /busses
```

```text
  GET /busses?engine=String
```

| Key       | Value    | Description                                                              |
|:----------|:---------|:-------------------------------------------------------------------------|
| `engine`  | `String` | **Optional**. Type of bus engine. Must match one of Enum's String value. |

```text
  GET /busses/{id}
```

where `id` is a value of a non-negative integer.

<br>

**2. POST**

```text
  POST /busses
```

- **Request body** pattern:

```text
{
  "id": int,
  "brand": String,
  "model": int || String,
  "seats": int || null,
  "standingRoom": int || null,
  "length": int || null,
  "engine": String
}
```

- where `int` is a non-negative integer.
- `null` values are converted to **0s**.
- each `int` can be expressed as a `String` as well.

<br>

**3. PUT**

```text
  PUT /busses/{id}
```

where `id` is a value of a non-negative integer.

- **Request body** pattern:

```text
{
  "id": int,
  "brand": String,
  "model": int || String,
  "seats": int || null,
  "standingRoom": int || null,
  "length": int || null,
  "engine": String
}
```

- where `int` is a non-negative integer.
- `null` values are converted to **0s**.
- each `int` can be expressed as a `String` as well.

<br>

**4. DELETE**

```text
  DELETE /busses/{id}
```

where `id` is a value of a non-negative integer.

<br>

### RegEx Details

`RegEx` to match for `id`, `seats`, `standingRoom` and `length`:

```regexp
^\d+$
```

Just a number or sequence of numbers between **0** and **9**.

<br>

`RegEx` to match for `brand`:

```regexp
^(?!.*[_\r\n])[a-zA-Z]([-a-zA-Z ]*[a-zA-Z])?$
```

To match this `regex` it is necessary that:

- Provided `String` **IS NOT BLANK**.
- Provided `String` starts and ends with any **latin** letter in **lower** or **UPPER** case.
- Provided `String` has a single line.
- Every, except **FIRST** and **LAST**, index of provided `String` can be:
    - A **latin** letter in **lower** or **UPPER** case.
    - A space character.
    - A dash: <code>&#8212;</code>.

<br>

`RegEx` to match for `model`:

```regexp
^(?!.*[_\r\n])\w([-\w ]*\w)?$
```

To match this `regex` it is necessary that:

- Provided `String` **IS NOT BLANK**.
- Provided `String` starts and ends with a **latin** letter in **lower** or **UPPER** case or with any number between
  **0** and **9**.
- Provided `String` has a single line.
- Every, except **FIRST** and **LAST**, index of provided `String` can be:
    - A **latin** letter in **lower** or **UPPER** case.
    - Any number between **0** and **9**.
    - A space character.
    - A dash: <code>&#8212;</code>.

<br>

`RegEx` to match for `engine`

```regexp
^((?i)\bdiesel\b+?|(?i)\belectric\b+?)*$
```

<p align="justify">
To match this <code>regex</code> it is necessary to provide either <code>diesel</code> or <code>electric</code> in 
<b>CASE-INSENSITIVE</b> variant and in a <b>SINGLE OCCURRENCE</b>. That means each letter of either word can be independently 
in <b>UPPER</b> or <b>lower</b> case.
</p>

### API Response Examples

<p align="center"><b>Let's consider valid requests at first.</b></p>

- [x] `GET /busses`


- HTTP status: `200 OK`
- Response:

```json5
[
  {
    "id": "1",
    "brand": "Kia Motors",
    "model": "Prototype 2000",
    "seats": 35,
    "standingRoom": 29,
    "length": 16,
    "engine": "DIESEL"
  },
  {
    "id": "2",
    "brand": "Daewoo Bus",
    "model": "Quadrillion",
    "seats": 45,
    "standingRoom": 10,
    "length": 6,
    "engine": "ELECTRIC"
  },
  .,
  .,
  .,
  {
    "id": "10",
    "brand": "Kia Motors",
    "model": "Focus",
    "seats": 33,
    "standingRoom": 28,
    "length": 18,
    "engine": "DIESEL"
  }
]
```

<br>

- [x] `GET /busses?engine=ELECTRIC`


- HTTP status: `200 OK`
- Response:

```json5
[
  {
    "id": "2",
    "brand": "Daewoo Bus",
    "model": "Quadrillion",
    "seats": 45,
    "standingRoom": 10,
    "length": 6,
    "engine": "ELECTRIC"
  },
  {
    "id": "4",
    "brand": "Renault",
    "model": "See-sharp",
    "seats": 55,
    "standingRoom": 26,
    "length": 12,
    "engine": "ELECTRIC"
  },
  .,
  .,
  .,
  {
    "id": "7",
    "brand": "Scania AB",
    "model": "Light",
    "seats": 66,
    "standingRoom": 12,
    "length": 15,
    "engine": "ELECTRIC"
  }
]
```

<br>

- [x] `GET /busses/3`


- HTTP status: `200 OK`
- Response:

```json
{
  "id": "3",
  "brand": "Kia Motors",
  "model": "Megane",
  "seats": 41,
  "standingRoom": 27,
  "length": 10,
  "engine": "DIESEL"
}
```

<br>

- [x] `POST /busses`

Request body:

```json
{
  "id": 20,
  "brand": "myBrand",
  "model": "myModel",
  "seats": 50,
  "standingRoom": 14,
  "length": 8,
  "engine": "eLeCtRiC"
}
```

- Http status: `201 Created`
- Response:

```json
{
  "id": "20",
  "brand": "myBrand",
  "model": "myModel",
  "seats": 50,
  "standingRoom": 14,
  "length": 8,
  "engine": "ELECTRIC"
}
```

<br>

- [x] `PUT /busses/20`

Request body:

```json
{
  "id": "21",
  "brand": "updatedBrand",
  "model": "updatedModel",
  "seats": 49,
  "standingRoom": 0,
  "length": 9,
  "engine": "diesel"
}
```

- Http status: `200 OK`
- Response:

```json
{
  "id": "20",
  "brand": "updatedBrand",
  "model": "updatedModel",
  "seats": 49,
  "standingRoom": 0,
  "length": 9,
  "engine": "DIESEL"
}
```

As we can see, once value is assigned to `id`, the property became **immutable**.

<br>

- [x] `DELETE /busses/20`


- Http status: `204 No Content`
- Response:

```text

```

The **response** has `no content`.

<hr>

<p align="center"><b>Now we are going to consider what happens if we do something wrong.</b></p>

<br>

- [ ] `GET /busses/engine=myEngine`


- `myEngine` **DOES NOT MATCH** declared `regex`
- HTTP status: `422 Unprocessable Entity`
- Response:

```json
{
  "code": 3,
  "message": "Null not allowed."
}
```

<br>

- [ ] `GET /busses/{id}`
- [ ] `PUT /busses/{id}`
- [ ] `DELETE /busses/{id}`

Path variable: `myId`

- `myId` **DOES NOT MATCH** declared `regex`, hence repository does not contain a bus with such id.
- HTTP status: `404 Not Found`
- Response:

```json
{
  "code": 1,
  "message": "Bus with id: [myId] not found."
}
```

Path variable: `0`

- We assume repository **DOES NOT CONTAIN** a bus with id: `0`
- HTTP status: `404 Not Found`
- Response:

```json
{
  "code": 1,
  "message": "Bus with id: [0] not found."
}
```

<br>

- [ ] `POST /busses`

Request body:

```json
{
  "id": "20",
  "brand": "newBrand",
  "model": "newModel",
  "seats": 25,
  "standingRoom": 10,
  "length": 4,
  "engine": "DIESEL"
}
```

- HTTP status: `409 Conflict`
- Response:

```json
{
  "code": 2,
  "message": "Bus with id: [20] already exists."
}
```

since we recently added a bus with `id=20`.

<br>

Request body:

```json
{
  "id": "a",
  "brand": "newBrand",
  "model": "newModel",
  "seats": 25,
  "standingRoom": 10,
  "length": 4,
  "engine": "DIESEL"
}
```

- HTTP status: `422 Unprocessable Entity`
- Response:

```json
{
  "code": 3,
  "message": "Null not allowed."
}
```

since `a` **DOES NOT MATCH** declared `regex`.

<br>

**Now we assume that bus with `id=40` does not exist yet.**

Request body:

```json
{
  "id": "40",
  "brand": "?",
  "model": "!",
  "seats": 25,
  "standingRoom": 10,
  "length": 4,
  "engine": "DIESEL"
}
```

- HTTP status: `422 Unprocessable Entity`
- Response:

```json
{
  "code": 3,
  "message": "not-null property references a null or transient value : com.internship.adb.busses.persistence.entity.BusEntity.brand"
}
```

since `?` and `!` **DOES NOT MATCH** declared `regex`.

<br>

Request body:

```json
{
  "id": "40",
  "brand": "newBrand",
  "model": "newModel",
  "seats": "b",
  "standingRoom": "c",
  "length": "d",
  "engine": "DIESEL"
}
```

- HTTP status: `400 Bad Request`
- Response:

```json
{
  "code": 3,
  "message": "JSON parse error: Cannot deserialize value of type `int` from String \"b\": not a valid `int` value; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `int` from String \"b\": not a valid `int` value\n at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 5, column: 12] (through reference chain: com.internship.adb.busses.model.BusModel[\"seats\"])"
}
```

since `b` and `c` and `d` **DOES NOT MATCH** declared `regex`.

<br>

Request body:

```json
{
  "id": "40",
  "brand": "newBrand",
  "model": "newModel",
  "seats": 25,
  "standingRoom": 10,
  "length": 4,
  "engine": true
}
```

- HTTP status: `422 Unprocessable Entity`
- Response:

```json
{
  "code": 3,
  "message": "Null not allowed."
}
```

since `String` value of `true` **DOES NOT MATCH** declared `regex`.

<br>

Request body:

```json
{
  "brand": "newBrand",
  "model": "newModel",
  "seats": 25,
  "standingRoom": 10,
  "length": 4,
  "engine": "DIESEL"
}
```

- HTTP status: `422 Unprocessable Entity`
- Response:

```json
{
  "code": 3,
  "message": "Null not allowed."
}
```

since there is no occurrence of required `json property`. In this case it is no occurrence of `id`.

<br>

Missing Request Body:

- HTTP status: `400 Bad Request`
- Response:

```json
{
    "code": 3,
    "message": "Required request body is missing: public org.springframework.http.ResponseEntity<com.internship.adb.busses.model.BusModel> com.internship.adb.busses.controller.BusController.addBus(com.internship.adb.busses.model.BusModel)"
}
```

since `request body` is required.

### Screenshots

![h2 login window](./Screenshots/EX7/login.jpg)

![database structure](./Screenshots/EX7/structure.jpg)

![busses records](./Screenshots/EX7/records.jpg)

### Dependencies

|                                                           ArtifactId                                                           |   Version    |
|:------------------------------------------------------------------------------------------------------------------------------:|:------------:|
|                                              [lombok](https://projectlombok.org/)                                              |   1.18.24    |
|      [spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web/2.7.5)      |    2.7.5     |
| [spring-boot-starter-data-jpa](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/2.7.5) |    2.7.5     |
|                               [h2](https://mvnrepository.com/artifact/com.h2database/h2/2.1.214)                               |   2.1.214    |
|                 [hibernate-core](https://mvnrepository.com/artifact/org.hibernate/hibernate-core/5.6.12.Final)                 | 5.6.12.Final |

## Author

[@lucasmalara](https://github.com/lucasmalara "author")