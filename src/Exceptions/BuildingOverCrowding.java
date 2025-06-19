package Exceptions;

public class BuildingOverCrowding extends RuntimeException {
    public BuildingOverCrowding(String message) {
        super(message);
    }

    @Override
    public String getMessage(){
        return "Недосаточно места в здании, надо расширить помещение";
    }
}
