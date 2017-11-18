package com.example.user.kidbox;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


/**
 * Created by emma on 10/10/17.
 */

class CustomAdapter_space extends BaseAdapter {
    String[] result_space;
    String[] result2;
    Context context_space;
    //int [] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter_space(SpaceActivity mainActivity, String[] spaceNameList) {
        // TODO Auto-generated constructor stub
        result_space = spaceNameList;
        context_space = mainActivity;
        //imageId=prgmImages;
        inflater = (LayoutInflater) context_space.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result_space.length;
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
        TextView t_space;
        //ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        CustomAdapter_space.Holder holder = new CustomAdapter_space.Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.sel_space, null);
        holder.t_space = (TextView) rowView.findViewById(R.id.text_sp);

        // holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.t_space.setText(result_space[position]);

        // holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();
                // Intent myIntent = new Intent(this, fullscreenpic.class);
                // myIntent.putExtra("value", position);
                //startActivity(myIntent);
                Intent newActivity = new Intent(context_space, FullSpace.class);
                newActivity.putExtra("select", position);
                context_space.startActivity(newActivity);


            }

        });
        return rowView;
    }
}
