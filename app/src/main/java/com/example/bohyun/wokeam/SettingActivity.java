package com.example.bohyun.wokeam;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.WindowManager;

public class SettingActivity extends PreferenceActivity {

    //The order of tasks: Math, English, Simon Says, Sudoku, Magic Square, Shake
    int[] wakeupTasks = {3, 3, 3, 3, 3, 3};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        addPreferencesFromResource(R.xml.setting_activity);
        listPreferenceListner();

    }
    public void getSelectedValues(ListPreference listPreference, int pos){
        String index = listPreference.getValue();
        if(index.equals("Easy")){
            wakeupTasks[pos] = 0;
        }else if(index.equals("Normal")){
            wakeupTasks[pos] = 1;
        }else if(index.equals("Hard")){
            wakeupTasks[pos] = 2;
        }

    }
    public void listPreferenceListner(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SettingActivity.this);
        final SharedPreferences.Editor editor = preferences.edit();

        final ListPreference taskCal = (ListPreference) findPreference("math");
        getSelectedValues(taskCal, 0);
        taskCal.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                int index = taskCal.findIndexOfValue(newValue.toString());
                switch(index){
                    case 0:
                        wakeupTasks[0] = 0;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 1:
                        wakeupTasks[0] = 1;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 2:
                        wakeupTasks[0] = 2;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 3:
                        wakeupTasks[0] = 3;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

        final ListPreference taskEng = (ListPreference) findPreference("english");
        getSelectedValues(taskEng, 1);
        taskEng.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                int index = taskEng.findIndexOfValue(newValue.toString());
                switch(index){
                    case 0:
                        wakeupTasks[1] = 0;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 1:
                        wakeupTasks[1] = 1;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 2:
                        wakeupTasks[1] = 2;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 3:
                        wakeupTasks[1] = 3;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

        final ListPreference taskSimon = (ListPreference) findPreference("simonSays");
        getSelectedValues(taskSimon, 2);
        taskSimon.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                int index = taskSimon.findIndexOfValue(newValue.toString());
                switch(index){
                    case 0:
                        wakeupTasks[2] = 0;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 1:
                        wakeupTasks[2] = 1;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 2:
                        wakeupTasks[2] = 2;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 3:
                        wakeupTasks[2] = 3;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

        final ListPreference taskSudoku = (ListPreference) findPreference("sudoku");
        getSelectedValues(taskSudoku, 3);
        taskSudoku.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                int index = taskSudoku.findIndexOfValue(newValue.toString());
                switch(index){
                    case 0:
                        wakeupTasks[3] = 0;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 1:
                        wakeupTasks[3] = 1;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 2:
                        wakeupTasks[3] = 2;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 3:
                        wakeupTasks[3] = 3;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

        final ListPreference taskMagicSquare = (ListPreference) findPreference("magicSquare");
        getSelectedValues(taskMagicSquare, 4);
        taskMagicSquare.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                int index = taskMagicSquare.findIndexOfValue(newValue.toString());
                switch(index){
                    case 0:
                        wakeupTasks[4] = 0;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 1:
                        wakeupTasks[4] = 1;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 2:
                        wakeupTasks[4] = 2;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 3:
                        wakeupTasks[4] = 3;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

        final ListPreference taskShake = (ListPreference) findPreference("shake");
        getSelectedValues(taskShake, 5);
        taskShake.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                int index = taskShake.findIndexOfValue(newValue.toString());
                switch(index){
                    case 0:
                        wakeupTasks[5] = 0;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 1:
                        wakeupTasks[5] = 1;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 2:
                        wakeupTasks[5] = 2;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 3:
                        wakeupTasks[5] = 3;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });
    }
}
