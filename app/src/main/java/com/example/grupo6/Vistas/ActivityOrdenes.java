package com.example.grupo6.Vistas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.grupo6.R;

public class ActivityOrdenes extends AppCompatActivity {

    Toolbar toolbarOrdenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenes);

        //---------CASTING-----------
        toolbarOrdenes=(Toolbar) findViewById(R.id.toolbarOrdenes);

        setSupportActionBar(toolbarOrdenes);

        //---------HABILITAR FLECHA DE RETROCESO-----------
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }
}