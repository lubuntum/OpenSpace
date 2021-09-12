package com.example.openspace.listeners;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.openspace.R;

public class GamePanelListener implements View.OnTouchListener {
    public static boolean isLeftPressed = false;
    public static boolean isRightPressed = false;
    @SuppressLint({"NonConstantResourceId", "ClickableViewAccessibility"})
    @Override
    public boolean onTouch(View button, MotionEvent event) {
        switch (button.getId()){
            case R.id.leftBtn:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        isLeftPressed = true;
                        Log.d("Click","left");
                        break;
                    case MotionEvent.ACTION_UP:
                        isRightPressed = true;
                        break;
                }
                break;
            case R.id.rightBtn:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        isRightPressed = true;
                        Log.d("Click","right");
                        break;
                    case MotionEvent.ACTION_UP:
                        isLeftPressed = true;
                        break;
                }
                break;
        }
        return true;
    }

}
