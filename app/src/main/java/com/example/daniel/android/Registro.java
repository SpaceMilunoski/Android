package com.example.daniel.android;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class Registro extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    CircleImageView imvUsuario;
    Bitmap bitmap =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        imvUsuario = (CircleImageView) findViewById(R.id.imgUsuarior);
        final FloatingActionButton btnImagen = (FloatingActionButton) findViewById(R.id.btnimagenr);
        final EditText etUsuario = (EditText) findViewById(R.id.etUsuario);
        final EditText etPass = (EditText) findViewById(R.id.etPas);
        final EditText etPassotra = (EditText) findViewById(R.id.etPasotra);
        final Button btnGuardar = (Button) findViewById(R.id.btnRegistrarser);
        final Crud  admin = new Crud(this, "administracion", null, 1);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etUsuario.getText().toString().equals("") || !etPass.getText().toString().equals("")){
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
                    Intent i = new Intent(Registro.this,Login.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(Registro.this,"Error datos vacios", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }
    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            //imvUsuario.setImageURI(imageUri);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                imvUsuario.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

