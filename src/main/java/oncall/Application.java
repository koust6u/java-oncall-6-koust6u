package oncall;

import oncall.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.insertMonthAndDay();
        inputView.insertMemberList();
    }
}
