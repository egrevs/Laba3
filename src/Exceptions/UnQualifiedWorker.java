package Exceptions;

public class UnQualifiedWorker extends RuntimeException {
    public UnQualifiedWorker(String message) {
        super(message);
    }

    public String getMessage(){
        return " работник не имеет квалификации и не может быть устроен на работу ";
    }
}
