package toong.example.stepcounterexample;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import toong.example.stepcounterexample.R;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor stepCounter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    stepCounter = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
}

@Override
protected void onResume() {
    super.onResume();
    mSensorManager.registerListener(this, stepCounter, SensorManager.SENSOR_DELAY_UI);
}

@Override
public void onSensorChanged(SensorEvent sensorEvent) {
   if(sensorEvent.sensor.getType() == Sensor.TYPE_STEP_COUNTER){
       Toast.makeText(this, "Sensor", Toast.LENGTH_SHORT).show();
   }
}

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
