# Spring Boot Learning Project

## Project Plan
1.	Implement basic REST API server 
2.	Persistence (JPA & Hibernate): Store the data coming in through REST in a database (MySQL)
3.	Implement a second application which will get notified through JMS 2.0 about the incoming REST request
4.  Adopt Apache Camel for the JMS processing in the second app.
5.	Implement a WebUI using Angular showing the number of items in the JMS queue. And showing a counter of processed messages, to monitor the live system (but manual browser refresh is sufficient)
6.  Implement OAuth 2.0 authentication for the WebUI using Spring Security
7.  Fetch data from a public REST API (e.g., Steam API, Rust, live weather data), and also store it in the database
8.  Implement WebUI live update through both, Server-Sent-Events and (alternatively, in parallel) through WebSockets.
9.  Implement Prometheus probes and a Kafka dashboard
10. Adopt Liquibase to manage DB schema


## Other skills to learn as we go:
* Git
* Testing
* Clean Code
* Maven / Gradle
* Logging
* Multithreading
* 