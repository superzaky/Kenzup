package app;

import helper.Utils;

/**
 * Created by yomac_000 on 21-11-2015.
 */
public class AppConfig {

    // Server user login url
    //public static String URL_LOGIN = "http://192.168.0.103:3000/api/login";
    public static String URL_LOGIN = "http://192.168.0.103:80/android_login_api/login.php";

    // Server user register url
    public static String URL_REGISTER = "http://192.168.0.103:80/android_login_api/register.php";
    //public static String URL_REGISTER = "http://192.168.0.103:3000/api/myTheme/register";

    public static String getUrlRegister() {
        if(!Utils.getIPAddress(true).equals("10.0.2.15")) {
            URL_REGISTER = "http://heroku.com/android_login_api/login.php";
            return URL_REGISTER;
        }

        return URL_REGISTER;
    }

    public static String getUrlLogin() {

        if(!Utils.getIPAddress(true).equals("10.0.2.15")) {
            URL_LOGIN = "http://heroku.com/android_login_api/login.php";
            return URL_LOGIN;
        }

        return URL_LOGIN;
    }

}
