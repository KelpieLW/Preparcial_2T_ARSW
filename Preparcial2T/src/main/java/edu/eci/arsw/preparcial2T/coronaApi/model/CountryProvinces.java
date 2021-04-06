package edu.eci.arsw.preparcial2T.coronaApi.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class CountryProvinces {

    private ArrayList<HashMap> provinces=new ArrayList<HashMap>();

    public CountryProvinces(){

    }
    public CountryProvinces(JSONArray jsonArrayProvinces){
        for (int i=0;i<jsonArrayProvinces.length();i++){
            HashMap provinceHashmap = new HashMap<String,String>();
            provinceHashmap.put("city",jsonArrayProvinces.getJSONObject(i).getString("city"));
            provinceHashmap.put("province",jsonArrayProvinces.getJSONObject(i).getString("province"));
            provinceHashmap.put("country",jsonArrayProvinces.getJSONObject(i).getString("country"));
            provinceHashmap.put("confirmed",jsonArrayProvinces.getJSONObject(i).getInt("confirmed"));
            provinceHashmap.put("recovered",jsonArrayProvinces.getJSONObject(i).getInt("recovered"));
            provinceHashmap.put("deaths",jsonArrayProvinces.getJSONObject(i).getInt("deaths"));
            this.provinces.add(provinceHashmap);

        }

    }

    public ArrayList<HashMap> getProvinces() {
        return provinces;
    }

    public void setProvinces(ArrayList<HashMap> provinces) {
        this.provinces = provinces;
    }
}
