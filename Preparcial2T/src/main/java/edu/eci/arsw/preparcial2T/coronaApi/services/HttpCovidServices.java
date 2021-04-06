package edu.eci.arsw.preparcial2T.coronaApi.services;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.mashape.unirest.http.HttpResponse;

@Service
public class HttpCovidServices {
    public JSONObject getCoronaGlobalStats() throws UnirestException {

        HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/total")
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "7fc63b0c57msh1ba14142cfc0fddp1d8c42jsn5bb007619597")
                .asString();
        return new JSONObject(response.getBody()).getJSONObject("data");
    }

    public JSONObject getCoronaCountryTotalStats(String country)throws UnirestException{
        HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/total/?country="+country)
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "7fc63b0c57msh1ba14142cfc0fddp1d8c42jsn5bb007619597")
                .asString();
        return new JSONObject(response.getBody()).getJSONObject("data");
    }
    public JSONObject getCoronaCountryProvinceTotalStats(String country)throws UnirestException{
        HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+country)
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "7fc63b0c57msh1ba14142cfc0fddp1d8c42jsn5bb007619597")
                .asString();
        return new JSONObject(response.getBody()).getJSONObject("data");
    }



}
