package com.example.bohyun.wokeam;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

public class TaskActivity extends AppCompatActivity {
    private Fragment selectedfrg;
    private Fragment mathTaskFrg;
    private Fragment shakeTaskFrg;
    private FragmentManager fragmentManager;

    public int[] tasks = new int[] {0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        mathTaskFrg = new MathTaskFragment();
        shakeTaskFrg = new ShakeFragment();
        selectedfrg = mathTaskFrg;
        selectedfrg = shakeTaskFrg;

        //Daily View || Start View
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, selectedfrg).commit();



    }
    


}
