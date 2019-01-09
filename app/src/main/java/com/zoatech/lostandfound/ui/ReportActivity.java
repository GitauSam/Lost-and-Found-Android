package com.zoatech.lostandfound.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.zoatech.lostandfound.R;


public class ReportActivity extends BaseActivity {

    ArrayAdapter adapter;
    String [] documentTypes = {"ID Card", "Passport", "Birth Certificate"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Spinner documentSpinner = findViewById(R.id.spinner_documents);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, documentTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        documentSpinner.setAdapter(adapter);
    }

}
