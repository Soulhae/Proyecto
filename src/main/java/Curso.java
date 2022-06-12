import java.util.*;
import java.io.*;

public class Curso implements Imprimible{
    private ArrayList<Persona> alumno;
    private ArrayList<Asignatura> asignatura;
    
    public Curso(){
        this.alumno = new ArrayList<>();
        this.asignatura = new ArrayList<>();
    }

    public void agregarAlumno(Persona alumno1) {
        this.alumno.add(alumno1);
    }

    public void agregarAsignatura(Asignatura asignatura) {
        this.asignatura.add(asignatura);
    }
    
    public int largo(){ return asignatura.size(); }
    
    public int largo(int x){ return alumno.size(); }
    
    @Override
    public void eliminarDato(String rut){
        for(int i=0; i<alumno.size(); i++){
            if(alumno.get(i).getRut().equals(rut)){
                this.alumno.remove(i);
                System.out.println("\nAlumno eliminado con exito.\n");
                return;
            }
        }
        System.out.println("\nEl alumno ingresado no existe.\n");
    }
    
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
    public void recorrerLista(){
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
    
    @Override
    public void recorrerLista(int x){
        if (alumno.size() != 0){
            System.out.println("\n- Lista de Alumnos -");
            int i;
            for(i=0; i<alumno.size(); i++){
                System.out.println(alumno.get(i).getNombre());
            }
            System.out.println("\n");
        }
        if (alumno.size() == 0) System.out.println("\nNo hay alumnos registrados.\n");
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
                return asignatura.get(i);
            }
        }
        return null;
    }

    public Persona buscarAlumno(String rut){
        for(int i = 0 ; i < alumno.size() ; i++){
            if ( alumno.get(i).getRut().equals(rut) ){
                return alumno.get(i);
            }
        }
        return null;
    }

    public void modificarAlumno(String rut, String nuevoNombre, String nuevoRut, int nuevaEdad) throws IOException {
        for(int i = 0 ; i < alumno.size() ; i++){
            if ( alumno.get(i).getRut().equals(rut) ){
                alumno.get(i).setNombre(nuevoNombre);
                alumno.get(i).setRut(nuevoRut);
                alumno.get(i).setEdad(nuevaEdad);
                System.out.println("\nAlumno modificado correctamente.\n");
                return;
            }
        }
        System.out.println("\nEl alumno ingresado no existe.\n");
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

    public Persona obtenerAlumnoBajo(){
        double promedioBajo = 8;
        Persona alumnoSeleccionado = new Alumno();
        for (int i = 0 ; i < alumno.size() ; i++){
            if ( promedioBajo > ( (Alumno) alumno.get(i) ).obtenerPromedio() ){
                promedioBajo = ( (Alumno) alumno.get(i) ).obtenerPromedio();
                alumnoSeleccionado = (Alumno) alumno.get(i);
            }
        }
        return (Alumno) alumnoSeleccionado;
    }

    public boolean notaRango(){
        double promedioRango = 0.0;
        int cont = 0;
        for (int i = 0 ; i < alumno.size() ; i++){
            promedioRango = ( (Alumno) alumno.get(i) ).obtenerPromedio();
            if (promedioRango == 0.0) cont ++;
            if ( promedioRango <= 7.0 && promedioRango >= 4.0 ){
                System.out.println("Promedio: "+promedioRango+" | Alumno: "+ alumno.get(i).getNombre() +" - "+ alumno.get(i).getRut());
            }
        }
        cont ++;
        if (cont == alumno.size()) return false;
        return true;
    }
    
    public boolean existenAlumnos(){
        if (alumno.size() == 0) return false;
        else return true;
    }
    
    public boolean existenAsignaturas(){
        if (asignatura.size() == 0) return false;
        else return true;
    }
    
    public void generarTXT () {
        File archivo;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter wr;
        
        try {
            archivo = new File ("Resultados.txt");
            fw = new FileWriter (archivo);
            bw = new BufferedWriter (fw);
            wr = new PrintWriter (bw);
            
            wr.write("- Lista de Alumnos -\n");
            wr.append("\n");
            
            int i;
            for(i = 0; i<alumno.size(); i++) {
                wr.append(alumno.get(i).getNombre()+" | "+alumno.get(i).getRut()+" \n");
            }
            
            wr.append("\n");
            wr.append("- Lista de Asignaturas -\n");
            wr.append("\n");
            
            for (i = 0; i<asignatura.size(); i++) {
                wr.append(asignatura.get(i).getNombre()+" | "+asignatura.get(i).getSigla()+" \n");
            }
            
            wr.append("\n");
            wr.append("- Lista de Recursos Digitales -\n");
            wr.append("\n");
            
            for (i = 0; i<asignatura.size(); i++) {
                wr.append(asignatura.get(i).getNombre()+" \n");
                wr.append("\n");
                asignatura.get(i).escribirRecDigital(archivo, fw, bw, wr);
            }
            
            wr.close();
            bw.close();
        } catch (Exception e) {
            System.out.println("Algo ha fallado");
        }
        
    }

}
 