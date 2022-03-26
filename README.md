# springDemo1ExploreCal
microservices-and-restful-services-with-spring-boot

http://explorecalifornia.org


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
