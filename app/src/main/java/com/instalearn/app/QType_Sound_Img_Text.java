package com.instalearn.app;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QType_Sound_Img_Text extends SuperQuestion{
    static List<QType_Sound_Img_Text> list_QType_Sound_Img_Text=new ArrayList<>();

    String q_text_sound;
    int op1_img_id;
    int op2_img_id;
    int op3_img_id;
    int op4_img_id;
    String op1_text;
    String op2_text;
    String op3_text;
    String op4_text;
    String ans_text;

     String q_type="sound_img_text";
     String q_text="Listen and choose correct option.";
     String category;


    public static List<QType_Sound_Img_Text> makeQuestions(Activity context) {
        list_QType_Sound_Img_Text.clear();
        SharedPreferences sharedPreferences=context.getSharedPreferences("kidsPro", Context.MODE_PRIVATE);
        String category=sharedPreferences.getString("category","");

        String[] itemNames={} ;//= context.getResources().getStringArray(R.array.farmanimalNames);
        int images_array[]= new int[0];


        switch (category) {
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





        Map<String,Integer> map=new HashMap<String,Integer>();
        for (int i=0;i<itemNames.length;i++)
        {
            map.put(itemNames[i],images_array[i]);
        }
        List list_all_text= new ArrayList();
        for(String e: itemNames) {
            list_all_text.add(e);
        }
        List randomList= new ArrayList(); randomList.add(1);randomList.add(2);randomList.add(3);randomList.add(4);
        for (String item_text : itemNames) {

            QType_Sound_Img_Text q= new QType_Sound_Img_Text();
            q.type="3";
            q.setQ_text_sound(item_text);
            q.setAns_text(item_text);
            Collections.shuffle(randomList);
            int opAns= (int) randomList.get(1);
            List t_list;
            switch (opAns) {
                case 1:
                    q.setOp1_img_id(map.get(item_text));
                    q.setOp1_text(item_text);
                    t_list=new ArrayList(list_all_text);
                    Collections.shuffle(t_list);
                    t_list.remove(item_text);

                    q.setOp2_text((String) t_list.get(1));
                    q.setOp2_img_id(map.get(t_list.get(1)));
                    q.setOp3_text((String) t_list.get(2));
                    q.setOp3_img_id(map.get(t_list.get(2)));
                    q.setOp4_text((String) t_list.get(3));
                    q.setOp4_img_id(map.get(t_list.get(3)));
                    break;
                case 2:
                    q.setOp2_img_id(map.get(item_text));
                    q.setOp2_text(item_text);
                    t_list=new ArrayList(list_all_text);
                    Collections.shuffle(t_list);
                    t_list.remove(item_text);

                    q.setOp1_text((String) t_list.get(1));
                    q.setOp1_img_id(map.get(t_list.get(1)));
                    q.setOp3_text((String) t_list.get(2));
                    q.setOp3_img_id(map.get(t_list.get(2)));
                    q.setOp4_text((String) t_list.get(3));
                    q.setOp4_img_id(map.get(t_list.get(3)));
                    break;
                case 3:
                    q.setOp3_img_id(map.get(item_text));
                    q.setOp3_text(item_text);
                    t_list=new ArrayList(list_all_text);
                    Collections.shuffle(t_list);
                    t_list.remove(item_text);

                    q.setOp1_text((String) t_list.get(1));
                    q.setOp1_img_id(map.get(t_list.get(1)));
                    q.setOp2_text((String) t_list.get(2));
                    q.setOp2_img_id(map.get(t_list.get(2)));
                    q.setOp4_text((String) t_list.get(3));
                    q.setOp4_img_id(map.get(t_list.get(3)));
                    break;
                case 4:
                    q.setOp4_img_id(map.get(item_text));
                    q.setOp4_text(item_text);
                    t_list=new ArrayList(list_all_text);
                    Collections.shuffle(t_list);
                    t_list.remove(item_text);

                    q.setOp1_text((String) t_list.get(1));
                    q.setOp1_img_id(map.get(t_list.get(1)));
                    q.setOp2_text((String) t_list.get(2));
                    q.setOp2_img_id(map.get(t_list.get(2)));
                    q.setOp3_text((String) t_list.get(3));
                    q.setOp3_img_id(map.get(t_list.get(3)));
                    break;
            }

            list_QType_Sound_Img_Text.add(q);
        }
        return list_QType_Sound_Img_Text;

    }
    public String getQ_text_sound() {
        return q_text_sound;
    }

    public void setQ_text_sound(String q_text_sound) {
        this.q_text_sound = q_text_sound;
    }

    public int getOp1_img_id() {
        return op1_img_id;
    }

    public void setOp1_img_id(int op1_img_id) {
        this.op1_img_id = op1_img_id;
    }

    public int getOp2_img_id() {
        return op2_img_id;
    }

    public void setOp2_img_id(int op2_img_id) {
        this.op2_img_id = op2_img_id;
    }

    public int getOp3_img_id() {
        return op3_img_id;
    }

    public void setOp3_img_id(int op3_img_id) {
        this.op3_img_id = op3_img_id;
    }

    public int getOp4_img_id() {
        return op4_img_id;
    }

    public void setOp4_img_id(int op4_img_id) {
        this.op4_img_id = op4_img_id;
    }

    public String getOp1_text() {
        return op1_text;
    }

    public void setOp1_text(String op1_text) {
        this.op1_text = op1_text;
    }

    public String getOp2_text() {
        return op2_text;
    }

    public void setOp2_text(String op2_text) {
        this.op2_text = op2_text;
    }

    public String getOp3_text() {
        return op3_text;
    }

    public void setOp3_text(String op3_text) {
        this.op3_text = op3_text;
    }

    public String getOp4_text() {
        return op4_text;
    }

    public void setOp4_text(String op4_text) {
        this.op4_text = op4_text;
    }

    public String getAns_text() {
        return ans_text;
    }

    public void setAns_text(String ans_text) {
        this.ans_text = ans_text;
    }

    public String getQ_type() {
        return q_type;
    }

    public void setQ_type(String q_type) {
        this.q_type = q_type;
    }

    public String getQ_text() {
        return q_text;
    }

    public void setQ_text(String q_text) {
        this.q_text = q_text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
