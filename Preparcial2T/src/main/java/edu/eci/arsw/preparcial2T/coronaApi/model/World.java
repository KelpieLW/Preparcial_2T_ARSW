package edu.eci.arsw.preparcial2T.coronaApi.model;

import org.springframework.stereotype.Component;

@Component
public class World {
    private Integer confirmed;
    private Integer recovered;
    private Integer dead;

    public World(){
        this.confirmed=0;
        this.recovered=0;
        this.dead=0;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }
}
