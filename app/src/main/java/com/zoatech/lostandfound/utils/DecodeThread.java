package com.zoatech.lostandfound.utils;

import android.os.Handler;
import android.os.Looper;

import com.zoatech.lostandfound.ui.CaptureActivity;
import com.zoatech.lostandfound.ui.handlers.DecodeHandler;

import java.util.concurrent.CountDownLatch;

/**
 * This thread does all the heavy lifting of decoding the images.
 * <p>
 * The code for this class was adapted from the ZXing project: http://code.google.com/p/zxing
 */
public final class DecodeThread extends Thread {

    private final CaptureActivity activity;
    private Handler handler;
    private final CountDownLatch handlerInitLatch;

    public DecodeThread(CaptureActivity activity) {
        this.activity = activity;
        handlerInitLatch = new CountDownLatch(1);
    }

    public Handler getHandler() {
        try {
            handlerInitLatch.await();
        } catch (InterruptedException ie) {
            // continue?
        }
        return handler;
    }

    @Override
    public void run() {
        Looper.prepare();
        handler = new DecodeHandler(activity);
        handlerInitLatch.countDown();
        Looper.loop();
    }
}
