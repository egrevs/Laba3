package models.factory.people;

import Exceptions.UnQualifiedWorker;
import Exceptions.UnableToWork;
import Interfaces.*;
import models.HandlingProduct;
import models.enums.WorkerHealth;
import models.enums.WorkerProfession;
import models.factory.WorkerFactory;

import java.util.Objects;
import java.util.Random;

public class Worker extends ShortyGuy implements AbleToRehabilitate{
    protected WorkerProfession profession;
    private WorkerHealth health;
    protected HandlingProduct handlingProduct;

    public Worker(String name, HandlingProduct product) {
        super(name);
        this.health = WorkerHealth.HEALTHY;
        this.handlingProduct = product;
        this.profession = WorkerProfession.UN_EMPLOYED;
        this.efficiency = 1;
        this.strength = 1;
    }

    @Override
    public void startWorking(HandlingProduct product) {
        if(this.profession == WorkerProfession.UN_EMPLOYED){
            throw new UnQualifiedWorker("");
        }
        if(checkHealth() == WorkerHealth.HEALTHY){
            System.out.println("Работник " + this.name + " приступает к работе");
        } else
            throw new UnableToWork("");
    }

    public WorkerProfession getProfession() {
        return profession;
    }

    public void setProfession(WorkerProfession profession) {
        this.profession = profession;
    }

    public WorkerHealth getHealth() {
        return checkHealth();
    }

    public void setHealth(WorkerHealth health) {
        this.health = health;
    }

    protected WorkerHealth checkHealth() {
        if (this.efficiency == 0 || this.strength == 0) {
            return this.health = WorkerHealth.IS_TIRED;
        } else if (this.efficiency >= 1 || this.strength >= 1) {
            return this.health = WorkerHealth.HEALTHY;
        }

        return this.health = WorkerHealth.ON_REHABILITATION;
    }


    @Override
    public int rehabilitate() {
        Random random = new Random();

        if (this.efficiency <= 0 || this.strength <= 0) {
            System.out.println(this.name + " проходит реабилитацию.");
            this.efficiency = random.nextInt(11) + 2;
            this.strength = random.nextInt(11) + 2;
        } else {
            System.out.println("Реабилитация работнику " + this.name + " не требуется");
        }
        return efficiency & strength;
    }

    public int getWage() {
        return this.profession.getMonthSalary();
    }

    public int bossPercent() {
        return this.profession.getWagesPerEmployee();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Worker worker = (Worker) o;
        return profession == worker.profession && health == worker.health && Objects.equals(handlingProduct, worker.handlingProduct);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(profession);
        result = 31 * result + Objects.hashCode(health);
        result = 31 * result + Objects.hashCode(handlingProduct);
        return result;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "profession=" + profession +
                ", health=" + health +
                ", efficiency=" + efficiency +
                ", strength=" + strength +
                ", name='" + name + '\'' +
                '}';
    }

}