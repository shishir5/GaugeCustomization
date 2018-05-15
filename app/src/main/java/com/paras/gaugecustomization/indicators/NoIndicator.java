package com.paras.gaugecustomization.indicators;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by Paras on 15/05/18.
 */
public class NoIndicator extends Indicator<NoIndicator> {

    public NoIndicator(Context context) {
        super(context);
    }

    @Override
    protected float getDefaultIndicatorWidth() {
        return 0f;
    }

    @Override
    public void draw(Canvas canvas, float degree) {
    }

    @Override
    protected void updateIndicator() {
    }

    @Override
    protected void setWithEffects(boolean withEffects) {
    }
}