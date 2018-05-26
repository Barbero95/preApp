package com.example.david.examdsaminim2.Classes;

import com.example.david.examdsaminim2.Classes.Alumno;
import com.example.david.examdsaminim2.Classes.Expressio;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Queue;

public class Operacion {

    @SerializedName("alumno")
    @Expose
    private Alumno alumno;

    @SerializedName("resultado")
    @Expose
    private int resultado=0;

    @SerializedName("llistaExpressions")
    @Expose
    private Queue<Expressio> llistaExpressions = null;

    public Operacion() {
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "alumno=" + alumno +
                ", resultado=" + resultado +
                ", llistaExpressions=" + llistaExpressions +
                '}';
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public Queue<Expressio> getLlistaExpressions() {
        return llistaExpressions;
    }

    public void setLlistaExpressions(Queue<Expressio> llistaExpressions) {
        this.llistaExpressions = llistaExpressions;
    }
}
