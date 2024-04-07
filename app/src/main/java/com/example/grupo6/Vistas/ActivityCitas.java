package com.example.grupo6.Vistas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.grupo6.Adapter.ListAdapterDetalle;
import com.example.grupo6.Adapter.ListAdapterServicios;
import com.example.grupo6.Adapter.ListAdapterServiciosCita;
import com.example.grupo6.Config.Servicios;
import com.example.grupo6.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ActivityCitas extends AppCompatActivity {

    Toolbar toolbarCitas;
    private EditText editTextDate;
    private EditText editTextTime;
    ListAdapterServiciosCita listAdapter;
    List<Servicios> servicios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        //---------CASTING-----------
        toolbarCitas = (Toolbar) findViewById(R.id.toolbarCitas);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);

        setSupportActionBar(toolbarCitas);

        //---------HABILITAR FLECHA DE RETROCESO-----------
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Configurar el listener para abrir el DatePickerDialog
        editTextDate.setOnClickListener(view -> showDatePickerDialog());
        editTextTime.setOnClickListener(view -> showTimePickerDialog());

        llenarLista();
    }

    private void llenarLista() {
        List<Servicios> detalleOrdens = new ArrayList<>();
        detalleOrdens.add(new Servicios("#2345", "Lavado sencillo", "Cantidad: 1", "Precio: 100 LPS"));
        detalleOrdens.add(new Servicios("#2345", "Lavado sencillo", "Cantidad: 1", "Precio: 100 LPS"));

        listAdapter=new ListAdapterServiciosCita(detalleOrdens,this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCitas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }


    // Método para mostrar el selector de fecha
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                editTextDate.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },dayOfMonth, month,year);

        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute1) -> {
                    // Aquí puedes manejar la hora seleccionada
                    String selectedTime = String.format("%02d:%02d", hourOfDay, minute1);
                    editTextTime.setText(selectedTime);
                }, hour, minute, true);
        timePickerDialog.show();
    }
}