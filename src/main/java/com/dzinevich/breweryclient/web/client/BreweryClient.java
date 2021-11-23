package com.dzinevich.breweryclient.web.client;

import com.dzinevich.breweryclient.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryClient {
    private static final String BEER_PATH_V1 = "/beer/";
    private final RestTemplate restTemplate;
    private final String hostName;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder,
                         @Value("${brewery.hostname}") String hostName) {
        this.restTemplate = restTemplateBuilder.build();
        this.hostName = hostName;
    }

    public BeerDto getBeerById(UUID beerId) {
        return restTemplate.getForObject(hostName + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto newBeer) {
        return restTemplate.postForLocation(hostName + BEER_PATH_V1, newBeer);
    }

    public void updateBeer(BeerDto updatedBeer) {
        restTemplate.put(hostName + BEER_PATH_V1 + updatedBeer.getId().toString(), updatedBeer);
    }

    public void deleteBeer(BeerDto beerToDelete) {
        restTemplate.delete(hostName + BEER_PATH_V1 + beerToDelete.getId().toString());
    }
}
