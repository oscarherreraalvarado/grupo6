package com.example.grupo6.Vistas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.grupo6.R;

public class ActivityMenu extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout citas, ordenes, servicios, locales;
    ImageView cerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //---------CASTING-----------
        citas = (LinearLayout) findViewById(R.id.citas);
        ordenes = (LinearLayout) findViewById(R.id.ordenes);
        servicios= (LinearLayout) findViewById(R.id.servicios);
        locales= (LinearLayout) findViewById(R.id.locales);
        cerrarSesion = (ImageView) findViewById(R.id.cerrarSesion);

        citas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityCitas.class);
                startActivity(intent);
            }
        });

        ordenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityOrdenes.class);
                startActivity(intent);
            }
        });

        servicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityServicios.class);
                startActivity(intent);
            }
        });

        locales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityLocales.class);
                startActivity(intent);
            }
        });
        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarSesion();
            }
        });
    }

    private void cerrarSesion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMenu.this);
        builder.setTitle("Cerrar Sesión ");
        builder.setMessage("¿Deseas cerrar la sesión?");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), ActivityInicio.class);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Si el usuario cancela, no hacer nada
            }
        });

        builder.show();
    }
}