package griffintech.org.surfercheater.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import griffintech.org.surfercheater.R;
import griffintech.org.surfercheater.Utils.Cache;
import griffintech.org.surfercheater.Utils.CurrentSurfInfo;
import griffintech.org.surfercheater.Utils.ForecastSurfInfo;
import griffintech.org.surfercheater.Utils.FormattingUtils;

/**
 * Created by James on 9/17/2015.
 */
public class DashboardFragment extends Fragment {

    @Bind(R.id.tv_favorite_spot_location) TextView mTvFavLocation;
    @Bind(R.id.tv_favorite_spot_surf_height) TextView mTvFavSurfHeight;
    @Bind(R.id.tv_favorite_spot_high_tide) TextView mTvFavHighTide;
    @Bind(R.id.tv_favorite_spot_low_tide) TextView mTvFavLowTide;
    @Bind(R.id.tv_favorite_spot_wind_info) TextView mTvFavWindInfo;
    @Bind(R.id.hsv_container) RelativeLayout hsvContainer;

    private Cache mCache;
    private CurrentSurfInfo mCurrentSurfInfo;
    private ForecastSurfInfo mForecastSurfInfo;
    private List<ForecastSurfInfo> mForecastSurfInfos;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCache = Cache.instance();
//        mCurrentSurfInfo = mCache.getCurrent();
//        mForecastSurfInfo = mCache.getForecast();
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        initializeWidgets();
    }

    private void initializeWidgets() {
        /*fav spot */
        mTvFavLocation.setText(mCurrentSurfInfo.getLocation());
        //mTvFavSurfHeight.setText(FormattingUtils.surfHeight(mCurrentSurfInfo.getHeightMin()
        // , mCurrentSurfInfo.getHeightMax()));
        mTvFavHighTide.setText(mCurrentSurfInfo.getHighTide());
        mTvFavLowTide.setText(mCurrentSurfInfo.getLowTide());
        //mTvFavWindInfo.setText(FormattingUtils.windInfo(mCurrentSurfInfo.getWindSpeed(), mCurrentSurfInfo.getWindDirection()));

        /* fav spot forecast */
        setupFavForecast();
    }

    private void setupFavForecast() {
        for (ForecastSurfInfo forecast : mForecastSurfInfos) {
            ForecastItem itemView = new ForecastItem(getContext(), forecast.getDate(),
                    forecast.getHeightMin(), forecast.getHeightMax());
            hsvContainer.addView(itemView);
        }
    }

    @OnClick(R.id.dashboard_nearby_forecast_card)
    public void nearbyClick() {
        //TODO: fragment transaction to nearby forecast
    }

    @OnClick(R.id.dashboard_all_spots_card)
    public void allSpotsClick() {
        //TODO: fragment transaction to nearby forecast
    }

    private class ForecastItem extends LinearLayout {

        public ForecastItem(Context context, String date, String heightMin, String heightMax) {
            super(context);

            setOrientation(LinearLayout.VERTICAL);
            setLayoutParams(new LayoutParams(getResources().getDimensionPixelOffset(R.dimen.dashboard_forecast_item_width)
                    , LayoutParams.MATCH_PARENT));
            setBackgroundColor(Color.GRAY);
            TextView tvDate = new TextView(context);
            //TODO: format date to today, tomorrow, and month/day after
            tvDate.setText(date);
            tvDate.setTextSize(14);

            TextView tvForecastHeight = new TextView(context);
            tvForecastHeight.setText(FormattingUtils.surfHeight(heightMin, heightMax));
            tvForecastHeight.setTextSize(12);

            addView(tvDate);
            addView(tvForecastHeight);
        }
    }

}
