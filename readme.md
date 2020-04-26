### Notes
- I have used ```lombok``` , enable it on your IntelliJ Idea to avoid compile time error  
- Java 14 is must cause I used *Java Switch Expression* which require Java 14 or greater
- If you don't have Java 14 then run ```./multiStage-run.sh```

### Requirements
- Java 14

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