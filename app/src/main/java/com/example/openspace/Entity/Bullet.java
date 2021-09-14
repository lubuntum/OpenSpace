package com.example.openspace.Entity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.openspace.GameView;

public class Bullet extends SpaceBody {
    float x1,y1;
    private int color = Color.WHITE;
    private int bulletW = 5;

    @Override
    public void init(Context context) {
    }

    public Bullet (float x, float y,float x1, float y1){
        size = 1;
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1 - size;
        speed = (float)0.3;

    }

    @Override
    public void update() {
        y -= speed;
        y1 -= speed;
    }

    @Override
    public void drow(Paint paint, Canvas canvas) {
        paint.setColor(color);
        paint.setStrokeWidth(bulletW);
        canvas.drawLine(x*GameView.unitW,y*GameView.unitH,
                x1*GameView.unitW,y1*GameView.unitH,paint);
    }

    @Override
    public boolean isCollision(SpaceBody body) {
        return (body.x < x1 && body.x + body.size > x1) && (body.y < y1 && body.y + size > y1);
    }

    public static Bullet spawn (float x, float y,float x1, float y1){
        return new Bullet(x,y,x1,y1);
    }

}
