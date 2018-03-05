package com.example.bohyun.wokeam;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    BluetoothAdapter bluetoothAdapter = null;
    int bluetooth = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // change AppCompatActivity to Activity to use this code
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();




//        final Button bluetoothButton = (Button) findViewById(R.id.btn_bluetooth);
//        bluetoothButton.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                buttonEffect(bluetoothButton);
//                if(bluetoothAdapter == null){
//                    Toast.makeText(getApplicationContext(), "not connected", Toast.LENGTH_SHORT).show();
//                }else if(!bluetoothAdapter.isEnabled()){
//                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//                    startActivityForResult(enableBtIntent, bluetooth);
//                }
//            }
//        });

        final Button settingButton = (Button) findViewById(R.id.btn_settings);
        settingButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonEffect(settingButton);
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        final Button exitButton = (Button) findViewById(R.id.btn_start);
        exitButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonEffect(exitButton);
                startActivity(new Intent(getApplicationContext(),TaskActivity.class ));
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
