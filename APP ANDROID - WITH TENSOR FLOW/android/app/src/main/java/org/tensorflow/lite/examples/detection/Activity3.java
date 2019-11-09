package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.content.Context;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Button;
import android.content.SharedPreferences;


public class Activity3 extends AppCompatActivity {

    static  Button   mButton;
    static EditText mEdit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


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


                    }
                });




    }
    public void ReturnHome(View v) {
        super.onBackPressed();
    }



}