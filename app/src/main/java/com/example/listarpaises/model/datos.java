package com.example.listarpaises.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class datos {
    private String pais;
    private String totalconfirmado;
    private String totalmuertes;
    private String nuevos;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTotalconfirmado() {
        return totalconfirmado;
    }

    public void setTotalconfirmado(String totalconfirmado) {
        this.totalconfirmado = totalconfirmado;
    }

    public String getTotalmuertes() {
        return totalmuertes;
    }

    public void setTotalmuertes(String totalmuertes) {
        this.totalmuertes = totalmuertes;
    }

    public String getNuevos() {
        return nuevos;
    }

    public void setNuevos(String nuevos) {
        this.nuevos = nuevos;
    }
    public datos(JSONObject a) throws JSONException {
        pais =  a.getString("Country").toString();

        totalconfirmado =  a.getString("TotalConfirmed").toString() ;
        totalmuertes =  a.getString("TotalDeaths").toString() ;
        nuevos = a.getString("NewConfirmed").toString() ;


    }

    public static  ArrayList<datos> JsonObjectsBuild(JSONArray pais) throws JSONException {
        ArrayList<datos> ps = new ArrayList<>();

        for (int i = 0; i < pais.length() ; i++) {
            ps.add(new datos(pais.getJSONObject(i)));
        }
        return ps;
    }
}
