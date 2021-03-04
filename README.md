# calculateprimes
RESTful service that calculates and returns all the prime numbers up to an including a number provided

To run the application :-
1) Start the application (Tomcat Server default port - 8080)
2) Open Postman client and provide the url - http://localhost:8080/api/primes/{number}
   here in the URL {number} can be any integer value.
3) HTTP method = GET
   HTTP Header:-
   Accept = application/json or application/xml
4) Click the send button to get the result in json or xml format based on the Accept header value.
5) Caching is implemented to improve the performance.
