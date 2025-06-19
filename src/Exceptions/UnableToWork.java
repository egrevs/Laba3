package Exceptions;

public class UnableToWork extends RuntimeException {
    public UnableToWork(String message) {
        super(message);
    }

    @Override
    public String getMessage(){
        return "Работник не может работать по состоянию здоровья," +
                " ему необходимо пройти реабилитацию";
    }
}
