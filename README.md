There are a couple of Gates already in the database. We can choose to create new ones or edit.

Following list is of end points, to interact with the system, with corresponding routes, request and responses.

-----------------------------------------

GET /gates/{gateId}

- Fetching a Gate by it's ID

Response body:

```json
{
    "id": 1,
    "name": "Tarmac",
    "inUse": false,
    "availableFrom": "00:00:00",
    "availableTo": "23:59:59"
}
```

-----------------------------------------

POST /gates

- Creating a Gate

Request body:

```json
{
    "name": "Charlie",
    "inUse": false,
    "availableFrom": "01:00:00",
    "availableTo": "05:00:00"
}
```

Response body:

```json
{
    "id": 5,
    "name": "Charlie",
    "inUse": false,
    "availableFrom": "01:00:00",
    "availableTo": "05:00:00"
}
```

-----------------------------------------

PUT /gates/{gateId}

- Editing a Gate

Request body:

```json
{
    "name": "Changable",
    "inUse": false,
    "availableFrom": "01:00:00",
    "availableTo": "05:00:00"
}
```

Response body:

```json
{
    "id": 1,
    "name": "Changable",
    "inUse": false,
    "availableFrom": "01:00:00",
    "availableTo": "05:00:00"
}
```

-----------------------------------------

POST /assigned-flight

- Creating a Gate Assignment with a flight number that can be alphanumeric

Request param:

```json
flightNumber:BA2491A
```

Response body:

```json
{
    "id": 1,
    "flightNumber": "BA2491A",
    "gate": {
        "id": 3,
        "name": "Apron",
        "inUse": true,
        "availableFrom": "00:00:00",
        "availableTo": "14:00:00"
    }
}
```

-----------------------------------------

GET /gates/assigned-flight/{gateAssignmentId}

- Fetching a Gate Assignment with it's ID

Response body:

```json
{
    "id": 1,
    "flightNumber": "BA2491A",
    "gate": {
        "id": 3,
        "name": "Apron",
        "inUse": true,
        "availableFrom": "00:00:00",
        "availableTo": "14:00:00"
    }
}
```

-----------------------------------------

To run project locally, you can download a JAR file I hosted on my Google Drive.
After download finishes, open Terminal and navigate to file location, after that run the following.

```
java -jar airport-gate-management-0.0.1-SNAPSHOT.jar
```

After starting the project, it will run on port 8080. And you can start using it right away.

```
GET http://localhost:8080/gates/1
```

[Link to executable JAR file](https://drive.google.com/file/d/1Pqp0hOAa2DbR6J8iIBOusONjEAR4kiHh/view?usp=sharing..)
