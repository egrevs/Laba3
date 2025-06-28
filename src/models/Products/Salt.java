package models.Products;

import java.util.Objects;

public record Salt(String name, int energyConsumption, int price) implements HandlingProduct {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Salt salt = (Salt) o;
        return price == salt.price && energyConsumption == salt.energyConsumption && Objects.equals(name, salt.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + energyConsumption;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Salt{" +
                "name='" + name + '\'' +
                ", energyConsumption=" + energyConsumption +
                ", price=" + price +
                '}';
    }

    @Override
    public String showInfo() {
        return name + " затрачивает на использование " + energyConsumption + " единиц силы и энергии. " +
                "При этом имеет стоимость " + price;
    }
}
