package com.example.user.kidbox;

import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Add_Video_Link extends AppCompatActivity {

    EditText mEditText;
    Button mButton;
    String VIDEO_ID = "";
    String ID = "";
    ImageButton mImageButton, mFinger;
    SharedPreferences prefs;

    @Override
    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean("firstrun", true)) {
           startActivity(new Intent(this, OnBoardingActivity.class));
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__video__link);

        prefs = getSharedPreferences("com.example.user.kidbox", MODE_PRIVATE);

        mImageButton = (ImageButton)findViewById(R.id.youtubelogo);
        mImageButton.setBaselineAlignBottom(true);
        mFinger = (ImageButton)findViewById(R.id.finger);
        mEditText = (EditText) findViewById(R.id.autoCompleteTextView);
        mButton = (Button)findViewById(R.id.done);


        Animation animSlideToRight = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_left_to_right);

        Animation animSlideToLeft = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_left_to_right);

        animSlideToLeft.setRepeatCount(Animation.INFINITE);

        animSlideToRight.setRepeatMode(Animation.INFINITE);
        animSlideToRight.setRepeatCount(Animation.INFINITE);


// Start the animation like this
        mFinger.startAnimation(animSlideToRight);




        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com")));
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                extractURL();
                return;
            }
        });

    }
    @Override
    public void finish()
    {
        if(VIDEO_ID.length() > 0)
        {
            Intent intent = new Intent();
            intent.putExtra("result", VIDEO_ID);
            setResult(RESULT_OK, intent);
            super.finish();
        }
    }

    void extractURL() {
        ID = mEditText.getText().toString();
        if(ID.length() > 0)
        {
            String[] parsedResult = ID.split("[/]+");
            ID = parsedResult[parsedResult.length-1];
        }
        Toast.makeText(this, ID, Toast.LENGTH_LONG).show();
        VIDEO_ID = ID;
    }

}
