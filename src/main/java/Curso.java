import java.util.*;

public class Curso {
    private ArrayList<Alumno> alumno;
    private ArrayList<Asignatura> asignatura;
    
    public Curso(){
        this.alumno = new ArrayList<>();
        this.asignatura = new ArrayList<>();
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumno.add(alumno);
    }

    public void agregarAsignatura(Asignatura asignatura) {
        this.asignatura.add(asignatura);
    }
        
    public void recorrerListaAlumno(){
        int i;
        for(i=0; i<alumno.size(); i++){
            System.out.println(alumno.get(i).getNombre()+" | "+alumno.get(i).getRut());
        }
    }
    
    public void recorrerListaAlumno(int x){
        int i;
        for(i=0; i<alumno.size(); i++){
            System.out.println(alumno.get(i).getNombre());
        }
    }
    
    public void recorrerListaAsignatura(){
        int i;
        for(i=0; i<asignatura.size(); i++){
            System.out.println(asignatura.get(i).getNombre()+" | "+asignatura.get(i).getSigla());
        }
    }
}
