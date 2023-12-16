package oncall.validate;

import static oncall.constant.ViewConstant.INSERT_MONTH_INFO;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import oncall.data.DayOfWeek;
import oncall.utils.ParseUtil;

public class MonthAndDayValidator extends Validator{
    @Override
    protected String validate(String input) {
        validateSize(input);
        List<String> parsedInput = ParseUtil.parseByCommas(input);
        String month = parsedInput.get(0);
        String dayOfWeek = parsedInput.get(1);
        convertMonthToInteger(month);
        isOneBetweenTwenty(month);
        isValidDayFormat(dayOfWeek);
        return input;
    }

    @Override
    protected <T> T errorHandling() {
        System.out.print(INSERT_MONTH_INFO);
        String retry = Console.readLine();
        return super.template(retry);
    }


    private void validateSize(String input){
        if (ParseUtil.parseByCommas(input).size() != 2){
            throw new IllegalStateException("잘못된 입력입니다. 다시 입력해주세요");
        }
    }

    private void convertMonthToInteger(String  month){
        try{
            Integer.valueOf(month);
        }catch (Exception e){
            throw new IllegalStateException("월은 숫자만 입력해주세요.");
        }
    }


    private void isOneBetweenTwenty(String monthInput){
        int month = Integer.parseInt(monthInput);
        if (month < 1 || month > 12){
            throw new IllegalStateException("1월부터 12일 사이까지만 입력이 가능합니다.");
        }
    }
    private void isValidDayFormat(String dayOfWeek){
        Arrays.stream(DayOfWeek.values())
                .map(DayOfWeek::getNameOfDay)
                .filter(day-> day.equals(dayOfWeek))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 요일 입력입니다. 다시 입력해주세요."));
    }
}
