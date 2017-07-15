package com.administrador.chronometerandroid.activities;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.administrador.chronometerandroid.R;
import com.administrador.chronometerandroid.adapters.LapsAdapter;
import com.administrador.chronometerandroid.model.ElemntListLaps;
import com.administrador.chronometerandroid.activities.BaseActivity.*;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.administrador.chronometerandroid.Constans.MILLIS_SECUND;
import static com.administrador.chronometerandroid.Constans.MINUTES_BASE;
import static com.administrador.chronometerandroid.R.*;

public class MainActivity extends BaseActivity {
    Long starTime = 0L, timeInMilleseconds = 0L, timeSwapBuff = 0L, updateTime = 0L;
  // ListView LapsListView;
    ArrayList<ElemntListLaps> arrayLaps,invArrayLaps;
    @BindView(id.btn_strat) Button btn_start;
    @BindView(id.btn_pause) Button btn_pause;
    @BindView(id.btn_laps) Button btn_laps;
    @BindView(id.btn_stop) Button btn_stop;
    @BindView(id.elemntinview) ListView LapsListView;
    @BindView(id.timerValue) TextView txtTimer;

  //  TextView txtTimer;
    Handler custonHandler = new Handler();
    // LinearLayout container;

    int contLaps;
    String dscLaps;




    Runnable updateTimeThread = new Runnable() {
        @Override
        public void run() {
            timeInMilleseconds = SystemClock.uptimeMillis() - starTime;
            updateTime = timeSwapBuff + timeInMilleseconds;

            int secs = (int)((updateTime/MILLIS_SECUND));
            int mins = secs/MINUTES_BASE;
            secs %= MINUTES_BASE;
            int millisecunds = (int) (updateTime%MILLIS_SECUND);
            txtTimer.setText(""+ String.format("%02d",mins) + ":" + String.format("%02d",secs)+ ":" + String.format("%03d", millisecunds));
            custonHandler.postDelayed(this,0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        ButterKnife.bind(this);
        //btn_start = (Button) findViewById(R.id.btn_strat);
        //btn_stop = (Button) findViewById(id.btn_stop);
        //btn_pause = (Button) findViewById(id.btn_pause);
        //btn_laps = (Button) findViewById(id.btn_laps);
       // LapsListView = (ListView) findViewById(id.elemntinview);
         arrayLaps = new ArrayList<ElemntListLaps>();
        //txtTimer.setTextColor(Color.parseColor("#FFFFFF"));

    //    txtTimer = (TextView) findViewById(id.timerValue);
        // txtTimer = (TextView) findViewById(R.id.timerValue);

        //container = (LinearLayout) findViewById(R.id.container);

       /* btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starTime = SystemClock.uptimeMillis();
                custonHandler.postDelayed(updateTimeThread,0);
                txtTimer.clearAnimation();
                txtTimer.setTextColor(Color.parseColor("#00FF00"));
            }
        });+*/





/*


        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeSwapBuff += timeInMilleseconds;
                custonHandler.removeCallbacks(updateTimeThread);
                txtTimer.setTextColor(Color.parseColor("#FF0000"));
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50); //You can manage the time of the blink with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                txtTimer.startAnimation(anim);

            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                custonHandler.removeCallbacks(updateTimeThread);
                starTime = 0L;
                timeInMilleseconds = 0L;
                timeSwapBuff = 0L;
                updateTime = 0L;
                txtTimer.clearAnimation();
                txtTimer.setTextColor(Color.parseColor("#0000FF"));

            }
        });


        btn_laps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invArrayLaps = new ArrayList<ElemntListLaps>();
                contLaps  = contLaps + 1;
                dscLaps = "Vuelta: ";

                arrayLaps.add(new ElemntListLaps(contLaps,dscLaps, (String) txtTimer.getText()));
                if (arrayLaps.size()>= 2){
                    int index = 0;
                    for (int i = arrayLaps.size()-1; i > -1; i -= 1) {
                        invArrayLaps.add(arrayLaps.get(i));
                    }
                    LapsAdapter midaptador = new LapsAdapter(MainActivity.this,invArrayLaps);
                    LapsListView.setAdapter(midaptador);

                }else {

                    LapsAdapter midaptador = new LapsAdapter(MainActivity.this, arrayLaps);
                    LapsListView.setAdapter(midaptador);
                }


            }
        });
*/


    }


    @OnClick (R.id.btn_strat)
    protected  void btn_strClick(){
        starTime = SystemClock.uptimeMillis();
        custonHandler.postDelayed(updateTimeThread,0);
        txtTimer.clearAnimation();
        txtTimer.setTextColor(Color.parseColor("#00FF00"));

    }

    @OnClick (R.id.btn_pause)
    protected  void btn_pauseClick(){
        timeSwapBuff += timeInMilleseconds;
        custonHandler.removeCallbacks(updateTimeThread);
        txtTimer.setTextColor(Color.parseColor("#FF0000"));
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(50); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        txtTimer.startAnimation(anim);

    }


    @OnClick (R.id.btn_laps)
    protected  void btn_lapsClick(){
        invArrayLaps = new ArrayList<ElemntListLaps>();
        contLaps  = contLaps + 1;
        dscLaps = "Vuelta: ";

        arrayLaps.add(new ElemntListLaps(contLaps,dscLaps, (String) txtTimer.getText()));
        if (arrayLaps.size()>= 2){
            int index = 0;
            for (int i = arrayLaps.size()-1; i > -1; i -= 1) {
                invArrayLaps.add(arrayLaps.get(i));
            }

            invArrayLaps = reverseListArray(arrayLaps);

            LapsAdapter midaptador = new LapsAdapter(MainActivity.this,invArrayLaps);
            LapsListView.setAdapter(midaptador);

        }else {

            LapsAdapter midaptador = new LapsAdapter(MainActivity.this, arrayLaps);
            LapsListView.setAdapter(midaptador);
        }
    }

    @OnClick (R.id.btn_stop)
    protected  void stopClick(){
        custonHandler.removeCallbacks(updateTimeThread);
        starTime = 0L;
        timeInMilleseconds = 0L;
        timeSwapBuff = 0L;
        updateTime = 0L;
        txtTimer.clearAnimation();
        txtTimer.setTextColor(Color.parseColor("#0000FF"));
    }

}
