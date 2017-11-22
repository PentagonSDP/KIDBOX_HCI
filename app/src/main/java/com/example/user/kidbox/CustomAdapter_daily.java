package com.example.user.kidbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by emma on 10/19/17.
 */

class CustomAdapter_daily extends BaseAdapter {
    ArrayList<String> result_daily;
    ArrayList<String> result_btn1;
    Context context_daily;
    private int flag = 0;
    ArrayList<String> dimageId;
    ArrayList<String> pointsList1;
    private static LayoutInflater inflater = null;

    public CustomAdapter_daily(TabActivity_1 mainActivity, ArrayList<String> dailyTaskList, ArrayList<String> dailyImages, ArrayList<String> buttonList1, ArrayList<String> pointsList, int fg) {
        // TODO Auto-generated constructor stub
        result_daily = dailyTaskList;
        context_daily = mainActivity;
        result_btn1 = buttonList1;
        dimageId = dailyImages;
        pointsList1 = pointsList;
        flag = fg;
        inflater = (LayoutInflater) context_daily.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result_daily.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        TextView t_daily;
        ImageButton b_dl1;
        ImageButton b_daily;
        ImageView d_img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder = new Holder();
        View rowView = inflater.inflate(R.layout.daily,null);
        holder.t_daily = (TextView) rowView.findViewById(R.id.text_daily);
        holder.b_daily = (ImageButton) rowView.findViewById(R.id.btn_daily);
        holder.d_img=(ImageView) rowView.findViewById(R.id.image_daily);
        holder.b_dl1 = (ImageButton) rowView.findViewById(R.id.del1);

        holder.t_daily.setText(result_daily.get(position));

        holder.b_dl1.setVisibility(View.INVISIBLE);//delete button

        if( result_btn1.get(position).equals("Approve") ) {
            holder.b_daily.setVisibility(View.VISIBLE);
        }
        else{
            holder.b_daily.setVisibility(View.INVISIBLE);
        }
        holder.b_daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( flag !=0 ){
                    changePoints(pointsList1.get(position));
                    changeFile(position);
                    holder.b_daily.setVisibility(View.INVISIBLE);
                    Log.e("Approve Button", "working");

                    Intent act = new Intent(context_daily, ToDoActivity.class);
                    act.putExtra("flag", "1");
                    context_daily.startActivity(act);
                }
                else {
                    Log.e("Approve Button", "not working");
                }
            }
        });

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        holder.d_img.setImageBitmap(BitmapFactory.decodeFile(dimageId.get(position), options));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(context_daily, DailyTask.class);
                newActivity.putExtra("task", result_daily.get(position));
                newActivity.putExtra("score", pointsList1.get(position));
                newActivity.putExtra("Image source", dimageId.get(position));
                context_daily.startActivity(newActivity);
            }
        });
        return rowView;
    }
    private void changePoints( String T_score){
        int score = 0;
        try {
            FileInputStream fileIn = context_daily.openFileInput("totalScore.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileIn));
            String str1 = bufferedReader.readLine();
            Log.e("Adapter_Daily::score", str1);
            bufferedReader.close();
            fileIn.close();

            score = Integer.parseInt(str1) + Integer.parseInt(T_score);
            Log.e("Adapter_Daily::score::", String.valueOf(score));

            File dir = context_daily.getFilesDir();
            File file = new File(dir, "totalScore.txt");
            boolean deleted = file.delete();

            if( deleted ){
                OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(context_daily.openFileOutput("totalScore.txt", context_daily.MODE_APPEND));
                outputStreamWriter1.write(String.valueOf(score));
                outputStreamWriter1.close();
            }
            else{
                Log.e("Adapter_Daily::score", "not deleted");
            }

        }catch (Exception e) {
            try{
                OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(context_daily.openFileOutput("totalScore.txt", context_daily.MODE_APPEND));
                outputStreamWriter1.write(String.valueOf(score));
                outputStreamWriter1.close();
            }catch (Exception e1){
                Log.e("Adapter_Daily::catch", e1.toString());
            }
            Log.e("Adapter_Daily::catch", e.toString());
        }
    }

    private void changeFile(int pos){
        String str = result_daily.get(pos) +","+ pointsList1.get(pos) +","+ "1" + ","+ dimageId.get(pos);
        String replace = result_daily.get(pos) +","+ pointsList1.get(pos) +","+ "0" + ","+  dimageId.get(pos) ;
        try {
            InputStreamReader InputRead = new InputStreamReader(context_daily.openFileInput("daily1.txt"));
            BufferedReader bufferedReader = new BufferedReader(InputRead);
            ArrayList<String> list = new ArrayList<String>();
            String str1 = "";
            Log.e("Daily Task::file::", str +"-->"+ replace);
            Log.e("adpter::file::", str.length() +"-->"+ replace.length());
            while ( (str1 = bufferedReader.readLine()) != null ) {
                if(str1.equals(str)){
                    list.add(replace);
                    Log.e("adpter::str::", str1 +"-->"+ replace);
                }
                else {
                    list.add(str1);
                }
            }
            bufferedReader.close();
            InputRead.close();

            File dir = context_daily.getApplicationContext().getFilesDir();
            File file = new File(dir, "daily1.txt");
            boolean deleted = file.delete();

            if( deleted ){
                OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(context_daily.openFileOutput("daily1.txt", context_daily.MODE_APPEND));
                for( int i=0; i<list.size(); i++){
                    outputStreamWriter1.append(list.get(i)+"\n");
                    Log.e("Adapter_Daily::score::", list.get(i) +"-->" +list.get(i).length());
                }
                outputStreamWriter1.close();
                reread();
            }
            else{
                Log.e("Adapter_Daily::score::", "not deleted");
            }
        }catch (Exception e) {
            Log.e("Adapter_Daily::catch::", e.toString());
        }
    }
    private void reread(){
        try {
            FileInputStream fileIn = context_daily.openFileInput("daily1.txt");
            InputStreamReader InputRead = new InputStreamReader(fileIn);
            BufferedReader bufferedReader = new BufferedReader(InputRead);

            String str1 = "";
            Log.e("Adapter_Daily::read:: ", "REREAD");
            while ( (str1 = bufferedReader.readLine()) != null ) {
                Log.e("Adapter_Daily::read::", str1);
            }

            bufferedReader.close();
            InputRead.close();
            fileIn.close();

        }catch (Exception e) {
            Log.e("Adapter_Daily::catch::", e.toString());
        }
    }
}