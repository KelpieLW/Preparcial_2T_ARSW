package edu.eci.arsw.preparcial2T.coronaApi.model;

import org.json.JSONArray;

public class Location {

    private Double latitude;
    private Double longitude;
    public Location(){

    }
    public Location(JSONArray longLatArray){

        this.latitude=longLatArray.isNull(0)? null:(Double) longLatArray.getDouble(0);
        this.longitude=longLatArray.isNull(0)? null:(Double) longLatArray.getDouble(0);

    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
