package com.universidad.EjercicioPersona;

public class ProfesorHoras extends Profesor{
    private int horas;
    public ProfesorHoras(String nombre, String cedula, String especialidad, int horas, int edad){
        super(nombre, cedula, edad,especialidad);
        this.horas=horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nhoras:" + horas;
    }
}
