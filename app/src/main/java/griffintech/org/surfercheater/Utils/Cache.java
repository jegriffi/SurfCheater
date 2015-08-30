package griffintech.org.surfercheater.Utils;

import java.util.HashMap;

/**
 * Created by James on 8/27/2015.
 */
public final class Cache {

    private static HashMap<String, Object> forecastCacheMap;
    private static HashMap<String, Object> currentCacheMap;
    private static Cache mInstance = null;

    public static synchronized Cache instance() {
        if (mInstance != null) {
            return mInstance;
        }
        mInstance = new Cache();
        forecastCacheMap = new HashMap<String, Object>();
        currentCacheMap = new HashMap<String, Object>();
        return mInstance;
    }

    public synchronized void putForecast(final String key, final Object value) {
        forecastCacheMap.put(key, value);
    }

    public synchronized Object getForecast(final String key) {
        return forecastCacheMap.get(key);
    }

    public synchronized void removeForecast(final String key) {
        forecastCacheMap.remove(key);
    }

    public synchronized void putCurrent(final String key, final Object value) {
        currentCacheMap.put(key, value);
    }

    public synchronized Object getCurrent(final String key) {
        return currentCacheMap.get(key);
    }

    public synchronized void removeCurrent(final String key) {
        currentCacheMap.remove(key);
    }
}
