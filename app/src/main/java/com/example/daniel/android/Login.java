package com.example.daniel.android;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button ingresar = (Button) findViewById(R.id.btnIniciarsesion);
        final  Button registro = (Button) findViewById(R.id.btnRegistrarse);
        final EditText etUsuariol = (EditText) findViewById(R.id.etUsuariol);
        final EditText etPas = (EditText) findViewById(R.id.etPassl);
        final Crud admin = new Crud (this, "administracion", null, 1);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                SQLiteDatabase bd = admin.getWritableDatabase();

                String usuario = etUsuariol.getText().toString();
                String pass = etPas.getText().toString();

                Cursor fila = bd.rawQuery(

                        "select * from usuario where usuario='" + usuario+"' and contrasena = '"+pass+"'", null);

                if (fila.moveToFirst()) {

                    Intent i = new Intent(Login.this , MainActivity.class);
                    startActivity(i);

                } else

                    Toast.makeText(Login.this, "No existe ningún usuario con ese dni",

                            Toast.LENGTH_SHORT).show();

                bd.close();

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
