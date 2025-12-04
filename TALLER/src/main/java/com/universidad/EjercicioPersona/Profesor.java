package com.universidad.EjercicioPersona;

public class Profesor extends Persona {
    private String especialidad;
    public Profesor(String nombre, String cedula, int edad, String especialidad){
        super(nombre, cedula, edad);
        this.especialidad=especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString()+
                "especialidad: " + especialidad;
    }
}
