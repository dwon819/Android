package org.techtown.sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    private static final String TAG = "MyActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                float curX=motionEvent.getX();
                float curY=motionEvent.getY();

                if(action==MotionEvent.ACTION_DOWN){
                    println("손가락 눌림: "+curX+","+curY);
                    Log.i(TAG,"눌림");
                }else if (action==MotionEvent.ACTION_MOVE){
                    println("손가락 움직임: "+curX+","+curY);
                    Log.i(TAG,"움직임");
                }else if(action== motionEvent.ACTION_UP){
                    println("손가락 뗌: "+curX+","+curY);
                    Log.i(TAG,"땜");
                }
                return true;
            }
        });

    }

    public void println(String data){
        textView.append(data+"\n");
    }
}
