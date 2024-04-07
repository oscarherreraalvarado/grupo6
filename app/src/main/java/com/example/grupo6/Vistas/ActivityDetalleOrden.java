package com.example.grupo6.Vistas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.grupo6.Adapter.ListAdapterDetalle;
import com.example.grupo6.Adapter.ListAdapterOrdenes;
import com.example.grupo6.Config.DetalleOrden;
import com.example.grupo6.Config.Ordenes;
import com.example.grupo6.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityDetalleOrden extends AppCompatActivity {

    Toolbar toolbarDetalleOrden;
    ListAdapterDetalle listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_orden);

        //---------CASTING-----------
        toolbarDetalleOrden=(Toolbar) findViewById(R.id.toolbarDetalleOrden);

        setSupportActionBar(toolbarDetalleOrden);

        //---------HABILITAR FLECHA DE RETROCESO-----------
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        llenarLista();
    }

    private void llenarLista() {
        List<DetalleOrden> detalleOrdens = new ArrayList<>();
        detalleOrdens.add(new DetalleOrden("#2345", "Lavado sencillo", "Cantidad: 1", "Precio: 100 LPS"));
        detalleOrdens.add(new DetalleOrden("#2345", "Lavado sencillo", "Cantidad: 1", "Precio: 100 LPS"));

        listAdapter=new ListAdapterDetalle(detalleOrdens,this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewDetalleOrden);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}