Airport Gate Management System

GET /gate/{gateId}

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
