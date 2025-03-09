# User-Product
User Microservice associated with Product Microservice (using Spring boot as backend and Angular as frontend)


Springboot-
    - created two microservices (named User and Product) 
    - establish communication between two microservices using Rest Template
    - It have some features-
        -Whenwhever you will try to delete the user that is not existing then you will get the exceptional error ("User id  is not existing")
        -If User is already using any product then you can't delete that product .If you try to delete any product(that is used by any User) then you will get an exceptional error(product is already used by some user).

Angular-
    - Created one page where CRUD operation is performed for User.

MySQL
    -Run this line 
        create database ups;
        use ups;
        select * from ups.users;
        select * from ups.products;
