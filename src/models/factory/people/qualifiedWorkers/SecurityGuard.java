package models.factory.people.qualifiedWorkers;

import Exceptions.UnableToWork;
import Interfaces.AbleToSecure;
import models.Products.HandlingProduct;
import models.Products.Weapon;
import models.enums.WorkerHealth;
import models.enums.WorkerProfession;
import models.factory.people.Worker;

public class SecurityGuard extends Worker implements AbleToSecure {

    public SecurityGuard(String name) {
        super(name, new Weapon("дубинка", 2) );
        this.efficiency = 10;
        this.strength = 12;
        this.profession = WorkerProfession.SECURITY_GUARD;
    }

    @Override
    public <T extends HandlingProduct> void startWorking(T product) {
        if (checkHealth() == WorkerHealth.HEALTHY) {
            System.out.println(this.getProfession().getName() + " " +
                    this.name + secureBuilding((Weapon) product));

            this.efficiency -= product.energyConsumption();
            this.strength -= product.energyConsumption();
        } else
            throw new UnableToWork("");

        System.out.println();
    }

    @Override
    public String secureBuilding(Weapon weapon) {
        return " охраняет помещение с " + weapon.name();
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
