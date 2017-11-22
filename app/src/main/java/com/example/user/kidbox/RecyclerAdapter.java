package com.example.user.kidbox;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ofaroque on 8/13/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter
        .VideoInfoHolder>{

    //these ids are the unique id for each video
    String[] VideoID = {"rtOvBOTyX00", "8iuZrJumCLo", "RBumgq5yVrA", "G6s2hiJ1aZo"};
    String[] titleList = {"ABC", "DEF", "GHI", "JKL"};
    private ArrayList<String> trash_items;
    Context ctx;
    private boolean isCheckBoxVisible = false;
    VideoInfoHolder videoinfoholder;

    public void setVideoList() throws IOException {
        ArrayList<String> allVideos = new ArrayList<>(Arrays.asList(VideoID));
        allVideos.removeAll(trash_items);
        VideoID = allVideos.toArray(new String[allVideos.size()]);
        trash_items = new ArrayList<String>();
        retrieveTitle();
        videoinfoholder.check_for_delete.setVisibility(View.INVISIBLE);
        videoinfoholder.check_for_delete.setChecked(false);
    }

    public ArrayList<String> getTrashItems()
    {
        return this.trash_items;
    }
    public void setTrash_items()
    {
        this.trash_items = new ArrayList<String>();
    }

    public boolean getCheckBoxVisibility()
    {
        return isCheckBoxVisible;
    }

    private void setViewinfoholder(VideoInfoHolder infoHolder)
    {
        this.videoinfoholder = infoHolder;
    }
    private void setCheckBox()
    {
        this.videoinfoholder.check_for_delete.setVisibility(View.VISIBLE);
        this.videoinfoholder.title.setPadding(50, 0, 0, 0);
        this.videoinfoholder.author.setPadding(50, 0, 0, 0);
    }

    public void setVideoID(String ID)
    {
        int length = VideoID.length;
        VideoID = Arrays.copyOf(VideoID, length+1);
        titleList = Arrays.copyOf(titleList, length+1);
        VideoID[length] = ID;
        retrieveTitle(ID, length);
    }

    public void setAllLinks(String[] videos) throws IOException {
        this.VideoID = videos;
        retrieveTitle();
    }

    public void retrieveTitle(String link, final int length)
    {
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(ctx);

        String url = "https://noembed.com/embed?url=https://www.youtube" +
                ".com/watch?v=" + link;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.contains("error")) {
                            try {
                                JSONObject allData = new JSONObject(response);
                                titleList[length] = allData.getString("title")+"~"+allData
                                        .getString("author_name");
                                //Toast.makeText(ctx, "Finally it worked "+titleList[length],
                                  //      Toast.LENGTH_SHORT);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {}
        });
        queue.add(stringRequest);
    }

    public void retrieveTitle() throws IOException {

        com.android.volley.RequestQueue queue = Volley.newRequestQueue(ctx);
        for(int i=0; i<VideoID.length; i++) {

            /*********************************************/
            final int j = i;
            String link = VideoID[i];

            //String url = "https://www.googleapis" +
                    //".com/youtube/v3/search?part="+link+"&key="+new YouTubeConfig().getAPI_KEY();

            String url = "https://noembed.com/embed?url=https://www.youtube.com/watch?v=" + link;
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("TAGING ", response);
                            if (!response.contains("error")) {
                                try {

                                    JSONObject allData = new JSONObject(response);
                                    titleList[j] = allData.getString("title")+"~"+allData
                                            .getString("author_name");
                                    //Toast.makeText(ctx, "Finally it worked " + titleList[j],
                                    // Toast.LENGTH_SHORT);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                Toast.makeText(ctx, "Content not found", Toast
                                        .LENGTH_SHORT);
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(ctx, "That didn't work!", Toast.LENGTH_SHORT);
                }
            });
            queue.add(stringRequest);
            /******************************************************/
        }
    }

    public RecyclerAdapter(Context context){
        this.ctx = context;
        this.trash_items = new ArrayList<String>();
    }

    @Override
    public VideoInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtubeplayer_row, parent,
                false);
        return new VideoInfoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final VideoInfoHolder holder, final int position) {

        final YouTubeThumbnailLoader.OnThumbnailLoadedListener  onThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener(){
            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

            }

            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                youTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.relativeLayoutOverYouTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.title.setVisibility(View.VISIBLE);
                holder.author.setVisibility(View.VISIBLE);
                holder.check_for_delete.setVisibility(View.VISIBLE);
            }
        };

        holder.youTubeThumbnailView.initialize(new YouTubeConfig().getAPI_KEY(), new YouTubeThumbnailView
                .OnInitializedListener
                () {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView,
                                                final YouTubeThumbnailLoader
                                                        youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(VideoID[position]);
                /*youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
                youTubeThumbnailLoader.release();*/
                /* --------------------------------------- */
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {

                        setViewinfoholder(holder);

                        youTubeThumbnailLoader.release();
                       // Toast.makeText(ctx, titleList[position], Toast.LENGTH_LONG).show();
                        String header[] = titleList[position].split("~");
                        holder.title.setText(header[0]);
                        holder.title.setVisibility(View.VISIBLE);
                       // Toast.makeText(ctx, header[0], Toast.LENGTH_LONG).show();

                        holder.author.setText(header[1]);
                        holder.author.setVisibility(View.VISIBLE);
                       // Toast.makeText(ctx, header[1], Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                    }
                });

                /*------------------------------------------*/
            }
            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //write something for failure
            }
        });
    }

    @Override
    public int getItemCount() {
        return VideoID.length;
    }

    public class VideoInfoHolder extends RecyclerView.ViewHolder implements View
            .OnLongClickListener, View
    .OnClickListener
             {

        protected RelativeLayout relativeLayoutOverYouTubeThumbnailView;
        protected LinearLayout relativeLayoutThumbnailAndPlay;
        YouTubeThumbnailView youTubeThumbnailView;
        protected ImageView playButton;
        protected TextView title, author;
        protected CheckBox check_for_delete;
        protected boolean isLongClick = false;

        public VideoInfoHolder(View itemView) {
            super(itemView);

            playButton=(ImageView)itemView.findViewById(R.id.btnYoutube_player);
            playButton.setOnClickListener(this);
            playButton.setOnLongClickListener(this);

            relativeLayoutOverYouTubeThumbnailView = (RelativeLayout) itemView.findViewById(R.id.relativeLayout_over_youtube_thumbnail);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.youtube_thumbnail);
            title = (TextView)itemView.findViewById(R.id.video_title);
            author = (TextView)itemView.findViewById(R.id.video_author);
            check_for_delete = (CheckBox)itemView.findViewById(R.id.check_per_item);
        }

        @Override
        public void onClick(View v) {
                Intent intent = YouTubeStandalonePlayer.createVideoIntent(
                        (Activity) ctx,
                        new YouTubeConfig().getAPI_KEY(),
                        VideoID[getLayoutPosition()],
                        100,
                        true,
                        false);
                ctx.startActivity(intent);

        }
        @Override
        public boolean onLongClick(View v) {

            isCheckBoxVisible = true;
            //setCheckBox();
            Toast.makeText((Activity)ctx, "This is long click ", Toast
                    .LENGTH_LONG).show();

            title.setPadding(50, 0, 0, 0);
            author.setPadding(50, 0, 0, 0);
            check_for_delete.setVisibility(View.VISIBLE);
            check_for_delete.setOnCheckedChangeListener(null);
            check_for_delete.setChecked(youTubeThumbnailView.isSelected());

            check_for_delete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (compoundButton.isChecked() == true) {
                        compoundButton.setChecked(true);
                        trash_items.add(VideoID[getLayoutPosition()]);
                        Toast.makeText(ctx, "This is checked "+VideoID[getLayoutPosition()], Toast
                                .LENGTH_LONG).show();
                    } else {
                        compoundButton.setChecked(false);
                        trash_items.remove(VideoID[getLayoutPosition()]);
                        Toast.makeText(ctx, "This is unchecked "+VideoID[getLayoutPosition()], Toast
                                .LENGTH_LONG).show();
                    }
                }
            });
            //check_for_delete.setVisibility(View.INVISIBLE);
            return true;
        }
        /*
                 @Override
                 public boolean onTouch(View view, MotionEvent motionEvent) {
                     Toast.makeText(ctx, "This is motion ", Toast
                             .LENGTH_LONG).show();
                     return true;
                 }*/
             }
}