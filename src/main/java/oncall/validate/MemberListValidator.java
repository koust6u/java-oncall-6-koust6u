package oncall.validate;

import static oncall.constant.ViewConstant.BLANK;
import static oncall.constant.ViewConstant.DELIMITER;
import static oncall.constant.ViewConstant.INSERT_HOLIDAY_MEMBER_MESSAGE;
import static oncall.constant.ViewConstant.INSERT_WEEKDAY_MEMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.awt.im.InputContext;
import java.util.List;
import oncall.constant.ViewConstant;
import oncall.utils.ParseUtil;
import oncall.view.InputView;


public class MemberListValidator extends Validator{


    private void isValidaMemberSize(List<String> parsedMembers){
        int sizeOfMembers = parsedMembers.size();
        if(sizeOfMembers < 5 || sizeOfMembers > 35){
            throw new IllegalStateException("근무자는 최소 5명에서 최대 35명까지 허용합니다.");
        }
    }


    private void checkMaxLengthAboutName(List<String> parsedMembers){
        long invalidNamesCount = parsedMembers.stream()
                .filter(member -> member.length() > 5)
                .count();

        if (invalidNamesCount > 0L){
            throw new IllegalStateException("근무자의 닉네임은 최대 5글자까지만 허용합니다.");
        }
    }
    private void duplicateNameCheck(List<String> parsedMember){
        long originCount = parsedMember
                .stream()
                .count();
        long distinctCount =  parsedMember
                .stream()
                .distinct()
                .count();
        if (originCount != distinctCount){
            throw new IllegalStateException("유효하지 않는 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private String validateEachWorkType(String nameList){
        List<String> parsedNameList = ParseUtil.parseByCommas(nameList);
        isValidaMemberSize(parsedNameList);
        checkMaxLengthAboutName(parsedNameList);
        duplicateNameCheck(parsedNameList);
        return nameList;
    }


    @Override
    protected String validate(String input) {
        System.out.print(INSERT_WEEKDAY_MEMBER_MESSAGE);
        String weekdayMemberList = Console.readLine();
        String weekDayMembers = validateEachWorkType(weekdayMemberList);
        validateEachWorkType(weekDayMembers);
        System.out.print(INSERT_HOLIDAY_MEMBER_MESSAGE);
        String holidayMemberList = Console.readLine();
        String holidayMembers = validateEachWorkType(holidayMemberList);
        validateEachWorkType(holidayMemberList);
        return String.join(DELIMITER, weekDayMembers, holidayMembers);
    }

    @Override
    protected <T> T errorHandling() {
        return this.template(BLANK);
    }


}
