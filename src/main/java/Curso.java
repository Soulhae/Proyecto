import java.util.*;
import java.io.*;

public class Curso {
    private ArrayList<Alumno> alumno;
    private ArrayList<Asignatura> asignatura;
    
    public Curso(){
        this.alumno = new ArrayList<>();
        this.asignatura = new ArrayList<>();
    }

    public void agregarAlumno(Alumno alumno1) {
        this.alumno.add(alumno1);
    }

    public void agregarAsignatura(Asignatura asignatura) {
        this.asignatura.add(asignatura);
    }
        
    public void recorrerListaAlumno(){
        System.out.println("\n- Lista de Alumnos -");
        int i;
        for(i=0; i<alumno.size(); i++){
            System.out.println(alumno.get(i).getNombre()+" | "+alumno.get(i).getRut());
        }
        System.out.println("\n");
    }
    
    public void recorrerListaAlumno(int x){
        System.out.println("\n- Lista de Alumnos -");
        int i;
        for(i=0; i<alumno.size(); i++){
            System.out.println(alumno.get(i).getNombre());
        }
        System.out.println("\n");
    }
    
    public void recorrerListaAsignatura(){
        System.out.println("\n- Lista de Asignaturas -");
        int i;
        for(i=0; i<asignatura.size(); i++){
            System.out.println(asignatura.get(i).getNombre()+" | "+asignatura.get(i).getSigla());
        }
        System.out.println("\n");
    }

    public Asignatura buscarAsignatura(String sigla) {
        for(int i = 0 ; i < asignatura.size() ; i++){
            if ( asignatura.get(i).getSigla().equals(sigla) ){
                return asignatura.get(i);
            }
        }
        return null;

    }

}
