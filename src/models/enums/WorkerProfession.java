package models.enums;

public enum WorkerProfession {
    SECURITY_GUARD(40000, 8000, "Охранник"),
    BOOKKEEPER(50000, 10000, "Учетчик"),
    LOADER(35000, 7000, "Грузчик"),
    STOREKEEPER(37000, 7400, "Кладовщик"),
    UN_EMPLOYED(0, 0, "Временно безработный");

    private final int monthSalary;
    private final int wagesPerEmployee;
    private final String name;


    WorkerProfession(int monthSalary, int wagesPerEmployee, String name) {
        this.monthSalary = monthSalary;
        this.wagesPerEmployee = wagesPerEmployee;
        this.name = name;
    }

    public int getMonthSalary() {
        return monthSalary;
    }

    public int getWagesPerEmployee() {
        return wagesPerEmployee;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "WorkerProfession{" +
                "monthSalary=" + monthSalary +
                ", wagesPerEmployee=" + wagesPerEmployee +
                ", name='" + name + '\'' +
                '}';
    }
}
