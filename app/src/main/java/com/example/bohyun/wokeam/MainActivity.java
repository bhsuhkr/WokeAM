package com.example.bohyun.wokeam;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;


public class MainActivity extends Activity {

    int bluetooth = 1;
    String address = null;
    String name = null;
    Button i1;
    TextView t1;

    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    Set<BluetoothDevice> pairedDevices;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // change AppCompatActivity to Activity to use this code
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        try{t1=(TextView)findViewById(R.id.textView1);
            myBluetooth = BluetoothAdapter.getDefaultAdapter();
            address = myBluetooth.getAddress();
            pairedDevices = myBluetooth.getBondedDevices();
            if (pairedDevices.size() > 0) {
                for (BluetoothDevice bt : pairedDevices) {
                    if(bt.getAddress().toString().equals("20:18:01:03:66:77")) {
                        address = bt.getAddress().toString();
                        name = bt.getName().toString();
                    }
                }
            }
//            myBluetooth = BluetoothAdapter.getDefaultAdapter();\
            BluetoothDevice device = myBluetooth.getRemoteDevice(address);
//            btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
//            try {
//                final Method m = device.getClass().getMethod("createInsecureRfcommSocketToServiceRecord", UUID.class);
//                btSocket = (BluetoothSocket) m.invoke(device, myUUID);
//            } catch(Exception e){
//                Toast.makeText(this, "before connect", Toast.LENGTH_SHORT).show();
//            }
            btSocket = device.createRfcommSocketToServiceRecord(myUUID);
            btSocket.connect();

            ////////////////////////////////////////////////
            i1=(Button)findViewById(R.id.button1);

            i1.setOnClickListener(new View.OnClickListener()
            { @Override
            public void onClick(View v){
                led_on_off("1");
                led_on_off("0");}
            });} catch(Exception e) {
            Toast.makeText(this, "On create exception", Toast.LENGTH_SHORT).show();
        }





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
    /////BLUETOOTH//////////////////////////////////////////////////////////////////////////////

    @SuppressLint("ClickableViewAccessibility")
//    private void setw() throws IOException
//    {
//        t1=(TextView)findViewById(R.id.textView1);
//        bluetooth_connect_device();
//        i1=(Button)findViewById(R.id.button1);
//
//        i1.setOnTouchListener(new View.OnTouchListener()
//        { @Override
//        public boolean onTouch(View v, MotionEvent event){
//            Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
//            if(event.getAction() == MotionEvent.ACTION_DOWN) {led_on_off("1");}
//            if(event.getAction()==MotionEvent.ACTION_UP){led_on_off("0");}
//            return true;}
//        });
//
//
//    }

    private void bluetooth_connect_device() throws IOException {
        try {
            myBluetooth = BluetoothAdapter.getDefaultAdapter();
            address = myBluetooth.getAddress();
            pairedDevices = myBluetooth.getBondedDevices();
            if (pairedDevices.size() > 0) {
                for (BluetoothDevice bt : pairedDevices) {
                    address = bt.getAddress().toString();
                    name = bt.getName().toString();
                }
            }
        } catch (Exception we) {Toast.makeText(MainActivity.this, "bluetooth_connect exception", Toast.LENGTH_SHORT).show();}
        myBluetooth = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);
        btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
        btSocket.connect();
        try {
            t1.setText("BT NAME: " + name + "\nBT Address: " + address);
        } catch (Exception e) {}
        }

        private void led_on_off(String i)
    {
        try
        {
            if(btSocket!=null)
            {
                OutputStream outputstream = btSocket.getOutputStream();
                outputstream.write(i.getBytes());
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }



























    /////BLUETOOTH//////////////////////////////////////////////////////////////////////////////



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
