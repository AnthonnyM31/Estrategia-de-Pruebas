package EjercicioFigura;

import java.util.Scanner;

public class Circulo extends Punto2D {
    private double radio;

    public double getmRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        if(radio >= 0){
            this.radio= radio;
        }else{
            this.radio= 0.0f;
        }
    }
    public double calcularPerimetro(){
        return 2*Math.PI*radio;
    }
    public double calcularArea(){
        return Math.PI*(Math.pow(2, radio));
    }

    @Override
    public String getTipo() {
        return "Circulo";
    }

    @Override
    public void leerDatos() {
        super.leerDatos();
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el radio: ");
        radio= sc.nextDouble();
    }
    @Override
    public void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("El radio es: "+ radio);
    }
}
