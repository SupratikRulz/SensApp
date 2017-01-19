package com.ordroid.sensapp.sensapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    Button btnProximity,btnLight,btnAccelerometer,btnSpeed;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnProximity = (Button) findViewById(R.id.btnProximity);
        btnLight = (Button) findViewById(R.id.btnLight);
        btnAccelerometer = (Button) findViewById(R.id.btnAccelerometer);
        btnSpeed = (Button) findViewById(R.id.btnSpeed);
        iv = (ImageView) findViewById(R.id.imageView);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),DeveloperActivity.class);
                startActivity(i);
            }
        });

        btnProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(),ProximityActivity.class);
                startActivity(i);
            }
        });

        btnLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),LightActivity.class);
                startActivity(i);

            }
        });

        btnAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),AccelerometerActivity.class);
                startActivity(i);

            }
        });

        btnSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(),SpeedActivity.class);
                startActivity(i);
            }
        });
    }
}
