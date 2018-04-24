package com.example.daniel.android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class temasdeestudio extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.temasdeestudio, container, false);
        //final FragmentManager fragmentManager = getFragmentManager();
        final Button btnTema1 = (Button) view.findViewById(R.id.btnIntroduccion);
        final Button btnTema2 = (Button) view.findViewById(R.id.btnClases);
        //final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        btnTema1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fragmentManager.beginTransaction().replace(R.id.Contenido, new MenuPrincipal()).commit();
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.Contenido, new Introduccion()).commit();
            }
        });
        btnTema2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fragmentManager.beginTransaction().replace(R.id.Contenido, new MenuPrincipal()).commit();
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.Contenido, new Clases()).commit();
            }
        });

        return view;
    }
}

