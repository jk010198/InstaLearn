package com.instalearn.app;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import at.markushi.ui.CircleButton;

import static android.content.Context.MODE_PRIVATE;

public class Tab3 extends Fragment implements
        TextToSpeech.OnInitListener {
    static QType_Img_Img q_img_img;
    static QType_Img_Text q_img_text;
    static QType_Sound_Img_Text q_soung_img_text;
    static String q_type;

    /// img to text

    static TextView tv_question;
    static ImageView iv_question_img_img, iv_question_img_text;
    CircleButton speaker;
    static Button btn_submit_answer, btn_option1_img_text, btn_option2_img_text, btn_option3_img_text, btn_option4_img_text,
            btn_option1_sound_img_text, btn_option2_sound_img_text, btn_option3_sound_img_text, btn_option4_sound_img_text;

    static ImageView iv_option1_img_img, iv_option2_img_img, iv_option3_img_img, iv_option4_img_img;
    static ImageView iv_option1_sound_img_text, iv_option2_sound_img_text, iv_option3_sound_img_text, iv_option4_sound_img_text;

    static Activity context;
    static CardView cardView1_img_img, cardView2_img_img, cardView3_img_img, cardView4_img_img,
            cardView1_img_text, cardView2_img_text, cardView3_img_text, cardView4_img_text,
            cardView1_sound_img_text, cardView2_sound_img_text, cardView3_sound_img_text, cardView4_sound_img_text;
    static ImageView iv_question_img;
    static RelativeLayout relativeLayout_img_img;
    static RelativeLayout relativeLayout_img_text;
    static RelativeLayout relativeLayout_sound_img_text;

    static int number = 0;
    static boolean isSelected, cv1, cv2, cv3, cv4, nxt_question = true;

    static List list_QType_Img_Img, list_QType_Img_Text, list_QType_Sound_Img_Text;
    static int score = 0;
    static private List combinedQuestions;

    TextToSpeech tts;
    TextToSpeech.OnInitListener onInitListener;
    static int pitch, speechRate;
    static double d_pitch, d_speech;
    SharedPreferences sp;
    View rootView;


    public Tab3(Activity activity) {
        context = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("TestLearning", "onCreateView");
        rootView = inflater.inflate(R.layout.three, container, false);

        tv_question = rootView.findViewById(R.id.tv_question);
        iv_question_img_img = rootView.findViewById(R.id.iv_question_img_img);
        iv_question_img_text = rootView.findViewById(R.id.iv_question_img_text);

        iv_option1_img_img = rootView.findViewById(R.id.imageView_1_img_img);
        iv_option2_img_img = rootView.findViewById(R.id.imageView_2_img_img);
        iv_option3_img_img = rootView.findViewById(R.id.imageView_3_img_img);
        iv_option4_img_img = rootView.findViewById(R.id.imageView_4_img_img);

        iv_option1_sound_img_text = rootView.findViewById(R.id.iv_option1_sound_img_text);
        iv_option2_sound_img_text = rootView.findViewById(R.id.iv_option2_sound_img_text);
        iv_option3_sound_img_text = rootView.findViewById(R.id.iv_option3_sound_img_text);
        iv_option4_sound_img_text = rootView.findViewById(R.id.iv_option4_sound_img_text);


        btn_option1_img_text = rootView.findViewById(R.id.button_option1_img_text);
        btn_option2_img_text = rootView.findViewById(R.id.button_option2_img_text);
        btn_option3_img_text = rootView.findViewById(R.id.button_option3_img_text);
        btn_option4_img_text = rootView.findViewById(R.id.button_option4_img_text);
        btn_option1_sound_img_text = rootView.findViewById(R.id.button_option1_sound_img_text);
        btn_option2_sound_img_text = rootView.findViewById(R.id.button_option2_sound_img_text);
        btn_option3_sound_img_text = rootView.findViewById(R.id.button_option3_sound_img_text);
        btn_option4_sound_img_text = rootView.findViewById(R.id.button_option4_sound_img_text);
        btn_submit_answer = rootView.findViewById(R.id.button_answer_submit);

        cardView1_img_img = rootView.findViewById(R.id.iv_answer_option1_img_img);
        cardView2_img_img = rootView.findViewById(R.id.iv_answer_option2_img_img);
        cardView3_img_img = rootView.findViewById(R.id.iv_answer_option3_img_img);
        cardView4_img_img = rootView.findViewById(R.id.iv_answer_option4_img_img);
        cardView1_img_text = rootView.findViewById(R.id.cv_answer_option1_img_text);
        cardView2_img_text = rootView.findViewById(R.id.cv_answer_option2_img_text);
        cardView3_img_text = rootView.findViewById(R.id.cv_answer_option3_img_text);
        cardView4_img_text = rootView.findViewById(R.id.cv_answer_option4_img_text);
        cardView1_sound_img_text = rootView.findViewById(R.id.cv_answer_option1_sound_img_text);
        cardView2_sound_img_text = rootView.findViewById(R.id.cv_answer_option2_sound_img_text);
        cardView3_sound_img_text = rootView.findViewById(R.id.cv_answer_option3_sound_img_text);
        cardView4_sound_img_text = rootView.findViewById(R.id.cv_answer_option4_sound_img_text);

        relativeLayout_img_img = rootView.findViewById(R.id.relative_img_img);
        relativeLayout_img_text = rootView.findViewById(R.id.relative_img_text);
        relativeLayout_sound_img_text = rootView.findViewById(R.id.relative_sound_img_text);

        speaker = rootView.findViewById(R.id.speaker);

        // pitch & speechrate retrive from sp //
        sp = context.getSharedPreferences("sp_sound", MODE_PRIVATE);
        pitch = sp.getInt("sp_pitch", 10);
        speechRate = sp.getInt("sp_speech", 8);
        //////////////////////////////////////////////////////////////////////////////////

        /// tts configure ////////////
        tts = new TextToSpeech(context, onInitListener);
        //////////////////////////////////////////////////////////////////////////////////

        /////////// speaking names method ////////////////////
        speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Speak(q_soung_img_text.q_text_sound);
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        /// setup question and their options //////////////
        // makeQuestions();
        // setQuestion(number);
        //////////////////////////////////////////////////////////////////////////////////

        /////////// checking which button selected ////////////
        //img-img start//
        cardView1_img_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "cv1 i i clicked");
                isSelected = true;
                cv1 = true;
                cv2 = false;
                cv3 = false;
                cv4 = false;

                cardView1_img_img.setBackgroundColor(getResources().getColor(R.color.blue));
                cardView2_img_img.setBackgroundColor(getResources().getColor(R.color.white));
                cardView3_img_img.setBackgroundColor(getResources().getColor(R.color.white));
                cardView4_img_img.setBackgroundColor(getResources().getColor(R.color.white));

            }
        });

        cardView2_img_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "cv2 i i clicked");
                isSelected = true;
                cv1 = false;
                cv2 = true;
                cv3 = false;
                cv4 = false;
                cardView1_img_img.setBackgroundColor(getResources().getColor(R.color.white));
                cardView2_img_img.setBackgroundColor(getResources().getColor(R.color.blue));
                cardView3_img_img.setBackgroundColor(getResources().getColor(R.color.white));
                cardView4_img_img.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        cardView3_img_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "cv3 i i clicked");
                isSelected = true;
                cv1 = false;
                cv2 = false;
                cv3 = true;
                cv4 = false;
                cardView1_img_img.setBackgroundColor(getResources().getColor(R.color.white));
                cardView2_img_img.setBackgroundColor(getResources().getColor(R.color.white));
                cardView3_img_img.setBackgroundColor(getResources().getColor(R.color.blue));
                cardView4_img_img.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        cardView4_img_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "cv4 i i clicked");
                isSelected = true;
                cv1 = false;
                cv2 = false;
                cv3 = false;
                cv4 = true;
                cardView1_img_img.setBackgroundColor(getResources().getColor(R.color.white));
                cardView2_img_img.setBackgroundColor(getResources().getColor(R.color.white));
                cardView3_img_img.setBackgroundColor(getResources().getColor(R.color.white));
                cardView4_img_img.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });
        // img-img end //

        // img-text start //

        btn_option1_img_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "btn1 i t clicked");
                isSelected = true;
                cv1 = true;
                cv2 = false;
                cv3 = false;
                cv4 = false;
                cardView1_img_text.setBackgroundColor(getResources().getColor(R.color.blue));
                cardView2_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView3_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView4_img_text.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        btn_option2_img_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "btn2 i t clicked");
                isSelected = true;
                cv1 = false;
                cv2 = true;
                cv3 = false;
                cv4 = false;
                cardView1_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView2_img_text.setBackgroundColor(getResources().getColor(R.color.blue));
                cardView3_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView4_img_text.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        btn_option3_img_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "btn3 i t clicked");
                isSelected = true;
                cv1 = false;
                cv2 = false;
                cv3 = true;
                cv4 = false;
                cardView1_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView2_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView3_img_text.setBackgroundColor(getResources().getColor(R.color.blue));
                cardView4_img_text.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        btn_option4_img_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "btn4 i t clicked");
                isSelected = true;
                cv1 = false;
                cv2 = false;
                cv3 = false;
                cv4 = true;
                cardView1_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView2_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView3_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView4_img_text.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });

        // img-text end //

        // sound-img-text start //

        btn_option1_sound_img_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "btn1 sit clicked");
                isSelected = true;
                cv1 = true;
                cv2 = false;
                cv3 = false;
                cv4 = false;
                cardView1_sound_img_text.setBackgroundColor(getResources().getColor(R.color.blue));
                cardView2_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView3_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView4_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        btn_option2_sound_img_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "btn2 sit clicked");
                isSelected = true;
                cv1 = false;
                cv2 = true;
                cv3 = false;
                cv4 = false;
                cardView1_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView2_sound_img_text.setBackgroundColor(getResources().getColor(R.color.blue));
                cardView3_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView4_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        btn_option3_sound_img_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "btn3 sit clicked");
                isSelected = true;
                cv1 = false;
                cv2 = false;
                cv3 = true;
                cv4 = false;
                cardView1_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView2_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView3_sound_img_text.setBackgroundColor(getResources().getColor(R.color.blue));
                cardView4_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        btn_option4_sound_img_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TestLearning", "btn4 sit clicked");
                isSelected = true;
                cv1 = false;
                cv2 = false;
                cv3 = false;
                cv4 = true;
                cardView1_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView2_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView3_sound_img_text.setBackgroundColor(getResources().getColor(R.color.white));
                cardView4_sound_img_text.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });

        // sound-img-text end //
        //////////////////////////////////////////////////////////////////////////////////

        /////// checking result /////////////////
        btn_submit_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nxt_question) {
                    Log.d("TestLearning", "nextQ in");
                    if (q_type.equals("img_img")) {
                        Log.d("TestLearning", "q type img img");
                        if (cardView1_img_img.isEnabled()) {
                            Log.d("TestLearning", "card views enabled");
                            if (isSelected) {
                                cardView1_img_img.setEnabled(false);
                                cardView2_img_img.setEnabled(false);
                                cardView3_img_img.setEnabled(false);
                                cardView4_img_img.setEnabled(false);
                                Log.d("TestLearning", "is Selected found true cv made fales");

                                int correct_option_no = q_img_img.correct_option_no;
                                if (correct_option_no == 1) {
                                    Log.d("TestLearning", "op1 correct");
                                    check();
                                    cardView1_img_img.setBackgroundColor(getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv1) {
                                        score++;
                                        resetMyViews();
                                    }
                                } else if (correct_option_no == 2) {
                                    Log.d("TestLearning", "op2 correct");
                                    check();
                                    cardView2_img_img.setBackgroundColor(getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv2) {
                                        score++;
                                        resetMyViews();
                                    }
                                } else if (correct_option_no == 3) {
                                    Log.d("TestLearning", "op3 correct");
                                    check();
                                    cardView3_img_img.setBackgroundColor(getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv3) {
                                        score++;
                                        resetMyViews();
                                    }
                                } else if (correct_option_no == 4) {
                                    Log.d("TestLearning", "op4 correct");
                                    check();
                                    cardView4_img_img.setBackgroundColor(getResources().getColor(R.color.correct_ans));//getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv4) {
                                        score++;
                                        resetMyViews();
                                    }
                                }
                            } else {
                                Log.d("TestLearning", "in else of No Option Selected.....");
                                Toast.makeText(context, "please select option.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.d("TestLearning", "else of nothing");
                            Toast.makeText(context, "ahnknlkasnalks", Toast.LENGTH_SHORT).show();
                        }
                    } else if (q_type.equals("img_text")) {
                        Log.d("TestLearning", "q type img text");
                        if (cardView1_img_text.isEnabled()) {
                            Log.d("TestLearning", "card views enabled");
                            if (isSelected) {
                                cardView1_img_text.setEnabled(false);
                                cardView2_img_text.setEnabled(false);
                                cardView3_img_text.setEnabled(false);
                                cardView4_img_text.setEnabled(false);

                                btn_option1_img_text.setEnabled(false);
                                btn_option2_img_text.setEnabled(false);
                                btn_option3_img_text.setEnabled(false);
                                btn_option4_img_text.setEnabled(false);

                                Log.d("TestLearning", "is Selected found true cv made fales");

                                String correct_ans = q_img_text.getAns_text_id();
                                if (btn_option1_img_text.getText().equals(correct_ans)) {
                                    Log.d("TestLearning", "op1 correct");
                                    check();
                                    cardView1_img_text.setBackgroundColor(getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv1) {
                                        score++;
                                        resetMyViews();
                                    }
                                } else if (btn_option2_img_text.getText().equals(correct_ans)) {
                                    Log.d("TestLearning", "op2 correct");
                                    check();
                                    cardView2_img_text.setBackgroundColor(getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv2) {
                                        score++;
                                        resetMyViews();
                                    }
                                } else if (btn_option3_img_text.getText().equals(correct_ans)) {
                                    Log.d("TestLearning", "op3 correct");
                                    check();
                                    cardView3_img_text.setBackgroundColor(getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv3) {
                                        score++;
                                        resetMyViews();
                                    }
                                } else if (btn_option4_img_text.getText().equals(correct_ans)) {
                                    Log.d("TestLearning", "op4 correct");
                                    check();
                                    cardView4_img_text.setBackgroundColor(getResources().getColor(R.color.correct_ans));//getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv4) {
                                        score++;
                                        resetMyViews();
                                    }
                                }
                            } else {
                                Log.d("TestLearning", "in else of No Option Selected.....");
                                Toast.makeText(context, "please select option.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.d("TestLearning", "else of nothing");
                            Toast.makeText(context, "ahnknlkasnalks", Toast.LENGTH_SHORT).show();
                        }
                    } else if (q_type.equals("sound_img_text")) {
                        Log.d("TestLearning", "q type sound img text");
                        if (cardView1_sound_img_text.isEnabled()) {
                            Log.d("TestLearning", "card views enabled");
                            if (isSelected) {
                                cardView1_sound_img_text.setEnabled(false);
                                cardView2_sound_img_text.setEnabled(false);
                                cardView3_sound_img_text.setEnabled(false);
                                cardView4_sound_img_text.setEnabled(false);

                                btn_option1_sound_img_text.setEnabled(false);
                                btn_option2_sound_img_text.setEnabled(false);
                                btn_option3_sound_img_text.setEnabled(false);
                                btn_option4_sound_img_text.setEnabled(false);

                                Log.d("TestLearning", "is Selected found true cv made fales");

                                String correct_ans = q_soung_img_text.getAns_text();
                                if (btn_option1_sound_img_text.getText().equals(correct_ans)) {
                                    Log.d("TestLearning", "op1 correct");
                                    check();
                                    cardView1_sound_img_text.setBackgroundColor(getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv1) {
                                        score++;
                                        resetMyViews();
                                    }
                                } else if (btn_option2_sound_img_text.getText().equals(correct_ans)) {
                                    Log.d("TestLearning", "op2 correct");
                                    check();
                                    cardView2_sound_img_text.setBackgroundColor(getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv2) {
                                        score++;
                                        resetMyViews();
                                    }
                                } else if (btn_option3_sound_img_text.getText().equals(correct_ans)) {
                                    Log.d("TestLearning", "op3 correct");
                                    check();
                                    cardView3_sound_img_text.setBackgroundColor(getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv3) {
                                        score++;
                                        resetMyViews();
                                    }
                                } else if (btn_option4_sound_img_text.getText().equals(correct_ans)) {
                                    Log.d("TestLearning", "op4 correct");
                                    check();
                                    cardView4_sound_img_text.setBackgroundColor(getResources().getColor(R.color.correct_ans));//getResources().getColor(R.color.correct_ans));
                                    nxt_question = false;
                                    if (cv4) {
                                        score++;
                                        resetMyViews();
                                    }
                                }
                            } else {
                                Log.d("TestLearning", "in else of No Option Selected.....");
                                Toast.makeText(context, "please select option.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.d("TestLearning", "else of nothing");
                            Toast.makeText(context, "ahnknlkasnalks", Toast.LENGTH_SHORT).show();
                        }

                    }
                } else {
                    resetMyViews();
                }
            }
        });
        //////////////////////////////////////////////////////////////////////////////////


        return rootView;
    }

    public static void resetMyViews() {
        Log.d("TestLearning", "Main ELSE.......");
        nxt_question = true;

        cardView1_img_img.setEnabled(true);
        cardView2_img_img.setEnabled(true);
        cardView3_img_img.setEnabled(true);
        cardView4_img_img.setEnabled(true);

        cardView1_img_img.setBackgroundColor(context.getResources().getColor(R.color.white));
        cardView2_img_img.setBackgroundColor(context.getResources().getColor(R.color.white));
        cardView3_img_img.setBackgroundColor(context.getResources().getColor(R.color.white));
        cardView4_img_img.setBackgroundColor(context.getResources().getColor(R.color.white));

        cardView1_img_text.setEnabled(true);
        cardView2_img_text.setEnabled(true);
        cardView3_img_text.setEnabled(true);
        cardView4_img_text.setEnabled(true);

        btn_option1_img_text.setEnabled(true);
        btn_option2_img_text.setEnabled(true);
        btn_option3_img_text.setEnabled(true);
        btn_option4_img_text.setEnabled(true);

        cardView1_img_text.setBackgroundColor(context.getResources().getColor(R.color.white));
        cardView2_img_text.setBackgroundColor(context.getResources().getColor(R.color.white));
        cardView3_img_text.setBackgroundColor(context.getResources().getColor(R.color.white));
        cardView4_img_text.setBackgroundColor(context.getResources().getColor(R.color.white));

        cardView1_sound_img_text.setEnabled(true);
        cardView2_sound_img_text.setEnabled(true);
        cardView3_sound_img_text.setEnabled(true);
        cardView4_sound_img_text.setEnabled(true);

        btn_option1_sound_img_text.setEnabled(true);
        btn_option2_sound_img_text.setEnabled(true);
        btn_option3_sound_img_text.setEnabled(true);
        btn_option4_sound_img_text.setEnabled(true);

        cardView1_sound_img_text.setBackgroundColor(context.getResources().getColor(R.color.white));
        cardView2_sound_img_text.setBackgroundColor(context.getResources().getColor(R.color.white));
        cardView3_sound_img_text.setBackgroundColor(context.getResources().getColor(R.color.white));
        cardView4_sound_img_text.setBackgroundColor(context.getResources().getColor(R.color.white));

        isSelected = false;
        cv1 = false;
        cv2 = false;
        cv3 = false;
        cv4 = false;
        number++;
        Log.d("TestLearning", "Before Setting Question " + number);
        setQuestion(number);
        Log.d("TestLearning", "After Setting Question " + number);

    }

    static void makeQuestions() {
        Log.d("TestLearning", "In Make Question...");
        list_QType_Img_Img = QType_Img_Img.makeQuestions(context);
        list_QType_Img_Text = QType_Img_Text.makeQuestions(context);
        list_QType_Sound_Img_Text = QType_Sound_Img_Text.makeQuestions(context);
        Collections.shuffle(list_QType_Img_Img);
        Collections.shuffle(list_QType_Img_Text);
        Collections.shuffle(list_QType_Sound_Img_Text);

        combinedQuestions = new ArrayList();

        combinedQuestions.add(list_QType_Img_Img.get(0));
        combinedQuestions.add(list_QType_Img_Img.get(1));
        combinedQuestions.add(list_QType_Img_Img.get(2));
        combinedQuestions.add(list_QType_Img_Text.get(0));
        combinedQuestions.add(list_QType_Img_Text.get(1));
        combinedQuestions.add(list_QType_Img_Text.get(2));
        combinedQuestions.add(list_QType_Sound_Img_Text.get(0));
        combinedQuestions.add(list_QType_Sound_Img_Text.get(1));
        combinedQuestions.add(list_QType_Sound_Img_Text.get(2));
        combinedQuestions.add(list_QType_Sound_Img_Text.get(3));
        Collections.shuffle(combinedQuestions);
        Log.d("TestLearning", "Shuffling of questions done");
    }

    //img to text methods
    ///////////// setup question and their option ///////////////
    public static void setQuestion(int number) {


        if (number >= 10) {
            Log.d("TestLearning", "Q no 11");
            Intent intent = new Intent(context.getApplication(), ScoreActivity.class);
            intent.putExtra("score", score);
            context.startActivity(intent);

        } else {
            Log.d("TestLearning", "Setting Question " + number);
            SuperQuestion sq = (SuperQuestion) combinedQuestions.get(number);
            if (sq.type.equals("1")) {

                Log.d("TestLearning", "Q " + number + " of type 1");
                relativeLayout_img_img.setVisibility(View.VISIBLE);
                relativeLayout_img_text.setVisibility(View.INVISIBLE);
                relativeLayout_sound_img_text.setVisibility(View.INVISIBLE);
                QType_Img_Img q = (QType_Img_Img) sq;
                q_type = q.getQ_type();
                q_img_img = q;

                iv_question_img_img.setImageResource(q.getQ_img_id());
                iv_option1_img_img.setImageResource(q.op1_img_id);
                iv_option2_img_img.setImageResource(q.op2_img_id);
                iv_option3_img_img.setImageResource(q.op3_img_id);
                iv_option4_img_img.setImageResource(q.op4_img_id);
                tv_question.setText(q.getQ_text());

            } else if (sq.type.equals("2")) {
                Log.d("TestLearning", "Q " + number + " of type 2");
                relativeLayout_img_img.setVisibility(View.INVISIBLE);
                relativeLayout_img_text.setVisibility(View.VISIBLE);
                relativeLayout_sound_img_text.setVisibility(View.INVISIBLE);
                QType_Img_Text q = (QType_Img_Text) sq;//(QType_Img_Text) list_QType_Img_Text.get(number);
                q_type = q.getQ_type();
                q_img_text = q;

                iv_question_img_text.setImageResource(q.getQ_img_id());
                tv_question.setText(q.getQ_text());
                btn_option1_img_text.setText(q.getOp1_string());
                btn_option2_img_text.setText(q.getOp2_string());
                btn_option3_img_text.setText(q.getOp3_string());
                btn_option4_img_text.setText(q.getOp4_string());
                if(q.getOp1_string().contains("No Mobile Ph")){
                    btn_option1_img_text.setTextSize(15);
                }else if(q.getOp2_string().contains("No Mobile Ph")){
                    btn_option2_img_text.setTextSize(15);
                }else if(q.getOp3_string().contains("No Mobile Ph")){
                    btn_option3_img_text.setTextSize(15);
                }else if(q.getOp4_string().contains("No Mobile Ph")){
                    btn_option4_img_text.setTextSize(15);
                }
                else {
                    btn_option1_img_text.setTextSize(18);
                    btn_option2_img_text.setTextSize(18);
                    btn_option3_img_text.setTextSize(18);
                    btn_option4_img_text.setTextSize(18);
                }



            } else if (sq.type.equals("3")) {
                Log.d("TestLearning", "Q " + number + " of type 3");
                relativeLayout_img_img.setVisibility(View.INVISIBLE);
                relativeLayout_img_text.setVisibility(View.INVISIBLE);
                relativeLayout_sound_img_text.setVisibility(View.VISIBLE);
                QType_Sound_Img_Text q = (QType_Sound_Img_Text) sq;
                q_type = q.getQ_type();
                q_soung_img_text = q;

                iv_option1_sound_img_text.setImageResource(q.op1_img_id);
                iv_option2_sound_img_text.setImageResource(q.op2_img_id);
                iv_option3_sound_img_text.setImageResource(q.op3_img_id);
                iv_option4_sound_img_text.setImageResource(q.op4_img_id);
                btn_option1_sound_img_text.setText(q.op1_text);
                btn_option2_sound_img_text.setText(q.op2_text);
                btn_option3_sound_img_text.setText(q.op3_text);
                btn_option4_sound_img_text.setText(q.op4_text);
                tv_question.setText(q.getQ_text());
                if(q.op1_text.contains("No Mobile Ph")){
                    btn_option1_sound_img_text.setTextSize(15);
                }else if(q.op2_text.contains("No Mobile Ph")){
                    btn_option2_sound_img_text.setTextSize(15);
                }else if(q.op3_text.contains("No Mobile Ph")){
                    btn_option3_sound_img_text.setTextSize(15);
                }else if(q.op4_text.contains("No Mobile Ph")){
                    btn_option4_sound_img_text.setTextSize(15);
                }
                else {
                    btn_option1_sound_img_text.setTextSize(18);
                    btn_option2_sound_img_text.setTextSize(18);
                    btn_option3_sound_img_text.setTextSize(18);
                    btn_option4_sound_img_text.setTextSize(18);

                }


            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////

    /////////// checking result //////////////
    public void check() {
        if (q_type.equals("img_img")) {
            Log.d("TestLearning", "Check()...");
            if (cv1) {
                Log.d("TestLearning", "Check cv1...");
                cardView1_img_img.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            } else if (cv2) {
                Log.d("TestLearning", "Checkcv2...");
                cardView2_img_img.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            } else if (cv3) {
                Log.d("TestLearning", "Checkcv3...");
                cardView3_img_img.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            } else if (cv4) {
                Log.d("TestLearning", "Checkcv4...");
                cardView4_img_img.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            }
        } else if (q_type.equals("img_text")) {
            if (cv1) {
                cardView1_img_text.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            } else if (cv2) {
                cardView2_img_text.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            } else if (cv3) {
                cardView3_img_text.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            } else if (cv4) {
                cardView4_img_text.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            }
        } else if (q_type.equals("sound_img_text")) {
            if (cv1) {
                cardView1_sound_img_text.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            } else if (cv2) {
                cardView2_sound_img_text.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            } else if (cv3) {
                cardView3_sound_img_text.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            } else if (cv4) {
                cardView4_sound_img_text.setBackgroundColor(getResources().getColor(R.color.wrong_ans));
            }
        }
    }
    /////////////////////////

    //////// for speaking /////////////////////
    public void Speak(String name) {
        d_speech = ((double) (speechRate + 1) / 10);
        d_pitch = ((double) (pitch + 1) / 10);
        String text = name;
        //set pitch rate adjusted by user
        tts.setPitch((float) d_pitch);
        //set speech rate adjusted by user
        tts.setSpeechRate((float) d_speech);
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    /////////////////////////

    /////////tts setup start
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

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                //speakOut(tts_name);
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }
    ////////////////// tts setup end
}