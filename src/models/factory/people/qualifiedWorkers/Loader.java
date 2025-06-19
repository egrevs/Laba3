package models.factory.people.qualifiedWorkers;

import Exceptions.UnableToWork;
import Interfaces.AbleToCarry;
import models.HandlingProduct;
import models.enums.WorkerHealth;
import models.enums.WorkerProfession;
import models.factory.people.Worker;

public class Loader extends Worker implements AbleToCarry {

    public Loader(String name) {
        super(name, new HandlingProduct("соль", 2) );
        this.efficiency = 6;
        this.strength = 10;
        this.profession = WorkerProfession.LOADER;
    }

    @Override
    public String carryProduct(HandlingProduct handlingProduct) {
        return " толочет и тоскает " + handlingProduct.name();
    }

    @Override
    public void startWorking(HandlingProduct product) {
        if (checkHealth() == WorkerHealth.HEALTHY) {
            System.out.println(this.getProfession().getName() + " " +
                    this.name + carryProduct(product) + ".");

            this.efficiency -= this.handlingProduct.energyConsumption();
            this.strength -= this.handlingProduct.energyConsumption();
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
