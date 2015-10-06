package griffintech.org.surfercheater.Utils;

/**
 * Created by James on 10/5/2015.
 */
public interface SurfInfo {
    public void setHeightMax(String s);
    public void setHeightMin(String s);
    public void setLocation(String s);
    public void setHighTide(String s);
    public void setLowTide(String s);

    public String getLocation();
    public String getHeightMax();
    public String getHeightMin();
    public String getLowTide();
    public String getHighTide();
}
