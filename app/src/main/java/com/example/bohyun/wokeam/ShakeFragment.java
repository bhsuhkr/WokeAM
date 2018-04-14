package com.example.bohyun.wokeam;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class ShakeFragment extends android.support.v4.app.Fragment  {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    private int count = 0;

    int bluetooth = 1;
    String address = null;
    String name = null;

    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    Set<BluetoothDevice> pairedDevices;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shake_task, container, false);


        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake(int count) {
                count++;
                if(count >= 5)
                {
                    sendSignalToAlarmClock();

                    ImageView img = getActivity().findViewById(R.id.shakeImg);
                    img.setImageResource(R.drawable.wakeup);

                    nextFragment();

                }
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    public void nextFragment() {
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        Fragment engTaskFrg = new EnglishTaskFragment();
//        transaction.replace(R.id.main_container, engTaskFrg).commit();
        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);
    }

    public void sendSignalToAlarmClock(){
        try{
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

            BluetoothDevice device = myBluetooth.getRemoteDevice(address);
            btSocket = device.createRfcommSocketToServiceRecord(myUUID);
            btSocket.connect();

            led_on_off("1");
            led_on_off("0");
            } catch(Exception e) {
            Toast.makeText(getActivity(), "Bluetooth Connection Fail", Toast.LENGTH_SHORT).show();
        }

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
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

}
