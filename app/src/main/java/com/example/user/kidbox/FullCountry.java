package com.example.user.kidbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by emma on 10/8/17.
 */

public class FullCountry extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_country);
        Intent mIntent = getIntent();
        int q = mIntent.getIntExtra("select", 0);
        ImageView iv = (ImageView) findViewById(R.id.i1);
        TextView tv = (TextView) findViewById(R.id.t1);
        TextView tv2 = (TextView) findViewById(R.id.t2);

        if (q == 0)
        {
            iv.setImageResource(R.drawable.bd);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");
            tv.setText("Country:"+ " Bangladesh");
            tv2.setText("Capital:"+ " Dhaka");

        }

}
}
