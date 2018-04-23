package com.example.daniel.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;


public class Juegos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_main, container, false);
        final Button btnCuestionario = (Button) view.findViewById(R.id.btnCuestionario);
        // Inflate the layout for this fragment
        btnCuestionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity() , Ajustes.class );
                startActivity(i);
            }
        });
        return view;
    }

}
