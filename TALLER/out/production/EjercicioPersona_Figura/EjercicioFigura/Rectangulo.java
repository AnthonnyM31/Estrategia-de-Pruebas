package EjercicioFigura;

import java.util.Scanner;

public class Rectangulo extends Punto2D {
    private double mAncho;
    private double mLargo;

    public double getmAncho() {
        return mAncho;
    }

    public void setmAncho(double mAncho) {
        this.mAncho = mAncho;
    }

    public double getmLargo() {
        return mLargo;
    }


    public void setmLargo(double mLargo) {
        this.mLargo = mLargo;
    }
    public double calcularPerimetro(){
        return 2*mAncho+2*mLargo;
    }
    public double calcularArea(){
        return mAncho*mLargo;
    }

    @Override
    public String getTipo() {
        return "Rectangulo";
    }
    @Override
    public void leerDatos() {
        super.leerDatos();
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el Ancho: ");
        mAncho= sc.nextDouble();
        System.out.println("Ingrese el Largo: ");
        mLargo= sc.nextDouble();
    }
    @Override
    public void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("El lado Ancho es: "+mAncho);
        System.out.println("El lado Largo es: "+mLargo);
    }
}
