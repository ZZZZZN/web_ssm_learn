package util;

/**
 * Created by Administrator on 2017/12/25.
 */
public class Common {
    public static String isblank(Object para) {
        return para == null ? "" : para.toString().trim();
    }
}
