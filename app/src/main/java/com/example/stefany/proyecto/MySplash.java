package com.example.stefany.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MySplash extends Activity {
    private ProgressBar prgBar;

    private int prgBarStatus = 0;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_my_splash );

        prgBar = (ProgressBar) findViewById(R.id.prgBar);

        new Thread (new Runnable(){
            @Override
            public void run(){
                while (prgBarStatus < 100){
                    prgBarStatus++;
                    android.os.SystemClock.sleep(40);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            prgBar.setProgress(prgBarStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MySplash.this, MainActivity.class);
                        startActivity(intent);
                    }

                });
            }
        }).start();
    }
}
