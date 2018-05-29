package com.example.david.examdsaminim2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.david.examdsaminim2.Classes.Alumno;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class LogIn extends AppCompatActivity {

    public static final String BASE_URL = "http://147.83.7.206:8080/myapp/";
    //public static final String BASE_URL ="http://localhost:8080/myapp/";
    //public static final String BASE_URL ="http://192.168.42.197:8080/myapp/";
    private TrackApi trackServices;
    String tag = "Events";
    EditText txtuser,txtpassword;

    ProgressBar pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);

    private Call<Alumno> callAlum;
    //Main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        txtuser = (EditText) findViewById(R.id.alumno);
        txtpassword = (EditText) findViewById(R.id.instituto);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trackServices = retrofit.create(TrackApi.class);
    }

    public void iniciar (View view){
        //inici de la tasca
        pb1.setVisibility(ProgressBar.VISIBLE);

        String user = txtuser.getText().toString();
        final String insti = txtpassword.getText().toString();
        //pb1.setVisibility(ProgressBar.VISIBLE);
        callAlum = trackServices.consultarAlumno(user);
        callAlum.enqueue(new Callback<Alumno>() {

            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                int statusCode = response.code();
                Alumno alumno = response.body();
                if (response.isSuccessful()) {
                    if (alumno.getInstituto().equals(insti)){
                        Toast.makeText (LogIn.this,"Login correct",Toast.LENGTH_LONG).show();
                        Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode)+ "resultado:" + alumno);
                        //obri el proxim layoud que obrira el joc
                        //pb1.setVisibility(ProgressBar.INVISIBLE);

                        //al final de la tasca
                        pb1.setVisibility(ProgressBar.INVISIBLE);

                        Intent intentOj = new Intent(LogIn.this, Operacion_Activity.class);
                        startActivity(intentOj);
                    } else{
                        Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode));
                        Toast.makeText (LogIn.this,"Alumno/Insti erroneos",Toast.LENGTH_LONG).show();
                    }

                } else {

                    //al final de la tasca
                    pb1.setVisibility(ProgressBar.INVISIBLE);

                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode));
                    Toast.makeText (LogIn.this,"Alumno/Insti erroneos",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {
                //al final de la tasca
                pb1.setVisibility(ProgressBar.INVISIBLE);

                // log error here since request failed
                Log.d("Request: ", "error loading API" + t.toString());
            }
        });
    }
}
