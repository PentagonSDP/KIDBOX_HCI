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
 * Created by emma on 11/16/17.
 */

class CustomAdapter_veg extends BaseAdapter {
    //String[] result_daily;
    //String[] result_btn1;
    Context context_veg;
    int [] vimageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter_veg(VegetableActivity mainActivity, int[] vImagesList) {
        // TODO Auto-generated constructor stub
        //result_daily = dailyTaskList;
        context_veg = mainActivity;
        //result_btn1 = buttonList1;
        vimageId = vImagesList;
        //imageId=prgmImages;
        inflater = (LayoutInflater) context_veg.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return vimageId.length;
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
        //TextView t_daily;

        //Button b_daily;
        ImageView vg_img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        CustomAdapter_veg.Holder holder = new CustomAdapter_veg.Holder();
        View grid;
        grid = inflater.inflate(R.layout.vegetable_grid,null);

        holder.vg_img=(ImageView) grid.findViewById(R.id.grid_image);

        holder.vg_img.setImageResource(vimageId[position]);
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(context_veg, Vegetable_gallery.class);
                newActivity.putExtra("select", position);
                context_veg.startActivity(newActivity);


            }

        });
        return grid;
    }
}

