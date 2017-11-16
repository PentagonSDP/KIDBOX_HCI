package com.example.user.kidbox;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


/**
 * Created by emma on 10/10/17.
 */

public class SpaceActivity extends AppCompatActivity {
    ListView lv;
    Context context_space;
    //public static int [] prgmImages={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7};
    public static String [] spaceNameList={"Planets","Dwarf planets and asteroids","Commets","Satellites","Meteor","Spaceships","Stars"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.space);

        context_space = this;
        lv = (ListView) findViewById(R.id.list_sp);
        lv.setAdapter(new CustomAdapter_space(this, spaceNameList));

    }
}
