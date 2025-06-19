package models.factory.people.qualifiedWorkers;

import Exceptions.UnableToWork;
import Interfaces.AbleToCount;
import models.HandlingProduct;
import models.enums.WorkerHealth;
import models.enums.WorkerProfession;
import models.factory.people.Worker;

public class BookKeeper extends Worker implements AbleToCount {

    public BookKeeper(String name) {
        super(name, new HandlingProduct("книжка", 2) );
        this.efficiency = 11;
        this.strength = 6;
        this.profession = WorkerProfession.BOOKKEEPER;
    }

    @Override
    public String countQuantity(HandlingProduct handlingProduct) {
        return " проводит подсчет привезенного товара" + " в " + handlingProduct.name() + ".";
    }

    @Override
    public void startWorking(HandlingProduct product) {
        if (checkHealth() == WorkerHealth.HEALTHY) {
            System.out.println(this.getProfession().getName() + " " +
                    this.name + countQuantity(product));

            this.efficiency -= this.handlingProduct.energyConsumption();
            this.strength -= this.handlingProduct.energyConsumption();
        } else
            throw new UnableToWork("");

        System.out.println();
    }

    @Override
    public String toString() {
        return "BookKeeper{" +
                "profession=" + profession +
                ", efficiency=" + efficiency +
                ", strength=" + strength +
                ", name='" + name + '\'' +
                '}';
    }
}
