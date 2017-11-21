package com.example.user.kidbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by USER on 10/18/2017.
 */

public class Gk extends AppCompatActivity {
    GridView gv;
    Context context_gk;
    ArrayList prgmName;
    public static int [] gkImagesList={R.drawable.country,
            R.drawable.space,
            R.drawable.flower,
            R.drawable.animal,
            R.drawable.vegetable,
            R.drawable.color};
    //public static String [] prgmNameList={"Bangladesh","India","Pakistan","Bhutan","Nepal","Sri Lanka","Maldives"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gk);

        context_gk = this;
        gv = (GridView) findViewById(R.id.grid_view);
        gv.setAdapter(new CustomAdapter_gk(this, gkImagesList));

    }
}
