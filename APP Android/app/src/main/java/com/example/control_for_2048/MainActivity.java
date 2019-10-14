package com.example.control_for_2048;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private Button btnTensorFlow;
    final JsonGenerator gerador = new JsonGenerator();
    final Server servidor = new Server("192.168.0.105", 3000); // setar com suas confs de server


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTensorFlow = findViewById(R.id.btnTensor);
        btnTensorFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               moveToTensorFlow();
            }
            private void moveToTensorFlow() {
                Intent intent = new Intent(MainActivity.this, DisplayTensorFlow.class);
                startActivity(intent);
            }
        });
        if (android.os.Build.VERSION.SDK_INT > 9) // corretor par funfar na rede local e interwebs
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }



    }


    public void onClickDown(View v) {
        servidor.initServer();
        servidor.Write(gerador.CriaObjeto("down").toString());
    }

    public void onClickUp(View v) {
        servidor.initServer();
        servidor.Write(gerador.CriaObjeto("up").toString());
    }

    public void onClickLeft(View v) {
        servidor.initServer();
        servidor.Write(gerador.CriaObjeto("left").toString());
    }

    public void onClickRight(View v) {
        servidor.initServer();
        servidor.Write(gerador.CriaObjeto("right").toString());
    }


}
