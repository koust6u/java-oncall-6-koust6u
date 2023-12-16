package oncall.view;

import static oncall.constant.ViewConstant.BLANK;
import static oncall.constant.ViewConstant.DELIMITER;
import static oncall.constant.ViewConstant.INSERT_HOLIDAY_MEMBER_MESSAGE;
import static oncall.constant.ViewConstant.INSERT_MONTH_INFO;
import static oncall.constant.ViewConstant.INSERT_WEEKDAY_MEMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import oncall.constant.ViewConstant;
import oncall.validate.MemberListValidator;
import oncall.validate.MonthAndDayValidator;
import oncall.validate.Validator;

public class InputView {

    private final Validator monthAndDayValidator = new MonthAndDayValidator();

    private final Validator memberListValidator = new MemberListValidator();

    public String insertMonthAndDay(){
        System.out.print(INSERT_MONTH_INFO);
        String monthAndDay = Console.readLine();
        return monthAndDayValidator.template(monthAndDay);
    }

    public String insertMemberList(){
        return memberListValidator.template(BLANK);
    }


}
