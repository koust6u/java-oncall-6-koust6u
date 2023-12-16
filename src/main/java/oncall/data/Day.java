package oncall.data;

public class Day {

    private final Integer day;

    private Boolean isHoliday;

    private final DayOfWeek dayOfWeek;

    public Day(Integer day, Boolean isHoliday, DayOfWeek dayOfWeek) {
        this.day = day;
        this.isHoliday = isHoliday;
        this.dayOfWeek = dayOfWeek;
    }

    public void updateToHoliday(){
        this.isHoliday = true;
    }
    public Boolean getHoliday() {
        return isHoliday;
    }

    public Integer getDay() {
        return day;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
