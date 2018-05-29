package com.example.david.examdsaminim2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class Peticiones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peticiones);

        //inici de la tasca
        ProgressBar pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);
        pb1.setVisibility(ProgressBar.VISIBLE);

        //al final de la tasca
        pb1.setVisibility(ProgressBar.INVISIBLE);


    }

    public void listaInstis (View view){

        //inici de la tasca
        ProgressBar pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);
        pb1.setVisibility(ProgressBar.VISIBLE);

        //al final de la tasca
        pb1.setVisibility(ProgressBar.INVISIBLE);


    }

    public void listaAlumnos (View view){

        //inici de la tasca
        ProgressBar pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);
        pb1.setVisibility(ProgressBar.VISIBLE);

        //al final de la tasca
        pb1.setVisibility(ProgressBar.INVISIBLE);


    }

    public void listaOperaciones (View view){

        //inici de la tasca
        ProgressBar pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);
        pb1.setVisibility(ProgressBar.VISIBLE);

        //al final de la tasca
        pb1.setVisibility(ProgressBar.INVISIBLE);


    }
}
