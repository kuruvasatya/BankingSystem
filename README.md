# BankingSystem

# Introduction

This is a dynamic web project which stimulates the real time banking system, all the data is stored in the database and a verified user is only given access to use the application.

# Tools used

**Front-End Languages :** HTML, CSS, BootStrap, JSP (Java server Pages)\
**Back-End Language :** Java, Java Servlets (used Session, cookies)\
**Database :** MySQL\
**DataBase-Java connector :** JDBC connectinos\
**Web-container** : TomCat

# How it works

1. Login page is loaded and user need to specify his credentials
    1. if right credentials are given control goes to Home Page
    1. if wrong credentials are given control again comes to login page showing that wrong credentials are entered
1. Creating account
    1. user neeed to enter name and password
    1. after successful registration user gets his account number
1. HomePage
    1. Here you can find your profile.
    2. You can see your name and your account number
1. Deposit
    1. Here we can deposit money
    1. if entered value is less than zero or not a integer then user is prompted a error message
    1. if we get success message the amount is deposited into your bank account and reflected in database
1. Withdraw
    1. Here we can withdraw money
    1. if entered value is not an integer, less than zero, or less than his current balance then user is prompted a error messagae
    1. if we get success message the amount is withdrawn from your bank account and reflected in database
1. Transer
    1. Here you can transfer money from your bank account to another.
    1. if sending bankaccount is not in the database then user is prompted a error message
    1. if entered value is not an integer, less than zero, or less than his current balance then user is prompted a error messagae
1. Balance Enquiry
    1. Here you can check the balance in your bank account

#Sequrity Managed

1. User should be a registed customer in the bank then only he is given permission to access\
1. You can only load **login.jsp** file, if you are trying to load any other page the request is atomatically redirected to login.jsp file, that is user can view any page if he successfully completes logging in.\
1. After logout you can not access the application by pressing vback button.



