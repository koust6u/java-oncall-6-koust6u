package oncall.validate;

import static oncall.constant.ErrorConstant.ERROR_PREFIX;

import oncall.constant.ErrorConstant;

public abstract class Validator {


    protected abstract <T> T validate(String input);

    protected abstract <T> T errorHandling();

    public <T> T template(String input){
        try{
            return validate(input);
        }catch (Exception e){
            System.out.println(ERROR_PREFIX + e.getMessage());
            return errorHandling();
        }
    }
}
