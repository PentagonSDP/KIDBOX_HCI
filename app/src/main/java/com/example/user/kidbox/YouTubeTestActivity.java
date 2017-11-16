package com.example.user.kidbox;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.io.IOException;

import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;

public class YouTubeTestActivity extends AppCompatActivity {

    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    String retVal = "";
    ProgressBar spinner;
    String isParent = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_test);

        Bundle bundle = getIntent().getExtras();
        isParent = bundle.getString("flag");
        String paramlist[] = bundle.getStringArray("paramlist");

        spinner = (ProgressBar)findViewById(R.id.progressbar);
        spinner.setVisibility(View.GONE);

        android.support.v7.widget.Toolbar myToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        recyclerView=(RecyclerView)findViewById(R.id.list);
        //recyclerView.setHasFixedSize(true);
        //to use RecycleView, you need a layout manager. default is LinearLayoutManager
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            adapter=new RecyclerAdapter(YouTubeTestActivity.this);
            adapter.setAllLinks(paramlist);
        } catch (IOException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(adapter);

    }

    void addData()
    {
        if(adapter != null) {
            adapter.setVideoID(retVal);
            //Toast.makeText(this, "HOPE SO "+retVal , Toast.LENGTH_LONG).show();
            adapter.notifyDataSetChanged();
            retVal = "";
        }
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cartoon__add, menu);
        if(Integer.valueOf(isParent) == 0)
        {
            menu.findItem(R.id.action_add).setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        while(resultCode != RESULT_OK)
            spinner.setVisibility(View.VISIBLE);
        if (resultCode == RESULT_OK) {
            spinner.setVisibility(View.GONE);
            if(data.hasExtra("result")) {
                // TODO Extract the data returned from the child Activity.
                retVal = data.getStringExtra("result");
                Toast.makeText(getApplicationContext(), "THIS IS " + retVal, Toast.LENGTH_LONG)
                        .show();

                addData();
            }
        }




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true; */

            case R.id.action_add:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent intent2 = new Intent(getApplicationContext(), Add_Video_Link.class);
                startActivityForResult(intent2, 1);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}