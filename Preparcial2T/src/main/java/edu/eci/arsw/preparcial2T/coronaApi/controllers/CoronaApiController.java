package edu.eci.arsw.preparcial2T.coronaApi.controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.preparcial2T.coronaApi.services.CovidServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class CoronaApiController {
    @Autowired
    private CovidServices service;

    @RequestMapping(value="/",method= RequestMethod.GET)
    public ResponseEntity<?> getGlobalStats() throws UnirestException {
        return new ResponseEntity<>(service.getGlobalStats(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/{country}",method= RequestMethod.GET)
    public ResponseEntity<?> getStatsByCountry(@PathVariable String country) throws UnirestException {
        return new ResponseEntity<>(service.getCountryTotalStats(country), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/provinces/{country}",method= RequestMethod.GET)
    public ResponseEntity<?> getStatsByCountryWithProvinces(@PathVariable String country) throws UnirestException {
        return new ResponseEntity<>(service.getCountryWithProvincesStats(country), HttpStatus.ACCEPTED);
    }

}
