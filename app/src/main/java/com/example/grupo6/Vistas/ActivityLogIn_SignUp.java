package com.example.grupo6.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.grupo6.R;

public class ActivityLogIn_SignUp extends AppCompatActivity {

    ToggleButton switchViewLog, switchViewSign;
    final int heightInicial = 1086, heightFinal = 1500;
    EditText txtNombre, txtCelular, txtCorreo, txtContra, txtConfirContra, txtNombreUsuario, txtPassWord;
    Button btnRegistrate, btnIniciarSesion;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //---------CASTING-----------

        cardView = (CardView) findViewById(R.id.cardView);

        //---------INFLAR EL DISEÑO DE INICIO DE SESIÓN Y DE REGISTRO-----------

        LayoutInflater inflater = LayoutInflater.from(ActivityLogIn_SignUp.this);
        View loginLayout = inflater.inflate(R.layout.log_in_design, null);
        View signUpLayout = inflater.inflate(R.layout.sign_up_design, null);
        switchViewLog = loginLayout.findViewById(R.id.switchLog);
        switchViewSign = signUpLayout.findViewById(R.id.switchSign);

        //---------IDENTIFICANDO SI LLAMARON A INIAR SESIÓN O REGISTRARSE-----------

        if ("1".equals(getIntent().getStringExtra("logIn"))) {
            establecerDisenio(cardView, loginLayout, "log");
        } else if ("1".equals(getIntent().getStringExtra("signUp"))) {
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            layoutParams.height = heightFinal;
            cardView.setLayoutParams(layoutParams);
            establecerDisenio(cardView, signUpLayout, "sign");
        }

        //---------CAMBIO DE DISEÑO-----------

        switchViewLog.setOnCheckedChangeListener(cambioDeSwitch(heightInicial, heightFinal, signUpLayout, "sign"));
        switchViewSign.setOnCheckedChangeListener(cambioDeSwitch(heightFinal, heightInicial, loginLayout, "log"));


    }

    private CompoundButton.OnCheckedChangeListener cambioDeSwitch(int heightInicial, int heightFinal, View layout, String disenio) {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton botonSwitch, boolean isChecked) {
                if (isChecked) {
                    botonSwitch.setChecked(false);

                    ValueAnimator animator = ValueAnimator.ofInt(heightInicial, heightFinal);
                    animator.setDuration(500);

                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int animacionValue = (int) valueAnimator.getAnimatedValue();
                            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                            layoutParams.height = animacionValue;
                            cardView.setLayoutParams(layoutParams);
                        }
                    });
                    animator.start();

                    establecerDisenio(cardView, layout, disenio);
                }
            }
        };
    }

    private void establecerDisenio(CardView cardView, View view, String disenio) {

        cardView.removeAllViews();
        cardView.addView(view);

        //************************************************ REGISTRARSE ************************************************************
        if (disenio.equals("sign")) {

            //---------CASTING-----------

            txtNombre = (EditText) findViewById(R.id.txtNombre);
            txtCelular = (EditText) findViewById(R.id.txtCelular);
            txtCorreo = (EditText) findViewById(R.id.txtCorreoRegistro);
            txtContra = (EditText) findViewById(R.id.txtPasswordRegistrate);
            txtConfirContra = (EditText) findViewById(R.id.txtConfPassword);
            btnRegistrate = (Button) findViewById(R.id.btnRegistrate);


            animacionDesvanecer(findViewById(R.id.btnRegistrate));

            btnRegistrate.setOnClickListener(View -> {

                //---------OBTENER DATOS-----------

                String username = txtNombre.getText().toString().trim();
                String celular = txtCelular.getText().toString().trim();
                String correo = txtCorreo.getText().toString().trim();
                String contra = txtContra.getText().toString().trim();
                String confirContra = txtConfirContra.getText().toString().trim();

                //---------VALIDACIONES-----------

//                if (username.isEmpty()) {
//                    txtNombre.setError("Campo obligatorio");
//                } else if (celular.isEmpty()) {
//                    txtCelular.setError("Campo obligatorio");
//                } else if (correo.isEmpty()) {
//                    txtCorreo.setError("Campo obligatorio");
//                } else if (contra.isEmpty() || confirContra.isEmpty()) {
//                    Toast.makeText(this, "Favor establecer la contraseña.", Toast.LENGTH_SHORT).show();
//                } else if (celular.length()!=8) {
//                    Toast.makeText(this, "El campo celular debe contener 8 dígitos.", Toast.LENGTH_SHORT).show();
//                } else {
//                    if (contra.equals(confirContra)) {
                        Intent intent=new Intent(getApplicationContext(),ActivityConfirm.class);
                        startActivity(intent);
//                    } else {
//                        Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
//                    }
//                }


            });


            //************************************************INICIO DE SESIÓN************************************************************
        } else {

            //---------ANIMACIÓN-----------

            animacionDesvanecer(findViewById(R.id.btnIniciarSesion));
            animacionDesvanecer(findViewById(R.id.txtViewOlvidoContra));

            //---------CASTING-----------

            btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);
            txtNombreUsuario = (EditText) findViewById(R.id.txtCorreo);
            txtNombreUsuario = (EditText) findViewById(R.id.txtCorreo);
            txtPassWord = (EditText) findViewById(R.id.txtPassword);

            btnIniciarSesion.setOnClickListener(View -> {
                //---------PRUEBA-----------
                Intent intent=new Intent(getApplicationContext(), ActivityMenu.class);
                startActivity(intent);
            });
        }
    }

    private void animacionDesvanecer(View view) {
        AlphaAnimation fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
        fadeInAnimation.setDuration(1000);
        view.startAnimation(fadeInAnimation);
    }
}