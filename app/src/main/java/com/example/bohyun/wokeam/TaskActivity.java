package com.example.bohyun.wokeam;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    private Fragment magicFrg;
    private Fragment shakeTaskFrg;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        mathTaskFrg = new MathTaskFragment();
        engTaskFrg = new EnglishTaskFragment();
        simonSaysTaskFrg = new SimonTaskFragment();
        sudokuTaskFrg = new SudokuFragment();
        magicFrg = new MagicFragment();
        shakeTaskFrg = new ShakeFragment();


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(TaskActivity.this);
        String value = preferences.getString("Difficulty", "3,3,3,3,3,3");
        String[] list = value.split(",");
//        Toast.makeText(TaskActivity.this, "Tasks: " + list[0]+" " + list[1]+" " + list[2]+" " + list[3]+" " + list[4]+" " + list[5], Toast.LENGTH_SHORT).show();
        if(Integer.parseInt(list[0]) != 3){
            selectedfrg = mathTaskFrg;
        }else if(!list[1].equals("3")){
            selectedfrg = engTaskFrg;
        }else if(!list[2].equals("3")){
            selectedfrg = simonSaysTaskFrg;
        }else if(!list[3].equals("3")){
            selectedfrg = sudokuTaskFrg;
        }else if(!list[4].equals("3")){
            selectedfrg = magicFrg;
        }else if(!list[5].equals("3")){
            selectedfrg = shakeTaskFrg;
        }

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, selectedfrg).commit();
    }
}
