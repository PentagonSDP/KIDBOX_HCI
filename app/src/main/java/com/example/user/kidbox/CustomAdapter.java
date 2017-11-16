package com.example.user.kidbox;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by emma on 10/8/17.
 */

class CustomAdapter extends BaseAdapter {
    String[] result;
    String[] result2;
    Context context;
    //int [] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter(CountryActivity mainActivity, String[] prgmNameList) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        context = mainActivity;
        //imageId=prgmImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
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
        TextView tv;
        //ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.sel_country, null);
        holder.tv = (TextView) rowView.findViewById(R.id.textView1);

        // holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv.setText(result[position]);

        // holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();
                // Intent myIntent = new Intent(this, fullscreenpic.class);
                // myIntent.putExtra("value", position);
                //startActivity(myIntent);
                Intent newActivity = new Intent(context, FullCountry.class);
                newActivity.putExtra("select", position);
                context.startActivity(newActivity);


            }

        });
        return rowView;
    }
}
