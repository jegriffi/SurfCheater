package griffintech.org.surfercheater.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 8/27/2015.
 */
@SuppressWarnings("unused")
public class SurfSpotForecast {
    private List<String> surfMin;
    private List<String> surfMax;
    private List<String> surfText;
    private List<String> generalCondition; // eg. poor, fair, poor to fair...
    private String region;

    public SurfSpotForecast() {
        surfMin = new ArrayList<>();
        surfMax = new ArrayList<>();
        surfText = new ArrayList<>();
        generalCondition = new ArrayList<>();
        region = "null";
    }

    public SurfSpotForecast(List<String> generalCondition, List<String> surfMax, List<String> surfMin, List<String> surfText, String region) {
        this.generalCondition = generalCondition;
        this.surfMax = surfMax;
        this.surfMin = surfMin;
        this.surfText = surfText;
        this.region = region;
    }

    public List<String> getGeneralCondition() {
        return generalCondition;
    }

    public void setGeneralCondition(List<String> generalCondition) {
        this.generalCondition = generalCondition;
    }

    public List<String> getSurfMax() {
        return surfMax;
    }

    public void setSurfMax(List<String> surfMax) {
        this.surfMax = surfMax;
    }

    public List<String> getSurfMin() {
        return surfMin;
    }

    public void setSurfMin(List<String> surfMin) {
        this.surfMin = surfMin;
    }

    public List<String> getSurfText() {
        return surfText;
    }

    public void setSurfText(List<String> surfText) {
        this.surfText = surfText;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
