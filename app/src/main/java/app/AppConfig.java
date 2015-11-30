package app;

import helper.Utils;

/**
 * Created by yomac_000 on 21-11-2015.
 */
public class AppConfig {

    // Server user login url
    //public static String URL_LOGIN = "http://192.168.0.103:3000/api/login";
    //public static String URL_LOGIN = "http://192.168.0.103:80/android_login_api/login.php";
    //public static String URL_LOGIN = "http://10.0.2.2:80/android_login_api/login.php";
    //public static String URL_LOGIN = "http://yuton-kenzup.herokuapp.com/api/login";
    public static String URL_LOGIN = "http://10.0.2.2:5000/api/login";

    // Server user register url
    //public static String URL_REGISTER = "http://192.168.0.103:80/android_login_api/register.php";
   // public static String URL_REGISTER = "http://10.0.2.2:80/android_login_api/register.php";
   // public static String URL_REGISTER = "http://yuton-kenzup.herokuapp.com/api/users";
    public static String URL_REGISTER = "http://10.0.2.2:5000/api/users";
    //public static String URL_REGISTER = "http://192.168.0.103:3000/api/myTheme/register";

    public static String getUrlRegister() {
        if(!Utils.getIPAddress(true).equals("10.0.2.2")) {
            URL_REGISTER = "http://yuton-kenzup.herokuapp.com/api/users";
            //URL_REGISTER = "http://kenzup.netne.net/register.php";
            return URL_REGISTER;
        }

        return URL_REGISTER;
    }

    public static String getUrlLogin() {

        if(!Utils.getIPAddress(true).equals("10.0.2.2")) {
            //URL_LOGIN = "http://kenzup.netne.net/login.php";
            URL_LOGIN = "http://yuton-kenzup.herokuapp.com/api/login";
            return URL_LOGIN;
        }

        return URL_LOGIN;
    }

}
