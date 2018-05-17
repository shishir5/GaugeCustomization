package com.paras.gaugecustomization.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;

/**
 * Created by Paras on 16/05/18.
 */
public class SegmentedSeekBar extends AppCompatSeekBar {

    private Paint mProgressPaint;

    public SegmentedSeekBar(Context context) {
        super(context);
        init();
    }

    public SegmentedSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SegmentedSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mProgressPaint = new Paint();
        mProgressPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mProgressPaint.setColor(Color.WHITE);
        mProgressPaint.setStrokeWidth(4.0f);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int yCentre = getHeight() / 2;
        int width = getMinimumHeight()/ 2;

        int pos;
        float div = (getWidth() - getPaddingRight() - getPaddingLeft()) / (getMax());

        for (int i = 1; i < getMax(); i++) {
            pos = (int) (div * i) + getPaddingLeft();
            canvas.drawLine(
                    pos + 1.0f,
                    yCentre - width + 1.0f,
                    pos + 1.0f,
                    yCentre + width - 1.0f,
                    mProgressPaint);
        }
    }
}
