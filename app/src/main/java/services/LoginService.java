package services;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import app.AppConfig;
import model.ImageResponse;
import model.ImgurAPI;
import model.User;
import model.YutonAPI;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedFile;
import utils.Constants;

/**
 * Created by yomac_000 on 13-12-2015.
 */
public class LoginService {
    public void Execute(String email, String password, Callback<User> callback, Context context) {
        final Callback<User> cb = callback;
        RestAdapter restAdapter = buildRestAdapter();

        System.out.println("Email " + email + " passowrd " + password);
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        restAdapter.create(YutonAPI.class).postLogin(
                user,
                new Callback<User>() {
                    @Override
                    public void success(User user, Response response) {
                        System.out.println("succes");
                        String bodyString = new String(((TypedByteArray) response.getBody()).getBytes());
                        System.out.println(bodyString);
                        try {
                            JSONObject jObj = new JSONObject(bodyString);
                            JSONObject jUser = jObj.getJSONObject("user");
                            String uid = jUser.getString("id");
                            String name = jUser.getString("name");
                            String email = jUser.getString("email");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void failure(RetrofitError error) {
                        System.out.println("error "+ error);
                    }
                });
    }

    private RestAdapter buildRestAdapter() {
        System.out.println("urllogin");
        System.out.println(AppConfig.getUrlLogin());
        RestAdapter yutonAdapter = new RestAdapter.Builder()
                .setEndpoint(AppConfig.getUrlLogin())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        /*
        Set rest adapter logging if we're already logging
        */
        if (Constants.LOGGING)
            yutonAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        return yutonAdapter;
    }

}
