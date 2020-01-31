package com.wcmc.torchlight;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Handler mHandler = new Handler();
    ToggleButton tourchBtn;
    Button delay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tourchBtn = (ToggleButton)findViewById(R.id.tglBtn);
        delay = (Button) findViewById(R.id.button2);

        delay.setEnabled(false);
        tourchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(tourchBtn.isChecked()){
                    flashIsOn();
                    Toast.makeText(MainActivity.this, "Flash is ON", Toast.LENGTH_SHORT).show();
                    delay.setEnabled(true);
                }else {
                    delay.setEnabled(false);
                    flashIsOff();
                    Toast.makeText(MainActivity.this, "Flash is OFF", Toast.LENGTH_SHORT).show();
                    mHandler.removeCallbacks(mRun);
                    mHandler.removeCallbacks(nRun);
                }
            }
        });
    }
    public void delayFlash(View V){
        mRun.run();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void flashIsOn(){
        CameraManager camera = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try{
            String CameraId = camera.getCameraIdList()[0];
            camera.setTorchMode(CameraId,true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void flashIsOff(){
        CameraManager camera = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try{
            String CameraId = camera.getCameraIdList()[0];
            camera.setTorchMode(CameraId,false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public Runnable mRun = new Runnable() {
        @Override
        public void run() {
            flashIsOff();
            mHandler.postDelayed(nRun,1000);
        }
    };
    public Runnable nRun = new Runnable() {
        @Override
        public void run() {
            flashIsOn();
            mHandler.postDelayed(mRun,1000);
        }
    };
}
