package com.rest.find.primes.service;

import com.rest.find.primes.model.PrimeResponseEntity;

public interface FindPrimeNumberService {
    PrimeResponseEntity findPrimeNumbers(int number);
    boolean isNumberPrime(int number);
}
