# FoodicesTask
## Google Task 
First I made the task for Google website test cases I used the page object model and cucumber and testNg to set my framework,

I used Web Driver Manager to select the driver without installing the compatible driver automatically on the test base page and, I used Chrome Web driver 

In the Google search page, I put my element locators using  find by  and By to use it when I put wait in different methods 

I used in other test cases that need scrolling Java script executer to scroll into dom to find elements instead of using scroll by with x and y 

I used most of the methods explicit wait to wait for an element to be located or to be visible because the running is so fast to capture sometimes element

I used cucumber and test runner to make test cases more clear to understand and used test runner to run all test cases at once 

I used testing listeners to make a report while running the test case and the report is HTML file you can access from the browser to see the passed and failed test cases 


## Rest assured task 
.First, the task wasn't clear at all because it was only indicated that there are 2 endpoints and write 3 test cases 

and it wasn't clear that I should take from the first response of first endpoint the token to use it in the second endpoint to get the data that took me a while to understand 

 .I made a rest API class to put all my functions on it 
 
.First I made a method for the base URL that I should use with the path directory 

.Then I made a method to post the data which is an email password and token and convert them into JSON objects to post it

.Then I extracted the response which is the token to use in the second endpoint 

.Then I made a method to return a response so I could assert that the response status code is correct

.I made another method for the second endpoint to get data email password and token plus the auth token
I extracted from the first endpoint and I made trim and split to the auth token so I can be able to use it

. And I made another method to get a response from the second endpoint 




## I made 4 test cases for that and I used the cucumber feature file and page object model 
 1-First test cases for the first endpoint that my data is posted correctly and the status code is 200 and I can get the response which is the auth token
 
2- Second I made another test case with invalid data for the first endpoint which was the wrong password to see the status code 

3- Third I made a test case to take the auth token from the first endpoint and use it in the other endpoint to get data

4- Fourth I made  a test case with an invalid auth token to see the response 




