package com.heltonbustos.ejemploprogressbar01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario, txtClave;
    Button btnLogin;
    ProgressBar progressBar;
    Handler h = new Handler();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtClave = findViewById(R.id.txtClave);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarLogin(view);
            }
        });
    }

    public void validarLogin(View view){
        String usuario = txtUsuario.getText().toString();
        String clave = txtClave.getText().toString();


        if(usuario.equals("") || clave.equals("")){
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show();
        }
        else if(usuario.equals("admin") && clave.equals("123")){
            //abrir un intent de admin
            progressBar.setVisibility(View.VISIBLE);
            intent = new Intent(this, Admin.class);
            h.postDelayed(cambiarActividad, 6000);
        }
        else if(usuario.equals("juanito") && clave.equals("123")){
            //abrir un intent de juanito
            progressBar.setVisibility(View.VISIBLE);
            intent = new Intent(this, Normal.class);
            intent.putExtra("usuario", usuario);
            h.postDelayed(cambiarActividad, 6000);
        }
        else if(usuario.equals("pedrito") && clave.equals("123")){
            //abrir un intent de pedrito
            progressBar.setVisibility(View.VISIBLE);
            intent = new Intent(this, Normal.class);
            intent.putExtra("usuario", usuario);
            h.postDelayed(cambiarActividad, 6000);
        }
        else{
            Toast.makeText(this, "La cuenta no existe", Toast.LENGTH_SHORT).show();
        }
    }

    public Runnable cambiarActividad = new Runnable() {
        @Override
        public void run() {
            progressBar.setVisibility(View.GONE);
            startActivity(intent);
        }
    };
}