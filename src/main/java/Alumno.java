import java.io.*;

public class Alumno {
    private String nombre;
    private String rut;
    
    public Alumno(){
        this.nombre = "default";
        this.rut = "default";
    }
    
    public Alumno(String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws IOException {
        while (!Character.isDigit(rut.charAt(0))){
            BufferedReader lector = new BufferedReader ( new InputStreamReader (System.in) );
            System.out.println("Vuelva a ingresar el rut.");
            rut = lector.readLine();
            System.out.println("false");
        }
        System.out.println("true");
        this.rut = rut;
    }
    
    public boolean validar(String letra){
        boolean valido = true;
        if(!letra.matches("[A-Z]*")){
            valido = false;
        }
        return valido;
    }

}
