package com.example.user.kidbox;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by emma on 10/19/17.
 */

public class TabActivity_3 extends Activity {
    private HorizontalScrollView scrollbarSh;
    private LinearLayout l, l1, l2,lGift2,lGift1;
    private int layHeight, layWidth, layHeight1, layWidth1, existingCoin;
    SharedPreferences sp1,sp2;
    private TextView tGift,tshort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        sp1 = getSharedPreferences("totalPrefs", Activity.MODE_PRIVATE);
        sp2 = getSharedPreferences("existingPrefs", Activity.MODE_PRIVATE);

        layWidth = sp1.getInt("total", -1);
        layWidth1 = sp2.getInt("existing", -1);

        sp1.edit().remove("totalPrefs");
        sp1.edit().commit();
        sp1.edit().clear();

        sp2.edit().remove("existingPrefs");
        sp2.edit().commit();
        sp2.edit().clear();

        scrollbarSh= (HorizontalScrollView)findViewById(R.id.scrollSh);
        l = (LinearLayout) findViewById(R.id.linear3);
        l1 = (LinearLayout) findViewById(R.id.linear4);
        l2 = (LinearLayout) findViewById(R.id.linear5);
        lGift1 = (LinearLayout) findViewById(R.id.l_gift1);
        //lGift2 = (LinearLayout) findViewById(R.id.l_gift2);

        FloatingActionButton fabback = (FloatingActionButton) findViewById(R.id.fabBack);
        fabback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        tGift = (TextView)findViewById(R.id.t_gift);
        tshort = (TextView)findViewById(R.id.t_shortage);
        tGift.setVisibility(View.GONE);

        ViewTreeObserver observer = l.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // TODO Auto-generated method stub
                layHeight = l.getHeight();
                layWidth = l.getWidth();

                SharedPreferences.Editor editor = sp1.edit();
                editor.putInt("total", layWidth);
                editor.commit();
                l.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });

        ImageView load_image = (ImageView)findViewById(R.id.load_Image);
        //
        Glide.with(TabActivity_3.this).load(R.drawable.gifts).asGif().crossFade().into(load_image);

        ImageView imageView = (ImageView) findViewById(R.id.load_Image);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
        Glide.with(TabActivity_3.this).load(R.drawable.gifts).into(imageViewTarget);


        int point = totalScore();
        show_coin(point);
        coin_shortage();
    }
    protected void init() {
        layHeight = l.getHeight();
        layWidth = l.getWidth();
        //Toast.makeText(getActivity,""+a+" "+b,3000).show();
        Toast.makeText(getApplicationContext(), "height:" + layHeight + "width:" + layWidth, Toast.LENGTH_SHORT).show();
    }

    private void show_coin(int point) {
        ImageView img_coin1;
        int tot = point;

        if(tot==0) {
            tGift.setVisibility(View.GONE);
            l.setVisibility(View.GONE);
            l1.setVisibility(View.GONE);
            tshort.setVisibility(View.GONE);
        }
        else {
            for (int i = 0; i < tot; i++) {
                img_coin1 = new ImageView(getApplicationContext());
                img_coin1.setImageResource(R.drawable.dollar);
                int width = 70;
                int height = 70;

                LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width, height);
                img_coin1.setLayoutParams(parms);
                Log.i("i", i + "");
                l1.addView(img_coin1);

                ViewTreeObserver observer = l1.getViewTreeObserver();
                observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        // TODO Auto-generated method stub
                        layHeight1 = l1.getHeight();
                        layWidth1 = l1.getWidth();
                        //Toast.makeText(getActivity,""+a+" "+b,3000).show();

                        SharedPreferences.Editor editor = sp2.edit();
                        editor.putInt("existing", layWidth1);
                        editor.commit();
                        l1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                });
            }
        }
    }

    private void coin_shortage() {
        existingCoin=(layWidth-layWidth1)/70;
        ImageView img_coin2;

        //Toast.makeText(getApplicationContext(), "coin" + existingCoin, Toast.LENGTH_SHORT).show();
        for (int j = 0; j < existingCoin; j++) {
            img_coin2 = new ImageView(getApplicationContext());
            img_coin2.setImageResource(R.drawable.dollar);
            int width = 70;
            int height = 70;

            LinearLayout.LayoutParams parms2 = new LinearLayout.LayoutParams(width, height);
            img_coin2.setLayoutParams(parms2);
            l2.addView(img_coin2);
            scrollbarSh.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
        }

        if(existingCoin==0) {
            tGift.setVisibility(View.VISIBLE);
            tshort.setVisibility(View.GONE);
        }
        if(existingCoin>=10) {
            l.setVisibility(View.GONE);
            l1.setVisibility(View.GONE);
        }
    }
    private int totalScore(){
        String sc = "";
        Log.e("Tab Activity3::file", "");
        try {
            FileInputStream fileIn=openFileInput("totalScore.txt");
            Log.e("Tab Activity3::file", "");
            if( fileIn == null ){
                Log.e("Tab Activity3::file", "noFile");
            }
            else{
                Log.e("Tab Activity3::file", "File found");
                InputStreamReader InputRead = new InputStreamReader(fileIn);
                BufferedReader bufferedReader = new BufferedReader(InputRead);
                String str = "";
                str = bufferedReader.readLine();
                Log.e("Tab Activity3::score", str);
                sc = str;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                sc = "0";
                OutputStreamWriter outputStreamWriter= new OutputStreamWriter(openFileOutput("totalScore.txt", MODE_PRIVATE));
                outputStreamWriter.write("0");
                outputStreamWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                Log.e("Tab Activity3::catch2", e1.toString());
            }
            Log.e("Tab Activity3::catch", e.toString());
        }
        int n = Integer.parseInt(sc);
        return n;
    }
}



        /*TextView score = (TextView) findViewById (R.id.my_point);
        String sc = "";
        Log.e("Tab Activity3::file", "");
        try {
            FileInputStream fileIn=openFileInput("totalScore.txt");
            Log.e("Tab Activity3::file", "");
            if( fileIn == null ){
                Log.e("Tab Activity3::file", "noFile");
            }
            else{
                Log.e("Tab Activity3::file", "File found");
                InputStreamReader InputRead = new InputStreamReader(fileIn);
                BufferedReader bufferedReader = new BufferedReader(InputRead);
                String str = "";
                str = bufferedReader.readLine();
                Log.e("Tab Activity3::score", str);
                sc = str;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                OutputStreamWriter outputStreamWriter= new OutputStreamWriter(openFileOutput("totalScore.txt", MODE_PRIVATE));
                outputStreamWriter.write("0");
                outputStreamWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                Log.e("Tab Activity3::catch2", e1.toString());
            }
            Log.e("Tab Activity3::catch", e.toString());
        }
        score.setText(sc);*/
