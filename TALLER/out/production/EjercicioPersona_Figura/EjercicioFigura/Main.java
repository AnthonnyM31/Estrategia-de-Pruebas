package EjercicioFigura;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Figura> figuras = new ArrayList<>();

        while (true) {
            System.out.println("------Menú------");
            System.out.println("1. Ingresar punto");
            System.out.println("2. Ingresar círculo");
            System.out.println("3. Ingresar triángulo");
            System.out.println("4. Ingresar rectángulo");
            System.out.println("5. Imprimir los datos");
            System.out.println("6. Imprimir los cálculos");
            System.out.println("7. Mostrar el perimetro mayor, menor e igual");
            System.out.println("8. Saliendo");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarPunto(figuras);
                    break;
                case 2:
                    ingresarCirculo(figuras);
                    break;
                case 3:
                    ingresarTriangulo(figuras);
                    break;
                case 4:
                    ingresarRectangulo(figuras);
                    break;
                case 5:
                    imprimirDatos(figuras);
                    break;
                case 6:
                    imprimirCalculos(figuras);
                    break;
                case 7:
                    perimetrosUnion(figuras);
                    break;
                case 8:
                    System.out.println("Saliendo del Programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Saliendo del programa.");
                    System.exit(0);
            }
        }
    }

    private static void ingresarPunto(ArrayList<Figura> figuras) {
        Punto2D punto = new Punto2D();
        punto.leerDatos();
        figuras.add(punto);
    }

    private static void ingresarCirculo(ArrayList<Figura> figuras) {
        Circulo circulo = new Circulo();
        circulo.leerDatos();
        figuras.add(circulo);
    }

    private static void ingresarTriangulo(ArrayList<Figura> figuras) {
        Triangulo triangulo = new Triangulo();
        triangulo.leerDatos();
        figuras.add(triangulo);
    }

    private static void ingresarRectangulo(ArrayList<Figura> figuras) {
        Rectangulo rectangulo = new Rectangulo();
        rectangulo.leerDatos();
        figuras.add(rectangulo);
    }

    private static void imprimirDatos(ArrayList<Figura> figuras) {
        Iterator<Figura> it = figuras.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    private static void imprimirCalculos(ArrayList<Figura> figuras) {
        for (Figura figura : figuras) {
            System.out.println("Tipo de figura: " + figura.getTipo());
            System.out.println("Área: " + figura.calcularArea());
            System.out.println("Perímetro: " + figura.calcularPerimetro());
        }
    }
    public static void perimetrosUnion(ArrayList<Figura> Lista) {
        Scanner sc = new Scanner(System.in);

        System.out.println("INDICE PERIMETRO N1: ");
        int IP1 = sc.nextInt();
        System.out.println("INDICE PERIMETRO N2: ");
        int IP2 = sc.nextInt();

        if (IP1 < 0 || IP1 >= Lista.size() || IP2 < 0 || IP2 >= Lista.size())
        {
            System.out.println("VALORES INVALIDOS, INTENTE NUEVAMENTE");
            return;
        }

        Figura figuraP1= Lista.get(IP1);
        Figura figuraP2= Lista.get(IP2);

        if (figuraP1.isGreater(figuraP1, figuraP2))
        {
            System.out.println("PERIMETRO MAYOR: N1");} else if (figuraP1.isLess(figuraP1, figuraP2))
            {            System.out.println("PERIMETRO MAYOR: N2");
            }
        else
        {
            System.out.println("VALORES IGUALES");
        }
    }
}