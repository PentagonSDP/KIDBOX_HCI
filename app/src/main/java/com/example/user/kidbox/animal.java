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

public class animal extends AppCompatActivity {
    private LinearLayout mGallery;
    private int[] mImgIds;
    private String[] mTxtIds;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal);
        mInflater = LayoutInflater.from(this);
        initData();
        initView();


    }

    private void initData() {

        mImgIds = new int[]{R.drawable.tiger,R.drawable.lion,R.drawable.deer,R.drawable.cat,R.drawable.cow,R.drawable.elephant,R.drawable.goat,R.drawable.horse};
        //size 300x300px
        mTxtIds = new String[] {"Tiger(রয়েল বেঙ্গল টাইগার)","Lion( সিংহ)", "Deer( হরিণ)","Cat( বিড়াল)","Cow ( গরু)", "Elephant( হাতি)","Goat(" +
                ")" ,"Horse( ঘোড়া)"};

    }

    private void initView() {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);
        for (int i = 0; i < mImgIds.length; i++) {

            View view = mInflater.inflate(R.layout.animal_gallery,
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
