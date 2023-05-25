package com.instalearn.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yinglan.shadowimageview.ShadowImageView;

import java.util.Locale;

import at.markushi.ui.CircleButton;

import static android.content.Context.MODE_PRIVATE;

public class Tab2 extends Fragment implements TextToSpeech.OnInitListener {

    CircleButton btn_next, btn_back, ib_sound;
    TextToSpeech tts1;
    ShadowImageView iv;
    Activity context;
    TextToSpeech.OnInitListener onInitListener;
    Context ca;
    SharedPreferences sp;
    static int pitch, speechRate;
    static double d_pitch, d_speech;
    CardView cardView;
    TextView tv_itemname_Card;
    Button button;
    String itemType;
    String itemNames[];
    boolean bool_flash;
    int number = 0;
    int images_array[];

    public Tab2(Activity acti, String itemType) {
        context = acti;
        this.itemType = itemType;
        this.itemType = itemType;
        //item_names= context.getResources().getStringArray(R.array.fruitNames);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.two, container, false);

        sp = ca.getSharedPreferences("sp_sound", MODE_PRIVATE);
        pitch = sp.getInt("sp_pitch", 10);
        speechRate = sp.getInt("sp_speech", 8);

        switch (itemType) {
            case "fruits":
                itemNames = context.getResources().getStringArray(R.array.fruits_name);
                images_array = new int[]{R.drawable.apple, R.drawable.strawberries, R.drawable.pomegranate,
                        R.drawable.bananas, R.drawable.papaya, R.drawable.pineapple, R.drawable.pear, R.drawable.orange,
                        R.drawable.watermelon, R.drawable.grapes, R.drawable.peach, R.drawable.plum, R.drawable.cherries,
                        R.drawable.chickoo, R.drawable.mango, R.drawable.litchis};
                break;

            case "vegetables":
                itemNames = context.getResources().getStringArray(R.array.vegetables_name);
                images_array = new int[]{R.drawable.tomato, R.drawable.green_peas, R.drawable.brocolli, R.drawable.corn,
                        R.drawable.cauliflower, R.drawable.carrots, R.drawable.cabbage, R.drawable.cucumber, R.drawable.spinach,
                        R.drawable.capsicium, R.drawable.potatoes, R.drawable.onion, R.drawable.garlic, R.drawable.green_chillies,
                        R.drawable.bottle_gourd};
                break;
            case "colors":
                itemNames = context.getResources().getStringArray(R.array.colors_name);
                images_array = new int[]{R.drawable.purple, R.drawable.pink, R.drawable.orange_color, R.drawable.red,
                        R.drawable.blue, R.drawable.green, R.drawable.yellow, R.drawable.grey, R.drawable.black, R.drawable.white,
                        R.drawable.brown};
                break;
            case "petanimals":
                itemNames = context.getResources().getStringArray(R.array.petanimals_name);
                images_array = new int[]{R.drawable.dog, R.drawable.cat, R.drawable.rabbit, R.drawable.parrot, R.drawable.goldfish,
                        R.drawable.tortoise};
                break;
            case "wildanimals":
                itemNames = context.getResources().getStringArray(R.array.wildanimals_name);

                images_array = new int[]{R.drawable.tiger, R.drawable.lion, R.drawable.giraffe, R.drawable.zebra,
                        R.drawable.bear, R.drawable.elephant, R.drawable.rhino, R.drawable.deer, R.drawable.snake, R.drawable.crocodile,
                        R.drawable.monkey, R.drawable.leopard};
                break;
            case "farmanimals":
                itemNames = context.getResources().getStringArray(R.array.farmanimal_name);
                images_array = new int[]{R.drawable.cow, R.drawable.horse, R.drawable.sheep, R.drawable.goat, R.drawable.donkey,
                        R.drawable.duck, R.drawable.pig};
                break;
            case "signsymbols":
                itemNames = context.getResources().getStringArray(R.array.signs_symbols_name);
                images_array = new int[]{R.drawable.do_not_enter, R.drawable.stop, R.drawable.not_allowed, R.drawable.go,
                        R.drawable.no_smoking, R.drawable.fire_extinguisher, R.drawable.fire_hazard, R.drawable.fire_alarm,
                        R.drawable.use_stairs_in_case_of_fire, R.drawable.no_shoes_allowed, R.drawable.disabled_wheelchair,
                        R.drawable.no_mobilephones_allowed, R.drawable.zebra_crossing, R.drawable.no_jay_walking, R.drawable.no_pets_allowed};
                break;
            case "transportation":
                itemNames = context.getResources().getStringArray(R.array.transportation_name);

                images_array = new int[]{R.drawable.ambulance, R.drawable.police_van, R.drawable.garbage_truck, R.drawable.mail_van,
                        R.drawable.truck, R.drawable.taxi, R.drawable.bus, R.drawable.train, R.drawable.aeroplane, R.drawable.helicopter,
                        R.drawable.metro};
                break;
            case "school":
                itemNames = context.getResources().getStringArray(R.array.school_name);
                images_array = new int[]{R.drawable.blackboard, R.drawable.table_chair, R.drawable.school_bag,
                        R.drawable.water_bottle, R.drawable.lunchbox, R.drawable.crayons, R.drawable.colour_pencils,
                        R.drawable.pencils, R.drawable.sharpner, R.drawable.ruler, R.drawable.paintbrushes, R.drawable.glue,
                        R.drawable.paints, R.drawable.scissors, R.drawable.eraser, R.drawable.school_canteen, R.drawable.teacher,
                        R.drawable.classroom};
                break;
            case "emotions":
                itemNames = context.getResources().getStringArray(R.array.emotions_name);
                images_array = new int[]{R.drawable.happy, R.drawable.unhappy, R.drawable.angry, R.drawable.shocked,
                        R.drawable.love, R.drawable.sad};
                break;
            case "communityhelpers":
                itemNames = context.getResources().getStringArray(R.array.community_helpers_name);
                images_array = new int[]{R.drawable.teacher, R.drawable.nurse, R.drawable.doctor, R.drawable.dentist,
                        R.drawable.policeman, R.drawable.carpenter, R.drawable.farmer, R.drawable.vet, R.drawable.fire_fighter,
                        R.drawable.sweepers};
                break;
            case "bodyhuman":
                itemNames = context.getResources().getStringArray(R.array.bodyparts_name);

                images_array = new int[]{R.drawable.eyes, R.drawable.nose, R.drawable.ears, R.drawable.lips, R.drawable.teeth,
                        R.drawable.tongue, R.drawable.cheeks, R.drawable.hair, R.drawable.eyebrows, R.drawable.hand, R.drawable.finger,
                        R.drawable.nails, R.drawable.thumb, R.drawable.toes, R.drawable.arm, R.drawable.legs, R.drawable.feet,
                        R.drawable.stomach, R.drawable.back, R.drawable.chest};
                break;
        }

        cardView = rootView.findViewById(R.id.cardview_layout);
        cardView.setVisibility(View.INVISIBLE);

        tv_itemname_Card = rootView.findViewById(R.id.textOnCard);
        button = rootView.findViewById(R.id.btn);
        ib_sound = rootView.findViewById(R.id.ib_sound_on_card);
        btn_next = rootView.findViewById(R.id.btn_next);
        btn_back = rootView.findViewById(R.id.btn_back);
        iv = rootView.findViewById(R.id.iv);
        tv_itemname_Card.setText(itemNames[number]);
        iv.setImageResource(images_array[number]);

        tts1 = new TextToSpeech(context, onInitListener);

        button.setVisibility(View.INVISIBLE);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                if (number <= images_array.length - 1) {
                    tv_itemname_Card.setText(itemNames[number]);
                    iv.setImageResource(images_array[number]);
                    iv.setVisibility(View.VISIBLE);
                    cardView.setVisibility(View.INVISIBLE);
                    bool_flash = false;
                } else {
                    number--;
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number >= 1) {
                    number--;
                }
                if (number >= 0) {
                    tv_itemname_Card.setText(itemNames[number]);
                    iv.setImageResource(images_array[number]);
                    iv.setVisibility(View.VISIBLE);
                    cardView.setVisibility(View.INVISIBLE);
                    bool_flash = false;
                } else {
                    number++;
                }
            }
        });

        ib_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut(number);
            }
        });

        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getText().toString().equals("Check")) {
                    iv.setVisibility(View.INVISIBLE);
                    cardView.setVisibility(View.VISIBLE);
                    button.setText("IMAGE");

                } else if (button.getText().equals("IMAGE")) {
                    iv.setVisibility(View.VISIBLE);
                    cardView.setVisibility(View.INVISIBLE);
                    button.setText("Check");
                } else {
                }
            }
        });*/

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bool_flash) {
                    iv.setVisibility(View.INVISIBLE);
                    cardView.setVisibility(View.VISIBLE);
                    bool_flash = true;
                    //button.setText("IMAGE");
                } else {
                    iv.setVisibility(View.VISIBLE);
                    cardView.setVisibility(View.INVISIBLE);
                    //button.setText("Check");
                    bool_flash = false;
                }
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bool_flash) {
                    iv.setVisibility(View.INVISIBLE);
                    cardView.setVisibility(View.VISIBLE);
                    bool_flash = true;
                    //button.setText("IMAGE");
                } else {
                    iv.setVisibility(View.VISIBLE);
                    cardView.setVisibility(View.INVISIBLE);
                    // button.setText("Check");
                    bool_flash = false;
                }
            }
        });


        return rootView;
    }

    /////////tts
    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts1 != null) {
            tts1.stop();
            tts1.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts1.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                //btnNext.setEnabled(true);
                //speakOut(number);
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    public void speakOut(int number) {
        d_speech = ((double) (speechRate + 1) / 10);
        d_pitch = ((double) (pitch + 1) / 10);
        String text = itemNames[number];
        //set pitch rate adjusted by user
        tts1.setPitch((float) d_pitch);
        //set speech rate adjusted by user
        tts1.setSpeechRate((float) d_speech);
        tts1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ca = context;
        }
}
