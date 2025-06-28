package Exceptions;

public class UnqualifiedWorker extends RuntimeException {
    public UnqualifiedWorker(String message) {
        super(message);
    }

    public String getMessage(){
        return " работник не имеет квалификации и не может быть устроен на работу ";
    }
}
