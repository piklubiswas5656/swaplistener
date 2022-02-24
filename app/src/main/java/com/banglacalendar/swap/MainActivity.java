package com.banglacalendar.swap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private static final String TAG = "Swap Position";
    private float x1, x2, y1, y2;
    private static int MIN_DISTANCE;
    GestureDetector gestureDetector;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        //initialise gesturedetector
        gestureDetector = new GestureDetector(getApplicationContext(), this);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gestureDetector.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();

                //getting value for horizontal swap
                float valueX = x2 - x1;
                //getting value for vertical swap
                float valueY = y2 - y1;


                //For left and right swap
                if (Math.abs(valueX) > MIN_DISTANCE) {
                    //detect left to right swap
                    if (x2 > x1) {
                       textView.setText("right swap");
                    }
                    //detect right to left swap
                    else {
                        textView.setText("left swap");
                    }

                }
                //For up and down swap
                else if (Math.abs(valueY) > MIN_DISTANCE) {
                    // detect top to bottom swap
                    if (y2 > y1) {
                        textView.setText("Botton");
                    }
                    //detect bottom to top swap
                    else {
                        textView.setText("up");
                    }
                }


        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}