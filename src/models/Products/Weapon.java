package models.Products;

import java.util.Objects;

public record Weapon(String name, int energyConsumption) implements HandlingProduct {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Weapon weapon = (Weapon) o;
        return energyConsumption == weapon.energyConsumption && Objects.equals(name, weapon.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + energyConsumption;
        return result;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", energyConsumption=" + energyConsumption +
                '}';
    }

    @Override
    public String showInfo() {
        return name + " затрачивает на использование " + energyConsumption + " единиц силы и энергии.";
    }
}
