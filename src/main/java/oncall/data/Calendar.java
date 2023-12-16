package oncall.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calendar {


    private final Month month;
    private final DayOfWeek startingDay;

    private final List<Day> days = new ArrayList<>();

    public Calendar(int month, String startingDay) {
         this.month = Arrays.stream(Month.values())
                .filter(order -> order.getOrder().equals(month))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("예상치 못한 오류 입니다."));
        this.startingDay = Arrays.stream(DayOfWeek.values())
                .filter(day -> day.getNameOfDay().equals(startingDay))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("예상치 못한 오류입니다."));
    }

    public void initializeCalendar(){

    }






}
