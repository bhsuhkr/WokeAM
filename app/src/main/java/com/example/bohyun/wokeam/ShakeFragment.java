package com.example.bohyun.wokeam;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ShakeFragment extends android.support.v4.app.Fragment  {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    private ProgressBar progressBar;
    private int count1 = 0;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shake_task, container, false);

        progressBar = view.findViewById(R.id.progressBarId);
        //Long operation by thread


        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake(int count) {
                count++;
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                String value = preferences.getString("Difficulty", "3");
                String[] list = value.split(",");
                if(list[5].equals("0")){
                    progressStatus += 16;
                    progressBar.setProgress(progressStatus);
                } else if(list[5].equals("1")){
                    progressStatus += 7;
                    progressBar.setProgress(progressStatus);
                } else if(list[5].equals("2")){
                    progressStatus += 5;
                    progressBar.setProgress(progressStatus);
                }

                if(list[5].equals("0") && count >= 7) {
                    nextFragment();
                } else if(list[5].equals("1") && count >= 15){
                    nextFragment();
                }else if(list[5].equals("2") && count >= 21){
                    nextFragment();
                }
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    public void nextFragment() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment turnoffFrg = new TurnOffAlarmFragment();
        transaction.replace(R.id.main_container, turnoffFrg).commit();
    }
}
