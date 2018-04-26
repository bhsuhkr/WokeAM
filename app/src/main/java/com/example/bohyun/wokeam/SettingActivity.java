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
    int[] wakeupTasks = {5, 5, 5, 5, 5, 5};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        addPreferencesFromResource(R.xml.setting_activity);
        listPreferenceListner();
    }

    public void listPreferenceListner(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();

        final ListPreference taskCal = (ListPreference) findPreference("math");
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
                    case 4:
                        wakeupTasks[0] = 4;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 5:
                        wakeupTasks[0] = 5;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

        final ListPreference taskEng = (ListPreference) findPreference("english");
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
                    case 4:
                        wakeupTasks[1] = 4;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 5:
                        wakeupTasks[1] = 5;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

        final ListPreference taskSimon = (ListPreference) findPreference("simonSays");
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
                    case 4:
                        wakeupTasks[2] = 4;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 5:
                        wakeupTasks[2] = 5;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

        final ListPreference taskSudoku = (ListPreference) findPreference("sudoku");
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
                    case 4:
                        wakeupTasks[3] = 4;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 5:
                        wakeupTasks[3] = 5;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

        final ListPreference taskMaginSquare = (ListPreference) findPreference("magicSquare");
        taskMaginSquare.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                int index = taskMaginSquare.findIndexOfValue(newValue.toString());
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
                    case 4:
                        wakeupTasks[4] = 4;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 5:
                        wakeupTasks[4] = 5;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

        final ListPreference taskShake = (ListPreference) findPreference("shake");
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
                    case 4:
                        wakeupTasks[5] = 4;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                    case 5:
                        wakeupTasks[5] = 5;
                        editor.putString("Difficulty", wakeupTasks[0] + "," + wakeupTasks[1] + ","+wakeupTasks[2] + ","+wakeupTasks[3] + ","+wakeupTasks[4] + ","+wakeupTasks[5]);
                        editor.apply();
                        break;
                }
                return true;
            }
        });

    }

}
