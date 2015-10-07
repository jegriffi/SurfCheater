package griffintech.org.surfercheater.Utils;

/**
 * Created by James on 10/5/2015.
 */
public class ForecastSurfInfo implements SurfInfo {
    private String heightMin;
    private String heightMax;
    private String location;
    private String highTide;
    private String lowTide;
    private String date;

    @Override
    public void setHeightMax(String heightMax) {
        this.heightMax = heightMax;
    }

    @Override
    public void setHeightMin(String heightMin) {
        this.heightMin = heightMin;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void setHighTide(String highTide) {
        this.highTide = highTide;
    }

    @Override
    public void setLowTide(String lowTide) {
        this.lowTide = lowTide;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return null;
    }

    @Override
    public String getLocation() {
        return this.location;
    }

    @Override
    public String getHeightMax() {
        return this.heightMax;
    }

    @Override
    public String getHeightMin() {
        return this.heightMin;
    }

    @Override
    public String getLowTide() {
        return this.lowTide;
    }

    @Override
    public String getHighTide() {
        return this.highTide;
    }
}
