package com.example.framgia.testlineargradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by phanvanlinh on 13/12/2016.
 */

public class CustomView extends View{
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        LinearGradient linearGradient =  new LinearGradient(0, 0, 0, getHeight(), Color.GREEN, Color.WHITE , Shader.TileMode.MIRROR);
        Paint paint  = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(linearGradient);

        canvas.drawRect(new RectF(0,0,getWidth(),getHeight()), paint);

        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(100);
        LinearGradient linearGradient2 =  new LinearGradient(0, 0, 0, 100, Color.RED, Color.YELLOW , Shader.TileMode.MIRROR);
        textPaint.setShader(linearGradient2);
        canvas.drawText("Hello", 100 , 100, textPaint);
    }
}
