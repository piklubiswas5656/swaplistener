package com.banglacalendar.swap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Swap extends AppCompatActivity {
    RelativeLayout relativeLayout;
    TextView swaptext;
    SwipeListener swipeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);
        relativeLayout = findViewById(R.id.Reletive_layout);
        swaptext = findViewById(R.id.swaptext);
        swipeListener = new SwipeListener(relativeLayout);

    }

    private class SwipeListener implements View.OnTouchListener {
        //initialize variable
        GestureDetector gestureDetector;

        //Create Constructor
        SwipeListener(View view) {
            //initialize threshold value
            int threshold = 100;
            int velocity_threshold = 100;
            //initialize simple gesture listener
            GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onDown(MotionEvent e) {
                    // return true value
                    return true;
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    //get x and y difference
                    float xDiff = e2.getX() - e1.getX();
                    float yDiff = e2.getY() - e1.getY();
                    try {
                        if (Math.abs(xDiff) > Math.abs(yDiff)) {
                            //When X is greater than y
                            if (Math.abs(xDiff) > threshold && Math.abs(velocityX) > velocity_threshold) {
                                //When X difference is greater then thereshold
                                //When X velocity is greater than velocity_thereshold
                                if (xDiff > 0) {
                                    //When swap right
                                    swaptext.setText("Swap Right");
                                } else {
                                    swaptext.setText("Swap Left");
                                }
                                return true;
                            }
                        } else {
                            //When y is quter than x
                            if (Math.abs(yDiff) > threshold && Math.abs(velocityY) > velocity_threshold) {
                                //When y difference is greater then thereshold
                                //When y velocity is greater than velocity_thereshold
                                if (yDiff > 0) {
                                    //When swap right
                                    swaptext.setText("Swap Down");
                                } else {
                                    swaptext.setText("Swap Up");
                                }
                                return true;
                            }
                        }


                    } catch (Exception e) {

                    }
                    return false;
                }
            };
            //initialize gesture detector
            gestureDetector = new GestureDetector(listener);
            //set listener on view
            view.setOnTouchListener(this);

        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            //return gesture even
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }
}