# BankingSystem

# Introduction

This is a dynamic web project which stimulates the real time banking system, all the data is stored in the database and a verified user is only given access to use the application.

# Tools used

**Front-End Languages :** HTML, CSS, BootStrap, JSP (Java server Pages)\
**Back-End Language :** Java, Java Servlets (used Session, cookies)\
**Database :** MySQL\
**DataBase-Java connector :** JDBC connectinos
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
    1. if we get success message the amount is deposited into your bank account
    


