package com.example.daniel.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button ingresar = (Button) findViewById(R.id.btnIniciarsesion);
        final  Button registro = (Button) findViewById(R.id.btnRegistrarse);
        final EditText etUsuariol = (EditText) findViewById(R.id.etUsuariol);
        final EditText etPas = (EditText) findViewById(R.id.etPassl);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsuariol.getText().toString().equals("u")&& etPas.getText().toString().equals("")){
                    Intent i = new Intent(Login.this , MainActivity.class);
                    startActivity(i);
                }else {

                }
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,Registro.class);
                startActivity(i);
            }
        });
    }
}
