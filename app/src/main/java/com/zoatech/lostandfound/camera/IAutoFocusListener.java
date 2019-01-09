package com.zoatech.lostandfound.camera;

import android.hardware.Camera;

public interface IAutoFocusListener {
    void onAutoFocusCallback(boolean success, Camera camera);
}
