import java.util.*;

public class Alumno extends Persona{
    private double rolAlumno;
    private ArrayList<Double> notas;
    
    public Alumno(){
        super();
        this.rolAlumno = 0.0;
        this.notas = new ArrayList<>();
    }
     
    public void setRolAlumno(String rut){
        int ultimoDig;
        int primerDig;
        if(Character.isDigit(rut.charAt(rut.length()-1))){
            primerDig = Integer.parseInt(rut.substring(0, 1));
            ultimoDig = Integer.parseInt(rut.substring(rut.length()-1));
        }else{
            primerDig = Integer.parseInt(rut.substring(0, 1));
            ultimoDig = (int) Math.round(Math.random() * 9);
        }
        
        rolAlumno = Math.pow(Math.abs(ultimoDig-primerDig),ultimoDig) + 1337 * Math.round(Math.random());
    }
    
    public double getRolAlumno(){
        return rolAlumno;
    }
    
    @Override
    public void identidad(){
        System.out.println("\nNombre: "+getNombre());
        System.out.println("Rut: "+getRut());
        System.out.println("Edad: "+getEdad());
        System.out.println("Rol Alumno: "+(int)rolAlumno);
        System.out.println("");
    }
    
    @Override
    /* imprimir lista de notas */
    public void listar(){
        if (notas.size() == 0){
            System.out.println("\nNo hay notas registradas del alumno "+getNombre()+".\n");
            return;
        }
        System.out.println("\n- Lista de notas del alumno "+getNombre()+" -");
        int i;
        for(i = 0 ; i < notas.size() ; i++){
            System.out.println(notas.get(i));
        }
        System.out.println("\n");
    }

    public void agregarNota(double nota){
        this.notas.add(nota);
    }

    public Double obtenerPromedio(){
        double suma = 0.0;
        double promedio = 0.0;
        for(int i = 0 ; i < notas.size() ; i++){
            suma += notas.get(i);
        }
        promedio = suma / notas.size();
        return promedio;
    }

    /*public void eliminarNota(int nota){
        for(int i = 0 ; i < notas.size() ; i++){
            if( notas[i] == nota){
                this.asignatura.remove(i);
                System.out.println("\nAsignatura eliminada con exito.\n");
                return;
            }
        }
        System.out.println("\nLa asignatura ingresada no existe.\n");
    }*/
    
}
