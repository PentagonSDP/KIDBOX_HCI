package com.example.user.kidbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.R.id.custom;
import static android.R.id.message;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity{
    //LinearLayout activityMain;

    Bundle bundle;
    String[] craftlist = {"Wgun4nvcITM", "1rv-IbAZozs", "JJwJTyeqEbI"};
    String[] cartoonlist = {"1jpe4vFvo9g", "6vT1p9Fl6gY", "QjuZhPjMnkE"};
    String[] rhymelist = {"M7crK9Bd-yk", "Zu6o23Pu0Do", "yCjJyiqpAuU"};
    String[] storylist = {"DYKADcR34Y8", "VhMNilSamDU", "0Dvmryh2Djg"};

    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(getApplicationContext(), YouTubeTestActivity.class);
        //startActivity(intent);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("OnDoubleTapListener", "onDoubleTap");
                if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    initiatePopupWindow(view);
                return true;
            }
        });

        ImageButton story = (ImageButton) findViewById(R.id.story);
        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(flag);
                bundle = new Bundle();
                bundle.putStringArray("paramlist", storylist);

                Intent intent = new Intent(getApplicationContext() , YouTubeTestActivity.class);
                intent.putExtra("flag", str);//EXTRA_MESSAGE
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ImageButton rhymes = (ImageButton) findViewById(R.id.rhyme);
        rhymes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = String.valueOf(flag);
                bundle = new Bundle();
                bundle.putStringArray("paramlist", rhymelist);

                Intent intent = new Intent(getApplicationContext() , YouTubeTestActivity.class);
                intent.putExtra("flag", str);//EXTRA_MESSAGE
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ImageButton craft = (ImageButton) findViewById(R.id.craft);
        craft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = String.valueOf(flag);

                bundle = new Bundle();
                bundle.putStringArray("paramlist", craftlist);

                Intent intent = new Intent(getApplicationContext() , YouTubeTestActivity.class);
                intent.putExtra("flag", str);//EXTRA_MESSAGE
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ImageButton cartoon = (ImageButton) findViewById(R.id.cartoon);
        cartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(flag);
                bundle = new Bundle();
                bundle.putStringArray("paramlist", cartoonlist);

                Intent intent = new Intent(getApplicationContext() , YouTubeTestActivity.class);
                intent.putExtra("flag", str);//EXTRA_MESSAGE
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ImageButton gk = (ImageButton) findViewById(R.id.gk);
        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                Intent Image = new Intent(getApplicationContext() , gk.class);
                startActivity(Image);
            }
        });

        ImageButton todolist = (ImageButton) findViewById(R.id.todolist);
        todolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(flag);
                //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                Intent Image = new Intent(getApplicationContext() , ToDoActivity.class);
                Image.putExtra("flag", str);
                startActivity(Image);
            }
        });
    }

    PopupWindow pwindo;
    private void initiatePopupWindow(View view) {
        try {
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context
                    .LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.signup,(ViewGroup) findViewById(R.id.popup_element));
            pwindo = new PopupWindow(layout, 700, 970,true);


            pwindo.setTouchable(true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            //pwindo.update();

            Button log_ = (Button) layout.findViewById(R.id.button_log);
            log_.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    flag = 1;
                    pwindo.dismiss();
                }
            });

            Button creatAcc = (Button) layout.findViewById(R.id.createAccount);
            //creatAcc.setOnClickListener(gotoSignUP);

            creatAcc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    flag = 1;
                    pwindo.dismiss();
                    return;
                }
            });

            Button cancel = (Button) layout.findViewById(R.id.cancel);
            //cancel.setOnClickListener(refreshPage);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pwindo.dismiss();
                    return;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void myFancyMethod1(View v) {
        Toast.makeText(getApplicationContext(),"Canceled",Toast.LENGTH_SHORT).show();
        Intent Image = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(Image);
        // does something very interesting
    }
    public void myFancyMethod(View v) {
        Toast.makeText(getApplicationContext(),"Wrong mail id",Toast.LENGTH_SHORT).show();
        Intent Image = new Intent(getApplicationContext() , signUpMain.class);
        startActivity(Image);
        // does something very interesting
    }
}

        /*GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener());
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent motionEvent) {
                Log.d("OnDoubleTapListener", "onDoubleTap");
                setContentView(R.layout.homepage);
                return true;
            }
            @Override
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return false;
            }
        });*/
        /*final GestureDetector gd = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                //your action here for double tap e.g.
                Log.d("OnDoubleTapListener", "onDoubleTap");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
            }
            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                Log.d("OnTapListener", "onTap");
                return true;
            }
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }
        });*/
//setContentView(R.layout.homepage);