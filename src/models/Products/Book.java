package models.Products;

import java.util.Objects;

public record Book (String name, int energyConsumption) implements HandlingProduct {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return energyConsumption == book.energyConsumption && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + energyConsumption;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", energyConsumption=" + energyConsumption +
                '}';
    }

    @Override
    public String showInfo() {
        return name + " затрачивает на использование " + energyConsumption + " единиц силы и энергии.";
    }
}
