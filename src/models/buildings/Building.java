package models.buildings;

import models.factory.people.Worker;

import java.util.Objects;

public abstract class Building {
    protected int capacity;
    protected String name;

    public Building(String name, int capacity) {
        this.capacity = capacity;
        this.name = name;
    }

    public abstract void addWorker(Worker worker);
    public abstract int countFreeSpace();


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Building building = (Building) o;
        return capacity == building.capacity && Objects.equals(name, building.name);
    }

    @Override
    public int hashCode() {
        int result = capacity;
        result = 31 * result + Objects.hashCode(name);
        return result;
    }

    @Override
    public String toString() {
        return "Building{" +
                "capacity=" + capacity +
                ", name='" + name + '\'' +
                '}';
    }
}
