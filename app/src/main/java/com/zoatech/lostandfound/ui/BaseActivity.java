package com.zoatech.lostandfound.ui;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.zoatech.lostandfound.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseActivity extends AppCompatActivity {

    private static final String PHONENO_PATTERN = "^[+][0-9]+$";
    private Pattern pattern = Pattern.compile(PHONENO_PATTERN);

    public boolean validatePhoneNo(String phoneNo) {
        Matcher matcher = pattern.matcher(phoneNo);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }

    public boolean confirmPasswordLength(String confirmPassword, String password) {
        return TextUtils.equals(confirmPassword, password);
    }
        
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public void hideError(TextInputLayout textInputLayout) {
        textInputLayout.setError(null);
        textInputLayout.setErrorEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                startActivity(new Intent(getApplicationContext(), SigninActivity.class));
                break;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Settings Activity Loading", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

}
