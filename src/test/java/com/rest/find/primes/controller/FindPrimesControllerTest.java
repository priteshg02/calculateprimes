package com.rest.find.primes.controller;

import com.rest.find.primes.model.PrimeResponseEntity;
import com.rest.find.primes.service.FindPrimeNumberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FindPrimesController.class)
public class FindPrimesControllerTest {

    @MockBean
    FindPrimeNumberService findPrimeNumberService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findPrimes() throws Exception {
        PrimeResponseEntity primeResponseEntity = new PrimeResponseEntity();
        primeResponseEntity.setInitial(10);
        List<Integer> primes = new ArrayList();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primeResponseEntity.setPrimes(primes);
        Mockito.when(findPrimeNumberService.findPrimeNumbers(Mockito.anyInt())).thenReturn(primeResponseEntity);

        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/primes/{number}", 10)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(MockMvcResultMatchers.jsonPath("$.Initial").value(10));
    }
}