import java.util.*;

public class Profesor extends Persona{
    private double rolProfe;
    private ArrayList<String> profesiones;
    
    public Profesor(){
        super();
        this.rolProfe = 0.0;
        this.profesiones = new ArrayList<>();
    }
    
    public void setRolProfe(String rut){
        int ultimoDig;
        int primerDig;
        if(Character.isDigit(rut.charAt(rut.length()-1))){
            primerDig = Integer.parseInt(rut.substring(0, 1));
            ultimoDig = Integer.parseInt(rut.substring(rut.length()-1));
        }else{
            primerDig = Integer.parseInt(rut.substring(0, 1));
            ultimoDig = (int) Math.round(Math.random() * 9);
        }
        
        rolProfe = Math.pow(Math.abs(ultimoDig-primerDig),ultimoDig) + 1337 * Math.round(Math.random());
    }
    
    public double getRolProfe(){
        return rolProfe;
    }
    
    @Override
    public void identidad(){
        System.out.println("\nNombre: "+getNombre());
        System.out.println("Rut: "+getRut());
        System.out.println("Edad: "+getEdad());
        System.out.println("Rol Profesor: "+(int)rolProfe);
        System.out.println("");
    }
    
    @Override
    public void listar(){
        if(profesiones.isEmpty()){
            System.out.println("\nEl profesor "+getNombre()+" no posee títulos profesionales.\n");
            return;
        }
        System.out.println("\n- Lista de títulos profesionales del profesor "+getNombre()+" -");
        int i;
        for(i=0; i<profesiones.size(); i++){
            System.out.println(profesiones.get(i));
        }
        System.out.println("\n");
    }
    
    public void agregarProfesion(String profesion){
        this.profesiones.add(profesion);
        System.out.println("\nProfesion agregada correctamente.\n");
    }
}
