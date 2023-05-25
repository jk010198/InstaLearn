package com.instalearn.app;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.yinglan.shadowimageview.ShadowImageView;

import java.util.ArrayList;

import at.markushi.ui.CircleButton;

public class ListAdaptorCategory extends ArrayAdapter {

    Activity context;
    ArrayList<CategoryModel> alist;
    ImageButton ib_sound;
    TextView tv_name;
    int drawable;

    public ListAdaptorCategory(@NonNull Activity context, int resource, @NonNull ArrayList<CategoryModel> product) {
        super(context, resource, product);
        this.context = context;
        alist = product;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.list_layout, null, true);
        TextView txtName = rowView.findViewById(R.id.tv_category_name);
        ShadowImageView image = rowView.findViewById(R.id.imageView);
        CircleButton ib_sound = rowView.findViewById(R.id.ib_sound);

        ////////////////// sound button ///////////////////////////////////
        ib_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = String.valueOf((alist.get(position).name));
                Tab1.speakOut(name);
            }
        });
        /////////////////

        txtName.setText(alist.get(position).name);
        image.setImageResource(alist.get(position).image);

        return rowView;
    }
}