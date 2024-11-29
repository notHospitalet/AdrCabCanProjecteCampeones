package com.example.adrcabcanprojectecampeones.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.adrcabcanprojectecampeones.R;

public class CampeonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_campeon_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // -


        // obtiene la referencia de los elementos del layout detail
        ImageView campeonImagen = findViewById(R.id.imageViewCampeonDetail);
        TextView campeonNombre = findViewById(R.id.textViewNombreDetail);
        TextView campeonLinia = findViewById(R.id.textViewLiniaDetail);
        TextView campeonRegion = findViewById(R.id.textViewRegionDetail);


        // con el intent recupera los datos de la actividad anterior (CampeonesList)
        String imageUrl = getIntent().getStringExtra("imagen");
        String nombre = getIntent().getStringExtra("nombre");
        String linia = getIntent().getStringExtra("linia");
        String region = getIntent().getStringExtra("region");

        Glide.with(this).load(imageUrl).into(campeonImagen);

        campeonNombre.setText(nombre);
        campeonLinia.setText("Linia: " + linia);
        campeonRegion.setText("Region: " + region);
    }
}