package com.example.yomac_000.kenzup;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.lang.reflect.Method;

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
    private ProgressDialog pDialog;
    private SessionManager session;

    // Database Helper
    DatabaseHelper db = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmail = (EditText) findViewById(R.id.email);
        etUsername = (EditText) findViewById(R.id.name);
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
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your details!", Toast.LENGTH_LONG)
                    .show();
        }

        if (password != confirmPassword) {
            Toast.makeText(getApplicationContext(),
                    "Passwords do not match", Toast.LENGTH_LONG)
                    .show();
        }
        else {

            registerUser(name, email, password);
        }
        db.addUser(user);
    }

    /**
     * Function to store user in Mongo database will post params(tag, name,
     * email, password) to register url
     * */
    private void registerUser(final String name, final String email,
                              final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        showDialog();



        // Adding request to request queue
       // AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }
}
