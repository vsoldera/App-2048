package org.tensorflow.lite.examples.detection;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.StrictMode;
import android.view.WindowManager;
import android.widget.TextView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;


public class Activity4 extends AppCompatActivity implements SensorEventListener {

    public Server servidor2 = new Server();
    private TextView xText, yText, zText;
    private Sensor mySensor;
    private SensorManager SM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        if (android.os.Build.VERSION.SDK_INT > 9) // corretor par funfar na rede local e interwebs
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        String preFixo, posFixo;

        preFixo ="http://";
        posFixo =":3000";
        servidor2.setUrlGet(preFixo + Activity3.mEdit.getText().toString() + posFixo);
        servidor2.setUrlPost(preFixo + Activity3.mEdit.getText().toString() + posFixo);

        //Assign Text View
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        SM = (SensorManager) getSystemService((SENSOR_SERVICE));

        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);




    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        System.out.println("X: " + event.values[0]);
        System.out.println("Y: " + event.values[1]);
        System.out.println("Z: " + event.values[2]);
        /*try {


        if (event.values[0] > event.values[1] && event.values[0] > event.values[2]) {
            try {
                servidor2.sendUpdatePost("Left");


            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (event.values[1] > event.values[2] && event.values[1] > event.values[0]) {
            try {
                servidor2.sendUpdatePost("Up");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (event.values[2] > event.values[0] && event.values[2] > event.values[1]) {
            try {
                servidor2.sendUpdatePost("Right");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            try {
                servidor2.sendUpdatePost("Down");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
*/
        if (event.values[0] > 9) {
            try {
                servidor2.sendUpdatePost("Left");


            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (event.values[1] >10) {
            try {
                servidor2.sendUpdatePost("Up");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (event.values[0] < -12) {
            try {
                servidor2.sendUpdatePost("Right");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if(event.values[2] > 10) {
            try {
                servidor2.sendUpdatePost("Down");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        this.onPause();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        this.onResume();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //nao usado
    }

    @Override
    protected void onPause(){
        super.onPause();
        SM.unregisterListener(this);
    }
    protected void onResume(){
        super.onResume();
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_UI);
    }

}