import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proyecto {
    public static void main (String arg[]) throws IOException{

        Curso curso = new Curso();

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
            /* modificar alumno */
            /* modificar asignatura */
            /* modificar recurso digital */

            try {
                System.out.println("\nIngrese opcion: ");
                opcion = sn.nextInt();
                BufferedReader lector = new BufferedReader ( new InputStreamReader (System.in) );

                switch(opcion) {
                    case 1:
                        break;
                    case 2:
                        Alumno alumno = new Alumno();
                        //BufferedReader lector = new BufferedReader ( new InputStreamReader (System.in) );
                        System.out.println("Ingrese nombre y apellido del alumno, de la forma 'Nombre Apellido'.");
                        String nombre = lector.readLine();
                        alumno.setNombre(nombre);
                        System.out.println("Ingrese rut del alumno, de la forma '12.345.678-9'.");
                        String rut = lector.readLine();
                        alumno.setRut(rut);
                        curso.agregarAlumno(alumno);
                        System.out.println("\nAlumno ingresado.\n");

                        break;
                    case 3:
                        Asignatura asignatura = new Asignatura();
                        //BufferedReader lector = new BufferedReader ( new InputStreamReader (System.in) );
                        System.out.println("\nIngrese asignatura: ");
                        String asig = lector.readLine();
                        System.out.println("Ingrese sigla de la asignatura: ");
                        String sigla = lector.readLine();;
                        asignatura.setNombre(asig);
                        asignatura.setSigla(sigla);
                        curso.agregarAsignatura(asignatura);
                        System.out.println("\nAsignatura agregada.\n");
                        break;
                    case 4:
                        RecursoDigital recDigital = new RecursoDigital();
                        System.out.println("Ingrese la sigla de la Asignatura: ");
                        String siglaAsig = lector.readLine();

                        while (curso.buscarAsignatura(siglaAsig) == null){
                            System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                            siglaAsig = lector.readLine();
                        }

                        System.out.println("Ingrese tipo del Recurso Digital: ");
                        String tipo = lector.readLine();
                        System.out.println("Ingrese nombre del Recurso Digital: ");
                        String nombreRedDigital = lector.readLine();
                        recDigital.setTipo(tipo);
                        recDigital.setNombre(nombreRedDigital);
                        curso.buscarAsignatura(siglaAsig).agregarRecDigital(recDigital);
                        curso.buscarAsignatura(siglaAsig).agregarRecDigital(recDigital.getNombre(), recDigital);
                        System.out.println("\nRecurso Digital agregado.\n");
                        break;
                    case 5:
                        System.out.println("Ingrese rut del alumno, de la forma '12.345.678-9'.");
                        rut = lector.readLine();
                        curso.eliminarAlumno(rut);
                        break;
                    case 6:
                        System.out.println("Ingrese sigla de la asignatura");
                        sigla = lector.readLine();
                        curso.eliminarAsignatura(sigla);
                        break;
                    case 7:
                        System.out.println("Ingrese la sigla de la Asignatura que desea ver los Recursos Digitales: ");
                        sigla = lector.readLine();
                        while (curso.buscarAsignatura(sigla) == null){
                            System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                            sigla = lector.readLine();
                        }
                        Asignatura auxAsignatura = curso.buscarAsignatura(sigla);
                        System.out.println("Ingrese el nombre del Recurso Digital: ");
                        nombre = lector.readLine();
                        auxAsignatura.eliminarRecDigital(nombre);
                        break;
                    case 8:
                        System.out.println("\n1.- Mostrar nombre y rut de alumnos.");
                        System.out.println("2.- Mostrar solo nombre de alumnos.\n");
                        System.out.println("Ingrese opcion:");
                        int x = Integer.parseInt(lector.readLine());
                        while (x != 1 || x != 2){
                            System.out.println("\nVuelva a ingresar una opcion válida.");
                            System.out.println("\n1.- Mostrar nombre y rut de alumnos.");
                            System.out.println("2.- Mostrar nombre de alumnos.\n");
                            System.out.println("Ingrese opcion:");
                            x = Integer.parseInt(lector.readLine());
                        }
                        if (x == 1) curso.recorrerListaAlumno();
                        if (x == 2) curso.recorrerListaAlumno(x);
                        break;
                    case 9:
                        curso.recorrerListaAsignatura();
                        break;
                    case 10:
                        System.out.println("Ingrese la sigla de la Asignatura que desea ver los Recursos Digitales: ");
                        String sigla1 = lector.readLine();
                        while (curso.buscarAsignatura(sigla1) == null){
                            System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                            sigla1 = lector.readLine();
                        }
                        curso.buscarAsignatura(sigla1).recorrerListaRecDigital();
                        break;
                    case 11:
                        System.out.println("Ingrese la sigla de la Asignatura que buscar el Recursos Digital: ");
                        String sigla2 = lector.readLine();
                        while (curso.buscarAsignatura(sigla2) == null){
                            System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                            sigla2 = lector.readLine();
                        }
                        auxAsignatura = curso.buscarAsignatura(sigla2);
                        System.out.println("Ingrese el nombre del Recurso Digital: ");
                        String buscarRecDigital = lector.readLine();
                        System.out.println("\n- Recurso Digital -");
                        System.out.println(auxAsignatura.buscarMapaRecDigital(buscarRecDigital).getTipo()+" | "+auxAsignatura.buscarMapaRecDigital(buscarRecDigital).getNombre()+ "\n");
                        break;
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