public class RecursoDigital {
    private String tipo;
    private String nombre;
    
    public RecursoDigital(){
        this.tipo = "default";
        this.nombre = "default";
    }
    
    public RecursoDigital(String tipo, String nombre){
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
