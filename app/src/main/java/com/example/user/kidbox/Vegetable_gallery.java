package com.example.user.kidbox;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * Created by emma on 11/16/17.
 */

public class Vegetable_gallery extends AppCompatActivity{
    private LinearLayout linear1;
    private HorizontalScrollView scrollbar1;
    private int sharedFlag =0;
    private int carot,spinach,radish,bitter,pumpkin,cucumber,melon,banana,guava;

    SharedPreferences sp_car,sp_spn,sp_rd,sp_bit,sp_pm,sp_cu,sp_ml,sp_ba,sp_gu;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetable_gallery);
        Intent mIntent = getIntent();
        int optn = mIntent.getIntExtra("select", 0);

        sp_car = getSharedPreferences("carPrefs", Activity.MODE_PRIVATE);
        sp_spn = getSharedPreferences("spnPrefs", Activity.MODE_PRIVATE);
        sp_rd = getSharedPreferences("rdPrefs", Activity.MODE_PRIVATE);
        sp_bit = getSharedPreferences("bitPrefs", Activity.MODE_PRIVATE);
        sp_pm = getSharedPreferences("pmPrefs", Activity.MODE_PRIVATE);
        sp_cu = getSharedPreferences("cuPrefs", Activity.MODE_PRIVATE);
        sp_ml = getSharedPreferences("mlPrefs", Activity.MODE_PRIVATE);
        sp_ba = getSharedPreferences("baPrefs", Activity.MODE_PRIVATE);
        sp_gu = getSharedPreferences("guPrefs", Activity.MODE_PRIVATE);

        carot = sp_car.getInt("carot", -1);
        spinach = sp_spn.getInt("spinach", -1);
        radish = sp_rd.getInt("radish", -1);
        bitter = sp_bit.getInt("bitter", -1);
        pumpkin = sp_pm.getInt("pumpkin", -1);
        cucumber = sp_cu.getInt("cucumber", -1);
        melon = sp_ml.getInt("melon", -1);
        banana = sp_ba.getInt("banana", -1);
        guava = sp_gu.getInt("guava", -1);


        if(carot<=0)
        {
            carot = 0;
        }
        if(spinach<=0)
        {
            spinach = 0;
        }
        if(radish<=0)
        {
            radish = 0;
        }
        if(bitter<=0)
        {
            bitter = 0;
        }
        if(pumpkin<=0)
        {
            pumpkin = 0;
        }
        if(cucumber<=0)
        {
            cucumber = 0;
        }if(melon<=0)
        {
            melon = 0;
        }if(banana<=0)
        {
            banana = 0;
        }if(guava<=0)
        {
            guava = 0;
        }


        final LinearLayout lin1 = (LinearLayout)findViewById(R.id.lay1);
        final LinearLayout lin2 = (LinearLayout)findViewById(R.id.lay2);
        final LinearLayout lin3 = (LinearLayout)findViewById(R.id.lay3);

        lin3.setVisibility(View.GONE);

        ImageView iv = (ImageView) findViewById(R.id.veg_img);
        TextView tv_vg1 = (TextView) findViewById(R.id.veg_txt1);
        final TextView tv_vg3 = (TextView) findViewById(R.id.veg_txt3);

        tv_vg3.setVisibility(View.GONE);

        ImageButton ib1 = (ImageButton) findViewById(R.id.yes);
        ImageButton ib2 = (ImageButton) findViewById(R.id.no);

        scrollbar1 = (HorizontalScrollView)findViewById(R.id.scroll1);
        linear1 = (LinearLayout)findViewById(R.id.linear1);

        //TextView tv2_sp = (TextView) findViewById(R.id.t2_sp);


        if (optn == 0) {

            tv_vg1.setText("Have you eaten any Carrot today?");
            tv_vg3.setText("Eat 1 carrot and see the progress!");

            iv.setImageResource(R.drawable.carrot);

            tv_vg1.setTextColor(Color.parseColor("#fff563"));
            tv_vg3.setTextColor(Color.parseColor("#fff563"));
            lin1.setBackgroundColor(Color.parseColor("#298c35"));

            ib1.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    sharedFlag=1;
                    carot++;
                    lin1.setBackgroundDrawable( getResources().getDrawable(R.drawable.carrotback) );

                    lin2.setVisibility(View.GONE);
                    lin3.setVisibility(View.VISIBLE);
                    ImageView load_image = (ImageView)findViewById(R.id.load_Image);

                    Glide.with(Vegetable_gallery.this)
                            .load(R.drawable.carota1)
                            .asGif()
                            .crossFade()
                            .into(load_image);

                    ImageView imageView = (ImageView) findViewById(R.id.load_Image);
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
                    Glide.with(Vegetable_gallery.this).load(R.drawable.carota1).into(imageViewTarget);

                    ImageView image ;
                    for(int i = 0; i< carot; i++){
                        image = new ImageView(getApplicationContext());
                        image.setImageResource(R.drawable.carrot);
                        int width = 100;
                        int height = 100;

                        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
                        image.setLayoutParams(parms);
                        Log.i("i", i+"");
                        linear1.addView(image);
                        scrollbar1.fullScroll(HorizontalScrollView.FOCUS_RIGHT);

                        SharedPreferences.Editor editor = sp_car.edit();
                        editor.putInt("carot", carot);
                        editor.commit();
                        //Toast.makeText(getApplicationContext(), "sum value put:"+sum,
                                //Toast.LENGTH_SHORT).show();

                    }

                }
            });
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    lin2.setVisibility(View.VISIBLE);
                    lin3.setVisibility(View.GONE);
                    tv_vg3.setVisibility(View.VISIBLE);
                }
            });

            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");

        }

        if (optn == 1) {

            tv_vg1.setText("Have you eaten any 'Spinach' today?");
            tv_vg3.setText("Eat Spinach and see the progress!");
            iv.setImageResource(R.drawable.spinach);

            tv_vg1.setTextColor(Color.parseColor("#298c35"));
            tv_vg3.setTextColor(Color.parseColor("#298c35"));

            lin1.setBackgroundColor(Color.parseColor("#fff563"));

            ib1.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    spinach++;
                    lin1.setBackgroundDrawable( getResources().getDrawable(R.drawable.spinachback) );

                    lin2.setVisibility(View.GONE);
                    lin3.setVisibility(View.VISIBLE);
                    ImageView load_image = (ImageView)findViewById(R.id.load_Image);

                    Glide.with(Vegetable_gallery.this)
                            .load(R.drawable.spinachs)
                            .asGif()
                            .crossFade()
                            .into(load_image);

                    ImageView imageView = (ImageView) findViewById(R.id.load_Image);
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
                    Glide.with(Vegetable_gallery.this).load(R.drawable.spinachs).into(imageViewTarget);

                    ImageView image ;


                    for(int i = 0; i< spinach; i++){
                        image = new ImageView(getApplicationContext());
                        image.setImageResource(R.drawable.spinach);
                        int width = 100;
                        int height = 100;
                        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
                        image.setLayoutParams(parms);
                        Log.i("i", i+"");
                        linear1.addView(image);
                        scrollbar1.fullScroll(HorizontalScrollView.FOCUS_RIGHT);


                        SharedPreferences.Editor editor = sp_spn.edit();
                        editor.putInt("spinach", spinach);
                        editor.commit();
                    }

                }
            });
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    lin2.setVisibility(View.VISIBLE);
                    lin3.setVisibility(View.GONE);
                    tv_vg3.setVisibility(View.VISIBLE);
                }
            });

        }

        if(optn==2)
        {
            tv_vg1.setText("Have you eaten any 'Radish' today?");
            tv_vg3.setText("Eat Radish and see the progress!");
            iv.setImageResource(R.drawable.radish);

            tv_vg1.setTextColor(Color.parseColor("#d12e9d"));
            tv_vg3.setTextColor(Color.parseColor("#d12e9d"));

            lin1.setBackgroundColor(Color.parseColor("#99f959"));

            ib1.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    radish++;
                    lin1.setBackgroundDrawable( getResources().getDrawable(R.drawable.radishback) );

                    lin2.setVisibility(View.GONE);
                    lin3.setVisibility(View.VISIBLE);
                    ImageView load_image = (ImageView)findViewById(R.id.load_Image);

                    Glide.with(Vegetable_gallery.this)
                            .load(R.drawable.radishs)
                            .asGif()
                            .crossFade()
                            .into(load_image);

                    ImageView imageView = (ImageView) findViewById(R.id.load_Image);
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
                    Glide.with(Vegetable_gallery.this).load(R.drawable.radishs).into(imageViewTarget);

                    ImageView image ;

                    for(int i = 0; i< radish; i++){
                        image = new ImageView(getApplicationContext());
                        image.setImageResource(R.drawable.radish);
                        int width = 100;
                        int height = 100;
                        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
                        image.setLayoutParams(parms);
                        Log.i("i", i+"");
                        linear1.addView(image);
                        scrollbar1.fullScroll(HorizontalScrollView.FOCUS_RIGHT);

                        SharedPreferences.Editor editor = sp_rd.edit();
                        editor.putInt("radish", spinach);
                        editor.commit();
                    }

                }
            });
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    lin2.setVisibility(View.VISIBLE);
                    lin3.setVisibility(View.GONE);
                    tv_vg3.setVisibility(View.VISIBLE);
                }
            });

        }


        if(optn==3)
        {
            tv_vg1.setText("Have you eaten any 'Bitter melon' today?");
            tv_vg3.setText("Eat Bitter melon and see the progress!");
            iv.setImageResource(R.drawable.bittermelon);

            tv_vg1.setTextColor(Color.parseColor("#298c35"));
            tv_vg3.setTextColor(Color.parseColor("#298c35"));

            lin1.setBackgroundColor(Color.parseColor("#fff563"));

            ib1.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    bitter++;
                    lin1.setBackgroundDrawable( getResources().getDrawable(R.drawable.bittermelonback) );

                    lin2.setVisibility(View.GONE);
                    lin3.setVisibility(View.VISIBLE);
                    ImageView load_image = (ImageView)findViewById(R.id.load_Image);

                    Glide.with(Vegetable_gallery.this)
                            .load(R.drawable.bittermelons)
                            .asGif()
                            .crossFade()
                            .into(load_image);

                    ImageView imageView = (ImageView) findViewById(R.id.load_Image);
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
                    Glide.with(Vegetable_gallery.this).load(R.drawable.bittermelons).into(imageViewTarget);


                    ImageView image ;

                    for(int i = 0; i< bitter; i++){
                        image = new ImageView(getApplicationContext());
                        image.setImageResource(R.drawable.bittermelon);
                        int width = 100;
                        int height = 100;
                        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
                        image.setLayoutParams(parms);
                        Log.i("i", i+"");
                        linear1.addView(image);
                        scrollbar1.fullScroll(HorizontalScrollView.FOCUS_RIGHT);

                        SharedPreferences.Editor editor = sp_bit.edit();
                        editor.putInt("bitter", bitter);
                        editor.commit();
                    }

                }
            });
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {

                    lin2.setVisibility(View.VISIBLE);
                    lin3.setVisibility(View.GONE);
                    tv_vg3.setVisibility(View.VISIBLE);
                }
            });

        }


        if(optn==4)
        {
            tv_vg1.setText("Have you eaten any 'Pumpkin' today?");
            tv_vg3.setText("Eat Pumpkin and see the progress!");
            iv.setImageResource(R.drawable.pumpkin);

            tv_vg1.setTextColor(Color.parseColor("#ed9633"));
            tv_vg3.setTextColor(Color.parseColor("#ed9633"));

            lin1.setBackgroundColor(Color.parseColor("#8f24b6"));

            ib1.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    pumpkin++;
                    lin1.setBackgroundDrawable( getResources().getDrawable(R.drawable.pumpkinback) );

                    lin2.setVisibility(View.GONE);
                    lin3.setVisibility(View.VISIBLE);
                    ImageView load_image = (ImageView)findViewById(R.id.load_Image);

                    Glide.with(Vegetable_gallery.this)
                            .load(R.drawable.pumpkins)
                            .asGif()
                            .crossFade()
                            .into(load_image);

                    ImageView imageView = (ImageView) findViewById(R.id.load_Image);
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
                    Glide.with(Vegetable_gallery.this).load(R.drawable.pumpkins).into(imageViewTarget);

                    ImageView image ;
                    for(int i = 0; i< pumpkin; i++){
                        image = new ImageView(getApplicationContext());
                        image.setImageResource(R.drawable.pumpkin);
                        int width = 100;
                        int height = 100;
                        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
                        image.setLayoutParams(parms);
                        Log.i("i", i+"");
                        linear1.addView(image);
                        scrollbar1.fullScroll(HorizontalScrollView.FOCUS_RIGHT);

                        SharedPreferences.Editor editor = sp_pm.edit();
                        editor.putInt("pumpkin", pumpkin);
                        editor.commit();
                    }


                }
            });
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    lin2.setVisibility(View.VISIBLE);
                    lin3.setVisibility(View.GONE);
                    tv_vg3.setVisibility(View.VISIBLE);
                }
            });

        }


        if(optn==5)
        {
            tv_vg1.setText("Have you eaten any 'Cucumber' today?");
            tv_vg3.setText("Eat Cucumber and see the progress!");
            iv.setImageResource(R.drawable.cucumber);

            tv_vg1.setTextColor(Color.parseColor("#ed9633"));
            tv_vg3.setTextColor(Color.parseColor("#ed9633"));

            lin1.setBackgroundColor(Color.parseColor("#a4f1f9"));

            ib1.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    cucumber++;
                    lin1.setBackgroundDrawable( getResources().getDrawable(R.drawable.cucamberback) );

                    lin2.setVisibility(View.GONE);
                    lin3.setVisibility(View.VISIBLE);
                    ImageView load_image = (ImageView)findViewById(R.id.load_Image);

                    Glide.with(Vegetable_gallery.this)
                            .load(R.drawable.cucambers)
                            .asGif()
                            .crossFade()
                            .into(load_image);

                    ImageView imageView = (ImageView) findViewById(R.id.load_Image);
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
                    Glide.with(Vegetable_gallery.this).load(R.drawable.cucambers).into(imageViewTarget);

                    ImageView image ;

                    for(int i = 0; i< cucumber; i++){
                        image = new ImageView(getApplicationContext());
                        image.setImageResource(R.drawable.cucumber);
                        int width = 100;
                        int height = 100;
                        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
                        image.setLayoutParams(parms);
                        Log.i("i", i+"");
                        linear1.addView(image);
                        scrollbar1.fullScroll(HorizontalScrollView.FOCUS_RIGHT);

                        SharedPreferences.Editor editor = sp_cu.edit();
                        editor.putInt("cucumber", cucumber);
                        editor.commit();
                    }

                }
            });
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    lin2.setVisibility(View.VISIBLE);
                    lin3.setVisibility(View.GONE);
                    tv_vg3.setVisibility(View.VISIBLE);
                }
            });


        }

        if(optn==6)
        {
            tv_vg1.setText("Have you eaten any 'Watermelon' today?");
            tv_vg3.setText("Eat Watermelon and see the progress!");
            iv.setImageResource(R.drawable.watermelon);

            tv_vg1.setTextColor(Color.parseColor("#8f24b6"));
            tv_vg3.setTextColor(Color.parseColor("#8f24b6"));

            lin1.setBackgroundColor(Color.parseColor("#ffcf7d"));

            ib1.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    melon++;
                    lin1.setBackgroundDrawable( getResources().getDrawable(R.drawable.watermelonback) );

                    lin2.setVisibility(View.GONE);
                    lin3.setVisibility(View.VISIBLE);
                    ImageView load_image = (ImageView)findViewById(R.id.load_Image);

                    Glide.with(Vegetable_gallery.this)
                            .load(R.drawable.watermelons)
                            .asGif()
                            .crossFade()
                            .into(load_image);

                    ImageView imageView = (ImageView) findViewById(R.id.load_Image);
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
                    Glide.with(Vegetable_gallery.this).load(R.drawable.watermelons).into(imageViewTarget);

                    ImageView image ;

                    for(int i = 0; i< melon; i++){
                        image = new ImageView(getApplicationContext());
                        image.setImageResource(R.drawable.watermelon);
                        int width = 100;
                        int height = 100;
                        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
                        image.setLayoutParams(parms);
                        Log.i("i", i+"");
                        linear1.addView(image);
                        scrollbar1.fullScroll(HorizontalScrollView.FOCUS_RIGHT);

                        SharedPreferences.Editor editor = sp_ml.edit();
                        editor.putInt("melon", melon);
                        editor.commit();
                    }

                }
            });
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    lin2.setVisibility(View.VISIBLE);
                    lin3.setVisibility(View.GONE);
                    tv_vg3.setVisibility(View.VISIBLE);
                }
            });

        }

        if(optn==7)
        {
            tv_vg1.setText("Have you eaten any 'Banana' today?");
            tv_vg3.setText("Eat Banana and see the progress!");
            iv.setImageResource(R.drawable.banana);

            tv_vg1.setTextColor(Color.parseColor("#f19545"));
            tv_vg3.setTextColor(Color.parseColor("#f19545"));

            lin1.setBackgroundColor(Color.parseColor("#4dedc8"));

            ib1.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    banana++;
                    lin1.setBackgroundDrawable( getResources().getDrawable(R.drawable.bananaback) );

                    lin2.setVisibility(View.GONE);
                    lin3.setVisibility(View.VISIBLE);
                    ImageView load_image = (ImageView)findViewById(R.id.load_Image);

                    Glide.with(Vegetable_gallery.this)
                            .load(R.drawable.bananas)
                            .asGif()
                            .crossFade()
                            .into(load_image);

                    ImageView imageView = (ImageView) findViewById(R.id.load_Image);
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
                    Glide.with(Vegetable_gallery.this).load(R.drawable.bananas).into(imageViewTarget);

                    ImageView image ;

                    for(int i = 0; i< banana; i++){
                        image = new ImageView(getApplicationContext());
                        image.setImageResource(R.drawable.banana);
                        int width = 100;
                        int height = 100;
                        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
                        image.setLayoutParams(parms);
                        Log.i("i", i+"");
                        linear1.addView(image);
                        scrollbar1.fullScroll(HorizontalScrollView.FOCUS_RIGHT);

                        SharedPreferences.Editor editor = sp_ba.edit();
                        editor.putInt("banana", banana);
                        editor.commit();
                    }

                }
            });
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    lin2.setVisibility(View.VISIBLE);
                    lin3.setVisibility(View.GONE);
                    tv_vg3.setVisibility(View.VISIBLE);
                }
            });

        }


        if(optn==8)
        {
            tv_vg1.setText("Have you eaten any 'Guava' today?");
            tv_vg3.setText("Eat Guava and see the progress!");
            iv.setImageResource(R.drawable.guava);

            tv_vg1.setTextColor(Color.parseColor("#298c35"));
            tv_vg3.setTextColor(Color.parseColor("#298c35"));

            lin1.setBackgroundColor(Color.parseColor("#ffbbeb"));

            ib1.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    guava++;
                    lin1.setBackgroundDrawable( getResources().getDrawable(R.drawable.guavaback) );

                    lin2.setVisibility(View.GONE);
                    lin3.setVisibility(View.VISIBLE);
                    ImageView load_image = (ImageView)findViewById(R.id.load_Image);

                    Glide.with(Vegetable_gallery.this)
                            .load(R.drawable.guavas)
                            .asGif()
                            .crossFade()
                            .into(load_image);

                    ImageView imageView = (ImageView) findViewById(R.id.load_Image);
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
                    Glide.with(Vegetable_gallery.this).load(R.drawable.guavas).into(imageViewTarget);

                    ImageView image ;

                    for(int i = 0; i< guava; i++){
                        image = new ImageView(getApplicationContext());
                        image.setImageResource(R.drawable.guava);
                        int width = 100;
                        int height = 100;
                        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
                        image.setLayoutParams(parms);
                        Log.i("i", i+"");
                        linear1.addView(image);
                        scrollbar1.fullScroll(HorizontalScrollView.FOCUS_RIGHT);

                        SharedPreferences.Editor editor = sp_gu.edit();
                        editor.putInt("guava", guava);
                        editor.commit();
                    }

                }
            });
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    lin2.setVisibility(View.VISIBLE);
                    lin3.setVisibility(View.GONE);
                    tv_vg3.setVisibility(View.VISIBLE);
                }
            });



        }

    }
}
