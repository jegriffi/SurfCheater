package griffintech.org.surfercheater.Utils;

import java.util.HashMap;

/**
 * Created by James on 8/27/2015.
 */
public final class Cache {

    private static HashMap<String, CacheValue> cacheMap;
    private static Cache mInstance = null;

    public static synchronized Cache instance() {
        if (mInstance != null) {
            return mInstance;
        }
        mInstance = new Cache();
        return mInstance;
    }

    // each area information will be put into the cache value;
    private static class CacheValue {


    }
}
