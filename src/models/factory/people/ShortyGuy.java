package models.factory.people;

import models.Products.HandlingProduct;

import java.util.List;
import java.util.Objects;

public abstract class ShortyGuy {
    protected int efficiency;
    protected int strength;
    protected String name;

    public ShortyGuy(String name) {
        this.name = name;
    }

    public abstract <T extends HandlingProduct> void startWorking(T product);

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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

        ShortyGuy shortyGuy = (ShortyGuy) o;
        return efficiency == shortyGuy.efficiency && strength == shortyGuy.strength && Objects.equals(name, shortyGuy.name);
    }

    @Override
    public int hashCode() {
        int result = efficiency;
        result = 31 * result + strength;
        result = 31 * result + Objects.hashCode(name);
        return result;
    }

    @Override
    public String toString() {
        return "ShortyGuy{" +
                "efficiency=" + efficiency +
                ", strength=" + strength +
                ", name='" + name + '\'' +
                '}';
    }
}
