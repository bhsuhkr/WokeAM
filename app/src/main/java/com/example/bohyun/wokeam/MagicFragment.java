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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

public class MagicFragment extends android.support.v4.app.Fragment{

    private View view;
    private Fragment selectedfrg;

    //Easy
    private String question[] = {"2", "7", "6", "A", "5", "1", "4", "B", "8"};
    private String answer[] = {"2", "7", "6", "9", "5", "1", "4", "3", "8"};

    private String question1[] = {"8", "1", "6", "A", "5", "7", "4", "B", "2"};
    private String answer1[] = {"8", "1", "6", "3", "5", "7", "4", "9", "2"};

    //Medium
    private String mquestion[] = {"8", "11", "14", "1", "13", "A", "7", "12", "B", "16", "C", "6", "10", "5", "4", "15"};
    private String manswer[] = {"8", "11", "14", "1", "13", "2", "7", "12", "3", "16", "9", "6", "10", "5", "4", "15"};

    //Hard
    private String hquestion[] = {"23", "6", "19", "2", "15", "4", "A", "25", "8", "16", "B", "18", "1", "14", "22", "11", "C", "7", "20", "3", "17", "D", "13", "21", "9"};
    private String hanswer[] = {"23", "6", "19", "2", "15", "4", "12", "25", "8", "16", "10", "18", "1", "14", "22", "11", "24", "7", "20", "3", "17", "5", "13", "21", "9"};

    private int difficulty = 1;

    TextView button1;
    TextView button2;
    TextView button3;
    TextView button4;
    TextView button5;
    TextView button6;
    TextView button7;
    TextView button8;
    TextView button9;

    //Only used in Medium difficulty
    TextView button10;
    TextView button11;
    TextView button12;
    TextView button13;
    TextView button14;
    TextView button15;
    TextView button16;

    //Only used in Hard difficulty
    TextView button17;
    TextView button18;
    TextView button19;
    TextView button20;
    TextView button21;
    TextView button22;
    TextView button23;
    TextView button24;
    TextView button25;
    EditText Ans1;
    EditText Ans2;

    //Only used in Medium difficulty
    EditText Ans3;

    //Only used in Hard difficulty
    EditText Ans4;

