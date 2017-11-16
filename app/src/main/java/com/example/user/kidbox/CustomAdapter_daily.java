package com.example.user.kidbox;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by emma on 10/19/17.
 */

class CustomAdapter_daily extends BaseAdapter {
    String[] result_daily;
    String[] result_btn1;
    Context context_daily;
    private int flag = 0;
    int [] dimageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter_daily(TabActivity_1 mainActivity, String[] dailyTaskList, int[] dailyImages, String[] buttonList1, int fg) {
        // TODO Auto-generated constructor stub
        result_daily = dailyTaskList;
        context_daily = mainActivity;
        result_btn1 = buttonList1;
        dimageId = dailyImages;
        flag = fg;
        //imageId=prgmImages;
        inflater = (LayoutInflater) context_daily.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result_daily.length;
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
        Button b_daily;
        ImageView d_img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.daily,null);
        holder.t_daily = (TextView) rowView.findViewById(R.id.text_daily);
        holder.b_daily = (Button) rowView.findViewById(R.id.btn_daily);
        holder.d_img=(ImageView) rowView.findViewById(R.id.image_daily);

        holder.t_daily.setText(result_daily[position]);
        if( flag ==0 ){
            holder.b_daily.setVisibility(View.INVISIBLE);
        }
        else {
            if( result_btn1[position].equals("Approve") ) {
                holder.b_daily.setText(result_btn1[position]);
            }
        }

         holder.d_img.setImageResource(dimageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(context_daily, DailyTask.class);
                newActivity.putExtra("select", position);
                context_daily.startActivity(newActivity);


            }

        });
        return rowView;
    }
}

