# Process Storage API - Java Spring
It's just a test project that i'm developing to learn Java Spring Framework.

## Notes
- Java version: 15
- To run this project you'll need docker installed because the api uses a postgres container to 
persist data.

## Installation
Running in development mode:
1. Create postgres Docker container:
```
docker container run --name postgresdb -e POSTGRES_PASSWORD=admin -d -p 5432:5432 postgres
```
2. Navigate to the project folder.
```
cd /path/to/process-storage-api-java-spring
```
3. Copy 'processrecorder_db.sql' into the docker container:
```
docker cp processstorage_db.sql postgresdb:/
```
4. Open a terminal inside the container:
```
docker container exec -it postgresdb bash
```
5. Create the database and its tables in postgres:
```
psql -U postgres --file processstorage_db.sql
```
6. Open the project on your IDE (IntelliJ, NetBeans, etc).
7. Click to run the code.

## Documentation - Api Routes
### Register - POST
#### Route: 
```
/api/users/register
```
#### Body:
```
{
  "firstName": "user", // varchar(24)
  "lastName": "user", // varchar(48)
  "email": "user@domain.com", // varchar(64)
  "password": "password" // varchar(64)
}
```
### Login - POST
#### Route: 
```
/api/users/login
```
#### Body:
```
{
  "email": "user@domain.com", // varchar(64)
  "password": "password" // varchar(64)
}
```

## Author
- Pietro Bondioli ([@bondiolipietro](https://github.com/bondiolipietro))

## License
[MIT](https://opensource.org/licenses/MIT)
