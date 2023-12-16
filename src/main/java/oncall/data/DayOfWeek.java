package oncall.data;

public enum DayOfWeek {
    MON("월"),
    TUE("화"),
    WED("수"),
    THU("목"),
    FRI("금"),
    SAT("토"),
    SUN("일");


    private final String nameOfDaya;

    DayOfWeek(String nameOfDaya) {
        this.nameOfDaya = nameOfDaya;
    }

    public String getNameOfDaya() {
        return nameOfDaya;
    }
}
