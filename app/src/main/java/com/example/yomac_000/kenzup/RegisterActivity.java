package com.example.yomac_000.kenzup;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.DatabaseHelper;
import model.User;


/**
 * Created by yomac_000 on 6-11-2015.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    User user = new User();
    EditText etName, etAge, etUsername, etPassword;
    Button post_register;
    // Database Helper
    DatabaseHelper db = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName = (EditText) findViewById(R.id.name);
        post_register = (Button) findViewById(R.id.btnRegister);
        post_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // do something when the button is clicked
        ContentValues values = new ContentValues();

        String name = etName.getText().toString();
        user.setName(name);
        db.addUser(user);
    }
}
