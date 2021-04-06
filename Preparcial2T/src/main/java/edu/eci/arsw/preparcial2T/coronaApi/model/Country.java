package edu.eci.arsw.preparcial2T.coronaApi.model;

import org.json.JSONArray;

import java.util.ArrayList;

public class Country {
    private String countryName;
    private Integer confirmed;
    private Integer recovered;
    private Integer dead;
    private ArrayList <Province>provinces = new ArrayList<Province>();
    public Country(){

    }

    public Country(String countryName, Integer confirmed, Integer recovered, Integer dead){
        this.countryName=countryName;
        this.confirmed=confirmed;
        this.recovered=recovered;
        this.dead=dead;
    }

    public Country(JSONArray jsonArrayProvinces){
        for (int i=0;i<jsonArrayProvinces.length();i++){
            Province tempProvince = new Province(
                    jsonArrayProvinces.getJSONObject(i).isNull("city")? null:jsonArrayProvinces.getJSONObject(i).getString("city"),
                    jsonArrayProvinces.getJSONObject(i).isNull("province")? null:jsonArrayProvinces.getJSONObject(i).getString("province"),
                    jsonArrayProvinces.getJSONObject(i).isNull("confirmed")? null:jsonArrayProvinces.getJSONObject(i).getInt("confirmed"),
                    jsonArrayProvinces.getJSONObject(i).isNull("recovered")? null:jsonArrayProvinces.getJSONObject(i).getInt("recovered"),
                    jsonArrayProvinces.getJSONObject(i).isNull("deaths")? null:jsonArrayProvinces.getJSONObject(i).getInt("deaths")
            );

            provinces.add(tempProvince);

        }

    }

    public ArrayList<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(ArrayList<Province> provinces) {
        this.provinces = provinces;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

}
