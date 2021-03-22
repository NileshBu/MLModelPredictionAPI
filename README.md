# MLModelPredictionAPI

URL Processor service is responsible for predicting the Sucess or Failure of the Cold Calling Campaign(For Car Insurance) using the trained Random Forest Machine Learning Model with accuracy around 84%.

Use Swagger or Postman to make REST calls e.g. http://localhost:8080/api/'specific endpoint'

HOW TO USE
WITH GIT : https://github.com/NileshBu/MLModelPredictionAPI.git

REQUIREMENTS 
Java 8 & Above
IDE( Spring Tool Suite or Intellij)

Core Requirements (Docker OR Python Set Up In Local)
1.) Docker : It is very  important that the ML Model API has to be up and running for using this application and acessing the endpoint within it. For this :  
docker run -p 5000:5000 bukane/ prediction-api . 
OR
2.) Python : Checkout the files from https://github.com/NileshBu/InsuranceMLModel.git . After this Run app.py file locally.
Either of the two options mentioned above can be used to Run the ML model API.


BASIC GUIDE TO THE SERVICE 1.) Use the Endpoint (predictOutcome) with POST REQUEST http://localhost:8080/api/predictOutcome for predicting the outcome of the Cold Call Campaign. For this follow the below mentioned steps:

1.) Check out the project Or Clone the project in your local.


2.) Open the project in the desirable IDE(Intellij or STS). 


3.) Run the spring boot project locally.( By running the SpringBoot Application)


4.) Run the ML Model API using Docker or Python.( Details mentioned in Core Requirements above)


5.) Once both the applications are started; then use Postman or Swagger (http://localhost:8080/swagger-ui/) for accessing the Endpoint (Rest API).


6.) If using POSTMAN : use POST call for http://localhost:8080/api/predictOutcome and in the body of the request pass Json data of below type. The Json Array can have multiple JSon Object ; therefore if required the additional JSON object can be added to 'DATA' Json Array. In the below sample data I have Json Array with 2 Object (one with Id:2 and another with ID:3); and according to the requirement we can add more objects. 


This Endpoint will give the results per ID based. For instance:-->The Outcome for DataSet with Id : '2' Is Predicted that it would be a : 'SUCCESS' and so on. 
So if our Json Array has two elements(2 JsonObjects) then we will have 2 Results and if more Json Objects than the results will be increasing accordingly.



{ "Data":[{
   "Id":2,
   "Age":29,
   "Job":"management",
   "Marital":"single",
   "Education":"tertiary",
   "Default":0,
   "Balance":637,
   "HHInsurance":1,
   "CarLoan":0,
   "Communication":"cellular",
   "LastContactDay":3,
   "LastContactMonth":"jun",
   "NoOfContacts":1,
   "DaysPassed":119,
   "PrevAttempts":1,
   "Outcome":"failure",
   "CallStart":"16:30:24",
   "CallEnd":"16:36:04"},
   
   
   {"Id":3,
   "Age":29,
   "Job":"management",
   "Marital":"single",
   "Education":"tertiary",
   "Default":0,
   "Balance":637,
   "HHInsurance":1,
   "CarLoan":0,
   "Communication":"cellular",
   "LastContactDay":3,
   "LastContactMonth":"jun",
   "NoOfContacts":1,
   "DaysPassed":119,
   "PrevAttempts":1,
   "Outcome":"failure",
   "CallStart":"16:30:24",
   "CallEnd":"16:36:04"}
   ]
}



NOTE:  IT IS VERY IMPORTANT to Run the ML Model API using Docker or Python.( Details mentioned in Core Requirements above); before hitting the above endpoint(REST API).


7.) After sending this request; the results will be avilable in below format: It will basically let you know; if the outcome for the particular record with particular Id will be SUCESS OR FAILURE.


[The Outcome for DataSet with Id : '2' Is Predicted that it would be a : 'SUCCESS'
, The Outcome for DataSet with Id : '3' Is Predicted that it would be a : 'SUCCESS'
] 







