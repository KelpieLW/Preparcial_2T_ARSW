package edu.eci.arsw.preparcial2T.coronaApi.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.preparcial2T.coronaApi.model.Country;
import edu.eci.arsw.preparcial2T.coronaApi.model.CountryProvinces;
import edu.eci.arsw.preparcial2T.coronaApi.model.World;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidServices {
    @Autowired
    HttpCovidServices httpCovidService;

    public World getGlobalStats() throws UnirestException{
        World globalStats=new World();
        JSONObject globalApiObject = httpCovidService.getCoronaGlobalStats();
        globalStats.setConfirmed(globalApiObject.getInt("confirmed"));
        globalStats.setDead(globalApiObject.getInt("deaths"));
//        globalStats.setRecovered(globalApiObject.getInt("recovered"));
        return globalStats;
    }

    public Country getCountryTotalStats(String country) throws UnirestException{
        JSONObject countryTotalStatJson = httpCovidService.getCoronaCountryTotalStats(country);

//        Country countryObject = new Country (countryTotalStatJson.getString("location"),countryTotalStatJson.getInt("confirmed"),countryTotalStatJson.getInt("recovered"), countryTotalStatJson.getInt("deaths"));
        Country countryObject = new Country (
                countryTotalStatJson.isNull("location") ? null:countryTotalStatJson.getString("location"),
                countryTotalStatJson.isNull("confirmed") ? null:countryTotalStatJson.getInt("confirmed"),
                countryTotalStatJson.isNull("recovered") ? null:countryTotalStatJson.getInt("recovered"),
                countryTotalStatJson.isNull("deaths") ? null:countryTotalStatJson.getInt("deaths")
            );
        return countryObject;
    }

    public Country getCountryWithProvincesStats(String country) throws UnirestException{
        JSONObject countryWithProvinceTotalStatJson = httpCovidService.getCoronaCountryProvinceTotalStats(country);
        Country countryProvincesObject = new Country(countryWithProvinceTotalStatJson.getJSONArray("covid19Stats"));

        return countryProvincesObject;
    }
}
