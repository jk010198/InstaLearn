package com.instalearn.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Locale;

public class SoundSetting extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech tts;
    EditText et;
    int pitch,speechRate;
    double d_pitch=0.0f, d_speechRate=0.0f;
    SeekBar sBSpeechRate,sBPitchRate;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_setting);

        tts = new TextToSpeech(this, this);
        et = findViewById(R.id.et_text);
        sBSpeechRate=(SeekBar)findViewById(R.id.sBSpeechRate);
        sBPitchRate=(SeekBar)findViewById(R.id.sBPitchRate);

        //sp setup...
        sharedPreferences=getSharedPreferences("sp_sound",MODE_PRIVATE);
        pitch = sharedPreferences.getInt("sp_pitch",10);
        speechRate = sharedPreferences.getInt("sp_speech",8);
        sBPitchRate.setProgress(pitch);
        sBSpeechRate.setProgress(speechRate);
        ////////////////

        sBSpeechRate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //divide progress by 10 to get speech rate in float values like 0.1
                d_speechRate = ((double)(progress+1)/10);
                speechRate = progress;
                sBSpeechRate.setProgress(speechRate);
                myDataSetInSP();
            }
        });

        sBPitchRate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //divide progress by 10 to get pitch in float values like 0.1
                d_pitch = ((double)(progress+1)/10);
                pitch = progress;
                sBPitchRate.setProgress(pitch);
                myDataSetInSP();

            }
        });
    }

    public void soundTest(View view) {
        speakOut();
        myDataSetInSP();
    }

    public void myDataSetInSP(){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("sp_pitch", pitch);
        editor.putInt("sp_speech", speechRate);
        editor.commit();
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                //ib.setEnabled(true);
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    private void speakOut() {
        String text = et.getText().toString();
        //set pitch rate adjusted by user
        tts.setPitch((float)d_pitch);
        //set speech rate adjusted by user
        tts.setSpeechRate((float)d_speechRate);

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}