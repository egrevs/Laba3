package models.factory.people;

import Exceptions.BuildingOverCrowding;
import Exceptions.NoAvailableBuilding;
import Exceptions.UnqualifiedWorker;
import Interfaces.*;
import models.Products.Salt;
import models.buildings.Building;
import models.buildings.Shed;
import models.enums.WorkerProfession;
import models.factory.WorkerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Ponchik implements AbleToCarry, BusinessExtension, MoneyCountable, OpenWorkingSession {
    private String name;
    private Building building;
    private List<Worker> workerList;
    private int balance;
    private int income;
    private static final Random RANDOM = new Random();


    public Ponchik(String name, Building building) {
        this.name = name;
        this.building = building;
        this.balance = 0;
        this.income = 0;
    }

    @Override
    public String carryProduct(Salt salt) {
        return this.name + " толочет и тоскет " + salt.name();
    }

    @Override
    public void constructNewBuilding(String name, int capacity) {
        this.building = new Shed(name, capacity);
        System.out.println(this.name + " строит новое помещение " + this.building.getName() + " с вместительностью в "
                + this.building.getCapacity() + " человек");
    }

    @Override
    public int countAllMoney() {
        for (Worker w : this.workerList) {
            this.balance += w.getWage();
        }
        System.out.println("За этот месяц заведение " + this.name + " заработало " + this.balance + ".руб");
        return balance;
    }

    @Override
    public int countMoneyForBoss() {
        for (Worker w : this.workerList) {
            this.income += w.bossPercent();
        }
        System.out.println("За этот месяц " + this.name + " заработал " + this.income + ".руб");
        return income;
    }

    public void generateWorkers(WorkerFactory factory, int count) {
        System.out.println("Для расширения бизнеса и увеличения прибыли " + this.name
                + " находит работников и подбирает им профессии. Его текущий баланс = "
                + this.balance + ".руб!");

        this.workerList = new ArrayList<>();

        WorkerProfession[] professions = WorkerProfession.values();

        if (count <= building.getCapacity()) {
            for (int i = 0; i < count; i++) {
                this.workerList.add(factory.createWorkerByProfession(professions[RANDOM.nextInt(4)]));
            }
        } else
            throw new BuildingOverCrowding("");

        System.out.println(this.name + " добавляет в свой штат " + count + " сотрудников по " +
                "таким спеацильностям, как " + WorkerProfession.SECURITY_GUARD.getName() + ", "
                + WorkerProfession.STOREKEEPER.getName() + ", "
                + WorkerProfession.LOADER.getName() + ", "
                + WorkerProfession.BOOKKEEPER.getName() + ".");

    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void addWorker(Worker worker) {
        if (worker.getProfession() == WorkerProfession.UN_EMPLOYED) {
            throw new UnqualifiedWorker("");
        }

        if (this.workerList.size() < this.building.getCapacity()) {
            this.building.addWorker(worker);
            this.workerList.add(worker);
        } else
            throw new BuildingOverCrowding("Недосаточно места в здании, расширьте помещение");

        System.out.println(this.name + " нанимает нового работника: " + worker.getName()
                + ", на должность " + worker.getProfession().getName() + ".");
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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

        Ponchik ponchik = (Ponchik) o;
        return balance == ponchik.balance
                && income == ponchik.income
                && Objects.equals(name, ponchik.name)
                && Objects.equals(building, ponchik.building)
                && Objects.equals(workerList, ponchik.workerList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(building);
        result = 31 * result + Objects.hashCode(workerList);
        result = 31 * result + balance;
        result = 31 * result + income;
        return result;
    }

    @Override
    public String toString() {
        return "Ponchik{" +
                "name='" + name + '\'' +
                ", building=" + building +
                ", workerList=" + workerList +
                ", balance=" + balance +
                ", income=" + income +
                '}';
    }

    private boolean buildingIsCreated() {
        return this.building != null;
    }

    @Override
    public void openWorkingDay() {
        if (buildingIsCreated()) {
            System.out.println(this.name + " объявляет о начале рабочего дня. Все должны приступить к работе.");
        } else
            throw new NoAvailableBuilding("");
    }

}
