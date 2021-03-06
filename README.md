# Process Storage API - Java Spring

It's just a test project that i'm developing to learn Java Spring Framework.

## Notes

- Java version: 15
- To run this project you'll need docker installed because the api uses a postgres container to
persist data.

## Setup & Installation

Running in development mode:

1. Create postgres Docker container:

```bash
docker container run --name postgresdb -e POSTGRES_PASSWORD=admin -d -p 5432:5432 postgres
```

2. Navigate to the project folder.

```bash
cd /path/to/process-storage-api-java-spring
```

3. Copy 'processrecorder_db.sql' into the docker container:

```bash
docker cp processstorage_db.sql postgresdb:/
```

4. Open a terminal inside the container:

```bash
docker container exec -it postgresdb bash
```

5. Create the database and its tables in postgres:

```bash
psql -U postgres --file processstorage_db.sql
```

6. Open the project on your IDE (IntelliJ, NetBeans, etc).
7. Click to run the code.

## Documentation - Api Routes

### User - Register - POST

#### Route

`/api/users/register`

#### Body

```
{
  "firstName": "user",
  "lastName": "user",
  "email": "user@domain.com",
  "password": "password"
}
```

### User - Login - POST

#### Route

`/api/users/login`

#### Body

```
{
  "email": "user@domain.com",
  "password": "password"
}
```

### Process - Create - POST

#### Route

`/api/processes/create`

#### Notes

- Needs JWT Auth token

#### Body

```
{
    "firstName": "user",
    "lastName": "user",
    "cpf": "111.111.111-11",
    "email": "user@domain.com",
    "folder": 1,
    "receipt": "1111111111",
    "receiptIssueDate": "1111-11-11",
    "address": "adress",
    "district": "district",
    "city": "city",
    "state": "state",
    "country": "country",
    "cep": "11111-111",
    "notes": "notes notes notes notes notes"
}
```

### Process - Find By Id - GET

#### Route

`/api/processes/{processId}`

#### Notes

- Needs JWT Auth token

### Process - Fetch All - GET

#### Route

`/api/processes`

#### Notes

- Needs JWT Auth token

### Process - Update - PUT

#### Route

`/api/processes/update/{processId}`

#### Notes

- Needs JWT Auth token

#### Body

```
{
    "firstName": "updatedUser",
    "lastName": "updatedUser", 
    "cpf": "111.111.111-11",
    "email": "updatedUser@domain.com",
    "folder": 1,
    "receipt": "1111111111",
    "receiptIssueDate": "1111-11-11",
    "address": "updatedAdress",
    "district": "updatedDistrict",
    "city": "updatedCity",
    "state": "updatedState",
    "country": "updatedCountry",
    "cep": "11111-111",
    "notes": "updatedNotes notes notes notes notes"
}
```

### Process - Delete - DELETE

#### Route

`/api/processes/delete/{processId}`

#### Notes

- Needs JWT Auth token

## Author

- Pietro Bondioli ([@bondiolipietro](https://github.com/bondiolipietro))

## License

[MIT](https://opensource.org/licenses/MIT)
