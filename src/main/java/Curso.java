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

    public void eliminarAlumno(String rut){
        for(int i=0; i < alumno.size() ; i++){
            if (alumno.get(i).getRut().equals(rut)){
                this.alumno.remove(i);
                System.out.println("\nAlumno eliminado con exito.\n");
                return;
            }
        }
        System.out.println("\nEl alumno ingresado no existe.\n");
    }

    public void eliminarAsignatura(String sigla){
        for(int i = 0 ; i < asignatura.size() ; i++){
            if(asignatura.get(i).getSigla().equals(sigla)){
                this.asignatura.remove(i);
                System.out.println("\nAsignatura eliminada con exito.\n");
                return;
            }
        }
        System.out.println("\nLa asignatura ingresada no existe.\n");
    }
        
    public void recorrerListaAlumno(){
        if (alumno.size() == 0){
            System.out.println("\nNo hay alumnos registrados.\n");
            return;
        }
        System.out.println("\n- Lista de Alumnos -");
        int i;
        for(i=0; i<alumno.size(); i++){
            System.out.println(alumno.get(i).getNombre()+" | "+alumno.get(i).getRut());
        }
        System.out.println("\n");
    }
    
    public void recorrerListaAlumno(int x){
        if (alumno.size() == 0){
            System.out.println("\nNo hay alumnos registrados.\n");
            return;
        }
        System.out.println("\n- Lista de Alumnos -");
        int i;
        for(i=0; i<alumno.size(); i++){
            System.out.println(alumno.get(i).getNombre());
        }
        System.out.println("\n");
    }
    
    public void recorrerListaAsignatura(){
        if (asignatura.size() == 0){
            System.out.println("\nNo hay asignaturas registradas.\n");
            return;
        }
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
