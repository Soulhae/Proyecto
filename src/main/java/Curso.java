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

    public void modificarAlumno(String rut, String nuevoNombre, String nuevoRut) throws IOException {
        for(int i = 0 ; i < alumno.size() ; i++){
            if ( alumno.get(i).getRut().equals(rut) ){
                alumno.get(i).setNombre(nuevoNombre);
                alumno.get(i).setRut(nuevoRut);
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
 