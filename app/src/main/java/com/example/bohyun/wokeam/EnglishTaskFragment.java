package com.example.bohyun.wokeam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class EnglishTaskFragment extends android.support.v4.app.Fragment{

    private String questions [][] = {{"The team seemed _____ to my idea for the annual fundraiser.", "My mother went to Paris and brought home a(n) _____ of the Eiffel Tower", "Getting approved for a loan is almost _____ these days, eliminating the wait for many people.","In order to save on the budget we need to _____ on the extra things in life","The hippie movement of the 1960's brought many people together who were considered _____ in society.", "The _____ number of people allowed to ride this roller coaster is six, so you'll have to split up your group of twelve.","While trying to _____ my laughter during the dramatic play, I accidentally ended up snorting rather loudly.","The recent _____ means that my favorite vegetables will cost more unless the farmers can save some of the destroyed crop.", "The polar bear was _____ after swimming for days without a meal", "She divided the room with a _____ to allow more privacy."}};
    private String options [][][] = {{{"recede", "responsive", "relish", "gullible", "immense"},{"burly", "bumbling", "replica", "subsequent", "sabotage"},{"optional", "perishable", "scour", "instantaneous", "pry"},{"impact","ovation","skimp","abominable","deter"},{"dawdle","numb","dole","distort","eerie"},{"maximum","numb","depict","petty","arid"},{"ovation","disquieting","libel","bumbling","constrain"},{"gullible","blight","beacon","discredit","compliant"},{"famished","tribute","strand","parody","pantomime"},{"salvage","influence","idiom","partition","setback"}}};
    private String answers [][] = {{"responsive", "replica", "instantaneous","skimp","dawdle","maximum","constrain","blight","famished","partition"}};
    int diff = getDifficulty(1)-1;
    Random rand = new Random();
    int n = rand.nextInt(10);
    TextView button1;
    TextView button2;
    TextView button3;
    TextView button4;
    TextView button5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_english_task, container, false);
        TextView textView = (TextView) view.findViewById(R.id.question);
        textView.setText(questions[diff][n]);
        button1 = (TextView) view.findViewById(R.id.answer1);
        button1.setText(options[diff][n][0]);
        button1.setOnClickListener(mListener);
        button2 = (TextView) view.findViewById(R.id.answer2);
        button2.setText(options[diff][n][1]);
        button2.setOnClickListener(mListener);
        button3 = (TextView) view.findViewById(R.id.answer3);
        button3.setText(options[diff][n][2]);
        button3.setOnClickListener(mListener);
        button4 = (TextView) view.findViewById(R.id.answer4);
        button4.setText(options[diff][n][3]);
        button4.setOnClickListener(mListener);
        button5 = (TextView) view.findViewById(R.id.answer5);
        button5.setText(options[diff][n][4]);
        button5.setOnClickListener(mListener);

        generateEnglishTask(1);


        return view;
    }

    private final View.OnClickListener mListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.answer1:
                    Button b1 = view.findViewById(R.id.answer1);
                    if(b1.getText()==answers[diff][n]){
                        Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                        nextFragment(true);
                    }else{
                        nextFragment(false);
                    }
                    break;
                case R.id.answer2:
                    Button b2 = view.findViewById(R.id.answer2);
                    if(b2.getText()==answers[diff][n]){
                        Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                        nextFragment(true);
                    }else{
                        nextFragment(false);
                    }
                    break;
                case R.id.answer3:
                    Button b3 = view.findViewById(R.id.answer3);
                    if(b3.getText()==answers[diff][n]){
                        Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                        nextFragment(true);
                    }else{
                        nextFragment(false);
                    }
                    break;
                case R.id.answer4:
                    Button b4 = view.findViewById(R.id.answer4);
                    if(b4.getText()==answers[diff][n]){
                        Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                        nextFragment(true);
                    }else{
                        nextFragment(false);
                    }
                    break;
                case R.id.answer5:
                    Button b5 = view.findViewById(R.id.answer5);
                    if(b5.getText()==answers[diff][n]){
                        Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                        nextFragment(true);
                    }else{
                        nextFragment(false);
                    }

                    break;
            }
        }
    };




    public void generateEnglishTask(int level){
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
            Fragment shakeTaskFrg = new ShakeFragment();
            transaction.replace(R.id.main_container, shakeTaskFrg).commit();
        }else{ // create new english Fragment
            Toast.makeText(getActivity(),"Incorrect!", Toast.LENGTH_SHORT).show();
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            final Fragment engTaskFrg = new EnglishTaskFragment();
                            transaction1.replace(R.id.main_container, engTaskFrg).commit();
                        }
                    },
                    3000
            );

        }
    }

}