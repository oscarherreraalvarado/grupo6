package com.example.grupo6.Vistas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.grupo6.Adapter.ListAdapterLocales;
import com.example.grupo6.Adapter.ListAdapterOrdenes;
import com.example.grupo6.Adapter.ListAdapterServicios;
import com.example.grupo6.Config.Locales;
import com.example.grupo6.Config.Ordenes;
import com.example.grupo6.Config.Servicios;
import com.example.grupo6.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityLocales extends AppCompatActivity {

    Toolbar toolbarLocales;
    ListAdapterLocales listAdapter;
    List<Locales> ListLocales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locales);

        //---------CASTING-----------
        toolbarLocales = (Toolbar) findViewById(R.id.toolbarLocales);

        setSupportActionBar(toolbarLocales);

        //---------HABILITAR FLECHA DE RETROCESO-----------
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        llenarLista();
    }

    private void llenarLista() {
        ListLocales = new ArrayList<>();
        ListLocales.add(new Locales("Car Wash EL Catracho #1", "Ciudad: Tegucigalpa", "Dirección: Media cuadra antes del \nparque central."));
        ListLocales.add(new Locales("Car Wash EL Catracho #2", "Ciudad: San Pedro Sula", "Dirección: Media cuadra antes del \nparque central."));

        listAdapter = new ListAdapterLocales(ListLocales, this, new ListAdapterLocales.OnItemDoubleClickListener() {
            @Override
            public void onItemDoubleClick(Locales locales) {
                alertaUbicacion(locales);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerViewLocales);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    private void alertaUbicacion(Locales locales) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityLocales.this);
        builder.setTitle("Ubicación.");
        builder.setMessage("¿Desea ver la ubicación del local seleccionado?");

        // Agregar botón de actualizar
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int selectedItemIndex = ListAdapterOrdenes.getSelectedItem();
                if (selectedItemIndex != -1) {
                    Locales locales = ListLocales.get(selectedItemIndex);

                    //Intent intent = new Intent(getApplicationContext(), ActivityDetalleOrden.class);
                    //intent.putExtra("latitud", contactos.getLatitud_gps());
                    //intent.putExtra("longitud", ordenes.getCiudad());
                    //startActivity(intent);

                }
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Si el usuario cancela la eliminación, no hacer nada
            }
        });

        builder.show();
    }
}