package com.rest.find.primes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author PRITESHG
 * @since 03 March 2021
 * @version 0.1
 * @implNote This class is a response entity POJO with getter and setter methods.
 */

public class PrimeResponseEntity {
    @JsonProperty("Initial")
    Integer initial;

    @JsonProperty("Primes")
    List<Integer> primes;

    public Integer getInitial() {
        return initial;
    }

    public void setInitial(Integer initial) {
        this.initial = initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public void setPrimes(List<Integer> primes) {
        this.primes = primes;
    }
}
