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

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class EnglishTaskFragment extends android.support.v4.app.Fragment{

    private String questions1 [][] = {{"This spinach omelet makes for a ____ breakfast; it has the vegetables and protein needed for a healthy diet", "Jerry's grandfather's house is full of ____ technology such as rotary-dial phones and other devices that are no longer in use.", "My younger brother constantly misbehaves and is always causing ____.", "The teacher only has one copy of the worksheet right now, so she is going to ____ it and give the new copy to her student.", "Almost no one actually believes that the god Zeus lives on top of Mount Olympus; most people unerstand that this is just a ____, not a reality."}};
    private String options1 [][][] ={{{"delicious", "filling", "fortunate", "edible", "nutritious"}, {"prehistoric", "obsolete", "current", "broken", "advanced"}, {"hostility", "generosity", "violence", "courtesy", "mischief"}, {"translate", "multiply", "duplicate", "plagiarize", "expand"}, {"poem", "lyric", "myth", "sonnet", "counterfeit"}}};
    private String answer1 [][] = {{"nutritious", "obsolete", "mischief", "duplicate", "myth"}};
    private String questions2 [][] = {{"The team seemed _____ to my idea for the annual fundraiser.", "My mother went to Paris and brought home a(n) _____ of the Eiffel Tower", "Getting approved for a loan is almost _____ these days, eliminating the wait for many people.","In order to save on the budget we need to _____ on the extra things in life","The hippie movement of the 1960's brought many people together who were considered _____ in society.", "The _____ number of people allowed to ride this roller coaster is six, so you'll have to split up your group of twelve.","While trying to _____ my laughter during the dramatic play, I accidentally ended up snorting rather loudly.","The recent _____ means that my favorite vegetables will cost more unless the farmers can save some of the destroyed crop.", "The polar bear was _____ after swimming for days without a meal", "She divided the room with a _____ to allow more privacy."}};
    private String options2 [][][] = {{{"recede", "responsive", "relish", "gullible", "immense"},{"burly", "bumbling", "replica", "subsequent", "sabotage"},{"optional", "perishable", "scour", "instantaneous", "pry"},{"impact","ovation","skimp","abominable","deter"},{"dawdle","numb","dole","distort","eerie"},{"maximum","numb","depict","petty","arid"},{"ovation","disquieting","libel","bumbling","constrain"},{"gullible","blight","beacon","discredit","compliant"},{"famished","tribute","strand","parody","pantomime"},{"salvage","influence","idiom","partition","setback"}}};
    private String answer2 [][] = {{"responsive", "replica", "instantaneous","skimp","dawdle","maximum","constrain","blight","famished","partition"}};
    private String questions3 [][] = {{"He proved that he was a(n) _____ by only hiring men for his company even though women were more qualified", "He create a(n) ____ when he forgot to introduce his fiancee to his colleagues.", "The dog was so happy to go for a walk because it could ____ without restraint.", "She likes to study the ____ period of History because she wore medieval clothing.", "The committee formed a(n) ____ in order to discuss the salaries of all employees."}};
    private String options3 [][][] ={{{"mirage", "chauvinist", "mnemonic", "bicker", "bilk"}, {"faux pas", "maladroit", "immolate", "verisimilitude", "matrix"}, {"liturgy", "gambol", "malleable", "traumatic", "hauteur"}, {"corollary", "bowdlerize", "resplendent", "iconoclastic", "gothic"}, {"icon", "flamboyant", "pastiche", "niggardly", "ad hoc"}}};
    private String answer3 [][] = {{"chauvinist", "faux pas", "gambol", "gothic", "ad hoc"}};
    private String questions [][];
    private String options [][][];
    private String answer [][];
    private Fragment selectedfrg;
    int diff = 0;
    int n;
    Random rand;
    TextView button1;
    TextView button2;
    TextView button3;
    TextView button4;
    TextView button5;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rand = new Random();
        n = rand.nextInt(5);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String value = preferences.getString("Difficulty", "Not Selected");
        String[] list = value.split(",");
        if(list[1].equals("0")){
            generateEnglishTask(1);
        } else if(list[1].equals("1")) {
            generateEnglishTask(2);
        } else if(list[1].equals("2")) {
            generateEnglishTask(3);
        }

        view = inflater.inflate(R.layout.fragment_english_task, container, false);
        TextView textView = view.findViewById(R.id.question);
        textView.setText(questions[diff][n]);
        button1 = view.findViewById(R.id.answer1);
        button1.setText(options[diff][n][0]);
        button1.setOnClickListener(mListener);
        button2 = view.findViewById(R.id.answer2);
        button2.setText(options[diff][n][1]);
        button2.setOnClickListener(mListener);
        button3 = view.findViewById(R.id.answer3);
        button3.setText(options[diff][n][2]);
        button3.setOnClickListener(mListener);
        button4 = view.findViewById(R.id.answer4);
        button4.setText(options[diff][n][3]);
        button4.setOnClickListener(mListener);
        button5 = view.findViewById(R.id.answer5);
        button5.setText(options[diff][n][4]);
        button5.setOnClickListener(mListener);

        return view;
    }

    private final View.OnClickListener mListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.answer1:
                    Button b1 = view.findViewById(R.id.answer1);
                    if(b1.getText()==answer[diff][n]){
                        nextFragment(true);
                    }else{
                        nextFragment(false);
                    }
                    break;
                case R.id.answer2:
                    Button b2 = view.findViewById(R.id.answer2);
                    if(b2.getText()==answer[diff][n]){
                        nextFragment(true);
                    }else{
                        nextFragment(false);
                    }
                    break;
                case R.id.answer3:
                    Button b3 = view.findViewById(R.id.answer3);
                    if(b3.getText()==answer[diff][n]){
                        nextFragment(true);
                    }else{
                        nextFragment(false);
                    }
                    break;
                case R.id.answer4:
                    Button b4 = view.findViewById(R.id.answer4);
                    if(b4.getText()==answer[diff][n]){
                        nextFragment(true);
                    }else{
                        nextFragment(false);
                    }
                    break;
                case R.id.answer5:
                    Button b5 = view.findViewById(R.id.answer5);
                    if(b5.getText()==answer[diff][n]){
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
            questions = questions1.clone();
            options = options1.clone();
            answer = answer1.clone();
        }else if(level == 2){
            questions = questions2.clone();
            options = options2.clone();
            answer = answer2.clone();
        }else if(level == 3){
            questions = questions3.clone();
            options = options3.clone();
            answer = answer3.clone();
        }else{

        }
    }

    public void nextFragment(boolean check) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        final FragmentTransaction transaction1 = fragmentManager.beginTransaction();
        if (check) {
            checkNextTask();
        }else{ // create new english Fragment
            Toast.makeText(getActivity(),"Incorrect! Try again.", Toast.LENGTH_SHORT).show();
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            backButtonDisable(view);
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

       if(!list[2].equals("3")){
            selectedfrg = new SimonTaskFragment();
        }else if(!list[3].equals("3")){
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

}