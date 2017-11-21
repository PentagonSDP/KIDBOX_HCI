package com.example.user.kidbox;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by emma on 10/19/17.
 */

public class DailyTask extends AppCompatActivity {
    private LinearLayout linear2;
    private RelativeLayout rl;
    private HorizontalScrollView scrollbar2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_task);

        Bundle bundle = getIntent().getExtras();
        final String task = bundle.getString("task");
        final int score = Integer.parseInt(bundle.getString("score"));
        final String imagePath = bundle.getString("Image source");

        ImageView iv = (ImageView) findViewById(R.id.i1);
        final TextView tv_sp = (TextView) findViewById(R.id.t_d);
        final TextView tv_sp2 = (TextView) findViewById(R.id.t_d2);
        //Button btn = (Button) findViewById(R.id.b_d);
        //TextView tv2_sp = (TextView) findViewById(R.id.t2_sp);
        ImageButton imb1 = (ImageButton) findViewById(R.id.yes);
        ImageButton imb2 = (ImageButton) findViewById(R.id.no);


        scrollbar2 = (HorizontalScrollView) findViewById(R.id.scroll2);
        rl = (RelativeLayout) findViewById(R.id.rel_lay);
        linear2 = (LinearLayout) findViewById(R.id.linear2);

        scrollbar2.setVisibility(View.GONE);
        tv_sp2.setVisibility(View.GONE);

        iv.setImageBitmap(BitmapFactory.decodeFile(imagePath));
        tv_sp.setText(task);

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges( task+","+score+","+"0"+","+imagePath, task+","+score+","+"1"+","+imagePath);
                Intent act = new Intent(getApplicationContext(), ToDoActivity.class);
                act.putExtra("flag", "0");
                startActivity(act);
            }
        });*/

        imb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl.setVisibility(View.GONE);
                tv_sp.setVisibility(View.GONE);
                tv_sp2.setVisibility(View.GONE);
                scrollbar2.setVisibility(View.VISIBLE);
                ImageView image;
                int sum = score;

                for (int i = 0; i < sum; i++) {
                    image = new ImageView(getApplicationContext());
                    image.setImageResource(R.drawable.dollar);
                    int width = 100;
                    int height = 100;
                    LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width, height);
                    image.setLayoutParams(parms);
                    Log.i("i", i + "");
                    linear2.addView(image);
                    scrollbar2.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
                }
                saveChanges( task+","+score+","+"0"+","+imagePath, task+","+score+","+"1"+","+imagePath);
            }
        });
        imb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl.setVisibility(View.VISIBLE);
                tv_sp.setVisibility(View.GONE);
                tv_sp2.setVisibility(View.VISIBLE);

                Intent act = new Intent(getApplicationContext(), ToDoActivity.class);
                act.putExtra("flag", "0");
                startActivity(act);
            }
        });
    }

    private void saveChanges(String str, String replace){
        try {
            FileInputStream fileIn = openFileInput("daily1.txt");
            InputStreamReader InputRead = new InputStreamReader(fileIn);
            BufferedReader bufferedReader = new BufferedReader(InputRead);

            ArrayList<String> list = new ArrayList<String>();
            String str1 = "";
            Log.e("Daily Task::file", str +"-->"+ replace);
            Log.e("Daily Task::file", str.length() +"-->"+ replace.length());
            while ( (str1 = bufferedReader.readLine()) != null ) {
                if(str1.equals(str)){
                    list.add(replace);
                    Log.e("Daily Task::str", str1 +"-->"+ replace);
                }
                else {
                    list.add(str1);
                }
            }
            bufferedReader.close();
            InputRead.close();
            fileIn.close();

            File dir = getApplicationContext().getFilesDir();
            File file = new File(dir, "daily1.txt");
            boolean deleted = file.delete();

            if( deleted ){
                OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(openFileOutput("daily1.txt", MODE_APPEND));
                for( int i=0; i<list.size(); i++){
                    Log.e("Daily Task::file", list.get(i)+"-->" +list.get(i).length());
                    outputStreamWriter1.append(list.get(i)+ "\n");
                }
                outputStreamWriter1.close();
            }
            else{
                Log.e("Daily Task::rewrite", "not deleted");
            }
            reread();
        }catch (Exception e) {
            Log.e("Daily Task::catch", e.toString());
        }
    }

    private void reread(){
        try {
            FileInputStream fileIn = openFileInput("daily1.txt");
            InputStreamReader InputRead = new InputStreamReader(fileIn);
            BufferedReader bufferedReader = new BufferedReader(InputRead);
            ArrayList<String> list = new ArrayList<String>();
            String str1 = "";
            Log.e("Daily Task::read", "REREAD");
            while ( (str1 = bufferedReader.readLine()) != null ) {
                Log.e("Daily Task::read", str1);
            }
            bufferedReader.close();
            InputRead.close();
            fileIn.close();

        }catch (Exception e) {
            Log.e("Daily Task::catch", e.toString());
        }
    }
}