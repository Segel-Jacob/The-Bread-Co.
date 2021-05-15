package com.example.sourdoughchronicles;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.provider.ContactsContract;
import android.transition.Scene;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class menu extends Fragment {

    ImageButton btnBoule;
    ImageButton btnMajorca;
    ImageButton btnCherry;
    ImageButton btnBrioche;
    ImageButton btnCheddar;
    ImageButton btnPumpkin;
    BakeryApplication bApp;
    SharedPreferences sharedPref;

    public menu() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PreferenceManager.setDefaultValues(getContext(),R.xml.root_preferences,false);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());

        if (sharedPref.getBoolean("darkTheme",false)){
            getActivity().setTheme(R.style.DarkTheme);
        }
        else{
            getActivity().setTheme(R.style.AppTheme);
        }

        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        btnBoule = v.findViewById(R.id.imgBoule);
        btnMajorca = v.findViewById(R.id.imgMajorca);
        btnCherry = v.findViewById(R.id.imgCherryChoc);
        btnBrioche = v.findViewById(R.id.imgBrioche);
        btnCheddar = v.findViewById(R.id.imgCheddar);
        btnPumpkin = v.findViewById(R.id.imgPumpkin);

        bApp = (BakeryApplication)getActivity().getApplication();

        btnBoule.setOnClickListener(v1 -> {

            Intent intent = new Intent(getContext(),ingredients.class);
            intent.putExtra("menuItem","boule");
            startActivity(intent);
            try {
                bApp.addBoule();
            }
            catch (Exception e){
                Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();
            }

        });
        btnMajorca.setOnClickListener(v12 -> {
            Intent intent = new Intent(getContext(),ingredients.class);
            intent.putExtra("menuItem","majorca");
            startActivity(intent);
        });
        btnCherry.setOnClickListener(v13 -> {
            Intent intent = new Intent(getContext(),ingredients.class);
            intent.putExtra("menuItem","cherry");
            startActivity(intent);
        });
        btnBrioche.setOnClickListener(v14 -> {
            Intent intent = new Intent(getContext(),ingredients.class);
            intent.putExtra("menuItem","brioche");
            startActivity(intent);
        });
        btnCheddar.setOnClickListener(v15 -> {
            Intent intent = new Intent(getContext(),ingredients.class);
            intent.putExtra("menuItem","cheddar");
            startActivity(intent);
        });
        btnPumpkin.setOnClickListener(v16 -> {
            Intent intent = new Intent(getContext(),ingredients.class);
            intent.putExtra("menuItem","pumpkin");
            startActivity(intent);
        });
        return v;
    }
}