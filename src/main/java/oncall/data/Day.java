package oncall.data;

public class Day {

    private final Integer day;

    private Boolean isHoliday;

    private final DayOfWeek dayOfWeek;

    private Member member;


    public Member getMember() {

        return member;
    }

    public Day(Integer day, Boolean isHoliday, DayOfWeek dayOfWeek) {
        this.day = day;
        this.isHoliday = isHoliday;
        this.dayOfWeek = dayOfWeek;
    }


    public void setMember(Member member){
        this.member = member;
    }

    public void updateToHoliday(){
        this.isHoliday = true;
    }
    public Boolean isHoliday() {
        return isHoliday;
    }

    public Integer getDayValue() {
        return day;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }


    public String getMemberName() {
        return this.member.getName();
    }
    public boolean isWeekDayAndHoliday(){
        if (this.dayOfWeek.equals(DayOfWeek.SUN)|| this.dayOfWeek.equals(DayOfWeek.SAT)){
            return false;
        }
        return this.isHoliday;
    }
}
