package com.zoatech.lostandfound.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zoatech.lostandfound.R;

public class WelcomeActivity extends BaseActivity implements View.OnClickListener{

    Button btnApply4LostId, btnUpdateProfile, btnScanId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnApply4LostId = findViewById(R.id.button_apply_for_id);
        btnUpdateProfile = findViewById(R.id.button_update_profile);
        btnScanId = findViewById(R.id.button_scan_id);

        btnApply4LostId.setOnClickListener(this);
        btnUpdateProfile.setOnClickListener(this);
        btnScanId.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnApply4LostId) {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        } else if (v == btnUpdateProfile) {
            startActivity(new Intent(WelcomeActivity.this, UpdateDetailsActivity.class));
        } else if (v == btnScanId) {
            startActivity(new Intent(WelcomeActivity.this, CaptureActivity.class));
        } else {
            Toast.makeText(getApplicationContext(), "Scan Id Activity Loading", Toast.LENGTH_SHORT).show();
        }
    }
}
