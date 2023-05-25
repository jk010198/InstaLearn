package com.instalearn.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView tv_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        tv_score = findViewById(R.id.textview_score);
        int score = getIntent().getIntExtra("score", 0);

        if (score <= 4) {
            tv_score.setText("Your score is: " + score);
            tv_score.setTextColor(getResources().getColor(R.color.wrong_ans));
        } else if (score > 4) {
            tv_score.setText("Your score is: " + score);
            tv_score.setTextColor(getResources().getColor(R.color.correct_ans));
        }

    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void goHome(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
