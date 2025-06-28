package Exceptions;

public class NoAvailableBuilding extends RuntimeException {
    public NoAvailableBuilding(String message) {
        super(message);
    }

    @Override
    public String getMessage(){
        return "помещения для работы не существует";
    }
}
