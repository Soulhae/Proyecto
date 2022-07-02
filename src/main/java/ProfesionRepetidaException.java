public class ProfesionRepetidaException extends Exception{
    public ProfesionRepetidaException(){
        super("\nEl profesor ya tiene asignada esta profesión.");
    }
}
