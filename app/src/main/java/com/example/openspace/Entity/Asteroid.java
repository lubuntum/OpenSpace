package com.example.openspace.Entity;

import android.content.Context;
import android.widget.Space;

import com.example.openspace.GameView;
import com.example.openspace.R;

import java.util.Random;

public class Asteroid extends SpaceBody{
    public static final Random randomSpawn = new Random();
    private int radius = 1;
    private float minSpeed = (float)0.2;
    private float maxSpeed = (float)0.4;
    public Asteroid (Context context){
        bitMapId = R.drawable.meteor;
        y = 0;
        x = randomSpawn.nextInt(GameView.maxX) - radius;
        size = radius*2;
        speed = minSpeed + (maxSpeed - minSpeed)*randomSpawn.nextFloat();
        init(context);
    }

    @Override
    public void update() {
        //if (y > GameView.maxY) y = 0;
        y += speed;
    }

    public static Asteroid spawn(Context context){
        return new Asteroid(context);
    }
    @Override
    public boolean isCollision(SpaceBody body) {
        if ((x > body.x && x < body.x + (body.size*3/4)) &&
                (y > body.y && y < body.y + (body.size*3/4))){
            return true;
        }
        return false;
    }
}
