package com.example.user.kidbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by emma on 10/19/17.
 */

public class DailyTask extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_task);
        Intent mIntent = getIntent();
        int q_sp = mIntent.getIntExtra("select", 0);
        ImageView iv = (ImageView) findViewById(R.id.i1);
        TextView tv_sp = (TextView) findViewById(R.id.t_d);
        Button btn = (Button) findViewById(R.id.b_d);
        //TextView tv2_sp = (TextView) findViewById(R.id.t2_sp);


        if (q_sp == 0)
        {
            iv.setImageResource(R.drawable.tidyupbed);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");
            tv_sp.setText("Tidy Up bed done: 5 points!");

            btn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent Image = new Intent(getApplicationContext(), ToDoActivity.class);
                    String str = "0";
                    Image.putExtra("flag", str);
                    startActivity(Image);

                    //startActivity(new Intent(getApplicationContext(), ToDoActivity.class));
                }

            });

        }

        if (q_sp == 1)
        {
            iv.setImageResource(R.drawable.toothbrush);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");
            tv_sp.setText("Brushing teeth done: 5 points!");

            btn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent Image = new Intent(getApplicationContext(), ToDoActivity.class);
                    String str = "0";
                    Image.putExtra("flag", str);
                    startActivity(Image);

                    //startActivity(new Intent(getApplicationContext(), ToDoActivity.class));
                }

            });

        }
        if (q_sp == 2)
        {
            iv.setImageResource(R.drawable.breakfast);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");
            tv_sp.setText("Eating breakfast done: 5 points!");

            btn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent Image = new Intent(getApplicationContext(), ToDoActivity.class);
                    String str = "0";
                    Image.putExtra("flag", str);
                    startActivity(Image);

                    //startActivity(new Intent(getApplicationContext(), ToDoActivity.class));
                }

            });

        }
        if (q_sp == 3) {
            iv.setImageResource(R.drawable.school);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");
            tv_sp.setText("Gone for School done: 5 points!");

            btn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent Image = new Intent(getApplicationContext(), ToDoActivity.class);
                    String str = "0";
                    Image.putExtra("flag", str);
                    startActivity(Image);

                    //startActivity(new Intent(getApplicationContext(), ToDoActivity.class));
                }

            });
        }

        if (q_sp == 4) {
            iv.setImageResource(R.drawable.homework);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+homework" "+" সেক্টরঃ ৪নং");
            tv_sp.setText("Homework done: 5 points!");

            btn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent Image = new Intent(getApplicationContext(), ToDoActivity.class);
                    String str = "0";
                    Image.putExtra("flag", str);
                    startActivity(Image);

                    //startActivity(new Intent(getApplicationContext(), ToDoActivity.class));
                }

            });
        }


    }
}


