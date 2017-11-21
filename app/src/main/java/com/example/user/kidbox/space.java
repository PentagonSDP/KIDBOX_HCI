package com.example.user.kidbox;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by rumaly on 11/18/17.
 */

public class space extends AppCompatActivity {
    private LinearLayout mGallery;
    private int[] mImgIds;
    private String[] mTxtIds;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.space);
        mInflater = LayoutInflater.from(this);
        initData();
        initView();


    }

    private void initData() {

        mImgIds = new int[]{R.drawable.earth,R.drawable.mars,R.drawable.pluto,R.drawable.commets,R.drawable.solarsystem,R.drawable.sat1,R.drawable.spaceship2,R.drawable.stars,R.drawable.ulka1};
        //size 300x300px
        mTxtIds = new String[] {"Earth","Mars", "Pluto", "Commet", "Solar System", "Sattelite", "Spaceship", "Stars", "Meteor"};

    }

    private void initView() {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);
        for (int i = 0; i < mImgIds.length; i++) {

            View view = mInflater.inflate(R.layout.space_gallery,
                    mGallery, false);
            ImageView img = (ImageView) view
                    .findViewById(R.id.item_image);
            img.setImageResource(mImgIds[i]);
            TextView txt = (TextView) view
                    .findViewById(R.id.item_text);
            txt.setText(mTxtIds[i]);
            //Toast toast=Toast.makeText(this,mTxtIds[i], Toast.LENGTH_SHORT);
            //toast.show();
            mGallery.addView(view);
        }
    }

}
