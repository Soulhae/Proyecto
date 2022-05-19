public class Profesor extends Persona{
    private String rolProfe;
    //private ArrayList asignaturas;
    
    public Profesor(){
        super();
        this.rolProfe = "default";
    }
    
    public void setRolProfe(String rolProfe){
        this.rolProfe = rolProfe;
    }
    
    public String getRolProfe(){
        return rolProfe;
    }
    
    @Override
    public void identidad(){
        System.out.println("Nombre: "+getNombre());
        System.out.println("Rut: "+getRut());
        System.out.println("Edad: "+getEdad());
        System.out.println("Rol Alumno: "+rolProfe);
    }
    
    @Override
    public void listar(){
        //imprimir lista de asignaturas
    }
    
}
