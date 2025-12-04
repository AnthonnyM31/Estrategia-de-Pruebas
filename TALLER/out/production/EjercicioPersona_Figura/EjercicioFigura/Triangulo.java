package EjercicioFigura;

import java.util.Scanner;

public class Triangulo extends Punto2D{
    private double mA;
    private double mB;
    private double mC;


    public double getmA() {
        return mA;
    }

    public void setmA(double mA) {
        this.mA = mA;
    }

    public double getmB() {
        return mB;
    }

    public void setmB(double mB) {
        this.mB = mB;
    }

    public double getmC() {
        return mC;
    }

    public void setmC(double mC) {
        this.mC = mC;
    }
    public double calcularPerimetro(){
        return mA+mB+mC;
    }
    public double calcularSemiperimetro(){
        return calcularPerimetro()/2;
    }
    public double calcularArea(){

        return Math.sqrt(calcularSemiperimetro()*(calcularSemiperimetro()-mA)*(calcularSemiperimetro()-mB)*(calcularSemiperimetro()-mC));
    }

    @Override
    public String getTipo() {
        return "Triangulo";
    }
    @Override
    public void leerDatos() {
        super.leerDatos();
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el A: ");
        mA= sc.nextDouble();
        System.out.println("Ingrese el B: ");
        mB= sc.nextDouble();
        System.out.println("Ingrese el C: ");
        mC= sc.nextDouble();
    }
    @Override
    public void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("El lado A es: "+mA);
        System.out.println("El lado B es: "+mB);
        System.out.println("El lado c es: "+mC);
    }

}
