package com.example.bohyun.wokeam;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // change AppCompatActivity to Activity to use this code
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        final Button settingButton = findViewById(R.id.btn_settings);
        settingButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                buttonEffect(settingButton);
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        final Button startButton = findViewById(R.id.btn_start);
        startButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    String value = preferences.getString("Difficulty", "Not Selected");
                    String[] list = value.split(",");
                    if (list[0].equals("3") && list[1].equals("3") && list[2].equals("3") && list[3].equals("3") && list[4].equals("3") && list[5].equals("3")) {
                        Toast.makeText(MainActivity.this, "No Task Selected!", Toast.LENGTH_SHORT).show();
                    }else{
//                        buttonEffect(startButton);
//                        Toast.makeText(MainActivity.this, list[0]+" " + list[1]+" " + list[2]+" " + list[3]+" " + list[4]+" " + list[5], Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), TaskActivity.class));
                    }
                }catch(Exception e){
                        Toast.makeText(MainActivity.this, "No Task Selected.", Toast.LENGTH_SHORT).show();
                    }

                }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.setting_actionbar:
                Intent intent = new Intent(this, SettingActivity.class);
                this.startActivity(intent);
                break;
        }
        return true;
    }

    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe036b2c0, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

    }

}
