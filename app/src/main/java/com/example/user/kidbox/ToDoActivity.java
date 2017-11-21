package com.example.user.kidbox;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import java.util.ArrayList;
public class ToDoActivity extends TabActivity {

    TabHost TabHostWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_todo);

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("flag");
        //String str1 = bundle.getString("addtaskFlag");
        //ArrayList<String> myList = bundle.getStringArrayList("mylist");
       // ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");


        //Assign id to Tabhost.
        TabHostWindow = (TabHost)findViewById(android.R.id.tabhost);

        //Creating tab menu.
        TabSpec TabMenu1 = TabHostWindow.newTabSpec("Daily");
        TabSpec TabMenu2 = TabHostWindow.newTabSpec("Bonous");
        TabSpec TabMenu3 = TabHostWindow.newTabSpec("Points");

        //Setting up tab 1 name.

        Intent Image = new Intent(this , TabActivity_1.class);
        Image.putExtra("flag", str);
        //Image.putExtra("addtaskFlag", str1);
        //Image.putExtra("mylist",myList);
        TabMenu1.setIndicator("Daily");
        TabMenu1.setContent(Image);

        Intent Image2 = new Intent(this , TabActivity_2.class);
        Image2.putExtra("flag", str);
        TabMenu2.setIndicator("Bonous");
        TabMenu2.setContent(Image2);

        Intent Image3 = new Intent(this , TabActivity_3.class);
        Image3.putExtra("flag", str);
        TabMenu3.setIndicator("Points");
        TabMenu3.setContent(Image3);
        //Set tab 1 activity to tab 1 menu.
        //TabMenu1.setContent(new Intent(this,TabActivity_1.class));

        //Setting up tab 2 name.
        /*TabMenu2.setIndicator("Bonous");
        //Set tab 3 activity to tab 1 menu.
        TabMenu2.setContent(new Intent(this,TabActivity_2.class));

        //Setting up tab 2 name.
        TabMenu3.setIndicator("Points");
        //Set tab 3 activity to tab 3 menu.
        TabMenu3.setContent(new Intent(this,TabActivity_3.class));*/

        //Adding tab1, tab2, tab3 to tabhost view.

        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);
        TabHostWindow.addTab(TabMenu3);
    }
}

