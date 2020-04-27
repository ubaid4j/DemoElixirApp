### Notes
- I have used ```lombok``` , enable it on your IntelliJ Idea to avoid compile time error
- Java 8 is compatible, Now you can run it with Java 8

### Requirements
- Java 8 or greater

### What it does
- When you access http://localhost:9090/ then it simply read a csv file (stored inside the application) and View the rows of CSV file in tabular form
- You can upload a csv file of same format, and it renders the rows of csv in web view 

### How to Run
#### For Windows Users
- git clone https://github.com/UbaidurRehman1/DemoElixirApp
- cd DemoElixirApp
- .\mvnw.cmd spring-boot:run
- You can access application here http://localhost:9090/


#### For Linux and Mac Users
- git clone https://github.com/UbaidurRehman1/DemoElixirApp
- cd DemoElixirApp
- chmod +x mvnw
- ./mvnw spring-boot:run
- You can access application here http://localhost:9090/


### Docker
- git clone https://github.com/UbaidurRehman1/DemoElixirApp
- cd DemoElixirApp
- For Single Stage 
    - chmod +x mvnw
    - ./singleStage-run.sh
- For Multi Stage
    - ./multiStage-run.sh
- You can access it http://localhost:9090/

### Demo
- ![](img/demo.png)

### Todo
- Exception Handling