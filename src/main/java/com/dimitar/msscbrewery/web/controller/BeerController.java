package com.dimitar.msscbrewery.web.controller;

import com.dimitar.msscbrewery.services.BeerService;
import com.dimitar.msscbrewery.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") final UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> handlePost(@Valid @RequestBody final BeerDto beerDto) {
        final BeerDto savedBeerDto = beerService.saveNewBeer(beerDto);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedBeerDto.getId().toString());
        return new ResponseEntity<BeerDto>(httpHeaders, HttpStatus.CREATED);
    }


    @PutMapping("/{beerId}")
    public ResponseEntity<?> handleUpdate(@PathVariable("beerId") final UUID beerId, final @Valid @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteById(beerId);
    }

}
