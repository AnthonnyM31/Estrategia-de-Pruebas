package com.universidad.EjercicioPersona;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas= new ArrayList<Persona>();
        String cedula;
        Scanner sc= new Scanner(System.in);
        int op;
        do {
            System.out.println("1. Ingrese Alumno de Pre-grado");
            System.out.println("2. Ingrese Alumno de Pos-grado");
            System.out.println("3. Ingrese un profesor por horas");
            System.out.println("4. Mostrar todas las personas de la Institucion");
            System.out.println("5. Mostrar Alumnos de Pre-grado");
            System.out.println("6. Mostrar Alumnos de Pos-grado");
            System.out.println("7. Mostrar Profesores por horas");
            System.out.println("8. Mostrar el mayor, menor e igual");
            System.out.println("9. Salir");
            System.out.println("Ingrese una opcion: ");
            op= sc.nextInt();
            switch (op){
                case 1:{
                    ingresarAlumnoPregrado((ArrayList<Persona>) personas);
                }break;
                case 2:{
                    ingresarAlumnoPosgrado((ArrayList<Persona>) personas);
                }break;
                case 3:{
                    ingresarProfesorPorHoras((ArrayList<Persona>) personas);
                }break;
                case 4:{
                    imprimirPersonas((ArrayList<Persona>) personas);
                }break;
                case 5:{
                    mostrarAlumnosPregrado((ArrayList<Persona>) personas);
                }break;
                case 6:{
                    mostrarAlumnosMagister((ArrayList<Persona>) personas);
                }break;
                case 7:{
                    mostrarProfesoresHoras((ArrayList<Persona>) personas);
                }break;
                case 8: {
                    Comparacion((ArrayList<Persona>) personas);
                } break;
                case 9:{
                    System.out.println("Saliendo del programa...");

                }break;
            }
        }while (op != 9);

    }
    public static void imprimirPersonas(ArrayList<Persona> lista){
         Iterator<Persona> it = lista.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    public static void mostrarAlumnosPregrado(ArrayList<Persona> Lista) {
        System.out.println("Alumnos de Pregrado:");
        for (Persona persona : Lista) {
            if (persona instanceof AlumnoPregrado) {
                AlumnoPregrado ap = (AlumnoPregrado) persona;
                System.out.println("Cedula: "+ap.getCedula());
                System.out.println("Nombre: "+ap.getNombre());
                System.out.println("Carrera: "+ap.getCarrera());
            }
        }
    }

    public static void mostrarAlumnosMagister(ArrayList<Persona> Lista) {
        System.out.println("Alumnos de Postgrado:");
        for (Persona persona : Lista) {
            if (persona instanceof AlumnoMagister) {
                AlumnoMagister am = (AlumnoMagister) persona;
                System.out.println("Tesis: "+am.getTesis());
                System.out.println("Edad: "+am.getEdad());
                System.out.println("Nombre: "+am.getNombre());
                System.out.println("Cedula: "+am.getCedula());
            }
        }
    }

    public static void mostrarProfesoresHoras(ArrayList<Persona> Lista) {
        System.out.println("Profesores por Horas:");
        for (Persona persona : Lista) {
            if (persona instanceof ProfesorHoras) {
                ProfesorHoras ph = (ProfesorHoras) persona;
                System.out.println("Cedula: "+ph.getCedula());
                System.out.println("Nombre: "+ph.getNombre());
                System.out.println("Horas: "+ph.getHoras());
            }
        }
    }

    public static void ingresarAlumnoPregrado(ArrayList<Persona> lista){
        String cedula, nombre, universidad, carrera;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la cedula: ");
        cedula= sc.next();
        System.out.println("Ingresa el nombre: ");
        nombre= sc.next();
        System.out.println("Ingrese la edad: ");
        int edad= sc.nextInt();
        System.out.println("Ingresa la universidad: ");
        universidad= sc.next();
        System.out.println("Ingresa la carrera: ");
        carrera= sc.next();
        lista.add(new AlumnoPregrado(nombre, cedula, universidad, carrera, edad));
    }
    public static void ingresarAlumnoPosgrado(ArrayList<Persona> lista){
        String cedula, nombre, universidad, tesis;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la cedula: ");
        cedula= sc.next();
        System.out.println("Ingresa el nombre: ");
        nombre= sc.next();
        System.out.println("Ingrese la edad: ");
        int edad= sc.nextInt();
        System.out.println("Ingresa la universidad: ");
        universidad= sc.next();
        System.out.println("Ingresa la tesis: ");
        tesis= sc.next();
        lista.add(new AlumnoMagister(nombre, cedula, universidad, tesis, edad));
    }
    public static void ingresarProfesorPorHoras(ArrayList<Persona> lista){
        String cedula, nombre, especialidad;
        int horas;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la cedula: ");
        cedula= sc.next();
        System.out.println("Ingresa el nombre: ");
        nombre= sc.next();
        System.out.println("Ingrese la edad: ");
        int edad= sc.nextInt();
        System.out.println("Ingresa la especialidad: ");
        especialidad= sc.next();
        System.out.println("Ingresa las horas: ");
        horas= sc.nextInt();
        lista.add(new ProfesorHoras(nombre, cedula, especialidad, horas, edad));
    }
    public static void Comparacion(ArrayList<Persona> Lista) {
        Scanner sc = new Scanner(System.in);

        System.out.println("INDICE PERSONA N1:");
        int IP1 = sc.nextInt();
        System.out.println("INDICE PERSONA N2:");
        int IP2 = sc.nextInt();

        if (IP1 < 0 || IP1 >= Lista.size() || IP2 < 0 || IP2 >= Lista.size()) {
            System.out.println("VALORES INVALIDOS, INTENTE NUEVAMENTE");
            return;
        }

        Persona personaN1 = Lista.get(IP1);
        Persona personaN2 = Lista.get(IP2);

        System.out.println("EDAD PERSONA N1:");
        System.out.println("PERSONA N1: " + personaN1);
        System.out.println("EDAD PERSONA N2:");
        System.out.println("PERSONA N2: " + personaN2);

        if (personaN1.isGreater(personaN1, personaN2))
        {System.out.println("PERSONA MAYOR: N1");}
        else if (personaN1.isLess(personaN1, personaN2))
            {System.out.println("PERSONA MAYOR: N2");}
        else
        {System.out.println("EDADES IGUALES");}
    }
}
