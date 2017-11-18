package com.example.user.kidbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * Created by emma on 10/10/17.
 */

public class VegetableActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable);
       /* ImageView load_image = (ImageView)findViewById(R.id.load_Image);

        Glide.with(this)
                .load(R.drawable.carota)
                .asGif()
                .crossFade()
                .into(load_image);*/

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
    }
}





