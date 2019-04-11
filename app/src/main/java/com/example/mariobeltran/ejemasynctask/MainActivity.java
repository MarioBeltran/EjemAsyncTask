package com.example.mariobeltran.ejemasynctask;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button btnValidar;
    private EditText etUsuario, etClave;
    private ProgressBar progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnValidar = (Button)findViewById(R.id.btnValidar);
        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etClave = (EditText)findViewById(R.id.etClave);
        progressBar1 = (ProgressBar)findViewById(R.id.progressBar1);

        ///Llamo el metodo de la clase asynctask a traves del boton validar
        //Y le envio el usuario como parametro al metodo
        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task1().execute(etUsuario.getText().toString());
            }
        });



    }

    ////Clase Task1 que le extiendo la clase Asynctask
    class Task1 extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            progressBar1.setVisibility(View.VISIBLE);
            btnValidar.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            ///simulo por 5 segundo de espera ingreso
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //return null;
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            // super.onPostExecute(s);
            progressBar1.setVisibility(View.INVISIBLE);
            btnValidar.setEnabled(true);
            //Intent para pasar a la siguiente actividad despues de terminar el background thread
            Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
            intent.putExtra("usuario", etUsuario.getText().toString());
            startActivity(intent);
        }
    }

}
