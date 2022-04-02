import java.util.*;

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
    
    public void recorrerListaRecDigital(){
        int i;
        if(listRecDigital.isEmpty()){
            System.out.println("Esta asignatura no contiene recursos digitales");
        }else{
            for(i=0; i<listRecDigital.size(); i++){
                System.out.println(listRecDigital.get(i).getTipo()+" | "+listRecDigital.get(i).getNombre());
            }
        }
        
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
