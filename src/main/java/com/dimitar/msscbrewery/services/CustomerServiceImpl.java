package com.dimitar.msscbrewery.services;

import com.dimitar.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(id).name("John").build();
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return CustomerDto.builder()
                .name(customerDto.getName())
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
       // @todo:
        log.info("Updating customer with id: " + customerId);
    }

    @Override
    public void deleteById(UUID customerId) {
        // @todo:
        log.info("Deleting customer with id: " + customerId);
    }

}
