package com.samuelbwr.cities;

public class City {
    private String ibge_id;
    private String uf;
    private String name;
    private String capital;
    private String lon;
    private String lat;
    private String no_accents;
    private String alternative_names;
    private String microregion;
    private String mesoregion;


    public String getIbge_id() {
        return ibge_id;
    }

    public void setIbge_id(String ibge_id) {
        this.ibge_id = ibge_id;
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
    public String getNo_accents() {
        return no_accents;
    }

    public void setNo_accents(String no_accents) {
        this.no_accents = no_accents;
    }

    public String getAlternative_names() {
        return alternative_names;
    }

    public void setAlternative_names(String alternative_names) {
        this.alternative_names = alternative_names;
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

        if (ibge_id != null ? !ibge_id.equals( city.ibge_id ) : city.ibge_id != null) return false;
        if (uf != null ? !uf.equals( city.uf ) : city.uf != null) return false;
        if (name != null ? !name.equals( city.name ) : city.name != null) return false;
        if (capital != null ? !capital.equals( city.capital ) : city.capital != null) return false;
        if (lon != null ? !lon.equals( city.lon ) : city.lon != null) return false;
        if (lat != null ? !lat.equals( city.lat ) : city.lat != null) return false;
        if (no_accents != null ? !no_accents.equals( city.no_accents ) : city.no_accents != null) return false;
        if (alternative_names != null ? !alternative_names.equals( city.alternative_names ) : city.alternative_names != null)
            return false;
        if (microregion != null ? !microregion.equals( city.microregion ) : city.microregion != null) return false;
        return mesoregion != null ? mesoregion.equals( city.mesoregion ) : city.mesoregion == null;
    }

    @Override
    public int hashCode() {
        int result = ibge_id != null ? ibge_id.hashCode() : 0;
        result = 31 * result + (uf != null ? uf.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (lon != null ? lon.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (no_accents != null ? no_accents.hashCode() : 0);
        result = 31 * result + (alternative_names != null ? alternative_names.hashCode() : 0);
        result = 31 * result + (microregion != null ? microregion.hashCode() : 0);
        result = 31 * result + (mesoregion != null ? mesoregion.hashCode() : 0);
        return result;
    }
}
