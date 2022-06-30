import java.util.*;
import java.io.*;

public class Asignatura implements Imprimible {
    private String nombre;
    private String sigla;
    private ArrayList<RecursoDigital> listRecDigital;
    private HashMap<String, RecursoDigital> mapRecDigital;
    private Persona profesor;
    private ArrayList<Persona> listAlumnos;
    
    public Asignatura(){
        this.nombre = "default";
        this.sigla = "default";
        this.listRecDigital = new ArrayList<>();
        this.mapRecDigital = new HashMap<>();
        this.listAlumnos = new ArrayList<>();
    }
    
    public Asignatura(String nombre, String sigla){
        this.nombre = nombre;
        this.sigla = sigla;
        this.listRecDigital = new ArrayList<>();
        this.mapRecDigital = new HashMap<>();
    }
    
    public void agregarRecDigital(RecursoDigital recDigital) {
        this.listRecDigital.add(recDigital);
    }
    
    public void agregarRecDigital(String clave, RecursoDigital recDigital){
        this.mapRecDigital.put(clave,recDigital);
    }
    
    public void agregarProfesor(Persona profesor){
        this.profesor = (Profesor) profesor;
    }
    
    public void escribirRecDigital (File archivo, FileWriter fw, BufferedWriter bw, PrintWriter wr) {
        int i;
        for(i=0; i<listRecDigital.size(); i++) {
            wr.append(listRecDigital.get(i).getTipo()+" | "+listRecDigital.get(i).getNombre()+" \n");
        }
        wr.append("\n");
    }
    
    @Override
    public void eliminarDato(String nombre){
        /* eliminar de la lista */
        int cont = 0;
        for(int i = 0 ; i < listRecDigital.size() ; i++){
            if(listRecDigital.get(i).getNombre().equals(nombre)){
                this.listRecDigital.remove(i);
                cont ++;
                break;
            }
        }
        /* Eliminar del mapa. */
        if (cont == 1){
            //RecursoDigital aux = buscarMapaRecDigital(nombre);
            this.mapRecDigital.remove(nombre);
            cont ++;
        }
        if (cont == 2) System.out.println("\nRecurso digital eliminado con exito.\n");
        else System.out.println("\nEl Recurso digital ingresado no existe.\n");
    }
    
    @Override
    public void eliminarDato(String rut, int x){
        for(int i=0; i<listAlumnos.size(); i++){
            if(listAlumnos.get(i).getRut().equals(rut)){
                this.listAlumnos.remove(i);
                System.out.println("\nAlumno eliminado con exito.\n");
                return;
            }
        }
        System.out.println("\nEl alumno ingresado no existe.\n");
    }
    
    @Override
    public void recorrerLista(){
        if(listRecDigital.isEmpty()){
            System.out.println("\nEsta asignatura no tiene recursos digitales registrados.");
        }else{
            System.out.println("\n- Lista de Recursos Digitales -");
            int i;
            for(i=0; i<listRecDigital.size(); i++){
                System.out.println(listRecDigital.get(i).getTipo()+" | "+listRecDigital.get(i).getNombre());
            }
        }
        System.out.println("\n");
    }

    public void modificarRecDigital(String nombre, String nuevoNombre, String nuevoTipo){
        /* modificar de la lista */
        int cont = 0;
        for(int i = 0 ; i < listRecDigital.size() ; i++){
            if(listRecDigital.get(i).getNombre().equals(nombre)){
                listRecDigital.get(i).setNombre(nuevoNombre);
                listRecDigital.get(i).setTipo(nuevoTipo);
                cont ++;
                break;
            }
        }
        /* modificar del mapa */
        if (cont == 1){
            RecursoDigital aux = buscarMapaRecDigital(nombre);
            aux.setNombre(nuevoNombre);
            aux.setTipo(nuevoTipo);
            this.mapRecDigital.put(nuevoNombre, aux);
            cont ++;
        }
        if (cont == 2) System.out.println("\nRecurso digital modificado con exito.\n");
        else System.out.println("\nEl Recurso digital a modificar no existe.\n");
    }
    
    public RecursoDigital buscarMapaRecDigital(String clave){
        return this.mapRecDigital.get(clave);
    }
    
    public void agregarAlumno(Persona alumno) {
        this.listAlumnos.add(alumno);
    }
    
    public void recorrerAlumnosAsig(){
        if (listAlumnos.size() == 0){
            System.out.println("\nNo hay alumnos registrados.\n");
            return;
        }
        System.out.println("\n- Lista de Alumnos -");
        int i;
        for(i=0; i<listAlumnos.size(); i++){
            System.out.println(listAlumnos.get(i).getNombre()+" | "+listAlumnos.get(i).getRut());
        }
        System.out.println("\n");
    }
    
    public Persona buscarAlumno(String rut){
        for(int i = 0 ; i < listAlumnos.size() ; i++){
            if ( listAlumnos.get(i).getRut().equals(rut) ){
                return listAlumnos.get(i);
            }
        }
        return null;
    }
    
    public void modificarAlumno(String rut, String nuevoNombre, String nuevoRut, int nuevaEdad) throws IOException {
        for(int i = 0 ; i < listAlumnos.size() ; i++){
            if ( listAlumnos.get(i).getRut().equals(rut) ){
                listAlumnos.get(i).setNombre(nuevoNombre);
                listAlumnos.get(i).setRut(nuevoRut);
                listAlumnos.get(i).setEdad(nuevaEdad);
                System.out.println("\nAlumno modificado correctamente.\n");
                return;
            }
        }
        System.out.println("\nEl alumno ingresado no existe.\n");
    }
    
    public boolean existenAlumnos(){
        if (listAlumnos.size() == 0) return false;
        else return true;
    }
    
    public Persona obtenerAlumnoBajo(){
        double promedioBajo = 8;
        Persona alumnoSeleccionado = new Alumno();
        for (int i = 0 ; i < listAlumnos.size() ; i++){
            if ( promedioBajo > ( (Alumno) listAlumnos.get(i) ).obtenerPromedio() ){
                promedioBajo = ( (Alumno) listAlumnos.get(i) ).obtenerPromedio();
                alumnoSeleccionado = (Alumno) listAlumnos.get(i);
            }
        }
        return (Alumno) alumnoSeleccionado;
    }
    
    public boolean notaRango(){
        double promedioRango = 0.0;
        int cont = 0;
        for (int i = 0 ; i < listAlumnos.size() ; i++){
            promedioRango = ( (Alumno) listAlumnos.get(i) ).obtenerPromedio();
            if (promedioRango == 0.0) cont ++;
            if ( promedioRango <= 7.0 && promedioRango >= 4.0 ){
                System.out.println("Promedio: "+promedioRango+" | Alumno: "+ listAlumnos.get(i).getNombre() +" - "+ listAlumnos.get(i).getRut());
            }
        }
        cont ++;
        if (cont == listAlumnos.size()) return false;
        return true;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public Profesor getProfesor(){
        return (Profesor) profesor;
    }
    
    public void setProfesor(Persona profesor){
        this.profesor = (Profesor) profesor;
    }

    @Override
    public void recorrerLista(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recorrerLista(short x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
