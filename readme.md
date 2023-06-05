# Recruitment task

This project provides an API for listing a user's GitHub repositories that are not forks. It retrieves information such as the repository name, owner login, branch names, and the last commit SHA for each branch.

Technologies were used in the project:
Java 17 + Spring Boot 3.1 with Mapstruct and Lombok libraries.

Projects uses Github API - https://developer.github.com/v3
## Getting Started

These instructions will help you set up and run the project on your local machine for development and testing purposes.

### Prerequisites

- Java 17
- Maven

### Installation

1. Clone the repository:

```shell
git clone https://github.com/patryklorbiecki1/AtiperaRecruitmentTask.git
```

2. Navigate to the project directory:

```shell
cd AtiperaRecruitmentTask
 ```
Build the project using Maven:

```shell
mvn clean package
```
### Usage

Start the application:
```shell
java -jar target/AtiperaRecruitmentTask-3.1.0.jar
```
Make a GET request to the following endpoint to retrieve the user's repositories:
```shell
GET http://localhost:8080/github/{username}
```
Replace {username} with the actual GitHub username.
The response will include the repository name, owner login, branch names, and the last commit SHA for each branch.
Customize the project according to your needs by modifying the source code files.

### Error Handling

The API handles two types of errors:

404 (Not Found):

If the requested GitHub user does not exist, the API will return a JSON response with the following structure:
```json
{
"status": 404,
"message": "User not found"
}
```

406 (Not Acceptable):

If the request has an unsupported media type, the API will return a JSON response with the following structure:

```json

{
"status": 406,
"message": "Not Acceptable"
}
```
