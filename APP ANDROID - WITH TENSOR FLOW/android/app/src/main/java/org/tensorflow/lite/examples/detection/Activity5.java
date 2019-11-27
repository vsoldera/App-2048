package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

public class Activity5 extends AppCompatActivity {

    private TextToSpeech myTTS;
    private SpeechRecognizer mySpeechRecognizer;
    final JsonGenerator gerador = new JsonGenerator();
    Server servidor = new Server();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String preFixo, posFixo;

        preFixo = "http://";
        posFixo = ":3000";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        if (android.os.Build.VERSION.SDK_INT > 9) // corretor par funfar na rede local e interwebs
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        System.out.println("IP: " + Activity3.mEdit.getText().toString());
        servidor.setUrlGet(preFixo+Activity3.mEdit.getText().toString()+posFixo);
        servidor.setUrlPost(preFixo+Activity3.mEdit.getText().toString()+posFixo);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((view) -> {

                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                    mySpeechRecognizer.startListening(intent);
                });


        initializeTextToSpeech();
        initializeSpeechRecognizer();

    }

    private void initializeTextToSpeech() {
        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (myTTS.getEngines().size() == 0) {
                    Toast.makeText(Activity5.this, "There is no TTS on your device! ", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    myTTS.setLanguage(Locale.US);
                    speak("Welcome to 2048.");
                }


            }


        });

    }

    private void initializeSpeechRecognizer() {
        if(SpeechRecognizer.isRecognitionAvailable(this)) {
            mySpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
            mySpeechRecognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle bundle) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float v) {

                }

                @Override
                public void onBufferReceived(byte[] bytes) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int i) {

                }

                @Override
                public void onResults(Bundle bundle) {
                    List<String> results = bundle.getStringArrayList (
                                SpeechRecognizer.RESULTS_RECOGNITION
                            );
                    try {
                        processResult(results.get(0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onPartialResults(Bundle bundle) {

                }

                @Override
                public void onEvent(int i, Bundle bundle) {

                }
            });
        }

    }

    private void speak(String message) {
        if(Build.VERSION.SDK_INT >= 21)
            myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
        else
            myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null);

    }

    private void processResult(String command) throws JSONException {
        command = command.toLowerCase();

        if (command.indexOf("up") != -1) {
            speak(("Going UP."));
            servidor.sendUpdatePost("Up");
        }
        else
        if (command.indexOf("down") != -1) {
            speak(("Going DOWN."));
            servidor.sendUpdatePost("Down");
        }
        else
        if (command.indexOf("left") != -1) {
            speak(("Going LEFT."));
            servidor.sendUpdatePost("Left");
        }
        else

        if (command.indexOf("right") != -1) {
            speak(("Going RIGHT."));
            servidor.sendUpdatePost("Right");
        }
        if(command.indexOf("xastre") != -1) {
            speak(("XASTRE"));
        }
        else {
            speak(("Sorry. I couldnt understand you."));
        }


    }

    protected void onPause() {
        super.onPause();
        myTTS.shutdown();
    }

}

