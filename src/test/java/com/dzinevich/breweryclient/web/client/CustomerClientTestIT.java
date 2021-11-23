package com.dzinevich.breweryclient.web.client;

import com.dzinevich.breweryclient.web.model.BeerDto;
import com.dzinevich.breweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTestIT {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto newCustomer = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("BeerLover")
                .build();
        URI newCustomerLocation = customerClient.saveNewCustomer(newCustomer);

        assertNotNull(newCustomerLocation);
    }

    @Test
    void updateACustomer() {
        CustomerDto updatedCustomer = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("PaleAleDrinker")
                .build();
        customerClient.updateCustomer(updatedCustomer);
    }

    @Test
    void deleteACustomer() {
        CustomerDto customerToDelete = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("PaleAleDrinker")
                .build();
        customerClient.deleteCustomer(customerToDelete);
    }
}