package com.example.bohyun.wokeam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
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
        red = (ImageButton) view.findViewById(R.id.red);
        red.setOnClickListener(mListener);
        blue = (ImageButton) view.findViewById(R.id.blue);
        blue.setOnClickListener(mListener);
        yellow = (ImageButton) view.findViewById(R.id.yellow);
        yellow.setOnClickListener(mListener);
        green = (ImageButton) view.findViewById(R.id.green);
        green.setOnClickListener(mListener);
        start = (Button) view.findViewById(R.id.start);
        start.setOnClickListener(mListener);
        start.setEnabled(true);


        generateSimonTask(1);


        return view;
    }


    private final View.OnClickListener mListener = new View.OnClickListener() {
        public void onClick(View view) {

            if(view.getId()==R.id.start){
                start.setEnabled(false);
                if (difficulty == 1){
                    end = 7;
                    sequence = sequence1.clone();
                }
                if (difficulty == 2){
                    end = 11;
                    sequence = sequence2.clone();
                }
                if (difficulty == 3){
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
                            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
                            nextFragment(true);
                        }
                        if(isCorrect==false) {
                            nextFragment(false);
                        }
                    }
                }
            }



//            int i;
//            for(i=0; i<8;) {
//                if (view.getId() == R.id.red) {
//                    answer.add(1);
//                    answer.add(0);
//                }
//                if (view.getId() == R.id.blue) {
//                    answer.add(2);
//                    answer.add(0);
//                }
//                if (view.getId() == R.id.yellow) {
//                    answer.add(3);
//                    answer.add(0);
//                }
//                if (view.getId() == R.id.green) {
//                    answer.add(4);
//                    answer.add(0);
//                }
//            }


        }
    };






    public void generateSimonTask(int level){
        if(level == 1){
        }else if(level == 2){

        }else if(level == 3){

        }else{

        }
    }

    public int getDifficulty(int task){
        if(task == 1){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void nextFragment(boolean check) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        final FragmentTransaction transaction1 = fragmentManager.beginTransaction();
        if (check) {
            Fragment turnOffFrg = new TurnOffAlarmFragment();
            transaction.replace(R.id.main_container, turnOffFrg).commit();
        }else{ // create new english Fragment
            Toast.makeText(getActivity(),"Incorrect!", Toast.LENGTH_SHORT).show();
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

}