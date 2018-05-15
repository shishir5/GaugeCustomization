package com.paras.gaugecustomization.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Paras on 15/05/18.
 */
public class MyCustomDrawable extends Drawable {

    private static final int NUM_RECTS = 10;
    private Paint mPaint = new Paint();

    @Override
    public void draw(@NonNull Canvas canvas) {
        int level = getLevel();                   // It will give the level of progress(0 to 10,000)
        Rect b = getBounds();
        float height = b.height();
        float width = b.width();
        int divisionFactor = (int) (height / NUM_RECTS);
        float x = divisionFactor - 5;
        float y = 0;
        for (int i = 0; i < NUM_RECTS; i++) {
            if ((i + 1) * 10000 / NUM_RECTS > level) {
                mPaint.setColor(Color.GRAY);
            } else {
                mPaint.setColor(Color.GREEN);
            }
            float left = 0;
            float top = height - x;
            float right = width;
            float bottom = height - y;
            canvas.drawRect(left, top, right, bottom, mPaint);
            x = x + divisionFactor;
            y = y + divisionFactor;
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    protected boolean onLevelChange(int level) {
        invalidateSelf();
        return true;
    }
}
