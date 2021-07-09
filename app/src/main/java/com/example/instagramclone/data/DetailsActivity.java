package com.example.instagramclone.data;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.instagramclone.ParcelableObject;
import com.example.instagramclone.Post;
import com.example.instagramclone.R;
import com.parse.ParseFile;
import com.parse.ParseUser;

import org.parceler.Parcels;

import java.util.Date;

public class DetailsActivity extends AppCompatActivity {

    Post posts;
    ImageView ivPost;
    TextView description;
    TextView tvTime;
    TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        description = findViewById(R.id.description);
        tvTime = findViewById(R.id.tvTime);
        ivPost = findViewById(R.id.ivPost);
        tvUser = findViewById(R.id.tvUser);

        ParcelableObject objectReceived = Parcels.unwrap(getIntent().getParcelableExtra("post"));
        Post postReceived = objectReceived.getPost();
        Log.d("DetailsActivity", "Post received = " + postReceived.getDescription());
        ParseUser postUser = postReceived.getUser();

        ParseFile image = postReceived.getImage();
        if (image != null) {
            Glide.with(this).load(image.getUrl()).into(ivPost);
        }
        if (description != null) {
          description.setText(postReceived.getDescription());
        }

        tvTime.setText(calculateTimeAgo(postReceived.getCreatedAt()));

        if(postUser != null){
            Log.d("DetailsActivity", "user = " + postUser.getUsername());
            tvUser.setText(postUser.getUsername());
        }
        //Toast.makeText(DetailsActivity.this, "post received = " + postReceived.getUser().getUsername(), Toast.LENGTH_SHORT).show();
    }

    public static String calculateTimeAgo(Date createdAt) {

        int SECOND_MILLIS = 1000;
        int MINUTE_MILLIS = 60 * SECOND_MILLIS;
        int HOUR_MILLIS = 60 * MINUTE_MILLIS;
        int DAY_MILLIS = 24 * HOUR_MILLIS;

        try {
            createdAt.getTime();
            long time = createdAt.getTime();
            long now = System.currentTimeMillis();

            final long diff = now - time;
            if (diff < MINUTE_MILLIS) {
                return "just now";
            } else if (diff < 2 * MINUTE_MILLIS) {
                return "a minute ago";
            } else if (diff < 50 * MINUTE_MILLIS) {
                return diff / MINUTE_MILLIS + " m";
            } else if (diff < 90 * MINUTE_MILLIS) {
                return "an hour ago";
            } else if (diff < 24 * HOUR_MILLIS) {
                return diff / HOUR_MILLIS + " h";
            } else if (diff < 48 * HOUR_MILLIS) {
                return "yesterday";
            } else {
                return diff / DAY_MILLIS + " d";
            }
        } catch (Exception e) {
            Log.i("Error:", "getRelativeTimeAgo failed", e);
            e.printStackTrace();
        }

        return "";
    }


    }
