package model;

import org.json.JSONObject;

import java.lang.reflect.Type;

import helper.Utils;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

/**
 * Created by yomac_000 on 13-12-2015.
 */
public interface YutonAPI {

    @POST("/api/login")
    void postLogin(
            @Body User user,
            Callback<User> cb
    );
}
