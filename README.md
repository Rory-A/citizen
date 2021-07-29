To run the application:
1. In the 'src/main/resources/application.properties' file change the apiKey value from \<INSERT-VALUE\> to the value sent in the email
2. Navigate to the root of the project in a terminal window and run 'mvn spring-boot:run'
3. Send http requests to http://localhost:8080/formatData
    - An example request, using the data link provided in the task would look like:
        - curl --location --request GET 'http://localhost:8080/formatData?dataUrl=https://docs.google.com/spreadsheets/d/1Atg931ZiX6wjlx4pVO9uIcIhcK32htdz2NaAwWzC1uQ/edit?usp=sharing&sheetName=Sheet1'
    - The data can also be sorted by city and surname (alphabetically). A request sorted by surname would look like:
        - curl --location --request GET 'http://localhost:8080/formatData?dataUrl=https://docs.google.com/spreadsheets/d/1Atg931ZiX6wjlx4pVO9uIcIhcK32htdz2NaAwWzC1uQ/edit?usp=sharing&sheetName=Sheet1&sortBy=surname'

If I had more time, I would add more handling of edgecases.
