package com.example.bohyun.wokeam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class TaskActivity extends AppCompatActivity {
    private Fragment selectedfrg;
    private Fragment mathTaskFrg;
    private Fragment engTaskFrg;
    private Fragment simonSaysTaskFrg;
    private Fragment sudokuTaskFrg;
    private Fragment magicSquareTaskFrg;
    private Fragment shakeTaskFrg;

    private FragmentManager fragmentManager;

    public int[] tasks = new int[] {0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        shakeTaskFrg = new ShakeFragment();
        mathTaskFrg = new MathTaskFragment();

        selectedfrg = mathTaskFrg;

        //Daily View || Start View
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, selectedfrg).commit();

    }
}
