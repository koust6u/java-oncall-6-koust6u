package oncall.utils;

import java.util.Arrays;
import java.util.List;

public class ParseUtil {

    public static List<String> parseByCommas(String originData){
        originData = originData.replaceAll(" ", "");
        return Arrays.stream(originData.split(","))
                .filter(eachData -> !eachData.isBlank())
                .toList();

    }
}
