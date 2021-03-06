package com.example.yomac_000.kenzup;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import app.AppConfig;
import app.AppController;
import helper.DatabaseHelper;
import helper.SessionManager;
import model.User;


/**
 * Created by yomac_000 on 6-11-2015.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    User user = new User();
    EditText etEmail, etUsername, etPassword, etConfirmPassword;
    Button post_register;
    private static final String TAG = RegisterActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private SessionManager session;

    // Database Helper
    DatabaseHelper db = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmail = (EditText) findViewById(R.id.email);
        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        etConfirmPassword = (EditText) findViewById(R.id.confirm_password);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Session manager
        session = new SessionManager(getApplicationContext());

        post_register = (Button) findViewById(R.id.btnRegister);
        post_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // do something when the button is clicked
        ContentValues values = new ContentValues();

        String email = etEmail.getText().toString();
        String name = etUsername.getText().toString();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your details!", Toast.LENGTH_LONG)
                    .show();
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(getApplicationContext(),
                    "Passwords do not match", Toast.LENGTH_LONG)
                    .show();
        }
        else {

            registerUser(name, email, password, confirmPassword, name);
        }
    }

    /**
     * Function to store user in Mongo database will post params(tag, name,
     * email, password) to register url
     * */
    private void registerUser(final String name, final String email,
                              final String password, final String confirmPassword, final String username) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.getUrlRegister(), new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject user = new JSONObject(response);
                    String uid = user.getString("id");
                    String name = user.getString("name");
                    String email = user.getString("email");

                    // Inserting row in users table
                    db.addUser(name, email, uid);
                    System.out.println("start");
                    Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();
                    System.out.println("end");
                    // Launch login activity
                    Intent intent = new Intent(
                            RegisterActivity.this,
                            LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                int  statusCode = error.networkResponse.statusCode;
                NetworkResponse response = error.networkResponse;
                Log.d("testerror", "" + statusCode + " " + new String(response.data));

                if (statusCode != 200) {
                    Toast.makeText(getApplicationContext(), new String(response.data), Toast.LENGTH_LONG).show();
                    hideDialog();
                }
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();

                params.put("email", email);
                params.put("password", password);
                params.put("confirmPassword", confirmPassword);
                params.put("username", username);
                params.put("name", name);


                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(i);
        finish();
    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
