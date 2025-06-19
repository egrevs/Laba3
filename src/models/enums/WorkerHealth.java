package models.enums;

public enum WorkerHealth {
    IS_TIRED("Устал"),
    HEALTHY("Полностью здоров"),
    ON_REHABILITATION("Находится на реабилитации");

    private final String condition;

    WorkerHealth(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "WorkerHealth{" +
                "condition='" + condition + '\'' +
                '}';
    }
}
