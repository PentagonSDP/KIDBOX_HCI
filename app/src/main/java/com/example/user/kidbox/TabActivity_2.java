package com.example.user.kidbox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;

/**
 * Created by emma on 10/19/17.
 */

public class TabActivity_2 extends Activity {

    ListView lv2;
    Context context_bonous;
    private int flag = 0;
    public static int [] bonousImages={R.drawable.plant,R.drawable.helpmom,R.drawable.puzzle,R.drawable.vegetable};
    public static String [] bonousTaskList={"Planting tree","Helping mom","Solving Puzzle","Eating Vegetable"};
    public static String[] buttonList2 = {"Approve","","",""};
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
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                    startActivity(new Intent(getApplicationContext(), AddTask.class));

                }
            });

        if( flag == 0 ) {
            fab.setVisibility(View.INVISIBLE);
        }


        context_bonous = this;
        lv2 = (ListView) findViewById(R.id.list_bonous);
        lv2.setAdapter(new CustomAdapter_bonous(this, bonousTaskList,bonousImages,buttonList2,flag));
    }
}
