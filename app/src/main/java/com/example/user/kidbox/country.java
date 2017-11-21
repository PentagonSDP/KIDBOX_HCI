package com.example.user.kidbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rumaly on 11/16/17.
 */

public class country extends AppCompatActivity {
    private LinearLayout mGallery;
    private int[] mImgIds;
    private String[] mTxtIds;
    private String[] mTxtIds2;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country);
        mInflater = LayoutInflater.from(this);
        initData();
        initView();


    }

    private void initData() {

        mImgIds = new int[]{R.drawable.afgan,R.drawable.australia,R.drawable.bangladesh,R.drawable.china,R.drawable.india,R.drawable.japan,R.drawable.korea,R.drawable.nepal,R.drawable.pakistan,R.drawable.srilanka};
        //size 300x300px
        mTxtIds = new String[] {"Country:Afghanistan","Country:Australia", "Country:Bangladesh", "Country:China", "Country:India", "Country:Japan","Country:North Korea","Country:Nepal", "Country:Pakistan", "Country:Sri Lanka"};
        mTxtIds2 = new String[] {"Capital:Kabul","Capital:Canberra","Capital:Dhaka", "Capital:Beijing", "Capital:New Delhi", "Capital:Tokyo", "Capital:Pyongyang","Capital:Kathmandu", "Capital:Islamabad","Capital:Colombo" };

    }

    private void initView() {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);
        for (int i = 0; i < mImgIds.length; i++) {

            View view = mInflater.inflate(R.layout.country_gallery,
                    mGallery, false);
            TextView txt = (TextView) view
                    .findViewById(R.id.item_text1);
            txt.setText(mTxtIds[i]);
            ImageView img = (ImageView) view
                    .findViewById(R.id.item_image);
            img.setImageResource(mImgIds[i]);

            TextView txt2 = (TextView) view
                    .findViewById(R.id.item_text);

            txt2.setText(mTxtIds2[i]);
            //Toast toast=Toast.makeText(this,mTxtIds[i], Toast.LENGTH_SHORT);
            //toast.show();
            mGallery.addView(view);
        }
    }

}
