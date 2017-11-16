package com.example.user.kidbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by USER on 11/2/2017.
 */

public class signUpMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupmain);
        Button signSubmit = (Button) findViewById(R.id.signSubmit);
        signSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Image = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(Image);
            }
        });
    }
}
