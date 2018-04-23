package com.example.daniel.android;
import  android.content.Context;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by Tono2 on 18/04/2018.
 */

public class MenuPrincipal extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menuprincipal, container, false);

    }
}