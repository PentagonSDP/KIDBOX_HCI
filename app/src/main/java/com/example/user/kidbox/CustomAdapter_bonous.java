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

class CustomAdapter_bonous extends BaseAdapter {
    String[] result_bonous;
    String[] result_btn2;
    Context context_bonous;
    private int flag = 0;
    int [] dimageId;
    //int [] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter_bonous(TabActivity_2 mainActivity, String[] bonousTaskList, int[]bonousImages, String[] buttonList2, int fg) {
        // TODO Auto-generated constructor stub
        result_bonous = bonousTaskList;
        context_bonous = mainActivity;
        result_btn2 = buttonList2;
        flag = fg;
        dimageId= bonousImages;
        inflater = (LayoutInflater) context_bonous.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result_bonous.length;
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
        TextView t_bonous;
        Button b_bonous;
        ImageView b_img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        CustomAdapter_bonous.Holder holder = new CustomAdapter_bonous.Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.bonous,null);
        holder.t_bonous = (TextView) rowView.findViewById(R.id.text_bonous);
        holder.b_bonous = (Button) rowView.findViewById(R.id.btn_bonous);

        holder.b_img=(ImageView) rowView.findViewById(R.id.image_bonous);
        holder.t_bonous.setText(result_bonous[position]);
        if( flag ==0 ){
            holder.b_bonous.setVisibility(View.INVISIBLE);
        }
        else {
            if( result_btn2[position].equals("Approve") ) {
                holder.b_bonous.setText(result_btn2[position]);
            }
        }

        holder.b_img.setImageResource(dimageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(context_bonous, BonousTask.class);
                newActivity.putExtra("select", position);
                context_bonous.startActivity(newActivity);


            }

        });
        return rowView;
    }
}

