package com.instalearn.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class FragmentActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    TabItem tl;
    String itemType;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        tabLayout=findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              int tab_pos=  tab.getPosition();
              // Toast.makeText(FragmentActivity.this, "Tab "+tab_pos+ " selected", Toast.LENGTH_SHORT).show();
                if(tab_pos==2)
                {
                    Tab3.makeQuestions();
                    Tab3.score=0;
                    Tab3.number=0;
                    Tab3.setQuestion(Tab3.number);

                    Tab3.cardView1_img_img.setEnabled(true);
                    Tab3.cardView2_img_img.setEnabled(true);
                    Tab3.cardView3_img_img.setEnabled(true);
                    Tab3.cardView4_img_img.setEnabled(true);

                    Tab3.cardView1_img_img.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));
                    Tab3.cardView2_img_img.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));
                    Tab3.cardView3_img_img.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));
                    Tab3.cardView4_img_img.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));

                    Tab3.cardView1_img_text.setEnabled(true);
                    Tab3.cardView2_img_text.setEnabled(true);
                    Tab3.cardView3_img_text.setEnabled(true);
                    Tab3.cardView4_img_text.setEnabled(true);

                    Tab3.btn_option1_img_text.setEnabled(true);
                    Tab3.btn_option2_img_text.setEnabled(true);
                    Tab3.btn_option3_img_text.setEnabled(true);
                    Tab3.btn_option4_img_text.setEnabled(true);

                    Tab3.cardView1_img_text.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));
                    Tab3.cardView2_img_text.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));
                    Tab3.cardView3_img_text.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));
                    Tab3.cardView4_img_text.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));

                    Tab3.cardView1_sound_img_text.setEnabled(true);
                    Tab3.cardView2_sound_img_text.setEnabled(true);
                    Tab3.cardView3_sound_img_text.setEnabled(true);
                    Tab3.cardView4_sound_img_text.setEnabled(true);

                    Tab3.btn_option1_sound_img_text.setEnabled(true);
                    Tab3.btn_option2_sound_img_text.setEnabled(true);
                    Tab3.btn_option3_sound_img_text.setEnabled(true);
                    Tab3.btn_option4_sound_img_text.setEnabled(true);

                    Tab3.cardView1_sound_img_text.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));
                    Tab3.cardView2_sound_img_text.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));
                    Tab3.cardView3_sound_img_text.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));
                    Tab3.cardView4_sound_img_text.setBackgroundColor(Tab3.context.getResources().getColor(R.color.white));

                    Tab3.isSelected = false;
                    Tab3.cv1 = false;
                    Tab3.cv2 = false;
                    Tab3.cv3 = false;
                    Tab3.cv4 = false;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        itemType = getIntent().getStringExtra("itemType");
        SharedPreferences sharedPreferences = getSharedPreferences("kidsPro", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("category", itemType);
        editor.commit();
        tl = findViewById(R.id.tabItem2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                    Tab1 tb1 = new Tab1(FragmentActivity.this, itemType);
                    return tb1;

                case 1:
                    Tab2 tb2 = new Tab2(FragmentActivity.this, itemType);
                    return tb2;

                case 2:
                    Tab3 tb3 = new Tab3(FragmentActivity.this);
                    return tb3;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        //Toast.makeText(this, "Tab index: "+tabLayout.getSelectedTabPosition(), Toast.LENGTH_SHORT).show();
        if (tabLayout.getSelectedTabPosition()== 2) {
            Toast.makeText(this, "Can't go back from quiz...", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
    }
}