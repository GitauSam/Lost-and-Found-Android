package com.zoatech.lostandfound.ocr;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;


public class OcrResult {
    private Bitmap bitmap;
    private Bitmap originalBitmap;
    private String text = "";

    private List<Rect> regionBoundingBoxes = new ArrayList<>();
    private List<Rect> textlineBoundingBoxes = new ArrayList<>();
    private List<Rect> wordBoundingBoxes = new ArrayList<>();
    private List<Rect> stripBoundingBoxes = new ArrayList<>();
    private List<Rect> characterBoundingBoxes = new ArrayList<>();

    private long timestamp = 0l;
    private long recognitionTimeRequired = 0l;

    private int[] wordConfidences = new int[]{};
    private int meanConfidence = 0;

    public OcrResult(Bitmap bitmap,
                     String text,
                     int[] wordConfidences,
                     int meanConfidence,
                     List<Rect> regionBoundingBoxes,
                     List<Rect> textlineBoundingBoxes,
                     List<Rect> wordBoundingBoxes,
                     List<Rect> stripBoundingBoxes,
                     List<Rect> characterBoundingBoxes,
                     long recognitionTimeRequired) {
        this.bitmap = bitmap;
        this.text = text;
        this.wordConfidences = wordConfidences;
        this.meanConfidence = meanConfidence;
        this.regionBoundingBoxes = regionBoundingBoxes;
        this.textlineBoundingBoxes = textlineBoundingBoxes;
        this.wordBoundingBoxes = wordBoundingBoxes;
        this.stripBoundingBoxes = stripBoundingBoxes;
        this.characterBoundingBoxes = characterBoundingBoxes;
        this.recognitionTimeRequired = recognitionTimeRequired;
        this.timestamp = System.currentTimeMillis();
    }

    public OcrResult() {
        timestamp = System.currentTimeMillis();
    }


    public Bitmap getBitmap() {
        return getAnnotatedBitmap(bitmap);
    }

    public Bitmap getOriginalAnnotatedBitmap() {
        return getAnnotatedBitmap(originalBitmap);
    }

    public Bitmap getAnnotatedBitmap(Bitmap bitmap) {
        try {
            Canvas canvas = new Canvas(bitmap);

            Paint paint = new Paint();
            // Draw bounding boxes around each word
            for (int i = 0; i < wordBoundingBoxes.size(); i++) {
                paint.setAlpha(0xFF);
                paint.setColor(0xFF00CCFF);
                paint.setStyle(Style.STROKE);
                paint.setStrokeWidth(2);
                Rect r = wordBoundingBoxes.get(i);
                canvas.drawRect(r, paint);
            }
        } catch (java.lang.IllegalStateException e) {
            System.err.println(e);
        }
        return bitmap;
    }

    public String getText() {
        return text;
    }

    public int[] getWordConfidences() {
        return wordConfidences;
    }

    public int getMeanConfidence() {
        return meanConfidence;
    }

    public long getRecognitionTimeRequired() {
        return recognitionTimeRequired;
    }

    public Point getBitmapDimensions() {
        return new Point(bitmap.getWidth(), bitmap.getHeight());
    }

    public List<Rect> getRegionBoundingBoxes() {
        return regionBoundingBoxes;
    }

    public List<Rect> getTextlineBoundingBoxes() {
        return textlineBoundingBoxes;
    }

    public List<Rect> getWordBoundingBoxes() {
        return wordBoundingBoxes;
    }

    public List<Rect> getStripBoundingBoxes() {
        return stripBoundingBoxes;
    }

    public List<Rect> getCharacterBoundingBoxes() {
        return characterBoundingBoxes;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setWordConfidences(int[] wordConfidences) {
        this.wordConfidences = wordConfidences;
    }

    public void setMeanConfidence(int meanConfidence) {
        this.meanConfidence = meanConfidence;
    }

    public void setRecognitionTimeRequired(long recognitionTimeRequired) {
        this.recognitionTimeRequired = recognitionTimeRequired;
    }

    public void setRegionBoundingBoxes(List<Rect> regionBoundingBoxes) {
        this.regionBoundingBoxes = regionBoundingBoxes;
    }

    public void setTextlineBoundingBoxes(List<Rect> textlineBoundingBoxes) {
        this.textlineBoundingBoxes = textlineBoundingBoxes;
    }

    public void setWordBoundingBoxes(List<Rect> wordBoundingBoxes) {
        this.wordBoundingBoxes = wordBoundingBoxes;
    }

    public void setStripBoundingBoxes(List<Rect> stripBoundingBoxes) {
        this.stripBoundingBoxes = stripBoundingBoxes;
    }

    public void setCharacterBoundingBoxes(List<Rect> characterBoundingBoxes) {
        this.characterBoundingBoxes = characterBoundingBoxes;
    }

    @Override
    public String toString() {
        return text + " " + meanConfidence + " " + recognitionTimeRequired + " " + timestamp;
    }

    public void setOriginalBitmap(Bitmap originalBitmap) {
        this.originalBitmap = originalBitmap;
    }

    public Bitmap getOriginalBitmap() {
        return getOriginalAnnotatedBitmap();
    }

}
