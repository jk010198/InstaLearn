package com.instalearn.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.yinglan.shadowimageview.ShadowImageView;

public class MainActivity extends AppCompatActivity {

    ShadowImageView ib_fruits, ib_vegetables, ib_colors, ib_petanimals, ib_wildanimals, ib_farmanimals, ib_sign_symbols,
            ib_transportation, ib_school, ib_emotions, ib_Community_Helpers_Occupations, ib_humanbodyparts;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(getApplicationContext(), FragmentActivity.class);
        ib_fruits = findViewById(R.id.imageButton_fruits);
        ib_vegetables = findViewById(R.id.imageButton_vegetables);
        ib_colors = findViewById(R.id.imageButton_Colors);
        ib_petanimals = findViewById(R.id.imageButton_petanimals);
        ib_wildanimals = findViewById(R.id.imageButton_wildanimal);
        ib_farmanimals = findViewById(R.id.imageButton_farmanimal);
        ib_sign_symbols = findViewById(R.id.imageButton_sign_symbols);
        ib_transportation = findViewById(R.id.imageButton_transportation);
        ib_school = findViewById(R.id.imageButton_school);
        ib_emotions = findViewById(R.id.imageButton_emotions);
        ib_Community_Helpers_Occupations = findViewById(R.id.imageButton_community_helpers_occupations);
        ib_humanbodyparts = findViewById(R.id.imageButton_bodyparts);

        //Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Raleway-Thin.ttf");
        //tv_animal.setTypeface(typeface);

        ib_fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "fruits");
                startActivity(intent);
            }
        });

        ib_vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "vegetables");
                startActivity(intent);
            }
        });

        ib_colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "colors");
                startActivity(intent);
            }
        });

        ib_petanimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "petanimals");
                startActivity(intent);
            }
        });

        ib_wildanimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "wildanimals");
                startActivity(intent);
            }
        });

        ib_farmanimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "farmanimals");
                startActivity(intent);
            }
        });

        ib_sign_symbols.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "signsymbols");
                startActivity(intent);
            }
        });

        ib_transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "transportation");
                startActivity(intent);
            }
        });

        ib_school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "school");
                startActivity(intent);
            }
        });

        ib_emotions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "emotions");
                startActivity(intent);
            }
        });

        ib_Community_Helpers_Occupations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "communityhelpers");
                startActivity(intent);
            }
        });

        ib_humanbodyparts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("itemType", "bodyhuman");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_sound) {
            startActivity(new Intent(getApplicationContext(), SoundSetting.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Alert");
        adb.setMessage("Do you want to exit");
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                System.exit(0);
                finish();

            }
        });
        adb.setNegativeButton("NO", null);
        adb.show();
    }
}