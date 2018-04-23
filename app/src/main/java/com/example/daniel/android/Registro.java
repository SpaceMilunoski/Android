package com.example.daniel.android;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        final EditText etUsuario = (EditText) findViewById(R.id.etUsuario);
        final EditText etPass = (EditText) findViewById(R.id.etPas);
        final EditText etPassotra = (EditText) findViewById(R.id.etPasotra);
        final Button btnGuardar = (Button) findViewById(R.id.btnRegistrarser);
        final Crud  admin = new Crud(this, "administracion", null, 1);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SQLiteDatabase bd = admin.getWritableDatabase();

                // String id = et1.getText().toString();
                String usuario = etUsuario .getText().toString();
                String pass = etPass.getText().toString();
                String passotra = etPassotra.getText().toString();

                ContentValues registro = new ContentValues();

                registro.put("usuario", usuario);
                registro.put("contrasena", pass);

                // los inserto en la base de datos
                bd.insert("usuario", null, registro);

                bd.close();

                etPass.setText(""); etUsuario.setText(""); etPassotra.setText("");

                Toast.makeText(Registro.this,"Datos del usuario cargados", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
