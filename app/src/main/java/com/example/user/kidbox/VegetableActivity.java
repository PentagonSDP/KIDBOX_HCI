package com.example.user.kidbox;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by emma on 10/10/17.
 */

public class VegetableActivity extends AppCompatActivity {

    GridView gv;
    Context context_veg;
    ArrayList prgmName;
    public static int [] vImagesList={R.drawable.carrot,R.drawable.spinach,R.drawable.radish,R.drawable.bittermelon,
            R.drawable.pumpkin,R.drawable.cucumber,R.drawable.watermelon,R.drawable.banana, R.drawable.guava};
    //public static String [] prgmNameList={"Bangladesh","India","Pakistan","Bhutan","Nepal","Sri Lanka","Maldives"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetable);

        context_veg = this;
        gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(new CustomAdapter_veg(this, vImagesList));

    }
}


        /*imgIds = new int[]{R.drawable.helpmom, R.drawable.plant, R.drawable.puzzle, R.drawable.school};

        Button prev = (Button) findViewById(R.id.left_button);
        Button nxt = (Button) findViewById(R.id.right_button);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = imgIds.length; i>0; i--) {
                    ImageView vegImg = (ImageView) findViewById(R.id.veg_img);
                    vegImg.setImageResource(imgIds[i]);
                }

            }
        });

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while (true){
                    int i=0;
                    if(imgIds[i]>= imgIds.length-1)
                    {
                        //i=imgIds.length-1;
                        ImageView vegImg = (ImageView) findViewById(R.id.veg_img);
                        vegImg.setImageResource(imgIds[imgIds.length-1]);
                    }
                    else if(imgIds[i]<imgIds.length)
                    {
                        i++;
                        ImageView vegImg = (ImageView) findViewById(R.id.veg_img);
                        vegImg.setImageResource(imgIds[i]);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "end image", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }*/










       /* ImageView load_image = (ImageView)findViewById(R.id.load_Image);

        Glide.with(this)
                .load(R.drawable.carota)
                .asGif()
                .crossFade()
                .into(load_image);

        ImageView imageView = (ImageView) findViewById(R.id.load_Image);
        ImageView imageView2 = (ImageView) findViewById(R.id.load_Image2);
        ImageView imageView3 = (ImageView) findViewById(R.id.load_Image3);
        ImageView imageView4 = (ImageView) findViewById(R.id.load_Image4);
        ImageView imageView5 = (ImageView) findViewById(R.id.load_Image5);
        ImageView imageView6 = (ImageView) findViewById(R.id.load_Image6);
        ImageView imageView7 = (ImageView) findViewById(R.id.load_Image7);
        ImageView imageView8 = (ImageView) findViewById(R.id.load_Image8);
        ImageView imageView9 = (ImageView) findViewById(R.id.load_Image9);
        ImageView imageView10 = (ImageView) findViewById(R.id.load_Image10);

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(R.drawable.carota).into(imageViewTarget);

        GlideDrawableImageViewTarget imageViewTarget2 = new GlideDrawableImageViewTarget(imageView2);
        Glide.with(this).load(R.drawable.carot_pecod).into(imageViewTarget2);



        GlideDrawableImageViewTarget imageViewTarget4 = new GlideDrawableImageViewTarget(imageView4);
        Glide.with(this).load(R.drawable.banana).into(imageViewTarget4);

        GlideDrawableImageViewTarget imageViewTarget5 = new GlideDrawableImageViewTarget(imageView5);
        Glide.with(this).load(R.drawable.broccoli).into(imageViewTarget5);

        GlideDrawableImageViewTarget imageViewTarget6 = new GlideDrawableImageViewTarget(imageView6);
        Glide.with(this).load(R.drawable.cucdance).into(imageViewTarget6);

        GlideDrawableImageViewTarget imageViewTarget7 = new GlideDrawableImageViewTarget(imageView7);
        Glide.with(this).load(R.drawable.carot_pecod2).into(imageViewTarget7);

        GlideDrawableImageViewTarget imageViewTarget8 = new GlideDrawableImageViewTarget(imageView8);
        Glide.with(this).load(R.drawable.maca).into(imageViewTarget8);

        GlideDrawableImageViewTarget imageViewTarget9 = new GlideDrawableImageViewTarget(imageView9);
        Glide.with(this).load(R.drawable.veg).into(imageViewTarget9);

       GlideDrawableImageViewTarget imageViewTarget10 = new GlideDrawableImageViewTarget(imageView10);
        Glide.with(this).load(R.drawable.dancingfruits).into(imageViewTarget10);

        //GlideDrawableImageViewTarget imageViewTarget3 = new GlideDrawableImageViewTarget(imageView3);
        //Glide.with(this).load(R.drawable.carot_potato).into(imageViewTarget3);
    }*/






