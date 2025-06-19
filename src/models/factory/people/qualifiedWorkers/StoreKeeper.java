package models.factory.people.qualifiedWorkers;

import Exceptions.UnableToWork;
import Interfaces.AbleToStore;
import models.HandlingProduct;
import models.enums.WorkerHealth;
import models.enums.WorkerProfession;
import models.factory.people.Worker;

public class StoreKeeper extends Worker implements AbleToStore {

    public StoreKeeper(String name) {
        super(name, new HandlingProduct("соль", 2));
        this.efficiency = 7;
        this.strength = 7;
        this.profession = WorkerProfession.STOREKEEPER;
    }

    @Override
    public String storeProduct(HandlingProduct handlingProduct) {
        return " собирает и раскладывает на складе " + handlingProduct.name();
    }

    @Override
    public void startWorking(HandlingProduct product) {
        if (checkHealth() == WorkerHealth.HEALTHY) {
            System.out.println(this.getProfession().getName() + " " +
                    this.name + storeProduct(product) + ".");

            this.efficiency -= this.handlingProduct.energyConsumption();
            this.strength -= this.handlingProduct.energyConsumption();
        } else
            throw new UnableToWork("");

        System.out.println();
    }

    @Override
    public String toString() {
        return "StoreKeeper{" +
                "profession=" + profession +
                ", efficiency=" + efficiency +
                ", strength=" + strength +
                ", name='" + name + '\'' +
                '}';
    }
}
