package oncall.utils;

import java.util.List;
import oncall.data.Calendar;
import oncall.data.Member;

public class ConvertUtil {

    public static Calendar convertInputToCalender(String input){
        List<String> parsedInput = ParseUtil.parseByCommas(input);
        Integer month = Integer.valueOf(parsedInput.get(0));
        String startDay = parsedInput.get(1);

        return new Calendar(month, startDay);
    }

    public static List<Member> convertInputToMemberList(String input){
        return ParseUtil.parseByCommas(input)
                .stream()
                .map(Member::new)
                .toList();
    }

}
