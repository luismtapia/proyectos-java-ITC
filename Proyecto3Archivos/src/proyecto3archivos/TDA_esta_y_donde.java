package proyecto3archivos;

public class TDA_esta_y_donde {
    boolean si_esta;
    String ruta,nombre_archivo;
    
    String no_ctrol,nombre_alumno,especialidad;
    int semestre;
    double promedio;
    
    
    public TDA_esta_y_donde(boolean esta, String RUTA, String NOMBRE_ARCHIVO, String NO_CTROL, String NOMBRE_ALUMNO, String ESPECIALIDAD, int SEMESTRE, double PROMEDIO) {
        si_esta = esta;
        ruta = RUTA;
        nombre_archivo = NOMBRE_ARCHIVO;
        no_ctrol = NO_CTROL;
        nombre_alumno = NOMBRE_ALUMNO;
        especialidad = ESPECIALIDAD;
        semestre = SEMESTRE;
        promedio = PROMEDIO;
    }
}
