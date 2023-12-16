package oncall.data;

import java.util.List;

public enum Month {
    JAN(1,31, List.of(1)),
    FEB(2,28, null),
    MAR(3,31, List.of(1)),
    APR(4,30, null),
    MAY(5,31, List.of(5)),
    JUN(6,30, List.of(6)),
    JUL(7,31, null),
    AUG(8,31, List.of(15)),
    SEP(9, 30, null),
    OCT(10,31, List.of(3,9)),
    NOV(11,30, null),
    DEC(12,31, List.of(25));


    public Integer getOrder() {
        return order;
    }

    public List<Integer> getWeekDayHoliday() {
        return weekDayHoliday;
    }

    private final List<Integer> weekDayHoliday;

    public Integer getDays() {
        return days;
    }

    private final Integer days;
    Month(Integer order, Integer days, List<Integer> weekDayHoliday) {
        this.order = order;
        this.days = days;
        this.weekDayHoliday = weekDayHoliday;
    }

    private Integer order;
}
