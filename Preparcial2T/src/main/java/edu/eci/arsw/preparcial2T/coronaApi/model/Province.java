package edu.eci.arsw.preparcial2T.coronaApi.model;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

public class Province {
    private String city;
    private String province;

    private Integer confirmed;
    private Integer recovered;
    private Integer dead;

    public Province(){

    }

    public Province(String city, String province, Integer confirmed,Integer recovered, Integer dead){
        this.city=city;
        this.province=province;
        this.confirmed=confirmed;
        this.recovered=recovered;
        this.dead=dead;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
