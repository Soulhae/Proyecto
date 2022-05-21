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
            System.out.println("3.- Ingresar profesor");
            System.out.println("4.- Ingresar asignatura");
            System.out.println("5.- Ingresar recurso digital");
            System.out.println("6.- Ingresar nota a un alumno");
            System.out.println("7.- Ingresar título profesional a un profesor");
            System.out.println("8.- Eliminar alumno");
            System.out.println("9.- Eliminar asignatura");
            System.out.println("10.- Eliminar recurso digital");
            System.out.println("11.- Modificar alumno");
            System.out.println("12.- Modificar asignatura");
            System.out.println("13.- Modificar recurso digital");
            System.out.println("14.- Ver datos de un alumno o profesor específico");
            System.out.println("15.- Ver lista de alumnos por curso");
            System.out.println("16.- Ver lista de notas de un alumno");
            System.out.println("17.- Ver lista de títulos profesionales de un profesor");
            System.out.println("18.- Ver lista de asignaturas");
            System.out.println("19.- Ver lista de recursos digitales");
            System.out.println("20.- Buscar recurso digital");
            System.out.println("21.- Seleccionar alumno con la nota final mas baja de todos los cursos");
            System.out.println("22.- Seleccion de alumnos con nota final entre 4.0 y 7.0 de todos los cursos");
            System.out.println("23.- Salir ");

            try {
                System.out.println("\nIngrese opcion: ");
                opcion = sn.nextInt();
                BufferedReader lector = new BufferedReader ( new InputStreamReader (System.in) );

                switch(opcion) {
                    case 1: //Generar archivo txt
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
                    case 2: //Ingresar alumno

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
                        ((Alumno) alumno).setRolAlumno(rut);
                        
                        System.out.println("Ingrese edad del alumno.");
                        int edad = Integer.parseInt(lector.readLine());
                        alumno.setEdad(edad);

                        numCurso --;
                        curso[numCurso].agregarAlumno(alumno);
                        System.out.println("\nAlumno ingresado.\n");

                        break;
                    case 3: //Ingresar profesor
                        
                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso --;
                        
                        String siglaAsig;
                        
                        if(curso[numCurso].largo() == 0){
                            System.out.println("El curso no posee asignaturas.");
                            System.out.println("Por favor, ingrese al menos una antes de agregar un profesor.\n");
                            break;
                        }else{
                            System.out.println("\nIngrese la sigla de la asignatura que imparte el profesor: ");
                            siglaAsig = lector.readLine();
                            while (curso[numCurso].buscarAsignatura(siglaAsig) == null){
                                System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                                siglaAsig = lector.readLine();
                            }
                            
                            Persona profesor = new Profesor();
                            System.out.println("\nIngrese nombre y apellido del profesor, de la forma 'Nombre Apellido'.");
                            nombre = lector.readLine();
                            profesor.setNombre(nombre);

                            System.out.println("Ingrese rut del profesor, de la forma '12.345.678-9'.");
                            rut = lector.readLine();
                            profesor.setRut(rut);
                            ((Profesor) profesor).setRolProfe(rut);

                            System.out.println("Ingrese edad del profesor.");
                            edad = Integer.parseInt(lector.readLine());
                            profesor.setEdad(edad);

                            curso[numCurso].buscarAsignatura(siglaAsig).agregarProfesor(profesor);
                            System.out.println("\nProfesor ingresado.\n");
                        }
                        
                        break;
                    case 4: //Ingresar asignatura

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
                    case 5: //Ingresar recurso digital

                        System.out.println("\nIngrese el curso de la asignatura: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());

                        RecursoDigital recDigital = new RecursoDigital();
                        
                        numCurso --;
                        if(curso[numCurso].largo() == 0){
                            System.out.println("El curso no posee asignaturas.");
                            System.out.println("Por favor, ingrese al menos una antes de agregar un recurso digital.\n");
                            break;
                        }else{
                            System.out.println("\nIngrese la sigla de la Asignatura: ");
                            siglaAsig = lector.readLine();
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
                        }

                        break;
                    case 6: //Ingresar nota a un alumno

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso --;
                        
                        double nota;
                        Persona auxAlumno;
                        
                        if(curso[numCurso].largo(1) == 0){
                            System.out.println("El curso no posee alumnos.");
                            System.out.println("Por favor, ingrese al menos uno antes de agregar una nota.\n");
                            break;
                        }else{
                            System.out.println("Ingrese rut del alumno, de la forma '12.345.678-9'.");
                            rut = lector.readLine();
                            
                            auxAlumno = new Alumno();
                            auxAlumno = (Alumno) curso[numCurso].buscarAlumno(rut);
                            while (auxAlumno == null){
                                System.out.println("El alumno ingresado no existe. Vuelva a intentarlo.");
                                rut = lector.readLine();
                                auxAlumno = (Alumno) curso[numCurso].buscarAlumno(rut);
                            }

                            System.out.println("Ingrese nota del alumno, rango de 1.0 a 7.0");
                            nota = Double.parseDouble(lector.readLine());

                            ((Alumno) auxAlumno).agregarNota(nota);
                            System.out.println("\nNota ingresada correctamente\n");
                        }
                        
                        break;
                    case 7: //Ingresar titulo profesional a un profesor

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;
                        
                        String titulo;
                        Persona auxProfesor;
                        
                        if(curso[numCurso].largo() == 0){
                            System.out.println("El curso no posee asignaturas, por lo tanto no existen profesores.\n");
                            break;
                        }else{
                            System.out.println("\nIngrese la sigla de la Asignatura: ");
                            siglaAsig = lector.readLine();
                            while (curso[numCurso].buscarAsignatura(siglaAsig) == null){
                                System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                                siglaAsig = lector.readLine();
                            }
                            if(curso[numCurso].buscarAsignatura(siglaAsig).getProfesor() != null){
                                System.out.println("Ingrese el título profesional: ");
                                titulo = lector.readLine();
                                curso[numCurso].buscarAsignatura(siglaAsig).getProfesor().agregarProfesion(titulo);
                            }else{
                                System.out.println("La asignatura no tiene asignado un profesor.\n");
                            }
                        }
                        
                        break;
                    case 8: //Eliminar alumno

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;
                        
                        if(curso[numCurso].largo(1) == 0){
                            System.out.println("El curso no posee alumnos.\n");
                            break;
                        }else{
                            System.out.println("Ingrese rut del alumno, de la forma '12.345.678-9'.");
                            rut = lector.readLine();
                            curso[numCurso].eliminarDato(rut);
                        }

                        break;
                    case 9: //Eliminar asignatura

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;
                        
                        if(curso[numCurso].largo() == 0){
                            System.out.println("El curso no posee asignaturas.\n");
                            break;
                        }else{
                            System.out.println("Ingrese sigla de la asignatura");
                            sigla = lector.readLine();
                            curso[numCurso].eliminarDato(sigla,1);
                        }

                        break;
                    case 10: //Eliminar recurso digital

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;
                        
                        Asignatura auxAsignatura;
                        
                        if(curso[numCurso].largo() == 0){
                            System.out.println("El curso no posee asignaturas, por lo tanto, no existen recursos digitales.\n");
                            break;
                        }else{
                            System.out.println("Ingrese la sigla de la Asignatura que desea ver los Recursos Digitales: ");
                            sigla = lector.readLine();

                            while (curso[numCurso].buscarAsignatura(sigla) == null){
                                System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                                sigla = lector.readLine();
                            }

                            auxAsignatura = curso[numCurso].buscarAsignatura(sigla);
                            System.out.println("Ingrese el nombre del Recurso Digital: ");
                            nombre = lector.readLine();
                            auxAsignatura.eliminarDato(nombre);
                        }

                        break;
                    case 11: //Modificar alumno

                        System.out.println("\nIngrese el curso del alumno: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;
                        
                        if(curso[numCurso].largo(1) == 0){
                            System.out.println("El curso no posee alumnos.\n");
                            break;
                        }else{
                            System.out.println("Ingrese el rut del alumno a modificar, de la forma '12.345.678-9'.");
                            rut = lector.readLine();
                            System.out.println("Ingrese el nuevo nombre y apellido, de la forma 'Nombre Apellido'.");
                            String nuevoNombre = lector.readLine();
                            System.out.println("Ingrese el nuevo rut, de la forma '12.345.678-9'.");
                            String nuevoRut = lector.readLine();
                            System.out.println("Ingrese la nueva edad");
                            int nuevaEdad = Integer.parseInt(lector.readLine());

                            curso[numCurso].modificarAlumno(rut, nuevoNombre, nuevoRut, nuevaEdad);
                        }

                        break;
                    case 12: //Modificar asignatura

                        System.out.println("\nIngrese el curso de la asignatura a modificar: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;
                        
                        if(curso[numCurso].largo() == 0){
                            System.out.println("El curso no posee asignaturas.\n");
                            break;
                        }else{
                            System.out.println("Ingrese la sigla de la asignatura a modificar.");
                            sigla = lector.readLine();
                            System.out.println("Ingrese el nombre de la asignatura modificada.");
                            String nuevoNombreAsig = lector.readLine();
                            System.out.println("Ingrese la sigla.");
                            String nuevaSigla = lector.readLine();

                            curso[numCurso].modificarAsignatura(sigla, nuevoNombreAsig, nuevaSigla);
                        }

                        break;
                    case 13: //Modificar recurso digital

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso--;

                        if(curso[numCurso].largo() == 0){
                            System.out.println("El curso no posee asignaturas, por lo tanto, no existen recursos digitales.\n");
                            break;
                        }else{
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
                        }
                        
                        break;
                    case 14: //Ver datos de un alumno o profesor específico
                        
                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        
                        System.out.println("\nDesea ver los datos de un alumno o de un profesor?: ");
                        System.out.println("1.- Alumno.");
                        System.out.println("2.- Profesor.\n");
                        
                        int x = Integer.parseInt(lector.readLine());
                        while(x!=1 && x!=2){
                            System.out.println("\nVuelva a ingresar una opcion válida.");
                            System.out.println("\n1.- Alumno.");
                            System.out.println("2.- Profesor.\n");
                            x = Integer.parseInt(lector.readLine());
                        }
                        
                        numCurso--;
                        if(x==1){
                            if(curso[numCurso].largo(1) == 0){
                                System.out.println("El curso no posee alumnos.\n");
                                break;
                            }else{
                                System.out.println("\nIngrese rut del alumno: ");
                                rut = lector.readLine();
                                while (curso[numCurso].buscarAlumno(rut) == null){
                                    System.out.println("Inténtelo nuevamente. Ingrese un rut válido.");
                                    rut = lector.readLine();
                                }
                                auxAlumno = curso[numCurso].buscarAlumno(rut);
                                ((Alumno) auxAlumno).identidad();
                            }
                        }
                        if(x==2){
                            if(curso[numCurso].largo() == 0){
                                System.out.println("El curso no posee asignaturas, por lo tanto, no existen profesores.\n");
                                break;
                            }else{
                                System.out.println("\nIngrese sigla de la asignatura que imparte el profesor: ");
                                sigla = lector.readLine();
                                while (curso[numCurso].buscarAsignatura(sigla) == null){
                                    System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                                    sigla = lector.readLine();
                                }
                                auxProfesor = new Profesor();
                                auxProfesor = curso[numCurso].buscarAsignatura(sigla).getProfesor();
                                ((Profesor) auxProfesor).identidad();
                            }
                        }
                        
                        break;
                    case 15: //Ver lista de alumnos por curso
                        
                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());

                        System.out.println("\nIngrese opcion para mostrar la lista de alumnos: ");
                        System.out.println("1.- Mostrar nombre y rut de alumnos.");
                        System.out.println("2.- Mostrar solo nombre de alumnos.\n");

                        x = Integer.parseInt(lector.readLine());
                        while (x != 1 && x != 2){
                            System.out.println("\nVuelva a ingresar una opcion válida.");
                            System.out.println("\n1.- Mostrar nombre y rut de alumnos.");
                            System.out.println("2.- Mostrar nombre de alumnos.\n");
                            x = Integer.parseInt(lector.readLine());
                        }

                        numCurso --;
                        if (x == 1) curso[numCurso].recorrerLista();
                        if (x == 2) curso[numCurso].recorrerLista(x);

                        break;
                    case 16: //Ver lista de notas de un alumno
                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso --;
                        
                        if(curso[numCurso].largo(1) == 0){
                            System.out.println("El curso no posee alumnos, por lo tanto no existen notas.\n");
                            break;
                        }else{
                            System.out.println("Ingrese rut del alumno, de la forma '12.345.678-9'.");
                            rut = lector.readLine();
                            while(curso[numCurso].buscarAlumno(rut) == null){
                                System.out.println("Inténtelo nuevamente. Ingrese un rut válido: ");
                                rut = lector.readLine();
                            }
                            curso[numCurso].buscarAlumno(rut).listar();
                        }

                        break;
                    case 17: //Ver lista de títulos profesionales de un profesor
                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso --;
                        
                        if(curso[numCurso].largo() == 0){
                            System.out.println("El curso no posee asignaturas, por lo tanto no existen profesores.\n");
                            break;
                        }else{
                            System.out.println("\nIngrese la sigla de la asignatura que imparte el profesor: ");
                            sigla = lector.readLine();
                            while(curso[numCurso].buscarAsignatura(sigla) == null){
                                System.out.println("Inténtelo nuevamente. Ingrese una sigla válida: ");
                                sigla = lector.readLine();
                            }
                            if(curso[numCurso].buscarAsignatura(sigla).getProfesor() == null){
                                System.out.println("La asignatura no tiene asignado un profesor.\n");
                            }else{
                                curso[numCurso].buscarAsignatura(sigla).getProfesor().listar();
                            }
                        }
                        
                        break;
                    case 18: //Ver lista de asignaturas

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        short a = 1;

                        numCurso --;
                        curso[numCurso].recorrerLista(a);

                        break;
                    case 19: //Ver lista de recursos digitales por asignatura
                    
                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso --;
                        
                        if(curso[numCurso].largo() == 0){
                            System.out.println("El curso no posee asignaturas, por lo tanto, no existen recursos digitales.\n");
                            break;
                        }else{
                            System.out.println("\nIngrese la sigla de la Asignatura que desea ver los Recursos Digitales: ");
                            String sigla1 = lector.readLine();
                            while (curso[numCurso].buscarAsignatura(sigla1) == null){
                                System.out.println("Inténtelo nuevamente. Ingrese una sigla válida: ");
                                sigla1 = lector.readLine();
                            }

                            curso[numCurso].buscarAsignatura(sigla1).recorrerLista();
                        }

                        break;
                    case 20: //Buscar recurso digital

                        System.out.println("\nIngrese el curso: ");
                        System.out.println("1.- 1° Medio");
                        System.out.println("2.- 2° Medio");
                        System.out.println("3.- 3° Medio");
                        System.out.println("4.- 4° Medio\n");
                        numCurso = Integer.parseInt(lector.readLine());
                        numCurso --;
                        
                        if(curso[numCurso].largo() == 0){
                            System.out.println("El curso no posee asignaturas, por lo tanto, no existen recursos digitales.\n");
                            break;
                        }else{
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
                        }

                        break;
                    case 21: /* Seleccionar alumno con la nota final mas baja de todos los cursos */

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
                            System.out.println("\nEl alumno con el promedio más bajo ("+promedioCursoBajo+") es: "+ seleccionarAlumno.getNombre() +" - "+ seleccionarAlumno.getRut()+"\n");
                        }

                        break;
                    case 22: /* Seleccion de alumnos con nota final entre 4.0 y 7.0 de todos los cursos */
                        System.out.println("\nLista de Alumnos con promedio entre 4.0 y 7.0");
                        boolean aux;
                        int cont = 0;
                        for(int i = 0 ; i < 4 ; i++){
                            aux = curso[i].notaRango();
                            if (aux == false) cont ++;
                        }
                        if (cont == 0) System.out.println("\nNo hay notas registradas.\n");
                        break;
                    case 23:
                        salir = true;
                        break;
                    default:
                        System.out.println("Ingrese solo opciones del 1 al 23.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese una opcion valida.");
                sn.next();
            }
        }
        
    }

}