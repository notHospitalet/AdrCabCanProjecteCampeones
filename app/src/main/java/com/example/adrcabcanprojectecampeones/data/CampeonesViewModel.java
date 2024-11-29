package com.example.adrcabcanprojectecampeones.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.adrcabcanprojectecampeones.models.Campeon;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CampeonesViewModel extends AndroidViewModel {
    private final Application app;
    private final AppDatabase appDatabase;
    private final CampeonDAO campeonDao;
    private LiveData<List<Campeon>> campeones;

    public CampeonesViewModel(Application application) {
        super(application);

        this.app = application;
        this.appDatabase = AppDatabase.getDatabase(this.getApplication());
        this.campeonDao = appDatabase.getCampeonDao();
    }

    public LiveData<List<CampeonEntity>> getCampeones() {
        RefreshDataTask();
        return campeonDao.getCampeon();
    }

    public void RefreshDataTask() {

        CampeonApiService apiService = RetrofitClient.getRetrofitInstance().create(CampeonApiService.class);
        Call <List<CampeonResponse>> call = apiService.getCampeones("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZhZHZmaXZiYWFsbmZ0bHd5ZmNxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzIwMDg5NDQsImV4cCI6MjA0NzU4NDk0NH0.iVYk162dwEGlR7aSYKkXF6NBfV2ciLqR_F4UU56j_nw");

        call.enqueue(new Callback<List<CampeonResponse>>() {
            @Override
            public void onResponse(Call<List<CampeonResponse>> call, Response<List<CampeonResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List <CampeonResponse> campeonesResponse = response.body();

                    ArrayList<CampeonEntity> campeonEntities = new ArrayList<>();
                    for (CampeonResponse campeonResponse : campeonesResponse ) {
                        campeonEntities.add(new CampeonEntity(campeonResponse));
                    }
                    new Thread(() -> campeonDao.addCampeones(campeonEntities)).start();
                }
            }

            @Override
            public void onFailure(Call<List<CampeonResponse>> call, Throwable t) {

            }
        });

    }
}