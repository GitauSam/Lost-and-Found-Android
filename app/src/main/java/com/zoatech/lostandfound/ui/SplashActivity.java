package com.zoatech.lostandfound.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zoatech.lostandfound.R;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private Button signIn, signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        signIn = findViewById(R.id.btn_sign_in);
        signUp = findViewById(R.id.btn_sign_up);
        signUp.setOnClickListener(this);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == signIn) {
            startActivity(new Intent(SplashActivity.this, SigninActivity.class));
            finish();
        } else {
            startActivity(new Intent(SplashActivity.this, SignupActivity.class));
            finish();
        }
    }
}
