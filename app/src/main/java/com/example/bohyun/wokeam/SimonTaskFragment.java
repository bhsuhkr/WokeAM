package com.example.bohyun.wokeam;


import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class SimonTaskFragment extends android.support.v4.app.Fragment{
    ImageButton red;
    ImageButton green;
    ImageButton yellow;
    ImageButton blue;
    Button start;
    Random random = new Random();
    Boolean sequenceDone;
    Fragment selectedfrg;
    boolean isCorrect;
    int difficulty = 1;
    int end;
    public Integer[] sequence;
    public Integer[] sequence1 = {

            random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0

    };
    public Integer[] sequence2 = {

            random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0

    };
    public Integer[] sequence3 = {

            random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0, random.nextInt(4)+1, 0

    };
    List<Integer> answer = new ArrayList<Integer>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sequenceDone = false;
        View view = inflater.inflate(R.layout.fragment_simon_task, container, false);
        red = view.findViewById(R.id.red);
        red.setOnClickListener(mListener);
        blue = view.findViewById(R.id.blue);
        blue.setOnClickListener(mListener);
        yellow = view.findViewById(R.id.yellow);
        yellow.setOnClickListener(mListener);
        green = view.findViewById(R.id.green);
        green.setOnClickListener(mListener);
        start = view.findViewById(R.id.start);
        start.setOnClickListener(mListener);
        start.setEnabled(true);

        return view;
    }


    private final View.OnClickListener mListener = new View.OnClickListener() {
        public void onClick(View view) {

            if(view.getId()==R.id.start){
                start.setEnabled(false);

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String value = preferences.getString("Difficulty", "Not Selected");
                String[] list = value.split(",");

                if (list[2].equals("0")){
                    end = 7;
                    sequence = sequence1.clone();
                }
                if (list[2].equals("1")){
                    end = 11;
                    sequence = sequence2.clone();
                }
                if (list[2].equals("2")){
                    end = 15;
                    sequence = sequence3.clone();
                }

                final Handler handler = new Handler();
                Runnable runnable = new Runnable()
                {
                    int i = 0;

                    public void run()
                    {
                        if(i==end){
                            red.setImageResource(R.drawable.red_circle);
                            blue.setImageResource(R.drawable.blue_circle);
                            yellow.setImageResource(R.drawable.yellow_circle);
                            green.setImageResource(R.drawable.green_circle);
                            sequenceDone = true;
                            return;
                        }
                        if(sequence[i]==0){
                            red.setImageResource(R.drawable.red_circle);
                            blue.setImageResource(R.drawable.blue_circle);
                            yellow.setImageResource(R.drawable.yellow_circle);
                            green.setImageResource(R.drawable.green_circle);
                        }
                        if(sequence[i]==1)
                            red.setImageResource(R.drawable.red_circle_lit);
                        if(sequence[i]==2)
                            blue.setImageResource(R.drawable.blue_circle_lit);
                        if(sequence[i]==3)
                            yellow.setImageResource(R.drawable.yellow_circle_lit);
                        if(sequence[i]==4)
                            green.setImageResource(R.drawable.green_circle_lit);

                        i++;
                        handler.postDelayed(this, 500);
                    }

                };
                handler.postDelayed(runnable, 1000); // for initial delay..
            }

            if(view.getId()==R.id.red){
                if(sequenceDone == true){
                    answer.add(1);
                    answer.add(0);
                    if(answer.size()==sequence.length) {
                        isCorrect = true;
                        for (int i = 0; i < answer.size(); i++) {
                            if (answer.get(i) != sequence[i])
                                isCorrect = false;
                        }
                        if(isCorrect==true) {
                            nextFragment(true);
                        }
                        if(isCorrect==false) {
                            nextFragment(false);
                        }
                    }
                }
            }
            if(view.getId()==R.id.blue){
                if(sequenceDone == true){
                    answer.add(2);
                    answer.add(0);
                    if(answer.size()==sequence.length){
                        isCorrect = true;
                        for (int i = 0; i < answer.size(); i++) {
                            if (answer.get(i) != sequence[i])
                                isCorrect = false;
                        }
                        if(isCorrect==true) {
                            nextFragment(true);
                        }
                        if(isCorrect==false) {
                            nextFragment(false);
                        }
                    }
                }
            }

            if(view.getId()==R.id.yellow){
                if(sequenceDone == true){
                    answer.add(3);
                    answer.add(0);
                    if(answer.size()==sequence.length){
                        isCorrect = true;
                        for (int i = 0; i < answer.size(); i++) {
                            if (answer.get(i) != sequence[i])
                                isCorrect = false;
                        }
                        if(isCorrect==true) {
                            nextFragment(true);
                        }
                        if(isCorrect==false) {
                            nextFragment(false);
                        }
                    }
                }
            }

            if(view.getId()==R.id.green){
                if(sequenceDone == true){
                    answer.add(4);
                    answer.add(0);
                    if(answer.size()==sequence.length){
                        isCorrect = true;
                        for (int i = 0; i < answer.size(); i++) {
                            if (answer.get(i) != sequence[i])
                                isCorrect = false;
                        }
                        if(isCorrect==true) {
                            nextFragment(true);
                        }
                        if(isCorrect==false) {
                            nextFragment(false);
                        }
                    }
                }
            }

        }
    };

    public void nextFragment(boolean check) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        final FragmentTransaction transaction1 = fragmentManager.beginTransaction();
        if (check) {
            goNextTask();
        }else{ // create new english Fragment
            Toast.makeText(getActivity(),"Incorrect! Try again.", Toast.LENGTH_SHORT).show();
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            final Fragment simonTaskFrg = new SimonTaskFragment();
                            transaction1.replace(R.id.main_container, simonTaskFrg).commit();
                        }
                    },
                    3000
            );

        }
    }

    public void goNextTask(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String value = preferences.getString("Difficulty", "Not Selected");
        String[] list = value.split(",");

        if(!list[3].equals("3")){
            selectedfrg = new SudokuFragment();
        }else if(!list[4].equals("3")){
            selectedfrg = new MagicFragment();
        }else if(!list[5].equals("3")){
            selectedfrg = new ShakeFragment();
        }else{
            selectedfrg = new TurnOffAlarmFragment();
        }

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, selectedfrg).commit();
    }

    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(final View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe036b2c0, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                v.getBackground().clearColorFilter();
                                v.invalidate();
                            }
                        }, 100L);
                        break;
                    }
                }
                return false;
            }

        });
    }
}