package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;


public class Activity3 extends AppCompatActivity {

    static  Button  mButton;
    public static EditText mEdit;
    private static final Pattern PARTIAl_IP_ADDRESS = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])\\.){0,3}"+ "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])){0,1}$");
    private String mPreviousText = "";
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
        mButton = (Button) findViewById(R.id.setIP);
        mEdit = (EditText) findViewById(R.id.typeIP);

        mButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {


                        Log.v("EditText", mEdit.getText().toString());
                        //Funcional
                        System.out.println(mEdit);
                        System.out.println("mEdit");

                        if (TextUtils.isEmpty(mEdit.getText())) {
                            mEdit.setHint("Please, enter your IP! ");
                            mEdit.setError("Required! ");
                        } else {
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