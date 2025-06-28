package models.factory.people.qualifiedWorkers;

import Exceptions.UnableToWork;
import Interfaces.AbleToCount;
import models.Products.Book;
import models.Products.HandlingProduct;
import models.Products.Salt;
import models.enums.WorkerHealth;
import models.enums.WorkerProfession;
import models.factory.people.Worker;

public class BookKeeper extends Worker implements AbleToCount {

    public BookKeeper(String name) {
        super(name, new Book("книжка", 2) );
        this.efficiency = 11;
        this.strength = 6;
        this.profession = WorkerProfession.BOOKKEEPER;
    }

    @Override
    public String countQuantity(Book book) {
        return " проводит подсчет привезенного товара" + " в " + book.name() + ".";
    }

    @Override
    public <T extends HandlingProduct> void startWorking(T product) {
        if (checkHealth() == WorkerHealth.HEALTHY) {
            System.out.println(this.getProfession().getName() + " " +
                    this.name + countQuantity((Book) product));

            this.efficiency -= product.energyConsumption();
            this.strength -= product.energyConsumption();
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
