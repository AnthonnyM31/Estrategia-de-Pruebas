package EjercicioPersona;

public class AlumnoMagister extends Alumno{
    private String tesis;
    public AlumnoMagister(String nombre, String cedula, String universidad, String tesis, int edad){
        super(nombre,cedula,edad,universidad);
        this.tesis=tesis;
    }

    public String getTesis() {
        return tesis;
    }

    public void setTesis(String tesis) {
        this.tesis = tesis;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTesis:'" + tesis + '\'';
    }
}
