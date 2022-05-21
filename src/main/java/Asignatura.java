import java.util.*;
import java.io.*;

public class Asignatura {
    private String nombre;
    private String sigla;
    private ArrayList<RecursoDigital> listRecDigital;
    private HashMap<String, RecursoDigital> mapRecDigital;
    
    public Asignatura(){
        this.nombre = "default";
        this.sigla = "default";
        this.listRecDigital = new ArrayList<>();
        this.mapRecDigital = new HashMap<>();
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
    
    public void escribirRecDigital (File archivo, FileWriter fw, BufferedWriter bw, PrintWriter wr) {
        int i;
        for(i=0; i<listRecDigital.size(); i++) {
            wr.append(listRecDigital.get(i).getTipo()+" | "+listRecDigital.get(i).getNombre()+" \n");
        }
        wr.append("\n");
    }

    public void eliminarRecDigital(String nombre){
        /* eliminar de la lista */
        int cont = 0;
        for(int i = 0 ; i < listRecDigital.size() ; i++){
            if(listRecDigital.get(i).getNombre().equals(nombre)){
                this.listRecDigital.remove(i);
                cont ++;
                break;
            }
        }
        /* Eliminar del mapa. No lo elimina correctamente */
        if (cont == 1){
            RecursoDigital aux = buscarMapaRecDigital(nombre);
            this.mapRecDigital.remove(nombre);
            cont ++;
        }
        if (cont == 2) System.out.println("\nRecurso digital eliminado con exito.\n");
        else System.out.println("\nEl Recurso digital ingresado no existe.\n");
    }
    
    public void recorrerListaRecDigital(){
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
    
}
