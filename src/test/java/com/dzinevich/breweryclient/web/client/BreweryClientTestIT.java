package com.dzinevich.breweryclient.web.client;

import com.dzinevich.breweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTestIT {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        BeerDto newBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .name("AleAle")
                .style("ALE")
                .build();
        URI newBeerLocation = breweryClient.saveNewBeer(newBeer);

        assertNotNull(newBeerLocation);
    }

    @Test
    void updateABeer() {
        BeerDto updatedBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .name("AleAle")
                .style("ALE")
                .build();
        breweryClient.updateBeer(updatedBeer);
    }

    @Test
    void deleteABeer() {
        BeerDto beerToDelete = BeerDto.builder()
                .id(UUID.randomUUID())
                .name("AleAle")
                .style("ALE")
                .build();
        breweryClient.deleteBeer(beerToDelete);
    }
}