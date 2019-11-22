package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.StrictMode;
import android.view.WindowManager;
import android.widget.TextView;
import android.os.Bundle;
import org.json.JSONException;


public class Activity4 extends AppCompatActivity implements SensorEventListener{
    private TextView xText, yText, zText;
    private Sensor mySensor;
    private SensorManager SM;

    final JsonGenerator gerador = new JsonGenerator();
    public Server servidor2 = new Server();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String preFixo, posFixo;

        preFixo = "http://";
        posFixo = ":3000";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        if (android.os.Build.VERSION.SDK_INT > 9) // corretor par funfar na rede local e interwebs
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        servidor2.setUrlGet(preFixo + Activity3.mEdit.getText().toString() + posFixo);
        servidor2.setUrlPost(preFixo + Activity3.mEdit.getText().toString() + posFixo);

        SM  = (SensorManager)getSystemService((SENSOR_SERVICE));

        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register sensor listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Assign Text View
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);




    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        System.out.println("X: " + event.values[0]);
        System.out.println("Y: " + event.values[1]);
        System.out.println("Z: " + event.values[2]);

        if(event.values[0] > event.values[1] && event.values[0] > event.values[2]) {
            try {
                servidor2.sendUpdatePost("Down");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if(event.values[1] > event.values[2] && event.values[1] > event.values[0]) {
            try {
                servidor2.sendUpdatePost("Right");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if(event.values[2] > event.values[0] && event.values[2] > event.values[1]) {
            try {
                servidor2.sendUpdatePost("Up");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                servidor2.sendUpdatePost("Left");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //nao usado
    }
}