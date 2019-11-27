package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
public class Activity3 extends AppCompatActivity {

    public static  Button  mButton;
    public static TextView mErro ;
    public static EditText mEdit;

    Server servidor = new Server(); // instanciamos um novo para validacao de IP
    String preFixo, posFixo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        int aux;
        if (android.os.Build.VERSION.SDK_INT > 9) // corretor par funfar na rede local e interwebs
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        preFixo = "http://";
        posFixo = ":3000";

        //Cast, apesar de ele dizer que nao precisa, eh necessario e logicamente correto;
        mErro = (TextView) findViewById(R.id.erroText);
        mButton = (Button) findViewById(R.id.setIP);
        mEdit = (EditText) findViewById(R.id.typeIP);



    }

    public void ReturnHome(View v) {
        super.onBackPressed();
    }

    public void TensorFlowCall() {
        Intent intent = new Intent(Activity3.this, DetectorActivity.class);
        startActivity(intent);
    }

    public void validar (View view) {
            int validation ;

            mButton.setText("Loading....");
            mButton.setBackgroundColor(0xFFFF0000);


            Log.v("EditText", mEdit.getText().toString());
            //Funcional
            System.out.println(mEdit);
            System.out.println("mEdit");

            servidor.setUrlGet(preFixo+ Activity3.mEdit.getText().toString()+posFixo);
            servidor.setUrlPost(preFixo+Activity3.mEdit.getText().toString()+posFixo);


            if (TextUtils.isEmpty(mEdit.getText())) {
                mEdit.setHint("Please, enter a IP! ");
                mEdit.setError("Required! ");
            } else {

                try {

                    validation = servidor.getValidationServer();
                    if(validation == -1) {
                        mErro.setText("Please, enter a valid IP! Connection Refused! ");

                        mButton.setText("Confirm");
                        mButton.setBackgroundColor(0xFFCCCCCC);


                    }else{
                        TensorFlowCall();
                    }
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }


    }

