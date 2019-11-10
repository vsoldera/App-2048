package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;




public class Activity2 extends AppCompatActivity {


    final JsonGenerator gerador = new JsonGenerator();

    final Server servidor = new Server(Activity3.mEdit.getText().toString(), 3000);

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        if (android.os.Build.VERSION.SDK_INT > 9) // corretor par funfar na rede local e interwebs
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        System.out.println("IP: " + Activity3.mEdit.getText().toString());
        System.out.println("Host: " + servidor.host);
        System.out.println("Port: " + servidor.port);

    }

    public void onClickDown(View v) {

        try {
            servidor.initServer();
            servidor.Write(gerador.CriaObjeto("down").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onClickUp(View v) {

        try {
            servidor.initServer();
            servidor.Write(gerador.CriaObjeto("up").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickLeft(View v) {

        try {
            servidor.initServer();
            servidor.Write(gerador.CriaObjeto("left").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickRight(View v) {

        try {
            servidor.initServer();
            servidor.Write(gerador.CriaObjeto("right").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void ReturnHome(View v) {
        super.onBackPressed();
    }


}


