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
 * Created by rumaly on 11/16/17.
 */

public class color extends AppCompatActivity {
    private LinearLayout mGallery;
    private int[] mImgIds;
    private String[] mTxtIds;
    private String[] colors;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color);
        mInflater = LayoutInflater.from(this);
        initData();
        initView();


    }

    private void initData() {

        mImgIds = new int[]{R.drawable.orange,R.drawable.red,R.drawable.yellow,R.drawable.blue,R.drawable.green};
        //size 300x300px
        mTxtIds = new String[] {"Orange( কমলা)","Red (লাল)","Yellow (হলুদ)","Blue (নীল)","Green (সবুজ)"};
        colors = new String[] {"#f97603","#fa090d","#fcf802","#0949fa","#1dd63f"};

    }

    private void initView() {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);
        for (int i = 0; i < mImgIds.length; i++) {

            View view = mInflater.inflate(R.layout.color_gallery,
                    mGallery, false);
            ImageView img = (ImageView) view
                    .findViewById(R.id.item_image);
            img.setImageResource(mImgIds[i]);
            TextView txt = (TextView) view
                    .findViewById(R.id.item_text);
            txt.setText(mTxtIds[i]);
            txt.setTextColor(Color.parseColor(colors[i]));
            //Toast toast=Toast.makeText(this,mTxtIds[i], Toast.LENGTH_SHORT);
            //toast.show();
            mGallery.addView(view);
        }
    }

}
