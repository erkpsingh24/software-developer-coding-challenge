# Setup Steps:

 - [ ] cd software-developer-coding challenge/car-auction

 - [ ] mvn clean install
 - [ ] mvn spring-boot:run

 ### For CLI:

 - [ ] python setup/initializedb.py
 - [ ] python setup/traderev.py
 
 #### Note: Currently the application is set to create a new db at application startup. To change- 
 			src/main/resources/application.properties:spring.jpa.hibernate.ddl-auto - update(instead of create)
 	
 
 Please update if you need to change it.


# Software Developer Coding Challenge

This is a coding challenge for software developer applicants applying through http://work.traderev.com/

## Goal:

#### You have been tasked with building a simple online car auction system which will allow users to bid on cars for sale and with the following funcitionalies: 

  - [ ] Fork this repo. Keep it public until we have been able to review it.
  - [ ] A simple auction bidding system
  - [ ] Record a user's bid on a car
  - [ ] Get the current winning bid for a car
  - [ ] Get a car's bidding history 

 ### Bonus:

  - [ ] Unit Tests on the above functions
  - [ ] Develop a UI on web or mobile or CLI to showcase the above functionality

## Evaluation:

 - [ ] Solution compiles. Provide a README to run/build the project and explain anything that you leave aside
 - [ ] No crashes, bugs, compiler warnings
 - [ ] App operates as intended
 - [ ] Conforms to SOLID principles
 - [ ] Code is easily understood and communicative
 - [ ] Commit history is consistent, easy to follow and understand
