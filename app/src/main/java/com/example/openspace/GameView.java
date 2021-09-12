package com.example.openspace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.openspace.Entity.Ship;

public class GameView extends SurfaceView implements Runnable {
    public static int maxX = 10;//20
    public static int maxY = 15;//28
    public static float unitW = 0;
    public static float unitH = 0;

    private boolean firstTime = true;
    private boolean gameRunning = true;
    private Ship ship;
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
            control();
        }
    }
    private void update(){
        if (!firstTime) {
            ship.update();
        }
    }
    private  void draw(){

        if (surfaceHolder.getSurface().isValid()){
            if (firstTime){
                firstTime = false;
                unitW = surfaceHolder.getSurfaceFrame().width()/maxX;
                unitH = surfaceHolder.getSurfaceFrame().height()/maxY;

                ship = new Ship(getContext());
            }
            canvas = surfaceHolder.lockCanvas();

            canvas.drawColor(Color.BLACK);
            ship.drow(paint,canvas);

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
}
