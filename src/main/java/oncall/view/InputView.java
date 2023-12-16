package oncall.view;

import static oncall.constant.ViewConstant.INSERT_MONTH_INFO;

import camp.nextstep.edu.missionutils.Console;
import oncall.constant.ViewConstant;

public class InputView {

    public void insertMonthAndDay(){
        System.out.print(INSERT_MONTH_INFO);
        String monthAndDay = Console.readLine();

    }
}
