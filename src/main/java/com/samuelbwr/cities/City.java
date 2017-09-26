package com.samuelbwr.cities;

import java.util.Objects;

public class City {
    private String ibgeId;
    private String uf;
    private String name;
    private String capital;
    private String lon;
    private String lat;
    private String noAccents;
    private String alternativeNames;
    private String microregion;
    private String mesoregion;


    public String getIbgeId() {
        return ibgeId;
    }

    public void setIbgeId(String ibgeId) {
        this.ibgeId = ibgeId;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getNoAccents() {
        return noAccents;
    }

    public void setNoAccents(String noAccents) {
        this.noAccents = noAccents;
    }

    public String getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(String alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    public String getMicroregion() {
        return microregion;
    }

    public void setMicroregion(String microregion) {
        this.microregion = microregion;
    }

    public String getMesoregion() {
        return mesoregion;
    }

    public void setMesoregion(String mesoregion) {
        this.mesoregion = mesoregion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals( ibgeId, city.ibgeId ) &&
                Objects.equals( uf, city.uf ) &&
                Objects.equals( name, city.name ) &&
                Objects.equals( capital, city.capital ) &&
                Objects.equals( lon, city.lon ) &&
                Objects.equals( lat, city.lat ) &&
                Objects.equals( noAccents, city.noAccents ) &&
                Objects.equals( alternativeNames, city.alternativeNames ) &&
                Objects.equals( microregion, city.microregion ) &&
                Objects.equals( mesoregion, city.mesoregion );
    }

    @Override
    public int hashCode() {
        return Objects.hash( ibgeId, uf, name, capital, lon, lat, noAccents, alternativeNames, microregion, mesoregion );
    }

    @Override
    public String toString() {
        return "City{" +
                "ibgeId='" + ibgeId + '\'' +
                ", uf='" + uf + '\'' +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", noAccents='" + noAccents + '\'' +
                ", alternativeNames='" + alternativeNames + '\'' +
                ", microregion='" + microregion + '\'' +
                ", mesoregion='" + mesoregion + '\'' +
                '}';
    }
}
