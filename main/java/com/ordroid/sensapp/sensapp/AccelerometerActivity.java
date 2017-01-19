package com.ordroid.sensapp.sensapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    TextView tvX,tvY,tvZ;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        tvX = (TextView) findViewById(R.id.tvX);
        tvY = (TextView) findViewById(R.id.tvY);
        tvZ = (TextView) findViewById(R.id.tvZ);

        sensorManager= (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor acceleometerSensor= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        if (acceleometerSensor == null){
            Toast.makeText(this,"No Accelerometer Sensor Found! ",Toast.LENGTH_LONG).show();
        }else{

            sensorManager.registerListener(this,acceleometerSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        tvX.setText("X = "+String.valueOf(event.values[0]));
        tvY.setText("Y = "+String.valueOf(event.values[1]));
        tvZ.setText("Z = "+String.valueOf(event.values[2]));

        tvX.invalidate();
        tvY.invalidate();
        tvZ.invalidate();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the lightSensor
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
