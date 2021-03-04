package com.rest.find.primes.service.impl;

import com.rest.find.primes.model.PrimeResponseEntity;
import com.rest.find.primes.service.FindPrimeNumberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FindPrimeNumberServiceImpl implements FindPrimeNumberService {


    @Override
    public PrimeResponseEntity findPrimeNumbers(int number) {
        List<Integer> primes = IntStream.rangeClosed(2, number)
                .filter(n -> isNumberPrime(n))
                .boxed()
                .collect(Collectors.toList());

        PrimeResponseEntity primeResponseEntity = new PrimeResponseEntity();
        primeResponseEntity.setInitial(number);
        primeResponseEntity.setPrimes(primes);
        return primeResponseEntity;
    }

    @Override
    public boolean isNumberPrime(int number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0 && IntStream.rangeClosed(3, (int) Math.sqrt(number))
                    .filter(n -> n % 2 != 0)
                    .noneMatch(n -> (number % n == 0));
    }
}
