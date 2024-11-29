package com.example.adrcabcanprojectecampeones.models;

import com.example.adrcabcanprojectecampeones.data.CampeonEntity;
import com.example.adrcabcanprojectecampeones.data.CampeonResponse;

public class Campeon {
    int id;
    String nombre;
    String imagen;
    String linia;
    String region;


    public Campeon(CampeonResponse campeonesResponse){
        this.id = campeonesResponse.getId();
        this.nombre = campeonesResponse.getNombre();
        this.imagen = campeonesResponse.getImagen();
        this.linia = campeonesResponse.getLinia();
        this.region = campeonesResponse.getRegion();
    }

    public Campeon(CampeonEntity campeonEntity) {
        this.id = campeonEntity.getId();
        this.nombre = campeonEntity.getNombre();
        this.imagen = campeonEntity.getImagen();
        this.linia = campeonEntity.getLinia();
        this.region = campeonEntity.getRegion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLinia() {
        return linia;
    }

    public void setLinia(String linia) {
        this.linia = linia;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
