package helper;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by yomac_000 on 26-11-2015.
 */
public class IntentHelper {
    public final static int FILE_PICK = 1001;

    public static void chooseFileIntent(Activity activity){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        activity.startActivityForResult(intent, FILE_PICK);
    }
}
