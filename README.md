# Contact-List Security
Contact-List that is secured via Spring Security
 
Goals of this assignment:
* Understand how a server can be secured with Spring Security.

## Assigment 1
Protect the Contact-List with Spring Security
* Only authenticated users should be able to see the contacts
* CSRF needs to be disabled (or configured correctly)
* Make sure all tests are still working after the change

## Assignment 2
Only users with the role ADMIN should be able to add new contacts
* Set up a mock user-repository with two users, one regular user and one admin
* Add the required authorization rules to the configuration

## Assignment 3
Show the add-button only to admins
* Get the data of the logged-in user in the Controller
* Check the roles of the logged-in user

## Assignment 4
* Implement your own login-screen
  * Use `formLogin().loginPage(loginPage)` to configure the page
* Add a control for logout
  * You need to send an Http-Get to `/logout`
