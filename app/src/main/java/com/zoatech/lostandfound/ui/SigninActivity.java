package com.zoatech.lostandfound.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zoatech.lostandfound.R;


public class SigninActivity extends BaseActivity {

    Button btn_sign_in;
    TextView text_view_account_not_exists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final TextInputLayout editTextPhoneNoWrapper = findViewById(R.id.text_input_layout_signin_phone_no);
        final TextInputLayout editTextPasswordWrapper = findViewById(R.id.text_input_layout_signin_password);

        editTextPhoneNoWrapper.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError(editTextPhoneNoWrapper);
                hideError(editTextPasswordWrapper);
            }
        });
        editTextPasswordWrapper.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError(editTextPhoneNoWrapper);
                hideError(editTextPasswordWrapper);
            }
        });

        btn_sign_in = findViewById(R.id.btn_act_sign_in);
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = editTextPhoneNoWrapper.getEditText().getText().toString();
                String password = editTextPasswordWrapper.getEditText().getText().toString();

                if (!TextUtils.isEmpty(phoneNo)||!TextUtils.isEmpty(password)) {
                    if (!validatePhoneNo(phoneNo)) {
                        editTextPhoneNoWrapper.setError("Not a valid phone number");
                    } else if (!validatePassword(password)) {
                        editTextPasswordWrapper.setError("Password should be at least 6 charachters");
                    } else {
                        editTextPhoneNoWrapper.setErrorEnabled(false);
                        editTextPasswordWrapper.setErrorEnabled(false);
                        startActivity(new Intent(SigninActivity.this,WelcomeActivity.class));
                        finish();
                    }
                } else {
                    Snackbar.make(getCurrentFocus(), "Please enter the missing details", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        text_view_account_not_exists = findViewById(R.id.text_view_account_not_exists);
        text_view_account_not_exists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SigninActivity.this, WelcomeActivity.class));
            }
        });
    }

}
