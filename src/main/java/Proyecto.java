import java.io.*;
//import java.util.*;

public class Proyecto {
    public static void main (String arg[]) throws IOException{
        /*Funciones:
            Alumnos:
                -Agregar alumnos
                -Eliminar alumnos
                -Ver lista alumnos
            Ramos:
                -Agregar ramos
                -Eliminar ramos
                -Ver lista ramos
            Recursos digitales:
                -Agregar recurso digital
                -Eliminar recurso digital
                -Lista de recursos digitales
        */
        Alumno alumno = new Alumno();
        Alumno alumno2 = new Alumno("Juanito Rojas","20.615.385-1");
        //Curso curso = new Curso();
        Asignatura asignatura = new Asignatura();
        Asignatura asignatura2 = new Asignatura("Matemáticas","MAT");
        
        RecursoDigital recDigital = new RecursoDigital();
        RecursoDigital recDigital2 = new RecursoDigital("PDF", "Clase 1");
        
        System.out.println(alumno.getNombre()+" | "+alumno2.getNombre());
        System.out.println(alumno.getRut()+" | "+alumno2.getRut());
        
        /*curso.setAlumno(alumno);
        curso.setAlumno(alumno2);
        ArrayList<Alumno> aux = curso.getAlumno();          aiuda con ArrayList
        for(int i=0; i<aux.size(); i++){
            System.out.println(aux.get(i));
        }*/
        
        System.out.println(asignatura.getNombre()+" | "+asignatura2.getNombre());
        System.out.println(asignatura.getSigla()+" | "+asignatura2.getSigla());
        
        System.out.println(recDigital.getTipo()+" | "+recDigital2.getTipo());
        System.out.println(recDigital.getNombre()+" | "+recDigital2.getNombre());
    }
}