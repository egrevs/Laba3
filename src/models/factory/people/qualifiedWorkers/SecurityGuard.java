package models.factory.people.qualifiedWorkers;

import Exceptions.UnableToWork;
import Interfaces.AbleToSecure;
import models.HandlingProduct;
import models.enums.WorkerHealth;
import models.enums.WorkerProfession;
import models.factory.people.Worker;

public class SecurityGuard extends Worker implements AbleToSecure {

    public SecurityGuard(String name) {
        super(name, new HandlingProduct("дубинка", 2) );
        this.efficiency = 10;
        this.strength = 12;
        this.profession = WorkerProfession.SECURITY_GUARD;
    }

    @Override
    public void startWorking(HandlingProduct product) {
        if (checkHealth() == WorkerHealth.HEALTHY) {
            System.out.println(this.getProfession().getName() + " " +
                    this.name + secureBuilding(product) + ".");

            this.efficiency -= this.handlingProduct.energyConsumption();
            this.strength -= this.handlingProduct.energyConsumption();
        } else
            throw new UnableToWork("");

        System.out.println();
    }

    @Override
    public String secureBuilding(HandlingProduct handlingProduct) {
        return " охраняет помещение с " + handlingProduct.name();
    }

    @Override
    public String toString() {
        return "SecurityGuard{" +
                "profession=" + profession +
                ", efficiency=" + efficiency +
                ", strength=" + strength +
                ", name='" + name + '\'' +
                '}';
    }
}
