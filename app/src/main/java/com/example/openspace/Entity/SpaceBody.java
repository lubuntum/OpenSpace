package com.example.openspace.Entity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.openspace.GameView;

import org.jetbrains.annotations.NotNull;

public class SpaceBody {
    protected float x,y;
    protected float size;
    protected float speed;
    protected int bitMapId;
    protected Bitmap bitmap;

    public void init(Context context){
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(),bitMapId);
        float testW = GameView.unitW;
        float testH = GameView.unitH;
        bitmap = Bitmap.createScaledBitmap(cBitmap,
                (int)(size* GameView.unitW),(int)(size*GameView.unitH),false);
        cBitmap.recycle();
    }
    public void update(){}
    public void drow(Paint paint, Canvas canvas){
        canvas.drawBitmap(bitmap,x*GameView.unitW,y*GameView.unitH,paint);
    }
}