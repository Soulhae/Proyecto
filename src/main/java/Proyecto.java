import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proyecto {
    public static void main (String arg[]) throws IOException{

        //Curso curso = new Curso();
        Curso curso[] = new Curso[4];
        for (int i = 0 ; i < 4 ; i ++){
            curso[i] = new Curso();
        }

        // menu
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while(!salir){
            System.out.println("1.- Generar archivo 'txt'");
            System.out.println("2.- Ingresar alumno");
            System.out.println("3.- Ingresar asignatura");
            System.out.println("4.- Ingresar recurso digital");
            System.out.println("5.- Ingresar nota a un alumno");
            System.out.println("6.- Eliminar alumno");
            System.out.println("7.- Eliminar asignatura");
            System.out.println("8.- Eliminar recurso digital");
            System.out.println("9.- Modificar alumno");
            System.out.println("10.- Modificar asignatura");
            System.out.println("11.- Modificar recurso digital");
            System.out.println("12.- Ver lista de alumnos por curso");
            System.out.println("13.- Ver lista de notas de un alumno");
            System.out.println("14.- Ver lista de asignaturas");
            System.out.println("15.- Ver lista de recursos digitales");
            System.out.println("16.- Buscar recurso digital");
            System.out.println("17.- Seleccionar alumno con la nota final mas baja de todos los cursos");
            System.out.println("18.- Seleccion de alumnos con nota final entre 4.0 y 7.0 de todos los cursos");
            System.out.println("19.- Salir ");

            try {
                System.out.println("\nIngrese opcion: ");
                opcion = sn.nextInt();
                BufferedReader lector = new BufferedReader ( new InputStreamReader (System.in) );

                switch(opcion) {
                    case 1:
                        /*System.out.println("Se creara un archivo .txt con la lista de los alumnos, las asignaturas y si en estas hay recursos digitales");
                        System.out.println("----GENERANDO ALUMNOS----");
                        System.out.println("..........................");
                        System.out.println("----GENERANDO ASIGNATURAS----");
                        System.out.println("..........................");
                        curso.generarTXT();
                        System.out.println("----GENERANDO RECURSOS DIGITALES");
                        System.out.println("..........................");
                        System.out.println("Archivo generado con exito, revise la carpeta del programa para encontrarlo y poder leelo, muchas gracias");*/
                        break;
                    case 2:

                        System.out.println("\nIngrese el curso del alumno: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        int numCurso = Integer.parseInt(lector.readLine());
                        
                        Persona alumno = new Alumno();
                        System.out.println("\nIngrese nombre y apellido del alumno, de la forma 'Nombre Apellido'.");
                        String nombre = lector.readLine();
                        alumno.setNombre(nombre);

                        System.out.println("Ingrese rut del alumno, de la forma '12.345.678-9'.");
                        String rut = lector.readLine();
                        alumno.setRut(rut);

                        numCurso --;
                        curso[numCurso].agregarAlumno(alumno);
                        System.out.println("\nAlumno ingresado.\n");

                        break;
                    case 3:

                        System.out.println("\nIngrese el curso de la asignatura: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        
                        Asignatura asignatura = new Asignatura();
                        System.out.println("\nIngrese nombre de la asignatura: ");
                        String asig = lector.readLine();

                        System.out.println("Ingrese sigla de la asignatura: ");
                        String sigla = lector.readLine();

                        asignatura.setNombre(asig);
                        asignatura.setSigla(sigla);

                        numCurso --;
                        curso[numCurso].agregarAsignatura(asignatura);
                        System.out.println("\nAsignatura agregada.\n");

                        break;
                    case 4:

                        System.out.println("\nIngrese el curso de la asignatura: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());

                        RecursoDigital recDigital = new RecursoDigital();
                        System.out.println("\nIngrese la sigla de la Asignatura: ");
                        String siglaAsig = lector.readLine();

                        numCurso --;
                        while (curso[numCurso].buscarAsignatura(siglaAsig) == null){
                            System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                            siglaAsig = lector.readLine();
                        }

                        System.out.println("Ingrese tipo del Recurso Digital: ");
                        String tipo = lector.readLine();

                        System.out.println("Ingrese nombre del Recurso Digital: ");
                        String nombreRedDigital = lector.readLine();

                        recDigital.setTipo(tipo);
                        recDigital.setNombre(nombreRedDigital);

                        curso[numCurso].buscarAsignatura(siglaAsig).agregarRecDigital(recDigital);
                        curso[numCurso].buscarAsignatura(siglaAsig).agregarRecDigital(recDigital.getNombre(), recDigital);
                        System.out.println("\nRecurso Digital agregado.\n");

                        break;
                    case 5:

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso --;
                        
                        System.out.println("Ingrese rut del alumno, de la forma '12.345.678-9'.");
                        rut = lector.readLine();

                        System.out.println("Ingrese nota del alumno.");
                        double nota = Double.parseDouble(lector.readLine());
                        //System.out.println("\n"+nota+"\n");

                        Persona auxAlumno = new Alumno();
                        auxAlumno = (Alumno) curso[numCurso].buscarAlumno(rut);
                        while (auxAlumno == null){
                            System.out.println("El alumno ingresado no existe. Vuelva a intentarlo.");
                            rut = lector.readLine();
                            auxAlumno = (Alumno) curso[numCurso].buscarAlumno(rut);
                        }
                        ((Alumno) auxAlumno).agregarNota(nota);

                        break;
                    case 6:

                        System.out.println("\nIngrese el curso del alumno: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;

                        System.out.println("Ingrese rut del alumno, de la forma '12.345.678-9'.");
                        rut = lector.readLine();
                        curso[numCurso].eliminarAlumno(rut);

                        break;
                    case 7:

                        System.out.println("\nIngrese el curso del alumno: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;

                        System.out.println("Ingrese sigla de la asignatura");
                        sigla = lector.readLine();
                        curso[numCurso].eliminarAsignatura(sigla);
                        break;
                    case 8:

                        System.out.println("\nIngrese el curso del alumno: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;

                        System.out.println("Ingrese la sigla de la Asignatura que desea ver los Recursos Digitales: ");
                        sigla = lector.readLine();

                        while (curso[numCurso].buscarAsignatura(sigla) == null){
                            System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                            sigla = lector.readLine();
                        }

                        Asignatura auxAsignatura = curso[numCurso].buscarAsignatura(sigla);
                        System.out.println("Ingrese el nombre del Recurso Digital: ");
                        nombre = lector.readLine();
                        auxAsignatura.eliminarRecDigital(nombre);

                        break;
                    case 9:

                        System.out.println("\nIngrese el curso del alumno: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;

                        System.out.println("Ingrese el rut del alumno a modificar, de la forma '12.345.678-9'.");
                        rut = lector.readLine();
                        System.out.println("Ingrese el nuevo nombre y apellido, de la forma 'Nombre Apellido'.");
                        String nuevoNombre = lector.readLine();
                        System.out.println("Ingrese rut, de la forma '12.345.678-9'.");
                        String nuevoRut = lector.readLine();

                        curso[numCurso].modificarAlumno(rut, nuevoNombre, nuevoRut);

                        break;
                    case 10:

                        System.out.println("\nIngrese el curso de la asignatura a modificar: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;

                        System.out.println("Ingrese la sigla de la asignatura a modificar.");
                        sigla = lector.readLine();
                        System.out.println("Ingrese el nombre de la asignatura modificada.");
                        String nuevoNombreAsig = lector.readLine();
                        System.out.println("Ingrese la sigla.");
                        String nuevaSigla = lector.readLine();

                        curso[numCurso].modificarAsignatura(sigla, nuevoNombreAsig, nuevaSigla);

                        break;
                    case 11:

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;

                        System.out.println("Ingrese la sigla de la asignatura del recurso digital a modificar:");
                        sigla = lector.readLine();
                        System.out.println("Ingrese el nombre del recurso digital a modificar:");
                        String nombreRecDigital = lector.readLine();
                        System.out.println("Ingrese el nombre del recurso digital modificado:");
                        String nuevoNombreRedDigital = lector.readLine();
                        System.out.println("Ingrese el tipo:");
                        String nuevoTipo = lector.readLine();

                        auxAsignatura = curso[numCurso].buscarAsignatura(sigla);
                        auxAsignatura.modificarRecDigital(nombreRecDigital, nuevoNombreRedDigital, nuevoTipo);

                        break;
                    case 12:
                        
                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());

                        System.out.println("\nIngrese opcion para mostrar la lista de alumnos: ");
                        System.out.println("1.- Mostrar nombre y rut de alumnos.");
                        System.out.println("2.- Mostrar solo nombre de alumnos.\n");
                        System.out.println("Ingrese opcion:");

                        int x = Integer.parseInt(lector.readLine());
                        while (x != 1 && x != 2){
                            System.out.println("\nVuelva a ingresar una opcion válida.");
                            System.out.println("\n1.- Mostrar nombre y rut de alumnos.");
                            System.out.println("2.- Mostrar nombre de alumnos.\n");
                            System.out.println("Ingrese opcion:");
                            x = Integer.parseInt(lector.readLine());
                        }

                        numCurso --;
                        if (x == 1) curso[numCurso].recorrerListaAlumno();
                        if (x == 2) curso[numCurso].recorrerListaAlumno(x);

                        break;
                    case 13:
                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso --;
                        
                        System.out.println("Ingrese rut del alumno, de la forma '12.345.678-9'.");
                        rut = lector.readLine();
                        
                        curso[numCurso].buscarAlumno(rut).listar();
                        break;
                    case 14:

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());

                        numCurso --;
                        curso[numCurso].recorrerListaAsignatura();

                        break;
                    case 15:
                    
                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso --;

                        System.out.println("\nIngrese la sigla de la Asignatura que desea ver los Recursos Digitales: ");
                        String sigla1 = lector.readLine();
                        while (curso[numCurso].buscarAsignatura(sigla1) == null){
                            System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                            sigla1 = lector.readLine();
                        }

                        curso[numCurso].buscarAsignatura(sigla1).recorrerListaRecDigital();

                        break;
                    case 16:

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso --;

                        System.out.println("Ingrese la sigla de la Asignatura que buscar el Recursos Digital: ");
                        String sigla2 = lector.readLine();

                        while (curso[numCurso].buscarAsignatura(sigla2) == null){
                            System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                            sigla2 = lector.readLine();
                        }

                        auxAsignatura = curso[numCurso].buscarAsignatura(sigla2);
                        System.out.println("Ingrese el nombre del Recurso Digital: ");

                        String buscarRecDigital = lector.readLine();
                        System.out.println("\n- Recurso Digital -");

                        if (auxAsignatura.buscarMapaRecDigital(buscarRecDigital) == null){
                            System.out.println("\nEl Recurso digital buscado no existe.\n");
                        }
                        else{
                            System.out.println(auxAsignatura.buscarMapaRecDigital(buscarRecDigital).getTipo()+" | "+auxAsignatura.buscarMapaRecDigital(buscarRecDigital).getNombre()+ "\n");
                        }
   
                        break;
                    case 17: /* Seleccionar alumno con la nota final mas baja de todos los cursos */

                        Persona seleccionarAlumno = new Alumno(); /* Alumno con el promedio mas bajo */
                        Persona auxSeleccionarAlumno = new Alumno(); /* Alumno que se compara */
                        double promedioCursoBajo = 8;
                        for (int i = 0 ; i < 4 ; i++){
                            auxSeleccionarAlumno = ((Alumno) curso[i].obtenerAlumnoBajo()); /* retorna el alumno */
                            if ( promedioCursoBajo > ( (Alumno) auxSeleccionarAlumno ).obtenerPromedio() ){
                                promedioCursoBajo = ( (Alumno) auxSeleccionarAlumno ).obtenerPromedio();
                                seleccionarAlumno = auxSeleccionarAlumno;
                            }
                        }
                        if (promedioCursoBajo == 8.0){
                            System.out.println("\nNo hay notas registradas.\n");
                        }
                        else{
                            System.out.println("\nEl alumno con promedio "+promedioCursoBajo+" es: "+ seleccionarAlumno.getNombre() +" - "+ seleccionarAlumno.getRut()+"\n");
                        }

                        break;
                    case 18: /* Seleccion de alumnos con nota final entre 4.0 y 7.0 de todos los cursos */
                        System.out.println("\nLista de Alumnos con promedio entre 4.0 y 7.0");
                        boolean aux;
                        int cont = 0;
                        for(int i = 0 ; i < 4 ; i++){
                            aux = curso[i].notaRango();
                            if (aux == false) cont ++;
                        }
                        if (cont == 0) System.out.println("No hay notas registradas.");
                        System.out.println("\n");
                        break;
                    case 19:
                        salir = true;
                        break;
                    default:
                        System.out.println("Ingrese solo opciones del 1 al 17.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese una opcion valida.");
                sn.next();
            }
        }
        
    }

}