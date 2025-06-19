package models.buildings;

import Interfaces.RaiseQuantityOfWorkers;
import models.factory.people.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shed extends Building implements RaiseQuantityOfWorkers {
    private List<Worker> workerList;

    public Shed(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void addWorker(Worker worker) {
        System.out.println("На вакасию о работе " + worker.getProfession().getName() + " с зараплатой в "
                + worker.getProfession().getMonthSalary() + ".руб в " + this.name + " откликнулся "
                + worker.getName() + ".");
        if (countFreeSpace() > 0) {
            if (this.workerList == null) {
                this.workerList = new ArrayList<>(capacity);
            }
            this.workerList.add(worker);
        }
    }

    @Override
    public int countFreeSpace() {
        System.out.println("Проводится рассчет свободного пространства для " + this.name + ".");
        return this.capacity - (this.workerList == null ? 0 : this.workerList.size());
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Shed shed = (Shed) o;
        return Objects.equals(workerList, shed.workerList);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(workerList);
        return result;
    }

    @Override
    public String toString() {
        return "Shed{" +
                "workerList=" + workerList +
                ", capacity=" + capacity +
                ", name='" + name + '\'' +
                '}';
    }
}
