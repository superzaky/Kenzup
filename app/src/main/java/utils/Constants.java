package utils;

/**
 * Created by yomac_000 on 27-11-2015.
 */
public class Constants {
    /*
  Logging flag
 */
    public static final boolean LOGGING = false;

    /*
      Your imgur client id. You need this to upload to imgur.

      More here: https://api.imgur.com/
     */
    public static final String MY_IMGUR_CLIENT_ID = "0721a7c8d9f8548";
    public static final String MY_IMGUR_CLIENT_SECRET = "";

    /*
      Redirect URL for android.
     */
    public static final String MY_IMGUR_REDIRECT_URL = "http://android";

    /*
      Client Auth
     */
    public static String getClientAuth() {
        return "Client-ID " + MY_IMGUR_CLIENT_ID;
    }
}
