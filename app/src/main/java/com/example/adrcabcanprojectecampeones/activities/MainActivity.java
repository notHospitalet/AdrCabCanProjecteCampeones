package com.example.adrcabcanprojectecampeones.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adrcabcanprojectecampeones.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        textView.setText("API CAMPEONES LoL");

        textView.setTextColor(Color.BLUE);
        button.setBackgroundColor(Color.BLUE);

    }

    public void siguientePagina(View element) {

        Intent intent = new Intent(MainActivity.this, CampeonesList.class);
        startActivity(intent);

    }
}