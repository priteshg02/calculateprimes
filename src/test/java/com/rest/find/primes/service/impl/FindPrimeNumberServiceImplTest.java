package com.rest.find.primes.service.impl;

import com.rest.find.primes.model.PrimeResponseEntity;
import com.rest.find.primes.service.FindPrimeNumberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindPrimeNumberServiceImplTest {

    @Test
    void findPrimeNumbers() {
        FindPrimeNumberService findPrimeNumberService = new FindPrimeNumberServiceImpl();
        PrimeResponseEntity actualPrimeResponseEntity = findPrimeNumberService.findPrimeNumbers(10);

        PrimeResponseEntity expectedPrimeResponseEntity = new PrimeResponseEntity();
        expectedPrimeResponseEntity.setInitial(10);
        List<Integer> primes = new ArrayList();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);

        expectedPrimeResponseEntity.setPrimes(primes);

        assertEquals(expectedPrimeResponseEntity.getInitial(),actualPrimeResponseEntity.getInitial());
        assertEquals(expectedPrimeResponseEntity.getPrimes(),actualPrimeResponseEntity.getPrimes());
    }
}