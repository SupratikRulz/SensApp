package com.ordroid.sensapp.sensapp;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProximityActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mgr;
    private Sensor proximity;
    private TextView txt;

    @Override
    protected void onResume() {
        mgr.registerListener(this,proximity,SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();

    }

    private String msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        mgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        proximity = mgr.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        txt = (TextView) findViewById(R.id.txt);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        msg="Got a Sensor Event :" + event.values[0] + " centimetres";
        txt.setText(msg);
        txt.invalidate();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        /*ignore*/
    }
}
