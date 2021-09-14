package com.example.openspace.listeners;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.openspace.R;

public class GameViewListener implements View.OnTouchListener {
    public static boolean shoot = false;
    @SuppressLint({"NonConstantResourceId", "ClickableViewAccessibility"})
    @Override
    public boolean onTouch(View gameLayOut, MotionEvent event) {
        if (gameLayOut.getId() == R.id.gameLayout) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                shoot = true;
                //Log.d("TOUCH", "MainGamePanel");
            }
        }
        return false;
    }
}
