package com.example.bohyun.wokeam;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MathTaskFragment extends android.support.v4.app.Fragment {
    private int operand1;
    private int operand2;
    private Button enterBtn;
    private Button regenBtn;
    private TextView operator;
    private TextView operand11;
    private TextView operand22;
    int answer;

    private View view;
    private Fragment selectedfrg;
    private int difficulty = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_math_task, container, false);

        regenBtn = view.findViewById(R.id.btn_regen);
        regenBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"New Question!", Toast.LENGTH_SHORT).show();
                nextFragment(false);
            }
        });

        enterBtn = view.findViewById(R.id.btn_submit);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)getActivity().findViewById(R.id.answer);
                editText.setEnabled(false);
                editText.setCursorVisible(false);
                editText.setKeyListener(null);

                String userAnswer = editText.getText().toString();
                if(userAnswer.compareTo(String.valueOf(answer))==0){
//                    Toast.makeText(getActivity().getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                    nextFragment(true);
                }else{
                    Toast.makeText(getActivity(),"Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                    nextFragment(false);
                }
            }
        });

        operand11 = view.findViewById(R.id.operand1);
        operand22 = view.findViewById(R.id.operand2);
        operator = view.findViewById(R.id.operator);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String value = preferences.getString("Difficulty", "Not Selected");
        String[] list = value.split(",");
        if(list[0].equals("0")){
            difficulty=1;
            generateQuestion(difficulty);
        } else if(list[0].equals("1")) {
            difficulty = 2;
            generateQuestion(difficulty);
        } else if(list[0].equals("2")) {
            difficulty = 3;
            generateQuestion(difficulty);
        }

        return view;
    }

    public void generateQuestion(int level){
        if(level==1){
            Random rand = new Random();
            operand1 = rand.nextInt(90) + 10;
            operand2 = rand.nextInt(90) + 10;
            answer = operand1 + operand2;

            operand11.setText(String.valueOf(operand1));
            operand22.setText(String.valueOf(operand2));

        }else if(level==2){
            Random rand = new Random();
            operand1 = rand.nextInt(90) + 10;
            operand2 = rand.nextInt(90) + 10;
            while(operand1 < operand2){
                rand = new Random();
                operand1 = rand.nextInt(90) + 10;
                operand2 = rand.nextInt(90) + 10;
            }
            operator.setText(" - ");
            answer = operand1 - operand2;

            operand11.setText(String.valueOf(operand1));
            operand22.setText(String.valueOf(operand2));

        }else if(level==3){
            Random rand = new Random();
            operand1 = rand.nextInt(50);
            operand2 = rand.nextInt(50);

            operator.setText(" × ");
            answer = operand1 * operand2;

            operand11.setText(String.valueOf(operand1));
            operand22.setText(String.valueOf(operand2));
        }
    }

    public void nextFragment(boolean check) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        final FragmentTransaction transaction1 = fragmentManager.beginTransaction();
        if (check) {
            checkNextTask();
        }else{
            enterBtn.setEnabled(false);
            regenBtn.setEnabled(false);
            backButtonDisable(view);
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            final Fragment mathTaskFrg = new MathTaskFragment();
                            transaction1.replace(R.id.main_container, mathTaskFrg).commit();
                        }
                    },
                    3000
            );
        }
    }

    public void backButtonDisable(View view){
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i("test", "keyCode: " + keyCode);
                if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    Log.i("test", "onKey Back listener is working!!!");
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                }

                return false;
            }
        });
    }

    public void checkNextTask(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String value = preferences.getString("Difficulty", "Not Selected");
        String[] list = value.split(",");

        if(!list[1].equals("3")){
            selectedfrg = new EnglishTaskFragment();
        }else if(!list[2].equals("3")){
            selectedfrg = new SimonTaskFragment();
        }else if(!list[3].equals("3")){ //sudoku
            selectedfrg = new MagicFragment();
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
}