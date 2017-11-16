package com.example.user.kidbox;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by emma on 10/8/17.
 */

public class CountryActivity extends AppCompatActivity {
    ListView lv;
    Context context;
    ArrayList prgmName;
    //public static int [] prgmImages={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7};
    public static String [] prgmNameList={"Bangladesh","India","Pakistan","Bhutan","Nepal","Sri Lanka","Maldives"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country);

        context = this;
        lv = (ListView) findViewById(R.id.list_cn);
        lv.setAdapter(new CustomAdapter(this, prgmNameList));

    }
}
