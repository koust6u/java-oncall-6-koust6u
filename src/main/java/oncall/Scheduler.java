package oncall;

import java.util.List;
import oncall.data.Calendar;
import oncall.data.Member;
import oncall.service.WorkScheduler;
import oncall.utils.ConvertUtil;
import oncall.utils.ParseUtil;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Scheduler {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private WorkScheduler workScheduler;

    public void schedule(){
        String monthAndDay = inputView.insertMonthAndDay();
        String memberList = inputView.insertMemberList();
        Calendar calendar = ConvertUtil.convertInputToCalender(monthAndDay);
        String weekdayMemberList = ParseUtil.parseByDelimiter(memberList).get(0);
        String holidayMemberList = ParseUtil.parseByDelimiter(memberList).get(1);
        workScheduler = new WorkScheduler(calendar);
        List<Member> convertedWeekdayMembers = ConvertUtil.convertInputToMemberList(weekdayMemberList);
        List<Member> convertedHolidayMembers = ConvertUtil.convertInputToMemberList(holidayMemberList);
        workScheduler.scheduling(convertedWeekdayMembers, convertedHolidayMembers);
        Calendar schedulerCalendar = workScheduler.getCalendar();
        outputView.renderAllSchedule(schedulerCalendar);
    }

}
