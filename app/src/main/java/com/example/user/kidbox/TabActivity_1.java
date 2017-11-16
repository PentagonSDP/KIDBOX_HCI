package com.example.user.kidbox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by emma on 10/19/17.
 */

public class TabActivity_1 extends Activity {

    ListView lv;
    Context context_daily;
    private int flag = 0;
    //ArrayList<String> dailyTaskList = new ArrayList<String>();
    public static int [] dailyImages={R.drawable.tidyupbed,R.drawable.toothbrush,R.drawable.breakfast,R.drawable.school,R.drawable.homework};
    public static String [] dailyTaskList={"Tidy Up Bed","Brushing Teeth","Eating Breakfast","Go for School","Do homework"};
    public static String[] buttonList1 = {"Approve","Approve","Approve","Approve","Approve"};
//    InputStream is = this.getResources().openRawResource(R.raw.data);
    //BufferedReader reader = new BufferedReader(new InputStreamReader(is));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("flag");
        //String str1 = bundle.getString("addtaskFlag");
        //int n = Integer.valueOf(str1);

        /*if(n == 1)
        {
            ArrayList<String> myList = bundle.getStringArrayList("mylist");

            String[] myListArr = myList.toArray(new String[myList.size()]);

            String[] result = Arrays.copyOf(dailyTaskList, dailyTaskList.length + myListArr.length);
            System.arraycopy(myListArr, 0, result, dailyTaskList.length, myListArr.length);
            flag = Integer.valueOf(str);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), AddTask.class));

                }
            });

            if( flag == 0 ) {
                fab.setVisibility(View.INVISIBLE);
            }
            context_daily = this;
            lv = (ListView) findViewById(R.id.list_daily);
            lv.setAdapter(new CustomAdapter_daily(this, result,dailyImages,buttonList1,flag));

        }
        else
        {*/
        flag = Integer.valueOf(str);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), AddTask.class));

                }
            });

            if( flag == 0 ) {
                fab.setVisibility(View.INVISIBLE);
            }
            context_daily = this;
            lv = (ListView) findViewById(R.id.list_daily);
            lv.setAdapter(new CustomAdapter_daily(this, dailyTaskList,dailyImages,buttonList1,flag));




        //dailyTaskList = append(myList);

    }
}
