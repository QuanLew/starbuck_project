# STARTBUCKS MIDTERM 2023

### 1. Code Changes & Discussion
* Explain (with code snippets from sample code) how the Web UI is able to "remember" the selected Store.
<br/>-> Web UI will get value from register to remember which store is selected
* Explain (with code snippets from your code) how you implemented storing the Order in MySQL.
<br/>-> 
* Explain (with code snippets from your code) how you support generating a different "random" order with each "Place Order" request (instead of the starter code's "hard coded" order)
  <br/>->
* Explain (with code snippets from your code) how you added support for Spring Security / Login Page
  + What's the User Name and Password you created? How did you "Hash" the Password?
    <br/>-> User Name is "user" and Password is "password" . I will build a function named hmac_sha256 to convert the "password" 
  + How does your implementation work behind a Load Balancer without using LB Sticky Sessions?
    <br/>->
  + How does your solution managed "remembering" the active order for a register
    / store?
    <br/>-> It will not work
* Did you make any System Architecture Changes to support the requirements?
  + If Yes, please explain and include an updated System Architecture Diagram. 
  + You may use the starter diagram (spring-cashier.asta (https://sjsu.instructure.com/courses/1559594/files/72468378?wrap=1) (https://sjsu.instructure.com/courses/1559594/files/72468378/download? download_frd=1) ) and make changes to it.
  <br/>-> No, I didn't. 
### 2. Successful Deployment
* Include your specifications for:
  + Dockerfile <br/>
  ![image1](./images/image1.png)<br/>
  + Docker Compose YAML<br/>
  ![image2](./images/image2.png)<br/>
  ![image3](./images/image3.png)<br/>
  + Spring Application Properties<br/>
  ![image4](./images/image4.png)<br/>
  + Screenshots (Docker PS or Docker Dashboard) showing status of Container with Port Mappings<br/>
  ![image5](./images/image5.png)<br/>
  + Screenshots for HA Proxy / LB Admin Console showing "green" healthy status of Containers<br/>
  ![image6](./images/image6.png)<br/>
  + Screenshots of the MySQL Commands to prepare the DB for deployment<br/>
  ![image7](./images/image7.png)<br/>
### 3. Test Results / Demonstration
* Include Screenshots of Spring Cashiers App UI (must include full browser URL and full page showing Host/IP)
* Login to the Spring Cashier's App
* Place Three Orders at Three Different Stores
* Provide evidence of the Orders Placed as shown on Web UI with MySQL Queries confirming Orders Stored in DB