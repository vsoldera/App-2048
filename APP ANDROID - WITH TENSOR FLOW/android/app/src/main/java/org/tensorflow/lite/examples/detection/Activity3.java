package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Camera;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.content.Context;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Button;
import android.content.SharedPreferences;


public class Activity3 extends AppCompatActivity {

    static  Button  mButton;
    public static EditText mEdit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        if (android.os.Build.VERSION.SDK_INT > 9) // corretor par funfar na rede local e interwebs
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Cast, apesar de ele dizer que nao precisa, eh necessario e logicamente correto;
        mButton = (Button)findViewById(R.id.setIP);
        mEdit   = (EditText)findViewById(R.id.typeIP);

        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Log.v("EditText", mEdit.getText().toString());
                        //Funcional
                        System.out.println(mEdit);
                        System.out.println("mEdit");

                        if( TextUtils.isEmpty(mEdit.getText())) {
                            mEdit.setHint("Please, enter your IP! ");
                            mEdit.setError("Required! ");
                        }else {
                            TensorFlowCall(view);
                        }





                    }
                });

    }
    public void ReturnHome(View v) {
        super.onBackPressed();
    }

    public void TensorFlowCall(View view) {
        Intent intent = new Intent(Activity3.this, DetectorActivity.class);
        startActivity(intent);
    }



}