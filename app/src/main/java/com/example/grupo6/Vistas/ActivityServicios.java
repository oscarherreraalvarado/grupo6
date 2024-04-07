package com.example.grupo6.Vistas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.grupo6.Adapter.ListAdapterDetalle;
import com.example.grupo6.Adapter.ListAdapterServicios;
import com.example.grupo6.Config.Servicios;
import com.example.grupo6.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityServicios extends AppCompatActivity {

    Toolbar toolbarServicios;
    ListAdapterServicios listAdapter;
    List<Servicios> servicios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        //---------CASTING-----------
        toolbarServicios = (Toolbar) findViewById(R.id.toolbarServicios);

        setSupportActionBar(toolbarServicios);

        //---------HABILITAR FLECHA DE RETROCESO-----------
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        llenarLista();
    }

    private void llenarLista() {
        List<Servicios> detalleOrdens = new ArrayList<>();
        detalleOrdens.add(new Servicios("#2345", "Lavado sencillo", "Cantidad: 1", "Precio: 100 LPS"));
        detalleOrdens.add(new Servicios("#2345", "Lavado sencillo", "Cantidad: 1", "Precio: 100 LPS"));

        listAdapter=new ListAdapterServicios(detalleOrdens,this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewServicios);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}