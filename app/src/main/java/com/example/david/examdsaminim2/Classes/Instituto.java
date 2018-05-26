package com.example.david.examdsaminim2.Classes;

import com.example.david.examdsaminim2.Classes.Alumno;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Instituto {
    @SerializedName("nombreInstituto")
    @Expose
    private String nombreInstituto;
    @SerializedName("listaAlumnos")
    @Expose
    private ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    @SerializedName("numOperacionesTotales")
    @Expose
    private int numOperacionesTotales=0;


    @Override
    public String toString() {
        return "Instituto{" +
                "nombreInstituto='" + nombreInstituto + '\'' +
                ", listaAlumnos=" + listaAlumnos +
                ", numOperacionesTotales=" + numOperacionesTotales +
                '}';
    }

    public Instituto() {
    }
    public Instituto(String insti){
        this.nombreInstituto = insti;
    }
    public void introAlumno (Alumno alumno){
        this.listaAlumnos.add(alumno);
    }

    public List<Alumno> consultarAlumnos(){
        return this.listaAlumnos;
    }
    public void NumOperacionesTotal (){
        for (Alumno alum: listaAlumnos) {
            int x = alum.getNumOperaciones();
            this.numOperacionesTotales = this.numOperacionesTotales + x;
        }
    }
    public String getNombreInstituto() {
        return nombreInstituto;
    }

    public void setNombreInstituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }
    public int getNumOperacionesTotales() {
        return numOperacionesTotales;
    }

    public void setNumOperacionesTotales(int numOperacionesTotales) {
        this.numOperacionesTotales = numOperacionesTotales;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
}
