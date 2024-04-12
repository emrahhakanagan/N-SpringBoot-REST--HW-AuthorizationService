## --- NETOLOGY HOMEWORK ---
### SPRING BOOT, DEPLOYMENT AND INFRASTRUCTURE --> REST


#### --> Task 1 --> Authorization Service 


# User Authorization Service

## Overview
This Spring Boot application provides a user authorization service that validates usernames and passwords against predefined rules and stored credentials.

## Features
- Validates username and password using regular expressions.
- Manages a simple in-memory database of users and their roles.
- Returns authorization details such as permitted actions (READ, WRITE, DELETE).
- Handles errors gracefully and returns meaningful error messages.

## Technologies Used
- Spring Boot
- Java
- Lombok for reducing boilerplate code

## Setup and Installation
1. Clone the repository:
   `git clone [repository URL]`

2. Navigate to the project directory:
   `cd [project name]`

3. Build the project with Maven:
   `mvn clean install`

4. Run the application:
   `java -jar target/[jar file name]`


## API Endpoints
- `/authorize?user={username}&password={password}`
- Method: GET
- Description: Validates the provided username and password, returns the user's authorities if valid.

## Handling Errors
- `Invalid Credentials`: Returns HTTP 400 Bad Request with a detailed error message.
- `Unauthorized User`: Returns HTTP 401 Unauthorized with a detailed error message.

