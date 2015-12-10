package api;

import com.android.volley.Response;

import java.util.Map;

/**
 * Created by yomac_000 on 10-12-2015.
 */
public abstract class  Request extends com.android.volley.toolbox.StringRequest {
    private final Map<String, String> _params = null;

    public Request(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    protected abstract Map<String, String> getParams();

    protected abstract void onResponse(String response);
}
