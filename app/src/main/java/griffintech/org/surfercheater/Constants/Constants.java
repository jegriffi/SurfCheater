package griffintech.org.surfercheater.Constants;

/**
 * Created by James on 8/27/2015.
 */
public class Constants {
    public static class ForcastLocationCode {

        // LOS ANGELES
        public static final String SOUTH_OC = "2950";
        public static final String NORTH_OC = "2143";
        public static final String SOUTH_LA = "2951";
        public static final String NORTH_LA = "2142";

        // VENTURA
        public static final String VENTURA = "2952";
    }

    public static class LiveLocationCode {
        // JAMES' FAVS
        public static final String HB_NORTHSIDE = "4223";
        public static final String HB_SOUTHSIDE = "4874";
        public static final String SEAL_BEACH = "4217";
        public static final String SEVENTEENTH_ST = "4871";
        public static final String BOLSA_CHICA_OVERVIEW = "103685";
        public static final String BOLSA_CHICA_STATE_PARK = "4868";
    }

    // URL code for json files
    public static class URLCode {
        public static final String PRE = "http://api.surfline.com/v1/forecasts/";
        public static final String POST = "?&callback=jQuery18008240336677990854_1440679349263&resources=resources%2Canalysis%2Csort&days=17";
    }
}
