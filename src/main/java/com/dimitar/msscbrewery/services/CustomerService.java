package com.dimitar.msscbrewery.services;

import com.dimitar.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID id);

}
