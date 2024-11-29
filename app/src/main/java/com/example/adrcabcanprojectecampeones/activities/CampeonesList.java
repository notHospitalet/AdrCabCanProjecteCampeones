package com.example.adrcabcanprojectecampeones.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.adrcabcanprojectecampeones.R;
import com.example.adrcabcanprojectecampeones.adapters.CampeonAdapter;
import com.example.adrcabcanprojectecampeones.data.CampeonEntity;
import com.example.adrcabcanprojectecampeones.data.CampeonesViewModel;
import com.example.adrcabcanprojectecampeones.data.RetrofitClient;
import com.example.adrcabcanprojectecampeones.models.Campeon;
import com.example.adrcabcanprojectecampeones.data.CampeonApiService;
import com.example.adrcabcanprojectecampeones.data.CampeonResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CampeonesList extends AppCompatActivity {

    private final String TAG = "CampeonesList";

    private List<Campeon> campeonList = new ArrayList<>();
    private CampeonAdapter adapter;
    private CampeonesViewModel campeonesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_campeones_list);

        adapter = new CampeonAdapter(this, campeonList);
        ListView listView = findViewById(R.id.listView_campeones);
        listView.setAdapter(adapter);

        mostrarDetalle(listView);
        //obtenerCampeones();

        campeonesViewModel = new ViewModelProvider(this).get(CampeonesViewModel.class);
        campeonesViewModel.getCampeones().observe(this, campeonEntities -> {
            campeonList.clear();
            for (CampeonEntity campeonEntity : campeonEntities) {
                campeonList.add(new Campeon(campeonEntity));
            }
            adapter.notifyDataSetChanged();
        });
    }

    private void mostrarDetalle(ListView listView) {
        listView.setOnItemClickListener((parent, view, position, id) -> {
          Campeon campeonSeleccionado = campeonList.get(position);

          Intent intent = new Intent(CampeonesList.this, CampeonDetailActivity.class);
          intent.putExtra("nombre", campeonSeleccionado.getNombre());
          intent.putExtra("linia", campeonSeleccionado.getLinia());
          intent.putExtra("region", campeonSeleccionado.getRegion());
          intent.putExtra("imagen", campeonSeleccionado.getImagen());
          startActivity(intent);
        });
    }

    /*private void obtenerCampeones() {

        CampeonApiService apiService = RetrofitClient.getRetrofitInstance().create(CampeonApiService.class);

        Call <List<CampeonResponse>> call = apiService.getCampeones("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZhZHZmaXZiYWFsbmZ0bHd5ZmNxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzIwMDg5NDQsImV4cCI6MjA0NzU4NDk0NH0.iVYk162dwEGlR7aSYKkXF6NBfV2ciLqR_F4UU56j_nw");

        call.enqueue(new Callback<List<CampeonResponse>>() {
            @Override
            public void onResponse(Call<List<CampeonResponse>> call, Response<List<CampeonResponse>>response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<CampeonResponse> campeonesResponse = response.body();
                    for (CampeonResponse campeonResponse: campeonesResponse) {
                        Campeon campeon = new Campeon(campeonResponse);
                        campeonList.add(campeon);
                    }
                   // Campeon campeon = new Campeon(campeonesResponse);

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<CampeonResponse>> call, Throwable t) {
                Log.e(TAG, "ERROR: Llamada de API" + t.getMessage());
            }
        });

    } */
}