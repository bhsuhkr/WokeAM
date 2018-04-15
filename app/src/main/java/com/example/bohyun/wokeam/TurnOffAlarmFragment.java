package com.example.bohyun.wokeam;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class TurnOffAlarmFragment extends android.support.v4.app.Fragment {

    Button turnoffBtn;

    int bluetooth = 1;
    String address = null;
    String name = null;

    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    Set<BluetoothDevice> pairedDevices;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_turn_off_alarm, container, false);

        turnoffBtn = view.findViewById(R.id.btn_turnOff);
        turnoffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Turning off the alarm...", Toast.LENGTH_LONG).show();
                sendSignalToAlarmClock();
            }
        });

        return view;
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
            led_on_off("1");
            led_on_off("1");
            led_on_off("1");
            led_on_off("1");
            
            turnoffBtn.setEnabled(false);

            Intent i = new Intent(getActivity(), MainActivity.class);
            startActivity(i);

        } catch(Exception e) {
            Toast.makeText(getActivity(), "Bluetooth Fail, Try Again", Toast.LENGTH_SHORT).show();
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
