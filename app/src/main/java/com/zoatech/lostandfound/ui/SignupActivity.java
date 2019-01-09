package com.zoatech.lostandfound.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zoatech.lostandfound.R;


public class SignupActivity extends BaseActivity {

    Button btn_sign_up;
    TextView textViewAccountExists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final TextInputLayout editTextPhoneNoWrapper = findViewById(R.id.text_input_layout_phone_no);
        final TextInputLayout editTextPasswordWrapper = findViewById(R.id.text_input_layout_password);
        final TextInputLayout editTextConfirmPasswordWrapper = findViewById(R.id.text_input_layout_confirm_password);

        editTextPhoneNoWrapper.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError(editTextPhoneNoWrapper);
                hideError(editTextPasswordWrapper);
                hideError(editTextConfirmPasswordWrapper);
            }
        });
        editTextPasswordWrapper.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError(editTextPhoneNoWrapper);
                hideError(editTextPasswordWrapper);
                hideError(editTextConfirmPasswordWrapper);
            }
        });
        editTextConfirmPasswordWrapper.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError(editTextPhoneNoWrapper);
                hideError(editTextPasswordWrapper);
                hideError(editTextConfirmPasswordWrapper);
            }
        });

        btn_sign_up = findViewById(R.id.btn_act_sign_up);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = editTextPhoneNoWrapper.getEditText().getText().toString();
                String password = editTextPasswordWrapper.getEditText().getText().toString();
                String confirmPassword = editTextConfirmPasswordWrapper.getEditText().getText().toString();

                if (!TextUtils.isEmpty(phoneNo)||!TextUtils.isEmpty(password)||!TextUtils.isEmpty(confirmPassword)) {
                    if (!validatePhoneNo(phoneNo)) {
                        editTextPhoneNoWrapper.setError("Not a valid phone number");
                    } else if (!validatePassword(password)) {
                        editTextPasswordWrapper.setError("Password should be at least 6 charachters");
                    } else if (!confirmPasswordLength(confirmPassword, password)) {
                        editTextConfirmPasswordWrapper.setError("Passwords do not match");
                    } else {
                        editTextPhoneNoWrapper.setErrorEnabled(false);
                        editTextPasswordWrapper.setErrorEnabled(false);
                        editTextConfirmPasswordWrapper.setErrorEnabled(false);
                        startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                        finish();
                    }
                } else {
                    Snackbar.make(getCurrentFocus(), "Please Enter The Required Details", Snackbar.LENGTH_SHORT).show();
                }

            }
        });

        textViewAccountExists = findViewById(R.id.text_view_account_exists);
        textViewAccountExists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this,WelcomeActivity.class));
            }
        });
    }

}
