package com.universidad.EjercicioPersona;

public class Alumno extends Persona {
    private String universidad;
    public Alumno(String nombre, String cedula,int edad, String universidad){
        super(cedula, nombre, edad);
        this.universidad = universidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nuniversidad: " + universidad;
    }
}
