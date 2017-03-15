package com.example.denis.lab3ejercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etname;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazamos los objetos.
        etname = (EditText) findViewById(R.id.etname);
        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    //Método para el boton Verificar

    public void verify(View v){
        Intent i = new Intent(this,VerifyCondition.class);
        i.putExtra("name", etname.getText().toString());
        startActivityForResult(i,1);
    }

    //Método para recuperar el resultado de la segunda activity

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        String result = data.getExtras().getString("resultado");
        if (resultCode == RESULT_OK){
            txtResult.setText("Respuesta: " + result);
        }
    }
}
