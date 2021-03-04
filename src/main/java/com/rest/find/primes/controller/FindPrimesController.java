package com.rest.find.primes.controller;

import com.rest.find.primes.model.PrimeResponseEntity;
import com.rest.find.primes.service.FindPrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author PRITESHG
 * @since 03 March 2021
 * @version 0.1
 * @implNote This is a controller class which returns all the prime numbers till the number in the input request url.
 */

@RestController
public class FindPrimesController {

    @Autowired
    FindPrimeNumberService findPrimeNumberService;

    /**
     * @param number
     * @return ResponseEntity
     */
    @GetMapping(value = "/api/primes/{number}", produces = {"application/json","application/xml"})
    @Cacheable(value="primeResponseEntity", key = "#number")
    @ResponseBody
    public ResponseEntity<PrimeResponseEntity> findPrimes(@PathVariable Integer number){
        PrimeResponseEntity primeResponseEntity = findPrimeNumberService.findPrimeNumbers(number);
        return new ResponseEntity(primeResponseEntity, HttpStatus.ACCEPTED);
    }
}
