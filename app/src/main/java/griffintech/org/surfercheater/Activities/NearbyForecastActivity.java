package griffintech.org.surfercheater.Activities;

import android.app.Activity;
import android.os.Bundle;

import com.airbnb.android.airmapview.AirMapMarker;
import com.airbnb.android.airmapview.AirMapView;
import com.airbnb.android.airmapview.listeners.OnMapInitializedListener;
import com.google.android.gms.maps.model.LatLng;

import butterknife.Bind;
import griffintech.org.surfercheater.R;
import griffintech.org.surfercheater.Utils.Cache;

/**
 * Created by James on 10/7/2015.
 */
public class NearbyForecastActivity extends Activity implements OnMapInitializedListener{
    @Bind(R.id.map_view) AirMapView map;

    private Cache mCache;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nearby_forecast);
        mCache = Cache.instance();

    }

    @Override
    public void onMapInitialized() {
        //get list of lat & long around location...
        /*
        ex.)
        final LatLng mainLatLng = new LatLng(37.771883, -122.405224);
        addMarker("Airbnb HQ", mainLatLng, 1);
        addMarker("surf spot", new LatLng(36.771883, -123.405224), 2);
        map.animateCenterZoom(airbnbLatLng, 10);
        map.setMyLocationEnabled(true);
         */
    }

    private void addMarker(String title, LatLng latLng, int id) {
        map.addMarker(new AirMapMarker.Builder()
                .id(id)
                .position(latLng)
                .title(title)
                //.iconId(R.mipmap.icon_location_pin)
                .build());
    }
}
