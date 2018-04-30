package com.example.bohyun.wokeam;

import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SudokuFragment extends Fragment {

    private View view;
    private Fragment selectedfrg;
    private int difficulty = 1;

    private String answer[][] = {{"8", "2", "7", "9", "6", "5", "3", "4", "1"},
            {"1", "5", "4", "3", "2", "7", "6", "8", "9"},
            {"3", "9", "6", "1", "4", "8", "7", "5", "2"},
            {"5", "9", "3", "4", "7", "2", "6", "1", "8"},
            {"4", "6", "8", "5", "1", "3", "9", "7", "2"},
            {"2", "7", "1", "6", "8", "9", "4", "3", "5"},
            {"7", "8", "6", "1", "5", "4", "2", "3", "9"},
            {"2", "3", "5", "7", "9", "6", "8", "4", "1"},
            {"9", "1", "4", "8", "2", "3", "5", "6", "7"}};

    private String question[][] = {{"8", "2", "7", " ", "6", "5", "3", " ", "1"},
            {"1", "5", "4", "3", "2", "7", "6", "8", "9"},
            {"3", "9", "6", "1", "4", "8", "7", "5", "2"},
            {"5", " ", "3", "4", "7", " ", "6", "1", "8"},
            {"4", "6", "8", "5", "1", "3", "9", "7", "2"},
            {"2", "7", "1", "6", "8", "9", "4", "3", "5"},
            {"7", "8", "6", "1", " ", "4", "2", "3", " "},
            {"2", "3", "5", "7", "9", "6", "8", "4", "1"},
            {"9", "1", "4", "8", "2", "3", "5", "6", "7"}};

    private String questionm[][] = {{"8", "2", "7", "9", " ", "5", "3", "4", " "},
            {"1", "5", "4", " ", "2", "7", "6", "8", " "},
            {"3", "9", "6", "1", "4", "8", "7", "5", "2"},
            {"5", "9", "3", " ", "7", "2", "6", " ", "8"},
            {"4", "6", "8", " ", "1", "3", "9", " ", "2"},
            {"2", "7", "1", "6", "8", "9", "4", "3", "5"},
            {"7", " ", "6", " ", "5", "4", "2", "3", "9"},
            {" ", "3", "5", "7", " ", "6", "8", "4", "1"},
            {"9", "1", "4", "8", "2", "3", "5", "6", "7"}};

    private String questionh[][] = {{" ", "2", "7", "9", " ", "5", "3", "4", "1"},
            {"1", "5", "4", "3", "2", " ", "6", " ", "9"},
            {"3", "9", "6", " ", "4", "8", " ", "5", "2"},
            {"5", "9", "3", "4", " ", "2", "6", "1", " "},
            {"4", " ", "8", "5", "1", "3", "9", " ", "2"},
            {"2", "7", "1", " ", "8", " ", "4", "3", "5"},
            {"7", "8", " ", "1", " ", "4", "2", "3", "9"},
            {" ", "3", "5", "7", "9", "6", "8", "4", " "},
            {"9", "1", " ", "8", "2", "3", " ", "6", "7"}};

    EditText s1, s2, s3, s4, s5, s6, s7, s8, s9,
            s10, s11, s12, s13, s14, s15, s16, s17, s18,
            s19, s20, s21, s22, s23, s24, s25, s26, s27,
            s28, s29, s30, s31, s32, s33, s34, s35, s36,
            s37, s38, s39, s40, s41, s42, s43, s44, s45,
            s46, s47, s48, s49, s50, s51, s52, s53, s54,
            s55, s56, s57, s58, s59, s60, s61, s62, s63,
            s64, s65, s66, s67, s68, s69, s70, s71, s72,
            s73, s74, s75, s76, s77, s78, s79, s80, s81;

    Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sudoku_task, container, false);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String value = preferences.getString("Difficulty", "Not Selected");
        String[] list = value.split(",");

        if(list[3].equals("0")){
            difficulty = 1;
        } else if(list[3].equals("1")) {
            difficulty = 2;
        } else if(list[3].equals("2")) {
            difficulty = 3;
        }

        if (difficulty == 1) {
            s1 = view.findViewById(R.id.sudoku0_0);
            s1.setText(question[0][0]);

            s2 = view.findViewById(R.id.sudoku0_1);
            s2.setText(question[0][1]);

            s3 = view.findViewById(R.id.sudoku0_2);
            s3.setText(question[0][2]);

            s4 = view.findViewById(R.id.sudoku0_3);
            s4.setText(question[0][3]);
            s4.setFocusable(true);
            s4.setClickable(true);
            s4.setCursorVisible(true);
            s4.setFocusableInTouchMode(true);
            s4.setTextColor(Color.RED);

            s5 = view.findViewById(R.id.sudoku0_4);
            s5.setText(question[0][4]);

            s6 = view.findViewById(R.id.sudoku0_5);
            s6.setText(question[0][5]);

            s7 = view.findViewById(R.id.sudoku0_6);
            s7.setText(question[0][6]);

            s8 = view.findViewById(R.id.sudoku0_7);
            s8.setText(question[0][7]);
            s8.setFocusable(true);
            s8.setClickable(true);
            s8.setCursorVisible(true);
            s8.setFocusableInTouchMode(true);
            s8.setTextColor(Color.RED);

            s9 = view.findViewById(R.id.sudoku0_8);
            s9.setText(question[0][8]);

            s10 = view.findViewById(R.id.sudoku1_0);
            s10.setText(question[1][0]);

            s11 = view.findViewById(R.id.sudoku1_1);
            s11.setText(question[1][1]);

            s12 = view.findViewById(R.id.sudoku1_2);
            s12.setText(question[1][2]);

            s13 = view.findViewById(R.id.sudoku1_3);
            s13.setText(question[1][3]);

            s14 = view.findViewById(R.id.sudoku1_4);
            s14.setText(question[1][4]);

            s15 = view.findViewById(R.id.sudoku1_5);
            s15.setText(question[1][5]);

            s16 = view.findViewById(R.id.sudoku1_6);
            s16.setText(question[1][6]);

            s17 = view.findViewById(R.id.sudoku1_7);
            s17.setText(question[1][7]);

            s18 = view.findViewById(R.id.sudoku1_8);
            s18.setText(question[1][8]);

            s19 = view.findViewById(R.id.sudoku2_0);
            s19.setText(question[2][0]);

            s20 = view.findViewById(R.id.sudoku2_1);
            s20.setText(question[2][1]);

            s21 = view.findViewById(R.id.sudoku2_2);
            s21.setText(question[2][2]);

            s22 = view.findViewById(R.id.sudoku2_3);
            s22.setText(question[2][3]);

            s23 = view.findViewById(R.id.sudoku2_4);
            s23.setText(question[2][4]);

            s24 = view.findViewById(R.id.sudoku2_5);
            s24.setText(question[2][5]);

            s25 = view.findViewById(R.id.sudoku2_6);
            s25.setText(question[2][6]);

            s26 = view.findViewById(R.id.sudoku2_7);
            s26.setText(question[2][7]);

            s27 = view.findViewById(R.id.sudoku2_8);
            s27.setText(question[2][8]);

            s28 = view.findViewById(R.id.sudoku3_0);
            s28.setText(question[3][0]);

            s29 = view.findViewById(R.id.sudoku3_1);
            s29.setText(question[3][1]);
            s29.setFocusable(true);
            s29.setClickable(true);
            s29.setCursorVisible(true);
            s29.setFocusableInTouchMode(true);
            s29.setTextColor(Color.RED);

            s30 = view.findViewById(R.id.sudoku3_2);
            s30.setText(question[3][2]);

            s31 = view.findViewById(R.id.sudoku3_3);
            s31.setText(question[3][3]);

            s32 = view.findViewById(R.id.sudoku3_4);
            s32.setText(question[3][4]);

            s33 = view.findViewById(R.id.sudoku3_5);
            s33.setText(question[3][5]);
            s33.setFocusable(true);
            s33.setClickable(true);
            s33.setCursorVisible(true);
            s33.setFocusableInTouchMode(true);
            s33.setTextColor(Color.RED);

            s34 = view.findViewById(R.id.sudoku3_6);
            s34.setText(question[3][6]);

            s35 = view.findViewById(R.id.sudoku3_7);
            s35.setText(question[3][7]);

            s36 = view.findViewById(R.id.sudoku3_8);
            s36.setText(question[3][8]);

            s37 = view.findViewById(R.id.sudoku4_0);
            s37.setText(question[4][0]);

            s38 = view.findViewById(R.id.sudoku4_1);
            s38.setText(question[4][1]);

            s39 = view.findViewById(R.id.sudoku4_2);
            s39.setText(question[4][2]);

            s40 = view.findViewById(R.id.sudoku4_3);
            s40.setText(question[4][3]);

            s41 = view.findViewById(R.id.sudoku4_4);
            s41.setText(question[4][4]);

            s42 = view.findViewById(R.id.sudoku4_5);
            s42.setText(question[4][5]);

            s43 = view.findViewById(R.id.sudoku4_6);
            s43.setText(question[4][6]);

            s44 = view.findViewById(R.id.sudoku4_7);
            s44.setText(question[4][7]);

            s45 = view.findViewById(R.id.sudoku4_8);
            s45.setText(question[4][8]);

            s46 = view.findViewById(R.id.sudoku5_0);
            s46.setText(question[5][0]);

            s47 = view.findViewById(R.id.sudoku5_1);
            s47.setText(question[5][1]);

            s48 = view.findViewById(R.id.sudoku5_2);
            s48.setText(question[5][2]);

            s49 = view.findViewById(R.id.sudoku5_3);
            s49.setText(question[5][3]);

            s50 = view.findViewById(R.id.sudoku5_4);
            s50.setText(question[5][4]);

            s51 = view.findViewById(R.id.sudoku5_5);
            s51.setText(question[5][5]);

            s52 = view.findViewById(R.id.sudoku5_6);
            s52.setText(question[5][6]);

            s53 = view.findViewById(R.id.sudoku5_7);
            s53.setText(question[5][7]);

            s54 = view.findViewById(R.id.sudoku5_8);
            s54.setText(question[5][8]);

            s55 = view.findViewById(R.id.sudoku6_0);
            s55.setText(question[6][0]);

            s56 = view.findViewById(R.id.sudoku6_1);
            s56.setText(question[6][1]);

            s57 = view.findViewById(R.id.sudoku6_2);
            s57.setText(question[6][2]);

            s58 = view.findViewById(R.id.sudoku6_3);
            s58.setText(question[6][3]);

            s59 = view.findViewById(R.id.sudoku6_4);
            s59.setText(question[6][4]);
            s59.setFocusable(true);
            s59.setClickable(true);
            s59.setCursorVisible(true);
            s59.setFocusableInTouchMode(true);
            s59.setTextColor(Color.RED);

            s60 = view.findViewById(R.id.sudoku6_5);
            s60.setText(question[6][5]);

            s61 = view.findViewById(R.id.sudoku6_6);
            s61.setText(question[6][6]);

            s62 = view.findViewById(R.id.sudoku6_7);
            s62.setText(question[6][7]);

            s63 = view.findViewById(R.id.sudoku6_8);
            s63.setText(question[6][8]);
            s63.setFocusable(true);
            s63.setClickable(true);
            s63.setCursorVisible(true);
            s63.setFocusableInTouchMode(true);
            s63.setTextColor(Color.RED);

            s64 = view.findViewById(R.id.sudoku7_0);
            s64.setText(question[7][0]);

            s65 = view.findViewById(R.id.sudoku7_1);
            s65.setText(question[7][1]);

            s66 = view.findViewById(R.id.sudoku7_2);
            s66.setText(question[7][2]);

            s67 = view.findViewById(R.id.sudoku7_3);
            s67.setText(question[7][3]);

            s68 = view.findViewById(R.id.sudoku7_4);
            s68.setText(question[7][4]);

            s69 = view.findViewById(R.id.sudoku7_5);
            s69.setText(question[7][5]);

            s70 = view.findViewById(R.id.sudoku7_6);
            s70.setText(question[7][6]);

            s71 = view.findViewById(R.id.sudoku7_7);
            s71.setText(question[7][7]);

            s72 = view.findViewById(R.id.sudoku7_8);
            s72.setText(question[7][8]);

            s73 = view.findViewById(R.id.sudoku8_0);
            s73.setText(question[8][0]);

            s74 = view.findViewById(R.id.sudoku8_1);
            s74.setText(question[8][1]);

            s75 = view.findViewById(R.id.sudoku8_2);
            s75.setText(question[8][2]);

            s76 = view.findViewById(R.id.sudoku8_3);
            s76.setText(question[8][3]);

            s77 = view.findViewById(R.id.sudoku8_4);
            s77.setText(question[8][4]);

            s78 = view.findViewById(R.id.sudoku8_5);
            s78.setText(question[8][5]);

            s79 = view.findViewById(R.id.sudoku8_6);
            s79.setText(question[8][6]);

            s80 = view.findViewById(R.id.sudoku8_7);
            s80.setText(question[8][7]);

            s81 = view.findViewById(R.id.sudoku8_8);
            s81.setText(question[8][8]);

            submit = view.findViewById(R.id.submit);
            submit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(s4.getText().toString().trim().equals(answer[0][3])
                            && s8.getText().toString().trim().equals(answer[0][7])
                            && s29.getText().toString().trim().equals(answer[3][1])
                            && s33.getText().toString().trim().equals(answer[3][5])
                            && s59.getText().toString().trim().equals(answer[6][4])
                            && s63.getText().toString().trim().equals(answer[6][8])
                            ){
                        nextFragment(true);
                    }else{
                        Toast.makeText(getActivity(),"Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                        nextFragment(false);
                    }
                }
            });
        } else if (difficulty == 2) {
            s1 = view.findViewById(R.id.sudoku0_0);
            s1.setText(questionm[0][0]);

            s2 = view.findViewById(R.id.sudoku0_1);
            s2.setText(questionm[0][1]);

            s3 = view.findViewById(R.id.sudoku0_2);
            s3.setText(questionm[0][2]);

            s4 = view.findViewById(R.id.sudoku0_3);
            s4.setText(questionm[0][3]);

            s5 = view.findViewById(R.id.sudoku0_4);
            s5.setText(questionm[0][4]);
            s5.setFocusable(true);
            s5.setClickable(true);
            s5.setCursorVisible(true);
            s5.setFocusableInTouchMode(true);
            s5.setTextColor(Color.RED);

            s6 = view.findViewById(R.id.sudoku0_5);
            s6.setText(questionm[0][5]);

            s7 = view.findViewById(R.id.sudoku0_6);
            s7.setText(questionm[0][6]);

            s8 = view.findViewById(R.id.sudoku0_7);
            s8.setText(questionm[0][7]);

            s9 = view.findViewById(R.id.sudoku0_8);
            s9.setText(questionm[0][8]);
            s9.setFocusable(true);
            s9.setClickable(true);
            s9.setCursorVisible(true);
            s9.setFocusableInTouchMode(true);
            s9.setTextColor(Color.RED);

            s10 = view.findViewById(R.id.sudoku1_0);
            s10.setText(questionm[1][0]);

            s11 = view.findViewById(R.id.sudoku1_1);
            s11.setText(questionm[1][1]);

            s12 = view.findViewById(R.id.sudoku1_2);
            s12.setText(questionm[1][2]);

            s13 = view.findViewById(R.id.sudoku1_3);
            s13.setText(questionm[1][3]);
            s13.setFocusable(true);
            s13.setClickable(true);
            s13.setCursorVisible(true);
            s13.setFocusableInTouchMode(true);
            s13.setTextColor(Color.RED);

            s14 = view.findViewById(R.id.sudoku1_4);
            s14.setText(questionm[1][4]);

            s15 = view.findViewById(R.id.sudoku1_5);
            s15.setText(questionm[1][5]);

            s16 = view.findViewById(R.id.sudoku1_6);
            s16.setText(questionm[1][6]);

            s17 = view.findViewById(R.id.sudoku1_7);
            s17.setText(questionm[1][7]);

            s18 = view.findViewById(R.id.sudoku1_8);
            s18.setText(questionm[1][8]);
            s18.setFocusable(true);
            s18.setClickable(true);
            s18.setCursorVisible(true);
            s18.setFocusableInTouchMode(true);
            s18.setTextColor(Color.RED);

            s19 = view.findViewById(R.id.sudoku2_0);
            s19.setText(questionm[2][0]);

            s20 = view.findViewById(R.id.sudoku2_1);
            s20.setText(questionm[2][1]);

            s21 = view.findViewById(R.id.sudoku2_2);
            s21.setText(questionm[2][2]);

            s22 = view.findViewById(R.id.sudoku2_3);
            s22.setText(questionm[2][3]);

            s23 = view.findViewById(R.id.sudoku2_4);
            s23.setText(questionm[2][4]);

            s24 = view.findViewById(R.id.sudoku2_5);
            s24.setText(questionm[2][5]);

            s25 = view.findViewById(R.id.sudoku2_6);
            s25.setText(questionm[2][6]);

            s26 = view.findViewById(R.id.sudoku2_7);
            s26.setText(questionm[2][7]);

            s27 = view.findViewById(R.id.sudoku2_8);
            s27.setText(questionm[2][8]);

            s28 = view.findViewById(R.id.sudoku3_0);
            s28.setText(questionm[3][0]);

            s29 = view.findViewById(R.id.sudoku3_1);
            s29.setText(questionm[3][1]);

            s30 = view.findViewById(R.id.sudoku3_2);
            s30.setText(questionm[3][2]);

            s31 = view.findViewById(R.id.sudoku3_3);
            s31.setText(questionm[3][3]);
            s31.setFocusable(true);
            s31.setClickable(true);
            s31.setCursorVisible(true);
            s31.setFocusableInTouchMode(true);
            s31.setTextColor(Color.RED);

            s32 = view.findViewById(R.id.sudoku3_4);
            s32.setText(questionm[3][4]);

            s33 = view.findViewById(R.id.sudoku3_5);
            s33.setText(questionm[3][5]);

            s34 = view.findViewById(R.id.sudoku3_6);
            s34.setText(questionm[3][6]);

            s35 = view.findViewById(R.id.sudoku3_7);
            s35.setText(questionm[3][7]);
            s35.setFocusable(true);
            s35.setClickable(true);
            s35.setCursorVisible(true);
            s35.setFocusableInTouchMode(true);
            s35.setTextColor(Color.RED);

            s36 = view.findViewById(R.id.sudoku3_8);
            s36.setText(questionm[3][8]);

            s37 = view.findViewById(R.id.sudoku4_0);
            s37.setText(questionm[4][0]);

            s38 = view.findViewById(R.id.sudoku4_1);
            s38.setText(questionm[4][1]);

            s39 = view.findViewById(R.id.sudoku4_2);
            s39.setText(questionm[4][2]);

            s40 = view.findViewById(R.id.sudoku4_3);
            s40.setText(questionm[4][3]);
            s40.setFocusable(true);
            s40.setClickable(true);
            s40.setCursorVisible(true);
            s40.setFocusableInTouchMode(true);
            s40.setTextColor(Color.RED);

            s41 = view.findViewById(R.id.sudoku4_4);
            s41.setText(questionm[4][4]);

            s42 = view.findViewById(R.id.sudoku4_5);
            s42.setText(questionm[4][5]);

            s43 = view.findViewById(R.id.sudoku4_6);
            s43.setText(questionm[4][6]);

            s44 = view.findViewById(R.id.sudoku4_7);
            s44.setText(questionm[4][7]);
            s44.setFocusable(true);
            s44.setClickable(true);
            s44.setCursorVisible(true);
            s44.setFocusableInTouchMode(true);
            s44.setTextColor(Color.RED);

            s45 = view.findViewById(R.id.sudoku4_8);
            s45.setText(questionm[4][8]);

            s46 = view.findViewById(R.id.sudoku5_0);
            s46.setText(questionm[5][0]);

            s47 = view.findViewById(R.id.sudoku5_1);
            s47.setText(questionm[5][1]);

            s48 = view.findViewById(R.id.sudoku5_2);
            s48.setText(questionm[5][2]);

            s49 = view.findViewById(R.id.sudoku5_3);
            s49.setText(questionm[5][3]);

            s50 = view.findViewById(R.id.sudoku5_4);
            s50.setText(questionm[5][4]);

            s51 = view.findViewById(R.id.sudoku5_5);
            s51.setText(questionm[5][5]);

            s52 = view.findViewById(R.id.sudoku5_6);
            s52.setText(questionm[5][6]);

            s53 = view.findViewById(R.id.sudoku5_7);
            s53.setText(questionm[5][7]);

            s54 = view.findViewById(R.id.sudoku5_8);
            s54.setText(questionm[5][8]);

            s55 = view.findViewById(R.id.sudoku6_0);
            s55.setText(questionm[6][0]);

            s56 = view.findViewById(R.id.sudoku6_1);
            s56.setText(questionm[6][1]);
            s56.setFocusable(true);
            s56.setClickable(true);
            s56.setCursorVisible(true);
            s56.setFocusableInTouchMode(true);
            s56.setTextColor(Color.RED);

            s57 = view.findViewById(R.id.sudoku6_2);
            s57.setText(questionm[6][2]);

            s58 = view.findViewById(R.id.sudoku6_3);
            s58.setText(questionm[6][3]);
            s58.setFocusable(true);
            s58.setClickable(true);
            s58.setCursorVisible(true);
            s58.setFocusableInTouchMode(true);
            s58.setTextColor(Color.RED);

            s59 = view.findViewById(R.id.sudoku6_4);
            s59.setText(questionm[6][4]);

            s60 = view.findViewById(R.id.sudoku6_5);
            s60.setText(questionm[6][5]);

            s61 = view.findViewById(R.id.sudoku6_6);
            s61.setText(questionm[6][6]);

            s62 = view.findViewById(R.id.sudoku6_7);
            s62.setText(questionm[6][7]);

            s63 = view.findViewById(R.id.sudoku6_8);
            s63.setText(questionm[6][8]);

            s64 = view.findViewById(R.id.sudoku7_0);
            s64.setText(questionm[7][0]);
            s64.setFocusable(true);
            s64.setClickable(true);
            s64.setCursorVisible(true);
            s64.setFocusableInTouchMode(true);
            s64.setTextColor(Color.RED);

            s65 = view.findViewById(R.id.sudoku7_1);
            s65.setText(questionm[7][1]);

            s66 = view.findViewById(R.id.sudoku7_2);
            s66.setText(questionm[7][2]);

            s67 = view.findViewById(R.id.sudoku7_3);
            s67.setText(questionm[7][3]);

            s68 = view.findViewById(R.id.sudoku7_4);
            s68.setText(questionm[7][4]);
            s68.setFocusable(true);
            s68.setClickable(true);
            s68.setCursorVisible(true);
            s68.setFocusableInTouchMode(true);
            s68.setTextColor(Color.RED);

            s69 = view.findViewById(R.id.sudoku7_5);
            s69.setText(questionm[7][5]);

            s70 = view.findViewById(R.id.sudoku7_6);
            s70.setText(questionm[7][6]);

            s71 = view.findViewById(R.id.sudoku7_7);
            s71.setText(questionm[7][7]);

            s72 = view.findViewById(R.id.sudoku7_8);
            s72.setText(questionm[7][8]);

            s73 = view.findViewById(R.id.sudoku8_0);
            s73.setText(questionm[8][0]);

            s74 = view.findViewById(R.id.sudoku8_1);
            s74.setText(questionm[8][1]);

            s75 = view.findViewById(R.id.sudoku8_2);
            s75.setText(questionm[8][2]);

            s76 = view.findViewById(R.id.sudoku8_3);
            s76.setText(questionm[8][3]);

            s77 = view.findViewById(R.id.sudoku8_4);
            s77.setText(questionm[8][4]);

            s78 = view.findViewById(R.id.sudoku8_5);
            s78.setText(questionm[8][5]);

            s79 = view.findViewById(R.id.sudoku8_6);
            s79.setText(questionm[8][6]);

            s80 = view.findViewById(R.id.sudoku8_7);
            s80.setText(questionm[8][7]);

            s81 = view.findViewById(R.id.sudoku8_8);
            s81.setText(questionm[8][8]);

            submit = view.findViewById(R.id.submit);
            submit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(s5.getText().toString().trim().equals(answer[0][4])
                            && s9.getText().toString().trim().equals(answer[0][8])
                            && s13.getText().toString().trim().equals(answer[1][3])
                            && s18.getText().toString().trim().equals(answer[1][8])
                            && s31.getText().toString().trim().equals(answer[3][3])
                            && s35.getText().toString().trim().equals(answer[3][7])
                            && s40.getText().toString().trim().equals(answer[4][3])
                            && s44.getText().toString().trim().equals(answer[4][7])
                            && s56.getText().toString().trim().equals(answer[6][1])
                            && s58.getText().toString().trim().equals(answer[6][3])
                            && s64.getText().toString().trim().equals(answer[7][0])
                            && s68.getText().toString().trim().equals(answer[7][4])
                            ){
                        nextFragment(true);
                    }else{
                        Toast.makeText(getActivity(),"Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                        nextFragment(false);
                    }
                }
            });
        } else if (difficulty == 3) {
            s1 = view.findViewById(R.id.sudoku0_0);
            s1.setText(questionh[0][0]);
            s1.setFocusable(true);
            s1.setClickable(true);
            s1.setCursorVisible(true);
            s1.setFocusableInTouchMode(true);
            s1.setTextColor(Color.RED);

            s2 = view.findViewById(R.id.sudoku0_1);
            s2.setText(questionh[0][1]);

            s3 = view.findViewById(R.id.sudoku0_2);
            s3.setText(questionh[0][2]);

            s4 = view.findViewById(R.id.sudoku0_3);
            s4.setText(questionh[0][3]);

            s5 = view.findViewById(R.id.sudoku0_4);
            s5.setText(questionh[0][4]);
            s5.setFocusable(true);
            s5.setClickable(true);
            s5.setCursorVisible(true);
            s5.setFocusableInTouchMode(true);
            s5.setTextColor(Color.RED);

            s6 = view.findViewById(R.id.sudoku0_5);
            s6.setText(questionh[0][5]);

            s7 = view.findViewById(R.id.sudoku0_6);
            s7.setText(questionh[0][6]);

            s8 = view.findViewById(R.id.sudoku0_7);
            s8.setText(questionh[0][7]);

            s9 = view.findViewById(R.id.sudoku0_8);
            s9.setText(questionh[0][8]);

            s10 = view.findViewById(R.id.sudoku1_0);
            s10.setText(questionh[1][0]);

            s11 = view.findViewById(R.id.sudoku1_1);
            s11.setText(questionh[1][1]);

            s12 = view.findViewById(R.id.sudoku1_2);
            s12.setText(questionh[1][2]);

            s13 = view.findViewById(R.id.sudoku1_3);
            s13.setText(questionh[1][3]);

            s14 = view.findViewById(R.id.sudoku1_4);
            s14.setText(questionh[1][4]);

            s15 = view.findViewById(R.id.sudoku1_5);
            s15.setText(questionh[1][5]);
            s15.setFocusable(true);
            s15.setClickable(true);
            s15.setCursorVisible(true);
            s15.setFocusableInTouchMode(true);
            s15.setTextColor(Color.RED);

            s16 = view.findViewById(R.id.sudoku1_6);
            s16.setText(questionh[1][6]);

            s17 = view.findViewById(R.id.sudoku1_7);
            s17.setText(questionh[1][7]);
            s17.setFocusable(true);
            s17.setClickable(true);
            s17.setCursorVisible(true);
            s17.setFocusableInTouchMode(true);
            s17.setTextColor(Color.RED);

            s18 = view.findViewById(R.id.sudoku1_8);
            s18.setText(questionh[1][8]);

            s19 = view.findViewById(R.id.sudoku2_0);
            s19.setText(questionh[2][0]);

            s20 = view.findViewById(R.id.sudoku2_1);
            s20.setText(questionh[2][1]);

            s21 = view.findViewById(R.id.sudoku2_2);
            s21.setText(questionh[2][2]);

            s22 = view.findViewById(R.id.sudoku2_3);
            s22.setText(questionh[2][3]);
            s22.setFocusable(true);
            s22.setClickable(true);
            s22.setCursorVisible(true);
            s22.setFocusableInTouchMode(true);
            s22.setTextColor(Color.RED);

            s23 = view.findViewById(R.id.sudoku2_4);
            s23.setText(questionh[2][4]);

            s24 = view.findViewById(R.id.sudoku2_5);
            s24.setText(questionh[2][5]);

            s25 = view.findViewById(R.id.sudoku2_6);
            s25.setText(questionh[2][6]);
            s25.setFocusable(true);
            s25.setClickable(true);
            s25.setCursorVisible(true);
            s25.setFocusableInTouchMode(true);
            s25.setTextColor(Color.RED);

            s26 = view.findViewById(R.id.sudoku2_7);
            s26.setText(questionh[2][7]);

            s27 = view.findViewById(R.id.sudoku2_8);
            s27.setText(questionh[2][8]);

            s28 = view.findViewById(R.id.sudoku3_0);
            s28.setText(questionh[3][0]);

            s29 = view.findViewById(R.id.sudoku3_1);
            s29.setText(questionh[3][1]);

            s30 = view.findViewById(R.id.sudoku3_2);
            s30.setText(questionh[3][2]);

            s31 = view.findViewById(R.id.sudoku3_3);
            s31.setText(questionh[3][3]);

            s32 = view.findViewById(R.id.sudoku3_4);
            s32.setText(questionh[3][4]);
            s32.setFocusable(true);
            s32.setClickable(true);
            s32.setCursorVisible(true);
            s32.setFocusableInTouchMode(true);
            s32.setTextColor(Color.RED);

            s33 = view.findViewById(R.id.sudoku3_5);
            s33.setText(questionh[3][5]);

            s34 = view.findViewById(R.id.sudoku3_6);
            s34.setText(questionh[3][6]);

            s35 = view.findViewById(R.id.sudoku3_7);
            s35.setText(questionh[3][7]);

            s36 = view.findViewById(R.id.sudoku3_8);
            s36.setText(questionh[3][8]);
            s36.setFocusable(true);
            s36.setClickable(true);
            s36.setCursorVisible(true);
            s36.setFocusableInTouchMode(true);
            s36.setTextColor(Color.RED);

            s37 = view.findViewById(R.id.sudoku4_0);
            s37.setText(questionh[4][0]);

            s38 = view.findViewById(R.id.sudoku4_1);
            s38.setText(questionh[4][1]);
            s38.setFocusable(true);
            s38.setClickable(true);
            s38.setCursorVisible(true);
            s38.setFocusableInTouchMode(true);
            s38.setTextColor(Color.RED);

            s39 = view.findViewById(R.id.sudoku4_2);
            s39.setText(questionh[4][2]);

            s40 = view.findViewById(R.id.sudoku4_3);
            s40.setText(questionh[4][3]);

            s41 = view.findViewById(R.id.sudoku4_4);
            s41.setText(questionh[4][4]);

            s42 = view.findViewById(R.id.sudoku4_5);
            s42.setText(questionh[4][5]);

            s43 = view.findViewById(R.id.sudoku4_6);
            s43.setText(questionh[4][6]);

            s44 = view.findViewById(R.id.sudoku4_7);
            s44.setText(questionh[4][7]);
            s44.setFocusable(true);
            s44.setClickable(true);
            s44.setCursorVisible(true);
            s44.setFocusableInTouchMode(true);
            s44.setTextColor(Color.RED);

            s45 = view.findViewById(R.id.sudoku4_8);
            s45.setText(questionh[4][8]);

            s46 = view.findViewById(R.id.sudoku5_0);
            s46.setText(questionh[5][0]);

            s47 = view.findViewById(R.id.sudoku5_1);
            s47.setText(questionh[5][1]);

            s48 = view.findViewById(R.id.sudoku5_2);
            s48.setText(questionh[5][2]);

            s49 = view.findViewById(R.id.sudoku5_3);
            s49.setText(questionh[5][3]);
            s49.setFocusable(true);
            s49.setClickable(true);
            s49.setCursorVisible(true);
            s49.setFocusableInTouchMode(true);
            s49.setTextColor(Color.RED);

            s50 = view.findViewById(R.id.sudoku5_4);
            s50.setText(questionh[5][4]);

            s51 = view.findViewById(R.id.sudoku5_5);
            s51.setText(questionh[5][5]);
            s51.setFocusable(true);
            s51.setClickable(true);
            s51.setCursorVisible(true);
            s51.setFocusableInTouchMode(true);
            s51.setTextColor(Color.RED);

            s52 = view.findViewById(R.id.sudoku5_6);
            s52.setText(questionh[5][6]);

            s53 = view.findViewById(R.id.sudoku5_7);
            s53.setText(questionh[5][7]);

            s54 = view.findViewById(R.id.sudoku5_8);
            s54.setText(questionh[5][8]);

            s55 = view.findViewById(R.id.sudoku6_0);
            s55.setText(questionh[6][0]);

            s56 = view.findViewById(R.id.sudoku6_1);
            s56.setText(questionh[6][1]);

            s57 = view.findViewById(R.id.sudoku6_2);
            s57.setText(questionh[6][2]);
            s57.setFocusable(true);
            s57.setClickable(true);
            s57.setCursorVisible(true);
            s57.setFocusableInTouchMode(true);
            s57.setTextColor(Color.RED);

            s58 = view.findViewById(R.id.sudoku6_3);
            s58.setText(questionh[6][3]);

            s59 = view.findViewById(R.id.sudoku6_4);
            s59.setText(questionh[6][4]);
            s59.setFocusable(true);
            s59.setClickable(true);
            s59.setCursorVisible(true);
            s59.setFocusableInTouchMode(true);
            s59.setTextColor(Color.RED);

            s60 = view.findViewById(R.id.sudoku6_5);
            s60.setText(questionh[6][5]);

            s61 = view.findViewById(R.id.sudoku6_6);
            s61.setText(questionh[6][6]);

            s62 = view.findViewById(R.id.sudoku6_7);
            s62.setText(questionh[6][7]);

            s63 = view.findViewById(R.id.sudoku6_8);
            s63.setText(questionh[6][8]);

            s64 = view.findViewById(R.id.sudoku7_0);
            s64.setText(questionh[7][0]);
            s64.setFocusable(true);
            s64.setClickable(true);
            s64.setCursorVisible(true);
            s64.setFocusableInTouchMode(true);
            s64.setTextColor(Color.RED);

            s65 = view.findViewById(R.id.sudoku7_1);
            s65.setText(questionh[7][1]);

            s66 = view.findViewById(R.id.sudoku7_2);
            s66.setText(questionh[7][2]);

            s67 = view.findViewById(R.id.sudoku7_3);
            s67.setText(questionh[7][3]);

            s68 = view.findViewById(R.id.sudoku7_4);
            s68.setText(questionh[7][4]);

            s69 = view.findViewById(R.id.sudoku7_5);
            s69.setText(questionh[7][5]);

            s70 = view.findViewById(R.id.sudoku7_6);
            s70.setText(questionh[7][6]);

            s71 = view.findViewById(R.id.sudoku7_7);
            s71.setText(questionh[7][7]);

            s72 = view.findViewById(R.id.sudoku7_8);
            s72.setText(questionh[7][8]);
            s72.setFocusable(true);
            s72.setClickable(true);
            s72.setCursorVisible(true);
            s72.setFocusableInTouchMode(true);
            s72.setTextColor(Color.RED);

            s73 = view.findViewById(R.id.sudoku8_0);
            s73.setText(questionh[8][0]);

            s74 = view.findViewById(R.id.sudoku8_1);
            s74.setText(questionh[8][1]);

            s75 = view.findViewById(R.id.sudoku8_2);
            s75.setText(questionh[8][2]);
            s75.setFocusable(true);
            s75.setClickable(true);
            s75.setCursorVisible(true);
            s75.setFocusableInTouchMode(true);
            s75.setTextColor(Color.RED);

            s76 = view.findViewById(R.id.sudoku8_3);
            s76.setText(questionh[8][3]);

            s77 = view.findViewById(R.id.sudoku8_4);
            s77.setText(questionh[8][4]);

            s78 = view.findViewById(R.id.sudoku8_5);
            s78.setText(questionh[8][5]);

            s79 = view.findViewById(R.id.sudoku8_6);
            s79.setText(questionh[8][6]);
            s79.setFocusable(true);
            s79.setClickable(true);
            s79.setCursorVisible(true);
            s79.setFocusableInTouchMode(true);
            s79.setTextColor(Color.RED);

            s80 = view.findViewById(R.id.sudoku8_7);
            s80.setText(questionh[8][7]);

            s81 = view.findViewById(R.id.sudoku8_8);
            s81.setText(questionh[8][8]);

            submit = view.findViewById(R.id.submit);
            submit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(s1.getText().toString().trim().equals(answer[0][0])
                            && s5.getText().toString().trim().equals(answer[0][4])
                            && s15.getText().toString().trim().equals(answer[1][5])
                            && s17.getText().toString().trim().equals(answer[1][7])
                            && s22.getText().toString().trim().equals(answer[2][3])
                            && s25.getText().toString().trim().equals(answer[2][6])
                            && s32.getText().toString().trim().equals(answer[3][4])
                            && s36.getText().toString().trim().equals(answer[3][8])
                            && s38.getText().toString().trim().equals(answer[4][1])
                            && s44.getText().toString().trim().equals(answer[4][7])
                            && s49.getText().toString().trim().equals(answer[5][3])
                            && s51.getText().toString().trim().equals(answer[5][5])
                            && s57.getText().toString().trim().equals(answer[6][2])
                            && s59.getText().toString().trim().equals(answer[6][4])
                            && s64.getText().toString().trim().equals(answer[7][0])
                            && s72.getText().toString().trim().equals(answer[7][8])
                            && s75.getText().toString().trim().equals(answer[8][2])
                            && s79.getText().toString().trim().equals(answer[8][6])
                            ){
                        nextFragment(true);
                    }else{
                        Toast.makeText(getActivity(),"Incorrect! Try again.", Toast.LENGTH_SHORT).show();
                        nextFragment(false);
                    }
                }
            });
        }
        return view;
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

                        }
                    },
                    3000
            );
        }
    }

    public void checkNextTask(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String value = preferences.getString("Difficulty", "Not Selected");
        String[] list = value.split(",");

       if(!list[4].equals("3")){
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
}