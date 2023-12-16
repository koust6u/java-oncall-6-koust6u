package oncall.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import oncall.data.Calendar;
import oncall.data.Day;
import oncall.data.Member;

public class WorkScheduler {

    private final Calendar calendar;
    private final List<Member> scheduleOfWeekDay = new ArrayList<>();
    private final List<Member> scheduleOfHoliday = new ArrayList<>();

    public WorkScheduler(Calendar calendar) {
        this.calendar = calendar;

    }

    public void rearrangeContinuousTwoDayWorkMember(){
        int numberOfDays = calendar.getDays().size();
        for (int i =0 ; i < numberOfDays -1; i++){
            String currentMemberName = calendar.getDays().get(i).getMemberName();
            String nextMemberName = calendar.getDays().get(i+1).getMemberName();
            if(currentMemberName.equals(nextMemberName)){
                rearrange(calendar.getDays().get(i+1));
            }
        }
    }

    private void rearrange(Day nextDay){
        Integer currentDayValue = nextDay.getDayValue();
        Member currentMember = nextDay.getMember();
        Day targetDay = calendar.getDays()
                .stream()
                .sequential()
                .filter(day -> day.getDayValue() > currentDayValue)
                .filter(day -> !day.getMemberName().equals(nextDay.getMemberName()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("예상 치 못한 요류 발생."));
        nextDay.setMember(targetDay.getMember());
        targetDay.setMember(currentMember);
    }
    public void scheduling(List<Member> weekdayList, List<Member> holidayList){
        findEarlySchedule(weekdayList, holidayList);
        rearrangeContinuousTwoDayWorkMember();
    }
    private void findEarlySchedule( List<Member> weekdayList, List<Member> holidayList){
        AtomicReference<Integer> holidayIndex = new AtomicReference<>(0);
        calendar.getDays()
                .stream()
                .filter(Day::isHoliday)
                .forEach(day -> addHolidaySchedule(day, holidayList, holidayIndex));

        AtomicReference<Integer> weekdayIndex = new AtomicReference<>(0);
        calendar.getDays()
                .stream()
                .filter(day -> !day.isHoliday())
                .forEach(day -> addWeekDaySchedule(day, weekdayList, weekdayIndex));
    }




    private void addHolidaySchedule(Day day, List<Member> holidayList, AtomicReference<Integer> holidayIndex) {
        day.setMember(holidayList.get(holidayIndex.getAndSet((holidayIndex.get()+1) % holidayList.size())));
    }

    private void addWeekDaySchedule(Day day, List<Member> weekdayList, AtomicReference<Integer> weekdayIndex) {
        day.setMember(weekdayList.get(weekdayIndex.getAndSet((weekdayIndex.get()+1) % weekdayList.size())));
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
