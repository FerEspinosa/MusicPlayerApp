package com.curso.android.app.practica.musicplayerapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt = findViewById(R.id.title_txt);
        start = findViewById(R.id.play_btn);
        stop = findViewById(R.id.stop_btn);


        start.setOnClickListener(v -> {
            Intent serviceIntent = new Intent(getApplicationContext(), MyCustomService.class);
            startService(serviceIntent);

        });
        stop.setOnClickListener(v -> {
            Intent serviceIntent = new Intent(getApplicationContext(), MyCustomService.class);
            stopService(serviceIntent);

        });
    }
}