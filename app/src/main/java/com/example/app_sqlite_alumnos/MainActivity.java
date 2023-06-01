package com.example.app_sqlite_alumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtMatricula, edtNombre, edtTelefono;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMatricula=(EditText) findViewById(R.id.edtMatricula);
        edtNombre=(EditText) findViewById(R.id.edtNombre);
        edtTelefono=(EditText) findViewById(R.id.edtTelefono);
        btnAgregar=(Button) findViewById(R.id.btnAgregar);

        final AlumnosBD alumnosBD=new AlumnosBD(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alumnosBD.agregarAlumnos(edtMatricula.getText().toString(),edtNombre.getText().toString(),edtTelefono.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AGREGÓ CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });






    }
}