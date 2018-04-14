package com.example.bohyun.wokeam;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class MathTaskFragment extends android.support.v4.app.Fragment {
    private int operand1;
    private int operand2;
    private Button enterBtn;
    private Button regenBtn;
    int answer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_math_task, container, false);

        regenBtn = view.findViewById(R.id.btn_regen);
        regenBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Implement 'disable edit text for 5 sec'
                Toast.makeText(getActivity().getApplicationContext(), "5 second penalty", Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Fragment mathTaskFrg = new MathTaskFragment();
                transaction.replace(R.id.main_container, mathTaskFrg).commit();
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
                    Toast.makeText(getActivity().getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                    nextFragment(true);
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
                    nextFragment(false);
                }
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Random rand = new Random();
        operand1 = rand.nextInt(90) + 10;
        operand2 = rand.nextInt(90) + 10;
        answer = operand1 + operand2;

        TextView operand11 = getView().findViewById(R.id.operand1);
        TextView operand22 = getView().findViewById(R.id.operand2);
        operand11.setText(String.valueOf(operand1));
        operand22.setText(String.valueOf(operand2));
    }

    public void nextFragment(boolean check) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (check) {
            Fragment engTaskFrg = new EnglishTaskFragment();
            transaction.replace(R.id.main_container, engTaskFrg).commit();
        }else{
            Fragment mathTaskFrg = new MathTaskFragment();
            transaction.replace(R.id.main_container, mathTaskFrg).commit();
        }
    }
}