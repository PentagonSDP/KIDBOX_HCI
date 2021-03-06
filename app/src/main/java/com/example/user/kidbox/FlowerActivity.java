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
 * Created by emma on 10/10/17.
 */

public class FlowerActivity extends AppCompatActivity {
    private LinearLayout mGallery;
    private int[] mImgIds;
    private String[] mTxtIds;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower);
        mInflater = LayoutInflater.from(this);
        initData();
        initView();


    }

    private void initData() {

        mImgIds = new int[]{R.drawable.lily,R.drawable.kodom,R.drawable.rose,R.drawable.jasmine,R.drawable.joba,R.drawable.gadha,R.drawable.oporajita,R.drawable.sheuli};
        //size 300x300px
        mTxtIds = new String[] {"Lily(শাপলা ফুল)","Burflower(কদম ফুল)", "Rose( গোলাপ ফুল)","Jasmine (বেলি ফুল)","China Rose (জবা ফুল)", "Marigold(গাঁদা ফুল)","Blue Petunia(নীল অপরাজিতা)" ,"Sheuli Flower( শিউলি ফুল)"};

    }

    private void initView() {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);
        for (int i = 0; i < mImgIds.length; i++) {

            View view = mInflater.inflate(R.layout.flower_gallery,
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
