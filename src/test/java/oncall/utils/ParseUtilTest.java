package oncall.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParseUtilTest {


    @Test
    @DisplayName(", 를 기준으로 String split 후 List로 반환 테스트")
    void parseByCommasTest() throws Exception{
        //given
        String ex = "hello,hello,asada      ,    asdasdas , sadas, sadd , asda";
        //when
        List<String> parsed = ParseUtil.parseByCommas(ex);
        //then
        Assertions.assertThat(parsed.get(0)).isEqualTo("hello");
        Assertions.assertThat(parsed.get(1)).isEqualTo("hello");
        Assertions.assertThat(parsed.get(2)).isEqualTo("asada");
        Assertions.assertThat(parsed.get(4)).isEqualTo("sadas");
     }
}