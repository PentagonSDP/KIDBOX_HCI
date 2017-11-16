package com.example.user.kidbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by emma on 10/10/17.
 */

public class FullSpace extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_space);
        Intent mIntent = getIntent();
        int q_sp = mIntent.getIntExtra("select", 0);
        ImageView iv = (ImageView) findViewById(R.id.i1);
        TextView tv_sp = (TextView) findViewById(R.id.t_sp);
        TextView tv2_sp = (TextView) findViewById(R.id.t2_sp);

        if (q_sp == 0)
        {
            iv.setImageResource(R.drawable.earth);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");
            tv_sp.setText("Planet:"+ " Earth");
            tv2_sp.setText("Earth is Almost a Sphere."+ " Plate Tectonics Keep the Planet Comfortable."+" It is Mostly Iron, Oxygen and Silicon."
                    +" 70% of the Earth’s Surface is Covered in Water."+" It actually takes 23 hours, 56 minutes and 4 seconds for to rotate once completely on its axis."
            +" A year on Earth isn’t 365 days."+" Earth has 1 Moon and 2 Co-Orbital Satellites. "+"Therefore it is the Only Planet Known to Have Life");

        }

    }
}
