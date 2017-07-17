package com.administrador.chronometerandroid.activities;
import android.os.Parcelable;
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

import static com.administrador.chronometerandroid.Constans.COLOR_STATE_PAUSE;
import static com.administrador.chronometerandroid.Constans.COLOR_STATE_START;
import static com.administrador.chronometerandroid.Constans.COLOR_STATE_STOP;
import static com.administrador.chronometerandroid.Constans.INITIAL_VALUE_TIMER;
import static com.administrador.chronometerandroid.Constans.MILLIS_SECUND;
import static com.administrador.chronometerandroid.Constans.MINUTES_BASE;
import static com.administrador.chronometerandroid.R.*;

public class MainActivity extends BaseActivity {
    Long starTime = 0L, timeInMilleseconds = 0L, timeSwapBuff = 0L, updateTime = 0L;
    Long starTimeTemp;
    int contLaps;
    String dscLaps;
    boolean btn_strat_state, btn_pause_state, btn_laps_state, btn_stop_state;

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

         arrayLaps = new ArrayList<ElemntListLaps>();
      }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putSerializable("arrayLaps",arrayLaps);
        outState.putBoolean("btn_pause_state",btn_pause_state);
        outState.putBoolean("btn_stop_state",btn_stop_state);
        outState.putBoolean("btn_strat_state",btn_strat_state);
        outState.putInt("contLaps",contLaps);
        outState.putLong("timeSwapBuff",timeSwapBuff);
        outState.putLong("timeInMilleseconds", timeInMilleseconds);
        outState.putLong("starTime", starTime);
        outState.putString("txtTimer",txtTimer.getText().toString());


        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ArrayList<ElemntListLaps> invArrayLapss = new ArrayList<ElemntListLaps>();
        String txtTimerTemp;

        arrayLaps = (ArrayList<ElemntListLaps>) savedInstanceState.getSerializable("arrayLaps");

        btn_pause_state = savedInstanceState.getBoolean("btn_pause_state");
        btn_stop_state = savedInstanceState.getBoolean("btn_stop_state");
        btn_strat_state = savedInstanceState.getBoolean("btn_strat_state");
        contLaps = savedInstanceState.getInt("contLaps");


        starTimeTemp = savedInstanceState.getLong("starTime");
        timeSwapBuff = savedInstanceState.getLong("timeSwapBuff");
        timeInMilleseconds = savedInstanceState.getLong("timeInMilleseconds");


        if((arrayLaps.size()> 0 && arrayLaps != null)){

            invArrayLapss = reverseListArray(arrayLaps);
            LapsAdapter midaptador = new LapsAdapter(MainActivity.this,invArrayLapss);
            LapsListView.setAdapter(midaptador);
        }

        if (btn_strat_state){

            starTime = starTimeTemp.longValue();
            custonHandler.postDelayed(updateTimeThread,0);
            btn_start.setEnabled(false);
            btn_pause_state = false;
            btn_stop_state = false;
            btn_strat_state = true;
            btn_pause.setEnabled(true);
            btn_laps.setEnabled(true);
            txtTimer.clearAnimation();
            txtTimer.setTextColor(Color.parseColor("#00FF00"));
        }

        if (btn_pause_state){

            starTime = starTimeTemp.longValue();
            txtTimer.setText(savedInstanceState.getString("txtTimer"));
            txtTimer.setTextColor(Color.parseColor("#FF0000"));
            Animation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(50); //You can manage the time of the blink with this parameter
            anim.setStartOffset(20);
            anim.setRepeatMode(Animation.REVERSE);
            anim.setRepeatCount(Animation.INFINITE);
            txtTimer.startAnimation(anim);
            btn_start.setEnabled(true);

        }

        if(btn_stop_state){

            contLaps = 0;
            btn_start.setEnabled(true);
            btn_stopClick();


        }

        super.onRestoreInstanceState(savedInstanceState);
    }


    @OnClick (R.id.btn_strat)
    protected  void btn_strClick(){
        btn_pause_state = false;
        btn_stop_state = false;
        btn_strat_state = true;
        btn_pause.setEnabled(true);
        btn_laps.setEnabled(true);
        btn_start.setEnabled(false);
        starTime = SystemClock.uptimeMillis();
        custonHandler.postDelayed(updateTimeThread, 0);
        txtTimer.clearAnimation();
        txtTimer.setTextColor(Color.parseColor(COLOR_STATE_START));

    }

    @OnClick (R.id.btn_pause)
    protected  void btn_pauseClick(){
        btn_pause_state = true;
        btn_stop_state = false;
        btn_strat_state = false;
        btn_start.setEnabled(true);
        timeSwapBuff += timeInMilleseconds;
        custonHandler.removeCallbacks(updateTimeThread);
        txtTimer.setTextColor(Color.parseColor(COLOR_STATE_PAUSE));
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

            invArrayLaps = reverseListArray(arrayLaps);

            LapsAdapter midaptador = new LapsAdapter(MainActivity.this,invArrayLaps);
            LapsListView.setAdapter(midaptador);

        }else {

            LapsAdapter midaptador = new LapsAdapter(MainActivity.this, arrayLaps);
            LapsListView.setAdapter(midaptador);
        }
    }

    @OnClick (R.id.btn_stop)
    protected  void btn_stopClick(){
        custonHandler.removeCallbacks(updateTimeThread);
        btn_pause_state = false;
        btn_stop_state = true;
        btn_strat_state = false;
        starTime = 0L;
        contLaps = 0;
        timeInMilleseconds = 0L;
        timeSwapBuff = 0L;
        updateTime = 0L;
        txtTimer.clearAnimation();
        txtTimer.setText(INITIAL_VALUE_TIMER);
        txtTimer.setTextColor(Color.parseColor(COLOR_STATE_STOP));
        btn_pause.setEnabled(false);
        btn_laps.setEnabled(false);
        btn_start.setEnabled(true);

        if (arrayLaps.size() > 0)
        {
            arrayLaps.clear();
            LapsAdapter midaptador = new LapsAdapter(MainActivity.this,arrayLaps);
            LapsListView.setAdapter(midaptador);

        }




    }

}