    Button submit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String value = preferences.getString("Difficulty", "3,3,3,3,3,3");
        String[] list = value.split(",");
        if(list[4].equals("0")){
            difficulty=1;
        } else if(list[4].equals("1")) {
            difficulty = 2;
        } else if(list[4].equals("2")) {
            difficulty = 3;
        }
        view = inflater.inflate(R.layout.fragment_magic_task, container, false);
        if (difficulty == 1) {
            view = inflater.inflate(R.layout.fragment_magic_task, container, false);

            button1 = view.findViewById(R.id.magic1);
            button1.setText(question[0]);

            button2 = view.findViewById(R.id.magic2);
            button2.setText(question[1]);

            button3 = view.findViewById(R.id.magic3);
            button3.setText(question[2]);

            button4 = view.findViewById(R.id.magic4);
            button4.setText(question[3]);

            button5 = view.findViewById(R.id.magic5);
            button5.setText(question[4]);

            button6 = view.findViewById(R.id.magic6);
            button6.setText(question[5]);

            button7 = view.findViewById(R.id.magic7);
            button7.setText(question[6]);

            button8 = view.findViewById(R.id.magic8);
            button8.setText(question[7]);

            button9 = view.findViewById(R.id.magic9);
            button9.setText(question[8]);

            Ans1 = view.findViewById(R.id.magic10);
            Ans2 = view.findViewById(R.id.magic11);

            submit = view.findViewById(R.id.submit);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Ans1Text = Ans1.getText().toString();
                    String Ans2Text = Ans2.getText().toString();
                    if(Ans1Text.equals(answer[3]) && Ans2Text.equals(answer[7])){
                        nextFragment(true);
//                        Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        nextFragment(false);
                        Toast.makeText(getActivity(),"Incorrect! Try again.", Toast.LENGTH_SHORT).show();

                    }
                }
            });
            return view;
        }

        if (difficulty == 2) {
            view = inflater.inflate(R.layout.fragment_magic_taskm, container, false);

            button1 = view.findViewById(R.id.magic1);
            button1.setText(mquestion[0]);

            button2 = view.findViewById(R.id.magic2);
            button2.setText(mquestion[1]);

            button3 = view.findViewById(R.id.magic3);
            button3.setText(mquestion[2]);

            button4 = view.findViewById(R.id.magic4);
            button4.setText(mquestion[3]);

            button5 = view.findViewById(R.id.magic5);
            button5.setText(mquestion[4]);

            button6 = view.findViewById(R.id.magic6);
            button6.setText(mquestion[5]);

            button7 = view.findViewById(R.id.magic7);
            button7.setText(mquestion[6]);

            button8 = view.findViewById(R.id.magic8);
            button8.setText(mquestion[7]);

            button9 = view.findViewById(R.id.magic9);
            button9.setText(mquestion[8]);

            button10 = view.findViewById(R.id.magic10);
            button10.setText(mquestion[9]);

            button11 = view.findViewById(R.id.magic11);
            button11.setText(mquestion[10]);

            button12 = view.findViewById(R.id.magic12);
            button12.setText(mquestion[11]);

            button13 = view.findViewById(R.id.magic13);
            button13.setText(mquestion[12]);

            button14 = view.findViewById(R.id.magic14);
            button14.setText(mquestion[13]);

            button15 = view.findViewById(R.id.magic15);
            button15.setText(mquestion[14]);

            button16 = view.findViewById(R.id.magic16);
            button16.setText(mquestion[15]);


            Ans1 = view.findViewById(R.id.magic17);
            Ans2 = view.findViewById(R.id.magic18);
            Ans3 = view.findViewById(R.id.magic19);

            submit = view.findViewById(R.id.submit);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Ans1Text = Ans1.getText().toString();
                    String Ans2Text = Ans2.getText().toString();
                    String Ans3Text = Ans3.getText().toString();
                    if(Ans1Text.equals(manswer[5]) && Ans2Text.equals(manswer[8]) && Ans3Text.equals(manswer[10])){
                        nextFragment(true);
//                        Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        nextFragment(false);
                        Toast.makeText(getActivity(),"Incorrect! Try again.", Toast.LENGTH_SHORT).show();

                    }
                }
            });

            return view;
        }

        if (difficulty == 3) {
            view = inflater.inflate(R.layout.fragment_magic_taskh, container, false);

            button1 = view.findViewById(R.id.magic1);
            button1.setText(hquestion[0]);

            button2 = view.findViewById(R.id.magic2);
            button2.setText(hquestion[1]);

            button3 = view.findViewById(R.id.magic3);
            button3.setText(hquestion[2]);

            button4 = view.findViewById(R.id.magic4);
            button4.setText(hquestion[3]);

            button5 = view.findViewById(R.id.magic5);
            button5.setText(hquestion[4]);

            button6 = view.findViewById(R.id.magic6);
            button6.setText(hquestion[5]);

            button7 = view.findViewById(R.id.magic7);
            button7.setText(hquestion[6]);

            button8 = view.findViewById(R.id.magic8);
            button8.setText(hquestion[7]);

            button9 = view.findViewById(R.id.magic9);
            button9.setText(hquestion[8]);

            button10 = view.findViewById(R.id.magic10);
            button10.setText(hquestion[9]);

            button11 = view.findViewById(R.id.magic11);
            button11.setText(hquestion[10]);

            button12 = view.findViewById(R.id.magic12);
            button12.setText(hquestion[11]);

            button13 = view.findViewById(R.id.magic13);
            button13.setText(hquestion[12]);

            button14 = view.findViewById(R.id.magic14);
            button14.setText(hquestion[13]);

            button15 = view.findViewById(R.id.magic15);
            button15.setText(hquestion[14]);

            button16 = view.findViewById(R.id.magic16);
            button16.setText(hquestion[15]);

            button17 = view.findViewById(R.id.magic17);
            button17.setText(hquestion[16]);

            button18 = view.findViewById(R.id.magic18);
            button18.setText(hquestion[17]);

            button19 = view.findViewById(R.id.magic19);
            button19.setText(hquestion[18]);

            button20 = view.findViewById(R.id.magic20);
            button20.setText(hquestion[19]);

            button21 = view.findViewById(R.id.magic21);
            button21.setText(hquestion[20]);

            button22 = view.findViewById(R.id.magic22);
            button22.setText(hquestion[21]);

            button23 = view.findViewById(R.id.magic23);
            button23.setText(hquestion[22]);

            button24 = view.findViewById(R.id.magic24);
            button24.setText(hquestion[23]);

            button25 = view.findViewById(R.id.magic25);
            button25.setText(hquestion[24]);


            Ans1 = view.findViewById(R.id.magic26);
            Ans2 = view.findViewById(R.id.magic27);
            Ans3 = view.findViewById(R.id.magic28);
            Ans4 = view.findViewById(R.id.magic29);
            submit = view.findViewById(R.id.submit);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Ans1Text = Ans1.getText().toString();
                    String Ans2Text = Ans2.getText().toString();
                    String Ans3Text = Ans3.getText().toString();
                    String Ans4Text = Ans4.getText().toString();
                    if(Ans1Text.equals(hanswer[6]) && Ans2Text.equals(hanswer[10]) && Ans3Text.equals(hanswer[16]) && Ans4Text.equals(hanswer[21])){
                        nextFragment(true);
//                        Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        nextFragment(false);
                        Toast.makeText(getActivity(),"Incorrect! Try again.", Toast.LENGTH_SHORT).show();

                    }

                }
            });

            return view;
        }

        return null;
    }

    public void nextFragment(boolean check) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        final FragmentTransaction transaction1 = fragmentManager.beginTransaction();
        if (check) {
            checkNextTask();
        }else{
            submit.setEnabled(false);
            backButtonDisable(view);
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            final Fragment magicFrg = new MagicFragment();
                            transaction1.replace(R.id.main_container, magicFrg).commit();
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

        selectedfrg = new ShakeFragment();
        if(list[5].equals("3")){
            selectedfrg = new TurnOffAlarmFragment();
        } else{
            selectedfrg = new ShakeFragment();
        }

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, selectedfrg).commit();
    }
}