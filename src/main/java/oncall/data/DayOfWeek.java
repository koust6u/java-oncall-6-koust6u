package oncall.data;

import java.util.Arrays;

public enum DayOfWeek {
    MON("월",0),
    TUE("화",1),
    WED("수",2),
    THU("목",3),
    FRI("금",4),
    SAT("토",5),
    SUN("일",6);


    private final Integer order;

    public static DayOfWeek findByOrder(Integer order){
        return Arrays.stream(DayOfWeek.values())
                .filter(day -> day.order.equals(order))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("예상치 못한 오류입니다."));
    }

    public Integer getOrder() {
        return order;
    }

    DayOfWeek(Integer order, String nameOfDay) {
        this.order = order;
        this.nameOfDay = nameOfDay;
    }

    private final String nameOfDay;

    DayOfWeek(String nameOfDaya, Integer order) {
        this.nameOfDay = nameOfDaya;
        this.order = order;
    }

    public String getNameOfDay() {
        return nameOfDay;
    }
}
