package com.example.openspace.Entity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.openspace.GameView;

import org.jetbrains.annotations.NotNull;

public abstract class SpaceBody {
    protected float x,y;
    protected float size;
    protected float speed;
    protected int bitMapId;
    protected Bitmap bitmap;

    public void init(Context context){
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(),bitMapId);
        int testW = (int)(size* GameView.unitW);
        int testH = (int)(size* GameView.unitH);
        bitmap = Bitmap.createScaledBitmap(cBitmap,
                (int)(size* GameView.unitW),(int)(size*GameView.unitH),false);
        cBitmap.recycle();

    }
    public void update(){}
    public void drow(Paint paint, Canvas canvas){
        canvas.drawBitmap(bitmap,x*GameView.unitW,y*GameView.unitH,paint);
        /**
        paint.setColor(Color.RED);
        canvas.drawLine(x*GameView.unitW,y*GameView.unitH,(x+size)*GameView.unitW,
                (y+size)*GameView.unitH,paint);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        canvas.drawPoint(x*GameView.unitW,y*GameView.unitH,paint);
        canvas.drawPoint((x+size/2)*GameView.unitW,(y+size/2)*GameView.unitH,paint);
        canvas.drawPoint((x+size)*GameView.unitW,(y+size)*GameView.unitH,paint);
        canvas.drawPoint((x+size*3/4)*GameView.unitW,(y+size*3/4)*GameView.unitH,paint);
         */
    }
    public abstract boolean isCollision(SpaceBody body);
    public boolean isOut(){
        return (y > GameView.maxY || y < 0);
    }
}
