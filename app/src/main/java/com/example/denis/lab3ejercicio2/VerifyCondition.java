package com.example.denis.lab3ejercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VerifyCondition extends AppCompatActivity {
    private TextView txtCondition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_condition);

        txtCondition = (TextView)findViewById(R.id.txtCondition);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        txtCondition.setText("Hola " + name +", ¿Aceptas las condiciones?");
    }

    //Cuando hacemos click en las opciones.
    public void condiciones(View v){
        Intent respuesta = new Intent();
        //Si el boton apretado es aceptar, se envia aceptado
        if(v.getId() == R.id.btAcept){
            respuesta.putExtra("resultado", "Aceptado");
        }
        //Si el boton apretado es rechazar, se envia rechazado
        if(v.getId() == R.id.btDeny){
            respuesta.putExtra("resultado", "Rechazado");
        }
        //El resultado que se envia.
        setResult(RESULT_OK,respuesta);
        //Cerramos la activity.
        finish();
    }
}
