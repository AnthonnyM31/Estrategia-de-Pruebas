package EjercicioFigura;

import EjercicioPersona.Persona;

public abstract class Figura implements FiguraInter {
    public double calcularArea() {
        return 0;
    }
    public double calcularPerimetro(){
        return 0;
    }
    public void mostrarCalcular(){
        System.out.println("Area:"+calcularArea());
        System.out.println("Perimetro:"+calcularPerimetro());
    }
    public abstract String getTipo();

    public abstract void leerDatos();
    public abstract void imprimirDatos();
    @Override
    public boolean isGreater(Object a, Object b) {
        double aFigura = ((Figura)a).calcularPerimetro();
        double bFigura = ((Figura)b).calcularPerimetro();
        return aFigura>bFigura;
    }

    @Override
    public boolean isLess(Object a, Object b) {
        double aFigura = ((Figura)a).calcularPerimetro();
        double bFigura = ((Figura)b).calcularPerimetro();
        return aFigura<bFigura;
    }

    @Override
    public boolean isEqual(Object a, Object b) {
        double aFigura = ((Figura)a).calcularPerimetro();
        double bFigura = ((Figura)b).calcularPerimetro();
        return (aFigura==bFigura);
    }


}
