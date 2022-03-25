import java.util.*;

public class Curso {
    private ArrayList<Alumno> alumno;
    private ArrayList<Asignatura> asignatura;
    
    public Curso(){
        this.alumno = new ArrayList();
        this.asignatura = new ArrayList();
    }

    /*public ArrayList<Alumno> getAlumno() {
        return alumno;
    }*/
    
    public void setAlumno(Alumno alumno) {
        this.alumno.add(alumno);
    }

    /*public ArrayList<Asignatura> getAsignatura() {
        return asignatura;
    }*/
    
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura.add(asignatura);
    }
    
}
