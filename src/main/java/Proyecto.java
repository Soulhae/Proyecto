import java.io.*;

public class Proyecto {
    public static void main (String arg[]) throws IOException{
        //Objetos de prueba
        
        Curso curso = new Curso();
        
        Alumno alumno = new Alumno("Juanito Rojas","20.615.385-1");
        Alumno alumno2 = new Alumno("Chimuelo Rodriguez","18.354.115-3");
         
        Asignatura asignatura = new Asignatura("Matemáticas","MAT");
        Asignatura asignatura2 = new Asignatura("Física","FIS");
       
        RecursoDigital recDigital = new RecursoDigital("MP4", "Ejercicios 1");
        RecursoDigital recDigital2 = new RecursoDigital("PDF", "Clase 1");
        
        asignatura.agregarRecDigital(recDigital);
        asignatura.agregarRecDigital(recDigital.getNombre(), recDigital);
        asignatura.agregarRecDigital(recDigital2);
        asignatura.agregarRecDigital(recDigital2.getNombre(), recDigital2);
        
        System.out.println("");
        System.out.println("Asignatura 1");
        System.out.println("LISTA");
        asignatura.recorrerListaRecDigital();
        
        System.out.println("");
        System.out.println("Asignatura 2");
        System.out.println("LISTA");
        asignatura2.recorrerListaRecDigital();
        
        System.out.println("");
        System.out.println("MAPA");
        System.out.println(asignatura.buscarMapaRecDigital("Ejercicios 1").getTipo()+" | "+asignatura.buscarMapaRecDigital("Ejercicios 1").getNombre());
        System.out.println(asignatura.buscarMapaRecDigital("Clase 1").getTipo()+" | "+asignatura.buscarMapaRecDigital("Clase 1").getNombre());
        
        System.out.println("");
        curso.agregarAlumno(alumno);
        curso.agregarAlumno(alumno2);
        curso.agregarAsignatura(asignatura);
        curso.agregarAsignatura(asignatura2);
        curso.recorrerListaAlumno();
        curso.recorrerListaAsignatura();
    }
}