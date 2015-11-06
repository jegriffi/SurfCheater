package griffintech.org.surfercheater.Utils;

import java.util.HashMap;

/**
 * Created by James on 8/27/2015.
 */
public final class Cache {

    private static HashMap<String, ForecastSurfInfo> forecastCacheMap;
    private static HashMap<String, CurrentSurfInfo> currentCacheMap;
    private static Cache mInstance = null;

    public static synchronized Cache instance() {
        if (mInstance != null) {
            return mInstance;
        }
        mInstance = new Cache();
        forecastCacheMap = new HashMap<>();
        currentCacheMap = new HashMap<>();
        return mInstance;
    }

    public synchronized void putForecast(final String key, final ForecastSurfInfo value) {
        forecastCacheMap.put(key, value);
    }

    public synchronized Object getForecast(final String key) {
        return forecastCacheMap.get(key);
    }

    public synchronized void removeForecast(final String key) {
        forecastCacheMap.remove(key);
    }

    public synchronized void putCurrent(final String key, final CurrentSurfInfo value) {
        currentCacheMap.put(key, value);
    }

    public synchronized Object getCurrent(final String key) {
        return currentCacheMap.get(key);
    }

    public synchronized void removeCurrent(final String key) {
        currentCacheMap.remove(key);
    }

    public synchronized HashMap<String, ForecastSurfInfo> getForecastCacheMap() {
        return forecastCacheMap;
    }

    public synchronized HashMap<String, CurrentSurfInfo> getCurrentCacheMap() {
        return currentCacheMap;
    }
}
