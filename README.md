# User-Product 
User Microservice associated with Product Microservice (using Spring boot as backend and Angular as frontend)


Springboot-\
    &nbsp;&nbsp;&nbsp;&nbsp;- created two microservices (named User and Product) \
    &nbsp;&nbsp;&nbsp;&nbsp;- establish communication between two microservices using Rest Template\
    &nbsp;&nbsp;&nbsp;&nbsp;- It have some features-\
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-Whenwhever you will try to delete the user that is not existing then you will get the exceptional error ("User id  is not existing")\
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-If User is already using any product then you can't delete that product .If you try to delete any product(that is used by any User) then you will get an exceptional error(product is already used by some user).

Angular-\
    &nbsp;&nbsp;&nbsp;&nbsp;- Created one page where CRUD operation is performed for User.

MySQL\
    &nbsp;&nbsp;&nbsp;&nbsp;-Run this line \
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;create database ups;\
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;use ups;\
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;select * from ups.users;\
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;select * from ups.products;\
