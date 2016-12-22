# Spring Microblog

![screenshot](screenshot.png)

## Description

Make a web application that allows you write and delete short messages. When you click "Submit", it will refresh and show a list of messages you wrote. If you're feeling *déjà vu*, it's because this is the same assignment we did two weeks ago, but this time we're doing it with Spring.

## Requirements

* Create a project from the Spring template
  * Go to [Spring Initializr](https://start.spring.io/)
  * Choose "Gradle Project"
  * Group is `com.theironyard` and artifcat is `MicroblogSpring`
  * Click "Switch to the full version"
  * Check the following options:
    * Web
    * Mustache
    * DevTools
  * Download and unzip the project
  * Import into IntelliJ
	* Click `New`->`Project From Existing Sources`
	* Navigate to the directory
	* Select `build.gradle`
	* Click `Open` 
* Create `home.html` in the templates directory
	* It should display a login form like the first screenshot
* Create a controller class next to the main application class
* In your controller, create a route for `/`
  * It should take the model and the session as arguments
  * It should read the username from the session and add it to the model
  * It should return the home template
* In your controller, create a route for `/login`
  * It should take the session and the username as arguments
  * It should save the username to the session
  * It should return a redirect to `/`
* In `home.html`, use Mustache tags to conditionally show the markup in the two screenshots below
  * If `username` doesn't exist, show the login form like the first screenshot
  * If `username` does exist, show the message submission form and message list like the second screenshot
* Create a `Message` class next to your other classes
  * It should have fields for `id` and `text`
* Create an `ArrayList<Message>` in your controller to store submitted messages
* In your controller, create a route for `/add-message`
  * It should take the message text as an argument
  * It should create a `Message` object and add it to the arraylist (for the id, do something like `messages.size() + 1`)
  * It should return a redirect to `/`
* In `home.html`, add a button or link called "Delete" next to each message
  * It will need to send the id as a parameter
* In your controller, create a route for `/delete-message`
  * It should take the message id as an argument
  * It should remove the message with the given id (do something like `messages.remove(id - 1)`)
  * It should return a redirect to `/`

![screenshot 1](screenshot1.png)
![screenshot 2](screenshot2.png)

## Hard Mode
* Change the id to be a Universally Unique ID
	* Look up information on `java.util.UUID`
	* Change the `Message` object to have the id as a unique id (you may use a string)
	* Generate a new UUID when the object is created
* Using JavaScript (JQuery as well if you wish) ask the user to confirm the deletion of the message.
* We are family friendly so make sure that the message doesn't have anything bad in it before saving it.  In the event that it does make sure to display a message letting them know.
* Change the messages to contain username and date created
* Create a new endpoint and template to view the details of the message.
	* Add a edit button and associated backend code
	* Add a delete buttton and associated backend code
	* Display all of the details of the message including the author name
* Change the list of messages to link their associated details pages.


## Resources
* [Github Repo](https://github.com/tiy-lv-java-2016-06/spring-microblog)
* [Spring MVC Guide](https://spring.io/guides/gs/serving-web-content/)
* [Spring Initializr](https://start.spring.io/)
