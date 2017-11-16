package com.example.user.kidbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by emma on 10/19/17.
 */

public class  AddTask  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        final EditText et1 = (EditText) findViewById(R.id.task);
        EditText et2 = (EditText) findViewById(R.id.point);

        Button submit = (Button) findViewById(R.id.sub);

        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                String getInput = et1.getText().toString();
                ArrayList<String> addArray = new ArrayList<String>();

                if (getInput!=null && getInput.length()>0) {
                    addArray.add(getInput);
                    Intent j = new Intent(getApplicationContext(), ToDoActivity.class);
                    //Intent k = new Intent(getApplicationContext(), TabActivity_1.class);
                    String str = "1";
                    String str1 = "1";
                    j.putExtra("flag", str);
                    j.putExtra("addtaskFlag", str1);
                    j.putExtra("mylist",addArray);
                    startActivity(j);
                    //startActivity(k);
                }


            }
        });


    }
}
