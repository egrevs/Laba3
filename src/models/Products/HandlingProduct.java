package models.Products;

public interface HandlingProduct {
    public String showInfo();

    default String describe(){
        return "Предмет используемый сотрудником: " + showInfo();
    }

    public String name();
    public int energyConsumption();
}
