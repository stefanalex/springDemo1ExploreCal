# springDemo1ExploreCal
microservices-and-restful-services-with-spring-boot

http://explorecalifornia.org

Ctrl + SHIFT + L which will open a list of all major shortcuts for eclipse.

### New Requirement

Travelers Can Rate Tours

* As a traveler who participated in a **tour** , I would like to submit a 1-5 star **score** and a **comment** up to 255 chars .
  I have a personal **customer identifier**.
  
Modify a tour rating

* As a traveler who previously rated a tour , I would like to modify the score or comment
  I have a personal customer identifier.


View all tours

* As a traveler, I would like to view the average score for each tour.
  I do not need a personal customer identifier for this use case.
  
View the average score

* As a potential traveler , I would like to view all the scores and comments for a tour.
  I do not need a personal customer identifier for this use case.
  
  
Various response codes for the scenarios
  

### UC -> Entities - find noun into requirements

Travelers Can Rate Tours -> TourRating( tourRattingPK(tour,customerID)) ,score ,comment)

### New Requirements

*As an administrator who publishes the ExploreCalifornia.json file , I would like the micro service to be able to ingest the .json 
file even if the details differ from tour to tour.

Always be present in a tour ( constraints) :
   "title" - value of title can change with each import
   "packageType" - value must match tour package name in DB
   
As a /tours client , I would like to key the names in the response payload to match the key names found in the .json file
This requirement is only for the details , not for the summary . 
(Summary=Id, Title,Tour package code,Tour package name)

As a /tours client , I would like to look up tours by tour package code but the response body should only return the summary(Id,Title,tour package code , Tour package name) not details .
   
   
### UC -> No schema MongoDB database , no FK concept

Advantages

* Data structure is flexible - easy to add , change,delete.
* Entries for an artifact repository can differ

Disadvantages

* Does not automatically catch referential integrity errors
* Application responsible for managing data integrity


Aplication itself must check for integrity errors

   
