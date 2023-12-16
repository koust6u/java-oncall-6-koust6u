package oncall.service;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.invoke.CallSite;
import java.util.List;
import oncall.data.Calendar;
import oncall.data.Day;
import oncall.data.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkSchedulerTest {
    private Calendar calendar =  new Calendar(1,"월");
    private List<Member> weekday
            = List.of(new Member("손흥민"),new Member("김민재"),new Member("이강인"));

    private List<Member> holiday
            = List.of(new Member("손흥민"), new Member("김민재"), new Member("이강인"));
    


    @Test
    @DisplayName("이틀 연속 근무자 스케줄 조정 이후")
    void afterReArrangeTest() throws Exception{
        //given
        WorkScheduler workScheduler = new WorkScheduler(calendar);
        //when
        workScheduler.scheduling(weekday, holiday);
        Calendar schedulerCalendar = workScheduler.getCalendar();
        Day findDay = schedulerCalendar.getDays().get(11);
        Day findSecond = schedulerCalendar.getDays().get(25);
        Day thirdSecond = schedulerCalendar.getDays().get(26);
        //then
        Assertions.assertThat(findDay.getMemberName()).isEqualTo("이강인");
        Assertions.assertThat(findSecond.getMemberName()).isEqualTo("손흥민");
        Assertions.assertThat(thirdSecond.getMemberName()).isEqualTo("김민재");
     }
    
}