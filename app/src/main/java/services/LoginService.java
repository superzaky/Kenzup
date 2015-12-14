package services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.example.yomac_000.kenzup.LoginActivity;
import com.example.yomac_000.kenzup.MainActivity;
import org.json.JSONException;
import org.json.JSONObject;
import app.AppConfig;
import helper.DatabaseHelper;
import helper.SessionManager;
import model.User;
import model.YutonAPI;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import utils.Constants;

/**
 * Created by yomac_000 on 13-12-2015.
 */
public class LoginService {
    private DatabaseHelper db;

    public void Execute(String email, String password,final Context context, final SessionManager session) {
        db = new DatabaseHelper(context);
        RestAdapter restAdapter = buildRestAdapter();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        restAdapter.create(YutonAPI.class).postLogin(
                user,
                new Callback<User>() {
                    @Override
                    public void success(User user, Response response) {
                        String bodyString = new String(((TypedByteArray) response.getBody()).getBytes());
                        try {
                            session.setLogin(true);
                            JSONObject jObj = new JSONObject(bodyString);
                            JSONObject jUser = jObj.getJSONObject("user");
                            String uid = jUser.getString("id");
                            String name = jUser.getString("name");
                            String email = jUser.getString("email");
                            // Inserting row in users table
                            db.addUser(name, email, uid);
                            // Launch main activity
                            Intent intent = new Intent(context, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            // JSON error
                            Toast.makeText(context, "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        String jsonResponse =  new String(((TypedByteArray)error.getResponse().getBody()).getBytes());
                        if (error.getResponse().getStatus() != 200) {
                            Toast.makeText(context, new String(jsonResponse), Toast.LENGTH_LONG).show();
                            LoginActivity.hideDialog();
                        }
                    }
                });
    }

    private RestAdapter buildRestAdapter() {
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
