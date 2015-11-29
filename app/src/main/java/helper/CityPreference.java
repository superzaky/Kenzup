package helper;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by yomac_000 on 28-11-2015.
 */
public class CityPreference {
    SharedPreferences prefs;

    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public String getCity(){
        return prefs.getString("city", "Sydney, AU");
    }

    public void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }
}
