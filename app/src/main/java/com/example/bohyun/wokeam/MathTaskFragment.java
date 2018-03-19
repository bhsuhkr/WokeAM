package com.example.bohyun.wokeam;
import android.os.Bundle;
import android.text.InputType;
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
    int answer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_math_task, container, false);

        enterBtn = (Button) view.findViewById(R.id.btn_submit);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)getActivity().findViewById(R.id.answer);
                String userAnswer = editText.getText().toString();
                if(userAnswer.compareTo(String.valueOf(answer))==0){
                    Toast.makeText(getActivity().getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                    //After task completed ...
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
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

        TextView operand11 = (TextView) getView().findViewById(R.id.operand1);
        TextView operand22 = (TextView) getView().findViewById(R.id.operand2);
        operand11.setText(String.valueOf(operand1));
        operand22.setText(String.valueOf(operand2));
    }


}
