package com.example.openspace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.openspace.listeners.GamePanelListener;
import com.example.openspace.listeners.GameViewListener;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    @SuppressLint("ClickableViewAccessibility")
    public void init(){
        GameView gameView = new GameView(this);

        LinearLayout gameLayout = findViewById(R.id.gameLayout);
        gameLayout.addView(gameView);

        GamePanelListener gamePanelListener = new GamePanelListener();
        GameViewListener gameViewListener = new GameViewListener();

        gameLayout.setOnTouchListener(gameViewListener);

        Button leftBtn = findViewById(R.id.leftBtn);
        Button rightBtn = findViewById(R.id.rightBtn);
        leftBtn.setOnTouchListener(gamePanelListener);
        rightBtn.setOnTouchListener(gamePanelListener);
    }

}