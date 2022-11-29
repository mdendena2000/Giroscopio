package com.example.giroscopio;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor giroscopio;
    private SensorEventListener listener;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        giroscopio = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (giroscopio == null) {
            Toast.makeText(this, "O dispositivo não possui acelerômetro!",
                    Toast.LENGTH_LONG).show();
            finish();
        }

        listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                view = findViewById(R.id.view);

                if (x >= 0 ){
                    view.setBackgroundColor(getResources().getColor(R.color.black));
                } else if (x >= -0.5 ){
                    view.setBackgroundColor(getResources().getColor(R.color.white));
                }
                else if (x >= -1){
                    view.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if (x >= -1.5 ){
                    view.setBackgroundColor(getResources().getColor(R.color.amarelo));
                }
                else if (x >= -2){
                    view.setBackgroundColor(getResources().getColor(R.color.verde));
                }
                else if (x >= -2.5){
                    view.setBackgroundColor(getResources().getColor(R.color.laranja));
                }
                else if (x >= -0.2){
                    view.setBackgroundColor(getResources().getColor(R.color.rosa));
                }
                else if (x >= -0.3){
                    view.setBackgroundColor(getResources().getColor(R.color.roxo));
                }
                else if (x >= -3){
                    view.setBackgroundColor(getResources().getColor(R.color.azulinho));
                }
                else if (x >= -3.5){
                    view.setBackgroundColor(getResources().getColor(R.color.verdeesc));
                }

                if (y >= 0){
                    view.setBackgroundColor(getResources().getColor(R.color.red));

                } else if (y >= -0.5){
                    view.setBackgroundColor(getResources().getColor(R.color.white));
                }
                else if (y >= -0.2){
                    view.setBackgroundColor(getResources().getColor(R.color.black));
                }
                else if (y >= -0.7){
                    view.setBackgroundColor(getResources().getColor(R.color.amarelo));
                }
                else if (y >= -1){
                    view.setBackgroundColor(getResources().getColor(R.color.roxo));
                }
                else if (y >= -1.5){
                    view.setBackgroundColor(getResources().getColor(R.color.laranja));
                }
                else if (y >= -0.3){
                    view.setBackgroundColor(getResources().getColor(R.color.verdeesc));
                }
                else if (y >= -2){
                    view.setBackgroundColor(getResources().getColor(R.color.verde));
                }
                else if (y >= -2.5){
                    view.setBackgroundColor(getResources().getColor(R.color.azulinho));
                }
                else if (y >= -2.8){
                    view.setBackgroundColor(getResources().getColor(R.color.rosa));

                }

                if (z >= 0){
                    view.setBackgroundColor(getResources().getColor(R.color.verdeesc));
                } else if (z >= -0.2){
                    view.setBackgroundColor(getResources().getColor(R.color.white));
                }
                else if (z >= -0.5){
                    view.setBackgroundColor(getResources().getColor(R.color.verde));
                }
                else if (z >= -0.6){
                    view.setBackgroundColor(getResources().getColor(R.color.azulinho));
                }
                else if (z >= -0.3){
                    view.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if (z >= -1){
                    view.setBackgroundColor(getResources().getColor(R.color.rosa));
                }
                else if (z >= -1.3){
                    view.setBackgroundColor(getResources().getColor(R.color.laranja));
                }
                else if (z >= -1.6){
                    view.setBackgroundColor(getResources().getColor(R.color.roxo));
                }
                else if (z >= -2){
                    view.setBackgroundColor(getResources().getColor(R.color.amarelo));
                }
                else if (z >= -2.4){
                    view.setBackgroundColor(getResources().getColor(R.color.black));
                }

            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(listener, giroscopio,
                SensorManager.SENSOR_DELAY_UI);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listener);
    }
}