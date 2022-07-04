import java.util.*;
import java.io.*;

public class Institucion implements Imprimible{
    private ArrayList<Asignatura> asignatura;
    
    public Institucion(){
        this.asignatura = new ArrayList<>();
    }

    public void agregarAsignatura(Asignatura asignatura) throws AsigRepetidaException {
        if(this.buscarAsignatura(asignatura.getSigla())!=null){
            throw new AsigRepetidaException();
        }
        this.asignatura.add(asignatura);
    }
    
    public int largo(){ return asignatura.size(); }
    
    @Override
    public void eliminarDato(String sigla, int x){
        for(int i = 0 ; i < asignatura.size() ; i++){
            if(asignatura.get(i).getSigla().equals(sigla)){
                this.asignatura.remove(i);
                System.out.println("\nAsignatura eliminada con exito.\n");
                return;
            }
        }
        System.out.println("\nLa asignatura ingresada no existe.\n");
    }
    
    @Override
    public void recorrerLista(short x){
        if (asignatura.size() == 0){
            System.out.println("\nNo hay asignaturas registradas.\n");
            return;
        }
        System.out.println("\n- Lista de Asignaturas -");
        int i;
        for(i=0; i<asignatura.size(); i++){
            if(asignatura.get(i).getProfesor() == null){
                System.out.println(asignatura.get(i).getNombre()+" | "+asignatura.get(i).getSigla()+" | Profesor: NO ASIGNADO");     
            }else{
                System.out.println(asignatura.get(i).getNombre()+" | "+asignatura.get(i).getSigla()+" | Profesor: "+asignatura.get(i).getProfesor().getNombre());
            }
        }
        System.out.println("\n");
    }
    
    public Asignatura buscarAsignatura(String sigla) {
        for(int i = 0 ; i < asignatura.size() ; i++){
            if ( asignatura.get(i).getSigla().equals(sigla) ){
                return (Asignatura) asignatura.get(i);
            }
        }
        return null;
    }

    public void modificarAsignatura(String sigla, String nuevoNombreAsig, String nuevaSigla){
        for(int i = 0 ; i < asignatura.size() ; i++){
            if ( asignatura.get(i).getSigla().equals(sigla) ){
                asignatura.get(i).setNombre(nuevoNombreAsig);
                asignatura.get(i).setSigla(nuevaSigla);
                System.out.println("\nAsignatura modificada correctamente.\n");
                return;
            }
        }
        System.out.println("\nLa asignatura ingresada no existe.\n");
    }
    
    public void obtenerAlumnoBajoAsig(){
        Persona seleccionarAlumno = new Alumno(); /* Alumno con el promedio mas bajo */
        Persona auxSeleccionarAlumno = new Alumno(); /* Alumno que se compara */
        double promedioCursoBajo = 8;
        for (int i = 0 ; i < asignatura.size() ; i++){
            auxSeleccionarAlumno = ((Alumno) asignatura.get(i).obtenerAlumnoBajo()); /* retorna el alumno */
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
    }
    
    public void notaRangoAsig(){
        System.out.println("\nLista de Alumnos con promedio entre 4.0 y 7.0");
        boolean aux;
        int cont = 0;
        for(int i = 0 ; i < asignatura.size() ; i++){
            aux = asignatura.get(i).notaRango();
            if (aux == false) cont ++;
        }
        if (cont == 0) System.out.println("\nNo hay notas registradas.\n");
    }
    
    public boolean existenAsignaturas(){
        if (asignatura.size() == 0) return false;
        else return true;
    }
    
    public void generarTXT () throws IOException {
        
        if (asignatura.size() == 0){
            System.out.println("Debe ingresar al menos una asignatura para generar el archivo.\n");
        }
        else{
            try {
                File archivo;
                FileWriter fw;
                BufferedWriter bw;
                PrintWriter wr;

                archivo = new File ("Datos.txt");
                fw = new FileWriter (archivo);
                bw = new BufferedWriter (fw);
                wr = new PrintWriter (bw);

                for (int i = 0 ; i < asignatura.size() ; i++){
                    wr.append("\n--- Asignatura: '"+asignatura.get(i).getNombre()+"' ---\n\n");
                    asignatura.get(i).escribirProfesor(archivo, fw, bw, wr);
                    asignatura.get(i).escribirAlumnos(archivo, fw, bw, wr);
                    asignatura.get(i).escribirRecDigital(archivo, fw, bw, wr);
                }

                wr.close();
                bw.close();

                System.out.println("Archivo '.txt' generado correctamente.\n");
            } catch (NullPointerException e) {
                System.out.println("El archivo no se genero correctamente.\n");
            }
        }
        
    }

    @Override
    public void recorrerLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recorrerLista(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarDato(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
 