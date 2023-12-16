package oncall.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

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
        initializeCalendar();


    }

    public void initializeCalendar() {
        AtomicReference<Integer> dayOfWeekIndex = new AtomicReference<>(this.startingDay.getOrder());
        Integer countOfDayInThisMonth = this.month.getDays();

        IntStream.range(1, countOfDayInThisMonth)
                .sequential()
                .forEach(count -> addDayInfo(dayOfWeekIndex, count));

        initializeHoliday();
    }

    private boolean addDayInfo(AtomicReference<Integer> dayOfWeekIndex, int count) {
        return days.add(new Day(count, false, DayOfWeek.findByOrder(
                dayOfWeekIndex.getAndSet(dayOfWeekIndex.get() + 1))));
    }

    private void initializeHoliday() {
        this.days
                .stream()
                .filter(this::checkHoliday)
                .forEach(Day::updateToHoliday);
        initializeWeekdayHoliday();
    }

    private void initializeWeekdayHoliday() {
        if (this.month.getWeekDayHoliday() != null) {
            month.getWeekDayHoliday()
                    .forEach(e -> this.days.get(e - 1).updateToHoliday());
        }
    }

    private boolean checkHoliday(Day day) {
        return day.getDayOfWeek().equals(DayOfWeek.SUN) || day.getDayOfWeek().equals(DayOfWeek.SAT);
    }


}
