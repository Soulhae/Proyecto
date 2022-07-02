public class AsigRepetidaException extends Exception {
    public AsigRepetidaException(){
        super("\nYa existe una asignatura con la misma sigla.");
    }
}
