# calculateprimes
RESTful service that calculates and returns all the prime numbers up to an including a number provided

To run the application :-
1) Start the application (Tomcat Server default port - 8080)
2) Open Postman client and provide the url - http://localhost:8080/api/primes/10
   HTTP method = GET
   HTTP Header ==> Accept = application/json or application/xml
3) Click the send button to get the result in json or xml format based on the Accept header value.
4) Caching is implemented to improve the performance.
