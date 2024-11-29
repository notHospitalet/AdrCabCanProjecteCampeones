package com.example.adrcabcanprojectecampeones.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.adrcabcanprojectecampeones.models.Campeon;

import java.io.Serializable;

@Entity
public class CampeonEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nombre;
    private String linia;
    private String region;
    private String imagen;

    public CampeonEntity(){}

    public CampeonEntity(CampeonResponse campeon) {
        this.id = campeon.getId();
        this.nombre = campeon.getNombre();
        this.linia = campeon.getLinia();
        this.region = campeon.getRegion();
        this.imagen = campeon.getImagen();
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
