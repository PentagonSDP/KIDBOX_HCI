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

public class BonousTask extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonous_task);
        Intent mIntent = getIntent();
        int q_sp = mIntent.getIntExtra("select", 0);
        ImageView iv = (ImageView) findViewById(R.id.i2);
        TextView tv_sp = (TextView) findViewById(R.id.t_b);
        Button btn = (Button) findViewById(R.id.b_b);
        //TextView tv2_sp = (TextView) findViewById(R.id.t2_sp);

        if (q_sp == 0)
        {
            iv.setImageResource(R.drawable.plant);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");
            tv_sp.setText("1 tree planted: 25 points!");

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
            iv.setImageResource(R.drawable.helpmom);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");
            tv_sp.setText("Helped mom once: 25 points!");

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
            iv.setImageResource(R.drawable.puzzle);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");
            tv_sp.setText("Solved puzzle once: 25 points!");

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
        if (q_sp == 3)
        {
            iv.setImageResource(R.drawable.vegetable);
            //tv.setText("" +" "+"(১৯৫৩-১৯৭১)"+" "+" সেক্টরঃ ৪নং");
            tv_sp.setText("Have eaten vegetable: 25 points!");

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
