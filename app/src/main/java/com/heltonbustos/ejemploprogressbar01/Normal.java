package com.heltonbustos.ejemploprogressbar01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Normal extends AppCompatActivity {

    TextView txtUsuarioActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        txtUsuarioActivity2 = findViewById(R.id.txtUsuarioActivity2);

        String recepcion = getIntent().getStringExtra("usuario");

        txtUsuarioActivity2.setText(recepcion);
    }
}