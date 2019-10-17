package com.dimitar.msscbrewery.web.mappers;

import com.dimitar.msscbrewery.domain.Customer;
import com.dimitar.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);
}
