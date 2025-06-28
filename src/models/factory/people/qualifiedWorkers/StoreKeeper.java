package models.factory.people.qualifiedWorkers;

import Exceptions.UnableToWork;
import Interfaces.AbleToStore;
import models.Products.HandlingProduct;
import models.Products.Salt;
import models.enums.WorkerHealth;
import models.enums.WorkerProfession;
import models.factory.people.Worker;

public class StoreKeeper extends Worker implements AbleToStore {

    public StoreKeeper(String name) {
        super(name, new Salt("соль", 2, 150));
        this.efficiency = 7;
        this.strength = 7;
        this.profession = WorkerProfession.STOREKEEPER;
    }

    @Override
    public String storeProduct(Salt salt) {
        return " собирает и раскладывает на складе " + salt.name();
    }

    @Override
    public <T extends HandlingProduct> void startWorking(T product) {
        if (checkHealth() == WorkerHealth.HEALTHY) {
            System.out.println(this.getProfession().getName() + " " +
                    this.name + storeProduct((Salt) product) + ".");

            this.efficiency -= product.energyConsumption();
            this.strength -= product.energyConsumption();
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
