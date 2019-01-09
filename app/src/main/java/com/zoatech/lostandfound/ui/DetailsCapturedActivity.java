package com.zoatech.lostandfound.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.zoatech.lostandfound.R;
import com.zoatech.lostandfound.ocr.OcrResult;


public class DetailsCapturedActivity extends BaseActivity {

    private Bitmap lastBitmap;
    private OcrResult ocrResult;
    private ImageView bitmapImageView;
    private TextView textViewPhoneNumber;
    private TextView textViewAge;
    private TextView textViewPOI;
    private TextView textViewDocument;
    private TextView textViewGender;
    private TextView textViewFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_captured);

        initUI();
        setUpValues();
    }

    private void initUI() {
        bitmapImageView = findViewById(R.id.image_view);

        textViewFullName = findViewById(R.id.text_view_full_name);
        textViewGender = findViewById(R.id.text_view_gender);
        textViewAge = findViewById(R.id.text_view_age);
        textViewDocument = findViewById(R.id.text_view_document);
        textViewPOI = findViewById(R.id.text_view_poi);
        textViewPhoneNumber = findViewById(R.id.text_view_dynamic_phone_no);
    }

    private void setUpValues() {
        lastBitmap = getIntent().getParcelableExtra("OCR_RESULT");

        if (lastBitmap != null) {
            bitmapImageView.setImageBitmap(lastBitmap);
        }
    }
}
