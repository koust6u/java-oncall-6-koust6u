package oncall.view;

import static oncall.constant.ViewConstant.PRINT_DAILY_INFO_MESSAGE;
import static oncall.constant.ViewConstant.PRINT_HOLIDAY_INFO_MESSAGE;

import java.text.MessageFormat;
import oncall.data.Calendar;
import oncall.data.Day;

public class OutputView {

    public void renderAllSchedule(Calendar calendar){
        calendar.getDays()
                .stream()
                .forEach(day -> printEachSchedule(day,calendar.getMonth().getOrder()));
    }


    private void printEachSchedule(Day day, int month){
        if (day.isWeekDayAndHoliday()){
            String format = MessageFormat.format(PRINT_HOLIDAY_INFO_MESSAGE,
                    month,day.getDayValue(),day.getDayOfWeek().getNameOfDay() ,day.getMemberName());
            System.out.println(format);
            return;
        }
        String format = MessageFormat.format(PRINT_DAILY_INFO_MESSAGE,
                month, day.getDayValue(), day.getDayOfWeek().getNameOfDay() ,day.getMemberName());
        System.out.println(format);
    }
}
