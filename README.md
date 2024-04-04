# Get Started

## Generate a security password
When running the project. You should get the following message:
```
Using generated security password: d3d9b2ec-fa13-4e0c-a917-994154d81d64
```
copy your generated password and use it to login to the application.
To login go to the following url: `http://localhost:8080/login`

## Create the database
Insert the following record to the `roles` table: 

```roomsql
INSERT INTO `a7nov`.`roles` (`id`, `name`) VALUES ('1', 'Admin');
INSERT INTO `a7nov`.`roles` (`id`, `name`) VALUES ('2', 'User');

```

## Postman Testing
To to test the JWT token, you have first register, and then login.
Once you login, copy the jwt token, and go to Postman and paste it in the `Authorization` header.
Choose `Bearer Token` as the type of the token.

## Notes
If you found an issue in the project, please report it in the issues section.