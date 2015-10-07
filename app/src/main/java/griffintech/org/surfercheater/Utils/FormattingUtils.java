package griffintech.org.surfercheater.Utils;

/**
 * Created by James on 10/7/2015.
 */
public class FormattingUtils {
    public static String surfHeight(String min, String max) {
        return (min + "-" + max + "ft.");
    }

    public static String windInfo(String speed, String direction) {
        return (direction + " at " + speed + "mph");
    }
}
