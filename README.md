# Process Storage API - Java Spring

It's just a test project that i'm developing to learn Java Spring Framework.

## Notes

- Java version: 15
- To run this project you'll need docker installed because the api uses a postgres container to
persist data.

## Installation

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

```json
{
  "firstName": "user", // varchar(24)
  "lastName": "user", // varchar(48)
  "email": "user@domain.com", // varchar(64)
  "password": "password" // varchar(64)
}
```

### User - Login - POST

#### Route

`/api/users/login`

#### Body

```json
{
  "email": "user@domain.com", // varchar(64)
  "password": "password" // varchar(64)
}
```

### Process - Create - POST

#### Route

`/api/processes/create`

#### Notes

- Needs JWT Auth token

#### Body

```json
{
    "firstName": "user", // varchar(24)
    "lastName": "user", // varchar(48)
    "cpf": "111.111.111-11", // varchar(24)
    "email": "user@domain.com", // varchar(64)
    "folder": 1, // integer
    "receipt": "1111111111", // varchar(96)
    "receiptIssueDate": "1111-11-11", // sql date
    "address": "adress", // varchar(96)
    "district": "district", // varchar(24)
    "city": "city", // varchar(24)
    "state": "state", // varchar(24)
    "country": "country", // varchar(24)
    "cep": "11111-111", // varchar(24)
    "notes": "notes notes notes notes notes" // varchar(4096)
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

```json
{
    "firstName": "updatedUser", // varchar(24)
    "lastName": "updatedUser", // varchar(48)
    "cpf": "111.111.111-11", // varchar(24)
    "email": "updatedUser@domain.com", // varchar(64)
    "folder": 1, // integer
    "receipt": "1111111111", // varchar(96)
    "receiptIssueDate": "1111-11-11", // sql date
    "address": "updatedAdress", // varchar(96)
    "district": "updatedDistrict", // varchar(24)
    "city": "updatedCity", // varchar(24)
    "state": "updatedState", // varchar(24)
    "country": "updatedCountry", // varchar(24)
    "cep": "11111-111", // varchar(24)
    "notes": "updatedNotes notes notes notes notes" // varchar(4096)
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
