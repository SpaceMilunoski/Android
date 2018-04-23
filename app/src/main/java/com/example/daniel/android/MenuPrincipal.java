package com.example.daniel.android;
import  android.content.Context;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Tono2 on 18/04/2018.
 */

public class MenuPrincipal extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_menuprincipal, container, false);
        //final FragmentManager fragmentManager = getFragmentManager();
        final Button btnJuego = (Button) view.findViewById(R.id.btnJuegos);
        //final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        btnJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fragmentManager.beginTransaction().replace(R.id.Contenido, new MenuPrincipal()).commit();
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.Contenido, new Juegos()).commit();
            }
        });
        return view;
    }
}