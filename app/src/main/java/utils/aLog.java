package utils;

import android.util.Log;

/**
 * Created by yomac_000 on 27-11-2015.
 */
public class aLog {
    public static void w (String TAG, String msg){
        if(Constants.LOGGING) {
            if (TAG != null && msg != null)
                Log.w(TAG, msg);
        }
    }

}
