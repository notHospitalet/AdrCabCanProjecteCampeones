package com.example.adrcabcanprojectecampeones.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.adrcabcanprojectecampeones.R;
import com.example.adrcabcanprojectecampeones.adapters.CampeonAdapter;
import com.example.adrcabcanprojectecampeones.data.CampeonEntity;
import com.example.adrcabcanprojectecampeones.data.CampeonesViewModel;
import com.example.adrcabcanprojectecampeones.models.Campeon;

import java.util.ArrayList;
import java.util.List;

public class CampeonesList extends AppCompatActivity {

    private final String TAG = "CampeonesList";

    private List<Campeon> campeonList = new ArrayList<>(); // almacenar campeones
    private CampeonAdapter adapter; // conectar la lista de campeones con la vista
    private CampeonesViewModel campeonesViewModel; // manejar logica y datos de los campeones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_campeones_list);

        adapter = new CampeonAdapter(this, campeonList);

        // obtiene el listView y lo asocia al adapter
        ListView listView = findViewById(R.id.listView_campeones);
        listView.setAdapter(adapter);

        mostrarDetalle(listView);

        // inicializa el viewModel y observa los cambios
        campeonesViewModel = new ViewModelProvider(this).get(CampeonesViewModel.class);
        campeonesViewModel.getCampeones().observe(this, campeonEntities -> {
            campeonList.clear(); // limpia la lista de campeones

            // convierte cada entidad campeon en un objeto y lo añade a la lista
            for (CampeonEntity campeonEntity : campeonEntities) {
                campeonList.add(new Campeon(campeonEntity));
            }
            adapter.notifyDataSetChanged();
        });

    }

    // metodo para manejar los clics en el listView y mostrar detalles del campeon
    private void mostrarDetalle(ListView listView) {
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Campeon campeonSeleccionado = campeonList.get(position); // obtiene el campeon seleccionado

            // con un intent inicia la actividad de la vista detalle y despues pasa los datos
            Intent intent = new Intent(CampeonesList.this, CampeonDetailActivity.class);
            intent.putExtra("nombre", campeonSeleccionado.getNombre());
            intent.putExtra("linia", campeonSeleccionado.getLinia());
            intent.putExtra("region", campeonSeleccionado.getRegion());
            intent.putExtra("imagen", campeonSeleccionado.getImagen());
            startActivity(intent);
        });
    }

    // boton refresh, limpia la lista y la vuelve a crear (refrescando el listView)
    public void refresh(View view) {

        campeonList.clear();
        campeonesViewModel.RefreshDataTask();
    }
}