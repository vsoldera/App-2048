package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;



public class Activity3 extends AppCompatActivity {

    static  Button  mButton;
    public static EditText mEdit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        if (Build.VERSION.SDK_INT > 9) // corretor par funfar na rede local e interwebs
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Cast, apesar de ele dizer que nao precisa, eh necessario e logicamente correto;
        mButton = (Button) findViewById(R.id.setIP);
        mEdit = (EditText) findViewById(R.id.typeIP);



            mButton.setOnClickListener(


                    new View.OnClickListener() {
                        public void onClick(View view) {

                            Log.v("EditText", mEdit.getText().toString());
                            //Funcional

                            if (mEdit.getText().toString().trim().equals("")) {
                                mEdit.setError("Required!");

                                mEdit.setHint("Enter IP!");
                            } else {
                                Intent intent = new Intent(Activity3.this, DetectorActivity.class);
                                startActivity(intent);
                                System.out.println(mEdit);
                                System.out.println("mEdit");
                            }


                        }


                    });


                    }
    }







