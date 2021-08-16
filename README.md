# Spring Boot - Email Microservice
Project built to implement synchronous and asynchronous email microservice with message server

Technologies used:

- Spring Data, Validation, Mail, Web, AMQP, Test
- RabbitMQ
- Postgresql
- Lombok

Use **docker-compose.yml** to run containers and to do locally tests:

- **MailDev:** Simulate an email provider
- **Postgresql:** Database server
- **RabbitMQ:** Broker server with management application

In root project run command:

- docker-compose up -d

In browser set urls:

- **MailDev:** http://localhost:1080/
- **RabbitMQ App:** http://localhost:15672/