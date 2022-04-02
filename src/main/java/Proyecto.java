import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proyecto {
    public static void main (String arg[]) throws IOException{

        Curso curso = new Curso();
        Alumno alumno = new Alumno();
        Alumno alumno2 = new Alumno();
        Asignatura asignatura = new Asignatura();
        Asignatura asignatura2 = new Asignatura();
        RecursoDigital recDigital = new RecursoDigital();
        RecursoDigital recDigital2 = new RecursoDigital();

        // menu
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while(!salir){
            System.out.println("1.- Leer archivo");
            System.out.println("2.- Ingresar alumno");
            System.out.println("3.- Ingresar asignatura");
            System.out.println("4.- Ingresar recurso digital");
            System.out.println("5.- Eliminar alumno");
            System.out.println("6.- Eliminar asignatura");
            System.out.println("7.- Eliminar recurso digital");
            System.out.println("8.- Ver lista de alumnos por curso");
            System.out.println("9.- Ver lista de asignaturas");
            System.out.println("10.- Ver lista de recursos digitales");
            System.out.println("11.- Buscar recurso digital");
            System.out.println("12.- Salir ");

            try {
                System.out.println("\nIngrese opcion: ");
                opcion = sn.nextInt();

                switch(opcion) {
                    case 1:
                        break;
                    case 2:
                        alumno.setNombre("Juanito Rojas");
                        alumno.setRut("20.615.385-1");
                        alumno2.setNombre("Chimuelo Rodriguez");
                        alumno2.setRut("18.354.115-3");
                        curso.agregarAlumno(alumno);
                        curso.agregarAlumno(alumno2);
                        System.out.println("\nAlumno agregado.\n");
                        break;
                    case 3:
                        asignatura.setNombre("Matemáticas");
                        asignatura.setSigla("MAT");
                        asignatura2.setNombre("Física");
                        asignatura2.setSigla("FIS");
                        curso.agregarAsignatura(asignatura);
                        curso.agregarAsignatura(asignatura2);
                        System.out.println("\nAsignatura agregada.\n");
                        break;
                    case 4:
                        recDigital.setTipo("MP4");
                        recDigital.setNombre("Ejercicios 1");
                        recDigital2.setTipo("PDF");
                        recDigital2.setNombre("Clase 1");
                        asignatura.agregarRecDigital(recDigital);
                        asignatura.agregarRecDigital(recDigital.getNombre(), recDigital);
                        asignatura2.agregarRecDigital(recDigital2);
                        asignatura2.agregarRecDigital(recDigital2.getNombre(), recDigital2);
                        curso.recorrerListaAsignatura();
                        System.out.println("\nRecurso Digital agregado.\n");
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        curso.recorrerListaAlumno();
                        break;
                    case 9:
                        curso.recorrerListaAsignatura();
                        break;
                    case 10:
                        asignatura.recorrerListaRecDigital();
                        asignatura2.recorrerListaRecDigital();
                        break;
                    case 11:
                        System.out.println("");
                        System.out.println("MAPA");
                        System.out.println(asignatura.buscarMapaRecDigital("Ejercicios 1").getTipo()+" | "+asignatura.buscarMapaRecDigital("Ejercicios 1").getNombre());
                        System.out.println(asignatura.buscarMapaRecDigital("Clase 1").getTipo()+" | "+asignatura.buscarMapaRecDigital("Clase 1").getNombre());
                    case 12:
                        salir = true;
                        break;
                    default:
                        System.out.println("Ingrese solo opciones del 1 al 11.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese una opcion valida.");
                sn.next();
            }
        }
        
    }
}