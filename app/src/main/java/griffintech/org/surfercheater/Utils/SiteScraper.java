package griffintech.org.surfercheater.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import griffintech.org.surfercheater.Constants.Constants;

/**
 * Created by James on 8/27/2015.
 */
public class SiteScraper extends AsyncTask<String, Void, String>  {

    private ProgressDialog dialog;
    private Context mContext;


    public SiteScraper(Context context) {
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(mContext, null, "Downloading...");
    }

    @Override
    protected String doInBackground(String... params) {
        String [] forecastLocations = Constants.ForcastLocationCode.getAll();
        try {
            for (String location : forecastLocations) {
                URL url = new URL(Constants.URLCode.PRE + location + Constants.URLCode.POST);

                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder total = new StringBuilder();
                String str;
                while((str = in.readLine()) != null) {
                    total.append(str);
                }
                String result = total.toString();
                result = result.substring(result.indexOf('(')+1, result.length()-2);

                JSONToCacheForecast(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }


    //takes JSON string of forecast and adds it to the cache
    private void JSONToCacheForecast(String str) {
        Cache mCache = Cache.instance();
        try {
            JSONObject mainObject = new JSONObject(str);
            JSONObject analysis = mainObject.getJSONObject("Analysis");

            List<String> generalCondition = JSONArrayToList(analysis.getJSONArray("generalCondition"));
            List<String> surfMin = JSONArrayToList(analysis.getJSONArray("surfMin"));
            List<String> surfMax = JSONArrayToList(analysis.getJSONArray("surfMax"));
            List<String> surfText = JSONArrayToList(analysis.getJSONArray("surfText"));
            String region = analysis.getString("name");

            SurfSpotForecast surfSpotForecast = new SurfSpotForecast(generalCondition, surfMax, surfMin, surfText, region);

            mCache.putForecast(region, surfSpotForecast);
        }catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
    private List<String> JSONArrayToList(JSONArray array) throws org.json.JSONException {
        List<String> objectList =  new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            objectList.add((String) array.get(i));
        }
        return objectList;
    }
}
