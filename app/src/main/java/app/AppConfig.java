package app;

import helper.Utils;

/**
 * Created by yomac_000 on 21-11-2015.
 */
public class AppConfig {

    // Server user login url
    //public static String URL_LOGIN = "http://10.0.2.2:5000/api/login";
    public static String URL_LOGIN = "http://10.0.2.2:5000";

    // Server user register url
    public static String URL_REGISTER = "http://10.0.2.2:5000/api/users";

    public static String getUrlRegister() {
        if(!Utils.getIPAddress(true).equals("10.0.2.2")) {
            URL_REGISTER = "http://yuton-kenzup.herokuapp.com/api/users";
            return URL_REGISTER;
        }

        return URL_REGISTER;
    }

    public static String getUrlLogin() {

        if(!Utils.getIPAddress(true).equals("10.0.2.2")) {
           // URL_LOGIN = "http://yuton-kenzup.herokuapp.com/api/login";
            //URL_LOGIN = "http://yuton-kenzup.herokuapp.com";
            URL_LOGIN = "http://10.0.2.2:5000";
            return URL_LOGIN;
        }

        return URL_LOGIN;
    }

}
