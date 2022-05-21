import java.io.*;

public abstract class Persona {
    private String nombre;
    private String rut;
    private int edad;
    
    public Persona(){
        this.nombre = "default";
        this.rut = "default";
        this.edad = 0;
    }
    
    public boolean validar(String letra){
        boolean valido = true;
        if(!letra.matches("[A-Z]*") && !letra.matches("[a-z]*")){
            valido = false;
        }
        return valido;
    }

    public void setNombre(String nombre) throws IOException {
        String letra = nombre.substring(0,1);
        while (!validar(letra)){
            BufferedReader lector = new BufferedReader ( new InputStreamReader (System.in) );
            System.out.println("Nombre invalido, intentelo nuevamente.");
            nombre = lector.readLine();
            letra = nombre.substring(0,1);
        }
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setRut(String rut) throws IOException {
        while (!Character.isDigit(rut.charAt(0))){
            BufferedReader lector = new BufferedReader ( new InputStreamReader (System.in) );
            System.out.println("Vuelva a ingresar el rut.");
            rut = lector.readLine();
        }
        this.rut = rut;
    }
    
    public String getRut(){
        return rut;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void identidad(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Rut: "+rut);
        System.out.println("Edad: "+edad);
    }
    
    public abstract void listar();
    
}
