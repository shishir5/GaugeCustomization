package com.paras.gaugecustomization.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.paras.gaugecustomization.R;
import com.paras.gaugecustomization.indicators.ImageIndicator;
import com.paras.gaugecustomization.views.Speedometer;

/**
 * Created by Paras on 15/05/18.
 */
public class ManualGaugeActivity extends AppCompatActivity {

    private Speedometer mSpeedoMeter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_gauge);
        init();
        setImageIndicator();
    }

    private void init() {
        mSpeedoMeter = findViewById(R.id.speedometer);
        mSpeedoMeter.speedPercentTo(50);
        mSpeedoMeter.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        int angle = (int) (Math.toDegrees(Math.atan2(v.getHeight() * .5f - event.getY(), v.getWidth() * .5f - event.getX()))) + 180;
                        mSpeedoMeter.setSpeedAt(mSpeedoMeter.getSpeedAtDegree(angle));
                        Toast.makeText(ManualGaugeActivity.this, mSpeedoMeter.getSpeedAtDegree(angle) + "", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return true;
            }
        });
    }

    private void setImageIndicator() {
        ImageIndicator imageIndicator = new ImageIndicator(getApplicationContext(), R.drawable.needle
                , (int) mSpeedoMeter.dpTOpx(50), (int) mSpeedoMeter.dpTOpx(150));
        mSpeedoMeter.setIndicator(imageIndicator);
    }
}
