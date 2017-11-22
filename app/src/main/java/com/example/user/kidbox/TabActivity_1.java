package com.example.user.kidbox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by emma on 10/19/17.
 */

//public static ArrayList<String> dailyTaskList={"Tidy Up Bed","Brushing Teeth","Eating Breakfast","Go for School","Do homework"};
//public static ArrayList<String> buttonList1 = {"Approve","","Approve","","Approve"};
public class TabActivity_1 extends Activity {

    ListView lv;
    Context context_daily;
    private int flag = 0;
    //ArrayList<String> dailyTaskList = new ArrayList<String>();
    //private static int[] dailyImages={R.drawable.tidyupbed,R.drawable.toothbrush,R.drawable.breakfast,R.drawable.school,R.drawable.homework};
    private static ArrayList<String> dailyTaskList = null;
    private static ArrayList<String> buttonList1 = null;
    private static ArrayList<String> pointsList1 = null;
    private static ArrayList<String> photosList1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("flag");

        flag = Integer.valueOf(str);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddTask.class));
            }
        });

        FloatingActionButton fabback = (FloatingActionButton) findViewById(R.id.fabBack);
        fabback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( flag == 1 ){
                    startActivity(new Intent(getApplicationContext(), tempMain.class));
                }
                else{
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        });

        if( flag == 0 ) {
            fab.setVisibility(View.INVISIBLE);
        }
        context_daily = this;
        dailyTaskList = new ArrayList<String>();
        buttonList1 = new ArrayList<String>();
        pointsList1 = new ArrayList<String>();
        photosList1 = new ArrayList<String>();
        lv = (ListView) findViewById(R.id.list_daily);
        int file = 0;

        try {
            FileInputStream fileIn = openFileInput("daily1.txt");
            if( fileIn == null ){
                Log.e("Tab Activity1::file", "noFile");
            }
            else{
                InputStreamReader InputRead = new InputStreamReader(fileIn);
                BufferedReader bufferedReader = new BufferedReader(InputRead);
                String str1 = "";
                //Log.e("Tab Activity1::file str", InputRead.toString() + bufferedReader.toString() );
                Log.e("Tab Activity1::file", "File found");
                while ( (str1 = bufferedReader.readLine()) != null ) {
                    //stringBuilder.append(str1);
                    Log.e("Tab Activity1::file str", str1);
                    String data[] = str1.split(",");
                    dailyTaskList.add(data[0]);
                    pointsList1.add(data[1]);
                    if( data[2].equals("0") ){
                        buttonList1.add("");
                    }
                    else {
                        buttonList1.add("Approve");
                    }
                    photosList1.add(data[3]);
                    Log.e("Tab Activity1::file str", data[0]+","+data[1]+","+data[2]+","+data[3]);
                }
                Log.e("Tab Activity1::file", "File found");
                //String s = stringBuilder.toString();
                //Log.e("Tab Activity1::file str", s);
            }
        } catch (Exception e) {
            file = 1;
            e.printStackTrace();
            Log.e("Tab Activity1::catch", e.toString());
        }

        if( file == 1 ){
            lv.setVisibility(View.INVISIBLE);
        }
        else{
            //lv.removeAllViews();
            //lv.setAdapter(null);
            lv.setAdapter(new CustomAdapter_daily(this, dailyTaskList, photosList1, buttonList1, pointsList1, flag));
        }
    }
}
