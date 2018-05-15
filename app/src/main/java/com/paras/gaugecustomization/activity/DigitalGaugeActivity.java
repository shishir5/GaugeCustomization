package com.paras.gaugecustomization.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.ProgressBar;

import com.paras.gaugecustomization.R;
import com.paras.gaugecustomization.views.MyCustomDrawable;

/**
 * Created by Paras on 15/05/18.
 */
public class DigitalGaugeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_gauge);
        init();
    }

    private void init() {
        ProgressBar progressBar = findViewById(R.id.progressBar);
        int padding = dpToPixels(1);
        progressBar.setPadding(padding, padding, padding, padding);
        Drawable d = new MyCustomDrawable();
        progressBar.setProgressDrawable(d);
    }

    public int dpToPixels(int i) {
        return (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());

    }
}