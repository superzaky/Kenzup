package api;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.yomac_000.kenzup.LoginActivity;
import com.example.yomac_000.kenzup.MainActivity;
import com.example.yomac_000.kenzup.RegisterActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by yomac_000 on 11-12-2015.
 */
public class LoginRequest extends Request {

    public LoginRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    @Override
    protected Map<String, String> getParams() {
        return null;
    }

    @Override
    protected void onResponse(String response) {

        try {
            System.out.println(response);
            JSONObject jObj = new JSONObject(response);

        } catch (JSONException e) {
            // JSON error
            e.printStackTrace();

        }

    }

}
