package com.example.openspace.Entity;

import android.content.Context;

import com.example.openspace.GameView;
import com.example.openspace.MainActivity;
import com.example.openspace.R;
import com.example.openspace.listeners.GamePanelListener;

public class Ship extends SpaceBody{
    public Ship (Context context){
        bitMapId = R.drawable.ship;
        size = 5;
        x = 7;
        y = GameView.maxY-size - 1;
        speed = (float) 0.2;

        init(context);
    }

    @Override
    public void update() {
        if (GamePanelListener.isLeftPressed && x >= 0){
            x -= speed;
        }
        if (GamePanelListener.isRightPressed && x < GameView.maxX - 5){
            x += speed;
        }
    }
}
