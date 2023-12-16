package oncall.data;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalendarTest {


    @Test
    @DisplayName("초기화 시 필드 값 테스트")
    void initValueTest() throws Exception{
        //when
        Calendar calendar = new Calendar(3, "목");
        //then
        Assertions.assertThat(calendar.getMonth()).isEqualTo(Month.MAR);
        Assertions.assertThat(calendar.getDays().get(0).getDayOfWeek()).isEqualTo(DayOfWeek.THU);
     }
    @Test
    @DisplayName("입력에 따라 초기화 되는 값 테스트")
    void initializeTest() throws Exception{
        //given
        Calendar calendar =new Calendar(1, "월");
        //when
        Day first = calendar.getDays().get(0);
        Day second = calendar.getDays().get(11);
        Day third = calendar.getDays().get(21);
        //then
        Assertions.assertThat(first.getDayValue()).isEqualTo(1);
        Assertions.assertThat(second.getDayValue()).isEqualTo(12);
        Assertions.assertThat(third.getDayValue()).isEqualTo(22);
        Assertions.assertThat(first.getDayOfWeek()).isEqualTo(DayOfWeek.MON);
        Assertions.assertThat(second.getDayOfWeek()).isEqualTo(DayOfWeek.FRI);
        Assertions.assertThat(third.getDayOfWeek()).isEqualTo(DayOfWeek.MON);

    }

}