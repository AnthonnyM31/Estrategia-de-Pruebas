package com.universidad.EjercicioPersona;

import javax.sound.sampled.Line;

public class Persona implements PersonaInter {
    private String cedula;
    private String nombre;
    private int edad;
    public Persona(String cedula, String nombre, int edad){
        this.nombre=nombre;
        this.cedula=cedula;
        this.edad=edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString(){
        return "\n Nombre: "+nombre+
                "\n Cedula: "+cedula+
                "\n Edad: "+edad;
    }

    @Override
    public boolean isGreater(Object a, Object b) {
        double aPersona = ((Persona)a).getEdad();
        double bPersona = ((Persona)b).getEdad();
        return aPersona>bPersona;
    }

    @Override
    public boolean isLess(Object a, Object b) {
        double aPersona = ((Persona)a).getEdad();
        double bPersona = ((Persona)b).getEdad();
        return aPersona<bPersona;
    }

    @Override
    public boolean isEqual(Object a, Object b) {
        double aPersona = ((Persona)a).getEdad();
        double bPersona = ((Persona)b).getEdad();
        return (aPersona==bPersona);
    }
}
