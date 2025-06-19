package models;

import java.util.Objects;

public record HandlingProduct(String name, int energyConsumption){

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        HandlingProduct product = (HandlingProduct) o;
        return energyConsumption == product.energyConsumption && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + energyConsumption;
        return result;
    }

    @Override
    public String toString() {
        return "HandlingProduct{" +
                "name='" + name + '\'' +
                ", energyConsumption=" + energyConsumption +
                '}';
    }
}