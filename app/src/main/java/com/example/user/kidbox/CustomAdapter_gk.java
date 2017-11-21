package com.example.user.kidbox;

/**
 * Created by emma on 11/17/17.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
        import android.widget.ImageView;
import android.widget.Space;

/**
 * Created by emma on 11/16/17.
 */

class CustomAdapter_gk extends BaseAdapter {
    //String[] result_daily;
    //String[] result_btn1;
    Context context_gk;
    int [] gkimageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter_gk(Gk mainActivity, int[] gkImagesList) {
        // TODO Auto-generated constructor stub
        //result_daily = dailyTaskList;
        context_gk = mainActivity;
        //result_btn1 = buttonList1;
        gkimageId = gkImagesList;
        //imageId=prgmImages;
        inflater = (LayoutInflater) context_gk.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return gkimageId.length;
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
        ImageView gk_img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        CustomAdapter_gk.Holder holder = new CustomAdapter_gk.Holder();
        View grid;
        grid = inflater.inflate(R.layout.gk_grid,null);

        holder.gk_img=(ImageView) grid.findViewById(R.id.grid_img);

        holder.gk_img.setImageResource(gkimageId[position]);
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // newActivity = new Intent(context_gk, Gk_gallery.class);
                //context_gk.startActivity(newActivity);
                if(position==0) {
                    Intent intent = new Intent(context_gk,country.class);
                    context_gk.startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent = new Intent(context_gk, space.class);
                    context_gk.startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent = new Intent(context_gk, FlowerActivity.class);
                    context_gk.startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent = new Intent(context_gk, animal.class);
                    context_gk.startActivity(intent);
                }
                if(position==4)
                {
                    Intent intent = new Intent(context_gk, VegetableActivity.class);
                    context_gk.startActivity(intent);
                }
                if(position==5)
                {
                    Intent intent = new Intent(context_gk, color.class);
                    context_gk.startActivity(intent);
                }
            }

        });
        return grid;
    }
}

