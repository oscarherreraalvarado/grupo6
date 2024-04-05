package com.example.grupo6.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.grupo6.R;

public class ActivityInicio extends AppCompatActivity {

    Button btnLogIn;
    TextView txtRegistrate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        txtRegistrate = (TextView) findViewById(R.id.txtRegistrate);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogIn = new Intent(getApplicationContext(), ActivityLogIn_SignUp.class);
                intentLogIn.putExtra("logIn", "1");
                startActivity(intentLogIn);
                //overridePendingTransition(R.anim.entrada,0);
            }
        });

        txtRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogIn = new Intent(getApplicationContext(), ActivityLogIn_SignUp.class);
                intentLogIn.putExtra("signUp", "1");
                startActivity(intentLogIn);
            }
        });
    }
}