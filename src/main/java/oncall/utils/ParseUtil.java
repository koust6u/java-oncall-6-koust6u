package oncall.utils;

import static oncall.constant.ViewConstant.DELIMITER;

import java.util.Arrays;
import java.util.List;
import oncall.constant.ViewConstant;

public class ParseUtil {

    public static List<String> parseByCommas(String originData){
        originData = originData.replaceAll(" ", "");
        return Arrays.stream(originData.split(","))
                .filter(eachData -> !eachData.isBlank())
                .toList();
    }

    public static List<String> parseByDelimiter(String originData){
        originData = originData.replaceAll(" ", "");
        return Arrays.stream(originData.split(DELIMITER))
                .toList();
    }
}
