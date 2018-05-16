package com.paras.gaugecustomization.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;

import com.paras.gaugecustomization.R;

public class DigitalGauge2 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activi ty_gauge2);
        init();
    }

    private void init() {

    }

    public int dpToPixels(int i) {
        return (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());
    }
}