public class Alumno extends Persona{
    private String rolAlumno;
    //private ArrayList notas;
    
    public Alumno(){
        super();
        this.rolAlumno = "default";
    }
    
    public void setRolAlumno(String rolAlumno){
        this.rolAlumno = rolAlumno;
    }
    
    public String getRolAlumno(){
        return rolAlumno;
    }
    
    @Override
    public void identidad(){
        System.out.println("Nombre: "+getNombre());
        System.out.println("Rut: "+getRut());
        System.out.println("Edad: "+getEdad());
        System.out.println("Rol Alumno: "+rolAlumno);
    }
    
    @Override
    public void listar(){
        //imprimir lista de notas
    }
    
}
