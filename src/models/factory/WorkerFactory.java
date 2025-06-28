package models.factory;

import models.enums.WorkerProfession;
import models.factory.people.Worker;
import models.factory.people.qualifiedWorkers.BookKeeper;
import models.factory.people.qualifiedWorkers.Loader;
import models.factory.people.qualifiedWorkers.SecurityGuard;
import models.factory.people.qualifiedWorkers.StoreKeeper;

import java.util.Random;

public class WorkerFactory {
    private static final Random RANDOM = new Random();

    public Worker createWorkerByProfession(WorkerProfession profession) {
        Worker worker = null;

        String[] names = {"Василий", "Мария", "Иван", "Наталья", "Дмитрий", "Ольга", "Сергей", "Елена",
                "Максим", "Егор", "Николай", "Альберт", "Артур", "Людмила", "Андрей", "Инна",
                "Роман", "Светлана", "Георгий", "Ксения"};

        worker = switch (profession) {
            case STOREKEEPER ->
                    new StoreKeeper(names[RANDOM.nextInt(names.length)]);
            case SECURITY_GUARD ->
                    new SecurityGuard(names[RANDOM.nextInt(names.length)]);
            case LOADER ->
                    new Loader(names[RANDOM.nextInt(names.length)]);
            case BOOKKEEPER ->
                    new BookKeeper(names[RANDOM.nextInt(names.length)]);
            default -> worker;
        };

        return worker;
    }

    @Override
    public String toString() {
        return "WorkerFactory{}";
    }
}