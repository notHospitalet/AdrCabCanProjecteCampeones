package com.example.adrcabcanprojectecampeones.data;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CampeonApiService {

    @GET("Campeones")
    Call <List<CampeonResponse>> getCampeones(@Query("apikey") String apikey);

}