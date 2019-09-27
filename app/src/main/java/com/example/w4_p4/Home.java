package com.example.w4_p4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.content.Intent;
import android.view.View;

public class Home extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    private GestureDetector detector;
    public static final String H = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        detector = new GestureDetector(this,this);
    }

    @Override
    public boolean onTouchEvent( MotionEvent event) {
        detector.onTouchEvent(event);
        Log.i(H,"isTouch");
        return true;
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
        float vFling = 1000;
        float vDiff = 800;
        float vx = Math.abs(v);
        float vy = Math.abs(v1);
        float vmax = vx;
        Log.i(H,"isFling");
        if(vmax < vy) {
            vmax = vy;
        }
        if(vmax > vFling && Math.abs(vx - vy) > vDiff){
            if(vx > vy){
                if(v > 0){//east
                    Log.i(H,"East");
                    startActivity(new Intent(Home.this, East.class));
                }
                else{//west
                    Log.i(H,"West");
                    startActivity(new Intent(Home.this, West.class));
                }
            }
            else if(vx < vy){//north
                if(v1 < 0){
                    Log.i(H,"North");
                    startActivity(new Intent(Home.this, North.class));
                }
                else{//south
                    Log.i(H,"South");
                    startActivity(new Intent(Home.this, South.class));
                }
            }
        }
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
