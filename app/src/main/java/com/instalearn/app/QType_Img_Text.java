package com.instalearn.app;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QType_Img_Text extends SuperQuestion{
    static List<QType_Img_Text> list_QType_Img_Text=new ArrayList<>();

    int q_img_id;
    String op1_string;
    String op2_string;
    String op3_string;
    String op4_string;
    String ans_text_id;

     String q_type="img_text";
     String q_text="Match the image to the word.";
     String category;

    public int getQ_img_id() {
        return q_img_id;
    }

    public void setQ_img_id(int q_img_id) {
        this.q_img_id = q_img_id;
    }

    public String getOp1_string() {
        return op1_string;
    }

    public void setOp1_string(String op1_string) {
        this.op1_string = op1_string;
    }

    public String getOp2_string() {
        return op2_string;
    }

    public void setOp2_string(String op2_string) {
        this.op2_string = op2_string;
    }

    public String getOp3_string() {
        return op3_string;
    }

    public void setOp3_string(String op3_string) {
        this.op3_string = op3_string;
    }

    public String getOp4_string() {
        return op4_string;
    }

    public void setOp4_string(String op4_string) {
        this.op4_string = op4_string;
    }

    public String getAns_text_id() {
        return ans_text_id;
    }

    public void setAns_text_id(String ans_text_id) {
        this.ans_text_id = ans_text_id;
    }

    public  String getQ_type() {
        return q_type;
    }

    public  void setQ_type(String q_type) {
        this.q_type = q_type;
    }

    public  String getQ_text() {
        return q_text;
    }

    public  void setQ_text(String q_text) {
        this.q_text = q_text;
    }

    public  String getCategory() {
        return category;
    }

    public  void setCategory(String category) {
        this.category = category;
    }

    public static List<QType_Img_Text> makeQuestions(Activity context) {

        list_QType_Img_Text.clear();
        SharedPreferences sharedPreferences=context.getSharedPreferences("kidsPro", Context.MODE_PRIVATE);
        String category=sharedPreferences.getString("category","");

        String[] itemNames ={};//= context.getResources().getStringArray(R.array.farmanimalNames);
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

        Map<Integer,String> map=new HashMap<Integer,String>();
        for (int i=0;i<itemNames.length;i++)
        {
            map.put(images_array[i],itemNames[i]);
        }
        List list_all_text= new ArrayList();
        for(String e: itemNames) {
            list_all_text.add(e);
        }
        List randomList= new ArrayList(); randomList.add(1);randomList.add(2);randomList.add(3);randomList.add(4);

        for (int img_id : images_array)
        {
            QType_Img_Text q= new QType_Img_Text();
            q.type="2";
            q.setQ_img_id(img_id);
            q.setAns_text_id(map.get(img_id));
            Collections.shuffle(randomList);
            int opAns= (int) randomList.get(1);
            List t_list;
            switch (opAns)
            {
                case 1:
                    q.setOp1_string(map.get(img_id));
                    t_list=new ArrayList(list_all_text);
                    Collections.shuffle(t_list);
                    t_list.remove(map.get(img_id));

                    q.setOp2_string((String) t_list.get(1));
                    q.setOp3_string((String) t_list.get(2));
                    q.setOp4_string((String) t_list.get(3));

                    break;
                case 2:
                    q.setOp2_string(map.get(img_id));
                    t_list=new ArrayList(list_all_text);
                    Collections.shuffle(t_list);
                    t_list.remove(map.get(img_id));

                    q.setOp1_string((String) t_list.get(1));
                    q.setOp3_string((String) t_list.get(2));
                    q.setOp4_string((String) t_list.get(3));

                    break;
                case 3:
                    q.setOp3_string(map.get(img_id));
                    t_list=new ArrayList(list_all_text);
                    Collections.shuffle(t_list);
                    t_list.remove(map.get(img_id));

                    q.setOp1_string((String) t_list.get(1));
                    q.setOp2_string((String) t_list.get(2));
                    q.setOp4_string((String) t_list.get(3));

                    break;
                case 4:
                    q.setOp4_string(map.get(img_id));
                    t_list=new ArrayList(list_all_text);
                    Collections.shuffle(t_list);
                    t_list.remove(map.get(img_id));

                    q.setOp1_string((String) t_list.get(1));
                    q.setOp2_string((String) t_list.get(2));
                    q.setOp3_string((String) t_list.get(3));

                    break;

            }
            list_QType_Img_Text.add(q);


        }
        return list_QType_Img_Text;
    }
}
