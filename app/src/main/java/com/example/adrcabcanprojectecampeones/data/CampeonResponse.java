package com.example.adrcabcanprojectecampeones.data;

import com.google.gson.annotations.SerializedName;

// clase que representa la respuesta de un campeon obtenida desde la API
// mapea las claves del json a los atributos del campeon
public class CampeonResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("linia")
    private String linia;

    @SerializedName("imagen")
    private String imagen;

    @SerializedName("region")
    private String region;

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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "CampeonesResponse{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", linia='" + linia + '\'' +
                ", imagen='" + imagen + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
