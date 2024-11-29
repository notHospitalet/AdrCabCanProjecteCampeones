package com.example.adrcabcanprojectecampeones.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// clase que se encarga de gestionar la isntancia retrofit para realizar llamadas a la api
public class RetrofitClient {

    private static final String BASE_URL = "https://vadvfivbaalnftlwyfcq.supabase.co/rest/v1/";

    private static Retrofit retrofit;

    // metodo que proporciona la instancia retrofit, si no ha sido creada la configura y la crea, sino solo la devuelve
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
