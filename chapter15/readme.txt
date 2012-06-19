* Download and install GlassFish 2.1 : https://glassfish.dev.java.net/downloads/v2.1-b60e.html

* Package this code with mvn package (or to skip the test mvn clean package -Dmaven.test.skip=true)

* Deploy to GlassFish : asadmin deploy --force=true target\chapter15-resource-1.0.war

* Test with curl
curl -X GET -H "Accept: text/xml" http://localhost:8080/chapter15-resource-1.0/rs/helloworld
curl -X GET -H "Accept: text/plain" http://localhost:8080/chapter15-resource-1.0/rs/helloworld

// Create a book
curl -X POST --data-binary "{ \"title\":\"H2G2\", \"description\":\"Scifi IT book\", \"illustrations\":\"false\", \"isbn\":\"134-234\", \"nbOfPage\":\"241\", \"price\":\"24.0\" }" -H "Content-Type: application/json" -H "Accept: application/json" http://localhost:8080/chapter15-resource-1.0/rs/books

// Get all the books
curl -X GET -H "Accept: application/xml" http://localhost:8080/chapter15-resource-1.0/rs/books

// Get a book
curl -X GET -H "Accept: application/xml" http://localhost:8080/chapter15-resource-1.0/rs/books/1234
curl -X GET -H "Accept: application/json" http://localhost:8080/chapter15-resource-1.0/rs/books/1234

// Delete a book
curl -X DELETE http://localhost:8080/chapter15-resource-1.0/rs/books/1234
