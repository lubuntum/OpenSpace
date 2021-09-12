package com.example.openspace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Space;

import com.example.openspace.Entity.Asteroid;
import com.example.openspace.Entity.Ship;
import com.example.openspace.Entity.SpaceBody;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends SurfaceView implements Runnable {
    public static int maxX = 20;//20
    public static int maxY = 28;//28
    public static float unitW = 0;
    public static float unitH = 0;
    public static int difficult = 750;
    private boolean firstTime = true;
    private boolean gameRunning = true;
    private Ship ship;
    private ArrayList<SpaceBody> asteroids;//arr
    private ArrayList<SpaceBody> removable;
    private Thread gameThread = null;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    public GameView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while(gameRunning) {
            update();
            draw();
            checkCollision();
            spawn();
            control();
        }
    }
    private void update(){
        if (!firstTime) {
            ship.update();
            for (SpaceBody asteroid:asteroids)
                if (asteroid.isOut())  removable.add(asteroid);
                else asteroid.update();
                asteroids.removeAll(removable);
                removable.clear();
        }
    }

    private  void draw(){

        if (surfaceHolder.getSurface().isValid()){
            if (firstTime){
                firstTime = false;
                unitW = surfaceHolder.getSurfaceFrame().width()/maxX;
                unitH = surfaceHolder.getSurfaceFrame().height()/maxY;

                ship = new Ship(getContext());
                asteroids = new ArrayList<>();
                removable = new ArrayList<>();
                asteroids.add(new Asteroid(getContext()));
            }
            canvas = surfaceHolder.lockCanvas();

            canvas.drawColor(Color.BLACK);
            ship.drow(paint,canvas);
            for (SpaceBody asteroid:asteroids)
                asteroid.drow(paint,canvas);

            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
    private void control(){
        try{
            Thread.sleep(10);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private void checkCollision(){
        if (!firstTime)
            for (SpaceBody asteroid:asteroids)
                if (asteroid.isCollision(ship)) gameRunning = false;
    }
    private void spawn(){
        if (Asteroid.randomSpawn.nextInt(difficult) <= 5 && !firstTime)
            asteroids.add(Asteroid.spawn(getContext()));
    }
}
