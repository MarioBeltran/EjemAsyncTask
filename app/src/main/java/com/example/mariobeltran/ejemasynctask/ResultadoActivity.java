package com.example.mariobeltran.ejemasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvMensaje = (TextView)findViewById(R.id.tvMensaje);
        String nombreUsuario = getIntent().getStringExtra("usuario");
        tvMensaje.setText("Bienvenido: " + nombreUsuario);
    }
}
