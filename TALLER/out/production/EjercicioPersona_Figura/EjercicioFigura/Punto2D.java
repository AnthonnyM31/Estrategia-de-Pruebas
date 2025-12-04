package EjercicioFigura;

import java.util.Scanner;

public class Punto2D extends Figura{
    private int mX;
    private int mY;

    @Override
    public void leerDatos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese la coordenada x:");
        mX= sc.nextInt();
        System.out.println("Ingrese la coordenada y:");
        mY= sc.nextInt();
    }
    @Override
    public void imprimirDatos(){
        System.out.println("Centro figura ("+mX+","+mY+")");
    }

    @Override
    public String getTipo() {
        return null;
    }
}
