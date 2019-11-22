package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;



public class Activity2 extends AppCompatActivity {


    final JsonGenerator gerador = new JsonGenerator();
    Server servidor = new Server();
    //final Server servidor = new Server(Activity3.mEdit.getText().toString(), 3000);


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        String preFixo, posFixo;

        preFixo = "http://";
        posFixo = ":3000";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        if (android.os.Build.VERSION.SDK_INT > 9) // corretor par funfar na rede local e interwebs
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        System.out.println("IP: " + Activity3.mEdit.getText().toString());

        /* XARXIXA NAO MUDA FDP*/

        servidor.setUrlGet(preFixo + Activity3.mEdit.getText().toString() + posFixo);
        servidor.setUrlPost(preFixo + Activity3.mEdit.getText().toString() + posFixo);



        //System.out.println("Host: " + servidor.host);
        //System.out.println("Port: " + servidor.port);




        //servidor.getMsg(jogo);



    }

    public void onClickDown(View v) {

        try {
            System.out.println("Down");
            servidor.sendUpdatePost("Down");
            //servidor.Write(gerador.CriaObjeto("down").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onClickUp(View v) {

        try {
            System.out.println("Up");
            servidor.sendUpdatePost("Up");
            //servidor.Write(gerador.CriaObjeto("up").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickLeft(View v) {

        try {
            System.out.println("Left");
            servidor.sendUpdatePost("Left");
            //servidor.Write(gerador.CriaObjeto("left").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickRight(View v) {

        try {
            System.out.println("Right");
            servidor.sendUpdatePost("Right");
            //servidor.Write(gerador.CriaObjeto("right").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void ReturnHome(View v) {
        super.onBackPressed();
    }


}


