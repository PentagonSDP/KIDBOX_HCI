package com.example.user.kidbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by USER on 10/18/2017.
 */

public class gk extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gk);
        Button country = (Button) findViewById(R.id.country);
        Button space = (Button) findViewById(R.id.space);
        Button flower = (Button) findViewById(R.id.flower);
        Button animal = (Button) findViewById(R.id.animal);
        Button vegetable = (Button) findViewById(R.id.vegetable);

        country.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), CountryActivity.class));
            }

        });
        space.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), SpaceActivity.class));
            }

        });
        flower.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), FlowerActivity.class));
            }

        });
        animal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), AnimalActivity.class));
            }

        });
        vegetable.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), VegetableActivity.class));
            }

        });


    }
}
