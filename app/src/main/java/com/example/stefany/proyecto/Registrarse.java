package com.example.stefany.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrarse extends AppCompatActivity implements View.OnFocusChangeListener {

    EditText inputIdentificacion;
    EditText inputEstudiante;
    EditText inputCorreo;
    Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        inputIdentificacion = (EditText) findViewById(R.id.edtIdentificacion);
        inputIdentificacion.setOnFocusChangeListener(this);
        inputEstudiante = (EditText) findViewById(R.id.edtEstudiante);
        inputIdentificacion.setOnFocusChangeListener(this);
        inputCorreo = (EditText) findViewById(R.id.edtCorreo);
        inputIdentificacion.setOnFocusChangeListener(this);
        registro = (Button) findViewById(R.id.btnRegistrar);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        String focus = inputIdentificacion.getText().toString();
        if (focus.length() == 0) {
            if (inputIdentificacion.requestFocus()) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                inputEstudiante.clearFocus();
                Toast.makeText(Registrarse.this, "Dieser Liganame ist bereits vergeben", Toast.LENGTH_SHORT).show();
                inputCorreo.clearFocus();
                Toast.makeText(Registrarse.this, "Dieser Liganame ist bereits vergeben", Toast.LENGTH_SHORT).show();
            }
        }
    }
}