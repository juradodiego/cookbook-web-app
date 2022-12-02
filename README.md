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

#### localhost:8080/user/get
GET: type raw -> json

{
"username" : "diegojurado",
"password" : "password"
}

#### localhost:8080/user/create
POST: type raw -> JSON

BODY:

{
"firstName" : "diego",
"lastName" : "jurado",
"username" : "diegojurado",
"email" : "diego@pitt.edu",
"password" : "password",
"savedRecipeIds" : [1]
}

#### localhost:8080/user/update
POST: type raw -> JSON

BODY:

{
"id" : 1,
"firstName" : "diego",
"lastName" : "jurado",
"username" : "diegojurado",
"email" : "diego@pitt.edu",
"password" : "password",
"savedRecipeIds" : [1, 2, 3]
}

#### localhost:8080/recipe/add
POST: type raw-> JSON

BODY:

{
"name" : "Test",
"description" : "Test",
"instructions" : ["Step 1", "Step 2", "Step 3"],
"ingredients" : { "Test" : "Test Amount"} ,
"appliances" : ["Appliance 1", "Appliance 2"],
"cooktime" : 0.0,
"difficultyRating" : 0.0,
"qualityRating" : 0.0,
"cuisine" : "Test",
"flavor" : "Test",
"diets" : ["Diet 1", "Diet 2"]
}

#### localhost:8080/recipe/getAll
GET: type raw -> JSON

BODY:

N/A

##### localhost:8080/recipe/get
GET: type raw -> JSON

BODY:

1

##### localhost:8080/recipe/delete
POST: type raw -> JSON

BODY:

1

#### localhost:8080/recipe/getByIds
GET: type raw -> JSON

BODY:

[1]

#### localhost:8080/recipe/getFiltered
GET: type raw -> JSON

No filter parameters are required, and if no filter parameter is provided it will get all recipes

BODY:

{
"ingredients" : ["Test"],
"appliances" : ["Test"],
"difficultyRating" : 0.0,
"qualityRating" : 0.0,
"cuisine" : "Test",
"flavor" : "Test",
"diets" : ["Test"]
}