package griffintech.org.surfercheater.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

import griffintech.org.surfercheater.R;
import griffintech.org.surfercheater.Utils.Cache;
import griffintech.org.surfercheater.Utils.CurrentSurfInfo;

/**
 * Created by james on 11/6/2015.
 */
public class SplashFragment extends Fragment {

    private Cache mCache;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCache = Cache.instance();
        if (savedInstanceState == null) {
            // add user specific data (maybe previous location(?) or most recent spot visited (?))
        }
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
//
//        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_splash, container, false);
//        return rootView;
//    }

    @Override
    public void onResume() {
        super.onResume();

        //start the loading animation (get from google docs)
        //call the scrape class to scrape site and put into cache
    }
}
