import java.util.*;

public class Asignatura {
    private String nombre;
    private String sigla;
    private ArrayList<RecursoDigital> recDigital;
    
    public Asignatura(){
        this.nombre = "default";
        this.sigla = "default";
    }
    
    public Asignatura(String nombre, String sigla){
        this.nombre = nombre;
        this.sigla = sigla;
    }

    /*public ArrayList<RecursoDigital> getRecDigital() {
        return recDigital;
    }*/

    public void setRecDigital(RecursoDigital recDigital) {
        this.recDigital.add(recDigital);
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
