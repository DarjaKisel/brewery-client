package com.dzinevich.breweryclient.web.client;

import com.dzinevich.breweryclient.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class CustomerClient {
    private static final String CUSTOMER_PATH_V1 = "/customer/";
    private final RestTemplate restTemplate;
    private final String hostName;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder,
                          @Value("${brewery.hostname}") String hostName) {
        this.restTemplate = restTemplateBuilder.build();
        this.hostName = hostName;
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(hostName + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto newCustomer) {
        return restTemplate.postForLocation(hostName + CUSTOMER_PATH_V1, newCustomer);
    }

    public void updateCustomer(CustomerDto updatedCustomer) {
        restTemplate.put(hostName + CUSTOMER_PATH_V1 + updatedCustomer.getId().toString(), updatedCustomer);
    }

    public void deleteCustomer(CustomerDto customerToDelete) {
        restTemplate.delete(hostName + CUSTOMER_PATH_V1 + customerToDelete.getId().toString());
    }
}
