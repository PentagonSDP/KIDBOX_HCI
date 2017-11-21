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
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by emma on 10/19/17.
 */

public class TabActivity_2 extends Activity {

    ListView lv2;
    Context context_bonous;
    private int flag = 0;
    /*public static int [] bonousImages={R.drawable.plant,R.drawable.helpmom,R.drawable.puzzle,R.drawable.vegetable};
    public static String [] bonousTaskList={"Planting tree","Helping mom","Solving Puzzle","Eating Vegetable"};
    public static String[] buttonList2 = {"Approve","","",""};*/
    private static ArrayList<String> bonusTaskList = null;
    private static ArrayList<String> buttonList1 = null;
    private static ArrayList<String> pointsList1 = null;
    private static ArrayList<String> photosList1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonous);

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

        context_bonous = this;
        bonusTaskList = new ArrayList<String>();
        buttonList1 = new ArrayList<String>();
        pointsList1 = new ArrayList<String>();
        photosList1 = new ArrayList<String>();
        lv2 = (ListView) findViewById(R.id.list_bonous);

        int file = 0;
        try {
            FileInputStream fileIn = openFileInput("bonus.txt");
            if( fileIn == null ){
                Log.e("Tab Activity2::file", "noFile");
            }
            else{
                InputStreamReader InputRead = new InputStreamReader(fileIn);
                BufferedReader bufferedReader = new BufferedReader(new FileReader("bonus.txt"));
                String str1 = "";
                //Log.e("Tab Activity1::file str", InputRead.toString() + bufferedReader.toString() );
                Log.e("Tab Activity1::file", "File found");
                while ( (str1 = bufferedReader.readLine()) != null ) {
                    //stringBuilder.append(str1);
                    Log.e("Tab Activity1::file str", str1);
                    String data[] = str1.split(",");
                    bonusTaskList.add(data[0]);
                    pointsList1.add(data[1]);
                    if( data[2].equals("0") ){
                        buttonList1.add("");
                    }
                    else {
                        buttonList1.add("Approve");
                    }
                    photosList1.add(data[3]);
                    Log.e("Tab Activity2::file str", data[0]+","+data[1]+","+data[2]+","+data[3]);
                }
                Log.e("Tab Activity2::file", "File found");
            }
        } catch (Exception e) {
            file = 1;
            e.printStackTrace();
            Log.e("Tab Activity2::catch", e.toString());
        }
        if( file == 1 ){
            lv2.setVisibility(View.INVISIBLE);
        }
        else{
            lv2.setAdapter(new CustomAdapter_bonous(this, bonusTaskList, photosList1, buttonList1, pointsList1, flag));
        }
    }
}
