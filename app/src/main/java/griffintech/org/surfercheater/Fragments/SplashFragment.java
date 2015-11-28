package griffintech.org.surfercheater.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
//        if (savedInstanceState == null) {
//            // add user specific data (maybe previous location(?) or most recent spot visited (?))
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.layout_splash, container, false);
        ImageView waveView = (ImageView) rootView.findViewById(R.id.surfAnimation);
        waveView.setBackgroundResource(R.drawable.animation);
        AnimationDrawable waveAnimation = (AnimationDrawable) waveView.getBackground();
        waveAnimation.start();

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    DashboardFragment dashFrag = new DashboardFragment();
                    FragmentTransaction trans = getFragmentManager().beginTransaction();
                    trans.replace(R.id.splashFrag, dashFrag);
                    trans.commit();
                }
            }
        };
        timer.start();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        //start the loading animation (get from google docs)
        //call the scrape class to scrape site and put into cache
    }
}
