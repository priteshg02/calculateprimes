package com.rest.find.primes.controller;

import com.rest.find.primes.model.PrimeResponseEntity;
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

    /**
     * @param number
     * @return ResponseEntity
     */
    @GetMapping(value = "/api/primes/{number}", produces = {"application/json","application/xml"})
    @Cacheable(value="primeResponseEntity", key = "#number")
    @ResponseBody
    public ResponseEntity<PrimeResponseEntity> findPrimes(@PathVariable Integer number){
        List<Integer> primes = IntStream.rangeClosed(2, number)
                .filter(n -> isNumberPrime(n))
                .boxed()
                .collect(Collectors.toList());

        PrimeResponseEntity primeResponseEntity = new PrimeResponseEntity();
        primeResponseEntity.setInitial(number);
        primeResponseEntity.setPrimes(primes);
        System.out.println("######prime numbers calculated manually");
        return new ResponseEntity<>(primeResponseEntity, HttpStatus.ACCEPTED);
    }

    private boolean isNumberPrime(int number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0 && IntStream.rangeClosed(3, (int) Math.sqrt(number))
                            .filter(n -> n % 2 != 0)
                            .noneMatch(n -> (number % n == 0));
    }
}
