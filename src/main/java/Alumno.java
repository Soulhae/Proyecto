import java.util.*;
import java.io.*;

public class Alumno extends Persona{
    private String rolAlumno;
    private ArrayList<Double> notas;
    
    public Alumno(){
        super();
        this.rolAlumno = "default";
        this.notas = new ArrayList<>();
    }
    
    public void setRolAlumno(String rolAlumno){
        this.rolAlumno = rolAlumno;
    }
    
    public String getRolAlumno(){
        return rolAlumno;
    }
    
    @Override
    public void identidad(){
        System.out.println("Nombre: "+getNombre());
        System.out.println("Rut: "+getRut());
        System.out.println("Edad: "+getEdad());
        System.out.println("Rol Alumno: "+rolAlumno);
    }
    
    @Override
    /* imprimir lista de notas */
    public void listar(){
        if (notas.size() == 0){
            System.out.println("\nNo hay notas registradas.\n");
            return;
        }
        System.out.println("\n- Lista de notas -");
        int i;
        for(i = 0 ; i < notas.size() ; i++){
            System.out.println(notas.get(i));
        }
        System.out.println("\n");
    }

    public void agregarNota(double nota){
        this.notas.add(nota);
    }

    public Double obtenerPromedio(){
        double suma = 0.0;
        double promedio = 0.0;
        for(int i = 0 ; i < notas.size() ; i++){
            suma += notas.get(i);
        }
        promedio = suma / notas.size();
        return promedio;
    }

    /*public void eliminarNota(int nota){
        for(int i = 0 ; i < notas.size() ; i++){
            if( notas[i] == nota){
                this.asignatura.remove(i);
                System.out.println("\nAsignatura eliminada con exito.\n");
                return;
            }
        }
        System.out.println("\nLa asignatura ingresada no existe.\n");
    }*/
    
}
