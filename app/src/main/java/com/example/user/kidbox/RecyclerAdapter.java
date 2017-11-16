package com.example.user.kidbox;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import  com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;

/**
 * Created by ofaroque on 8/13/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter
        .VideoInfoHolder>{

    //these ids are the unique id for each video
    String[] VideoID = {"rtOvBOTyX00", "8iuZrJumCLo", "RBumgq5yVrA", "G6s2hiJ1aZo"};
    String[] titleList = {"ABC", "DEF", "GHI", "JKL"};
    Context ctx;

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

    public class VideoInfoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected RelativeLayout relativeLayoutOverYouTubeThumbnailView;
        YouTubeThumbnailView youTubeThumbnailView;
        protected ImageView playButton;
        protected TextView title, author;

        public VideoInfoHolder(View itemView) {
            super(itemView);
            playButton=(ImageView)itemView.findViewById(R.id.btnYoutube_player);
            playButton.setOnClickListener(this);
            relativeLayoutOverYouTubeThumbnailView = (RelativeLayout) itemView.findViewById(R.id.relativeLayout_over_youtube_thumbnail);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.youtube_thumbnail);
            title = (TextView)itemView.findViewById(R.id.video_title);
            author = (TextView)itemView.findViewById(R.id.video_author);
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
    }
}