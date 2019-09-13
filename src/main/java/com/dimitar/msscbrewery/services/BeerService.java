package com.dimitar.msscbrewery.services;

import com.dimitar.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
