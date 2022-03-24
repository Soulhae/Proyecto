public class Asignatura {
    private String nombre;
    private String sigla;
    
    public Asignatura(){
        this.nombre = "default";
        this.sigla = "default";
    }
    
    public Asignatura(String nombre, String sigla){
        this.nombre = nombre;
        this.sigla = sigla;
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
