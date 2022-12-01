# CS1530-CookBook

## Instructions to get running locally:

### Frontend:
Install Node.js

cd into client directory

run "npm i"

run "npm run dev" to start local server

### Backend:

Looking into creating a local database programmatically.

On Mac Download MAMP for creating a local database / On Windows Download XAMPP for creating a local database

In MAMP / XAMPP ensure that MySQL Port is 3306

Start running MySQL Database

Enter directory ~/cookbook/...

run "mvn spring-boot:run"

To test GET and POSTS:
Download Postman

#### Adding Posts and Gets in Postman

localhost:8080/user/get
GET 
type raw -> json

{
"username" : "diegojurado",
"password" : "password"
}

localhost:8080/user/create
POST
type raw -> JSON

{
"firstName" : "diego",
"lastName" : "jurado",
"username" : "diegojurado",
"email" : "diego@pitt.edu",
"password" : "password",
"savedRecipeIds" : [1]
}

localhost:8080/user/update
POST
type raw -> JSON

{
"id" : 1,
"firstName" : "diego",
"lastName" : "jurado",
"username" : "diegojurado",
"email" : "diego@pitt.edu",
"password" : "password",
"savedRecipeIds" : [1, 2, 3]
}
