package com.example.david.examdsaminim2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.david.examdsaminim2.Classes.Alumno;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Minim2 extends AppCompatActivity {
    //public static final String BASE_URL = "http://147.83.7.206:8080/myapp/";
    //public static final String BASE_URL ="http://localhost:8080/myapp/";
    public static final String BASE_URL ="http://192.168.1.49:8080/myapp/";

    private TrackApi trackServices;
    String tag = "Events";
    EditText txtuser,txtpassword;

    private Call<Alumno> callAlum;
    //Main activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minim2);

        txtuser = (EditText) findViewById(R.id.alumno);
        txtpassword = (EditText) findViewById(R.id.instituto);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public void iniciar (View view){
        String user = txtuser.getText().toString();
        final String insti = txtpassword.getText().toString();


        callAlum = trackServices.consultarAlumno(user);
        callAlum.enqueue(new Callback<Alumno>() {
            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                int statusCode = response.code();
                Alumno alumno = response.body();
                if (response.isSuccessful()) {
                    if (alumno.getInstituto().equals(insti)){
                        Toast.makeText (Minim2.this,"Login correct",Toast.LENGTH_LONG).show();
                        Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode)+ "resultado:" + alumno);
                        //obri el proxim layoud que obrira el joc
                        Intent intentOj = new Intent(Minim2.this, Operacion_Activity.class);
                        startActivity(intentOj);
                    } else{
                        Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode));
                        Toast.makeText (Minim2.this,"Alumno/Insti erroneos",Toast.LENGTH_LONG).show();
                    }

                } else {
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode));
                    Toast.makeText (Minim2.this,"Alumno/Insti erroneos",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {
                // log error here since request failed
                Log.d("Request: ", "error loading API" + t.toString());
            }
        });
    }
}
