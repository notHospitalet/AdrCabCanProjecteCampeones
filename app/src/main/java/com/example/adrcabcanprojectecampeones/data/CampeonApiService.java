package com.example.adrcabcanprojectecampeones.data;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CampeonApiService {

    // interfaz para la api campeones,, realiza peticion get a Campeones

    @GET("Campeones")
    Call <List<CampeonResponse>> getCampeones(@Query("apikey") String apikey); // obtener lista campeones desde la api

}