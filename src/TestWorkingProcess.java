import models.Products.Book;
import models.Products.HandlingProduct;
import models.Products.Salt;
import models.Products.Weapon;
import models.buildings.Building;
import models.buildings.Shed;
import models.factory.WorkerFactory;
import models.factory.people.Ponchik;
import models.factory.people.Worker;
import models.factory.people.qualifiedWorkers.BookKeeper;
import models.factory.people.qualifiedWorkers.Loader;
import models.factory.people.qualifiedWorkers.SecurityGuard;
import models.factory.people.qualifiedWorkers.StoreKeeper;

public class TestWorkingProcess {
    public static void main(String[] args) {
        Building building = new Shed("Сарай", 18);
        Ponchik ponchik = new Ponchik("Пончик", building);
        WorkerFactory factory = new WorkerFactory();

        HandlingProduct salt = new Salt("соль", 3, 150);
        HandlingProduct weapon = new Weapon("пистолет", 2);
        HandlingProduct book = new Book("бухгалтерская книжка", 1);

        ponchik.carryProduct((Salt) salt);

        ponchik.generateWorkers(factory, 14);

        Worker securityGuard = new SecurityGuard("Дима");
        ponchik.addWorker(securityGuard);

        Worker loader = new Loader("Стас");
        ponchik.addWorker(loader);

        Worker storeKeeper = new StoreKeeper("Святослав");
        ponchik.addWorker(storeKeeper);

        Worker bookKeeper = new BookKeeper("Василий");
        ponchik.addWorker(bookKeeper);

        // вылетает первый exception BuildingOverCrowing
        Worker bookKeeper1 = new BookKeeper("Альберт");
//        ponchik.addWorker(bookKeeper1);

        // создаем новое помещение с вместительностью в 20 человек
        ponchik.constructNewBuilding("Ресторан", 20);

        ponchik.addWorker(bookKeeper1);

        ponchik.openWorkingDay();
        System.out.println();
        System.out.println();

        for(Worker w: ponchik.getWorkerList()){
            switch (w.getProfession()){
                case BOOKKEEPER -> w.startWorking(book);
                case LOADER, STOREKEEPER -> w.startWorking(salt);
                case SECURITY_GUARD -> w.startWorking(weapon);
            }
        }

        // при вызове метода: bookKeeper1.startWorking(book) вылетает UnableToWork => проходим реабилитацию
        bookKeeper1.startWorking(book);
        bookKeeper1.startWorking(book);

        bookKeeper1.rehabilitate();
        bookKeeper1.startWorking(book);
        // все хорошо прошло

        bookKeeper1.rehabilitate();
        System.out.println();

        //посчет всех денег (заработок)
        ponchik.countAllMoney();
        ponchik.countMoneyForBoss();

    }
}
