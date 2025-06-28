package models.factory.people.qualifiedWorkers;

import Exceptions.UnableToWork;
import Interfaces.AbleToCarry;
import models.Products.HandlingProduct;
import models.Products.Salt;
import models.enums.WorkerHealth;
import models.enums.WorkerProfession;
import models.factory.people.Worker;

public class Loader extends Worker implements AbleToCarry {

    public Loader(String name) {
        super(name, new Salt("соль", 2, 150) );
        this.efficiency = 6;
        this.strength = 10;
        this.profession = WorkerProfession.LOADER;
    }

    @Override
    public String carryProduct(Salt salt) {
        return " толочет и тоскает " + salt.name();
    }

    @Override
    public <T extends HandlingProduct> void startWorking(T product) {
        if (checkHealth() == WorkerHealth.HEALTHY) {
            System.out.println(this.getProfession().getName() + " " +
                    this.name + carryProduct((Salt) product) + ".");

            this.efficiency -= product.energyConsumption();
            this.strength -= product.energyConsumption();
        } else
            throw new UnableToWork("");

        System.out.println();
    }

    @Override
    public String toString() {
        return "Loader{" +
                "profession=" + profession +
                ", efficiency=" + efficiency +
                ", strength=" + strength +
                ", name='" + name + '\'' +
                '}';
    }
}
