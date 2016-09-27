package edu.orangecoastcollege.cs273.kfrederick5.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    private ImageView eventImageView;
    private TextView eventTitleText;
    private TextView eventDetailText;

    //In order to use AssetManager, need to know context
    private Context context = (Context) this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent detailsIntent = getIntent();
        String title = detailsIntent.getStringExtra("Title");
        String detail = detailsIntent.getStringExtra("Detail");
        String imageFileName = title.replace(" ","") + ".jpeg";

        eventImageView = (ImageView) findViewById(R.id.eventImageView);
        eventTitleText = (TextView) findViewById(R.id.eventTitleTextView);
        eventDetailText = (TextView) findViewById(R.id.eventDetailsTextView);

        eventTitleText = ;

        //Load image from Assets folder using AssetManager class
        AssetManager am = context.getAssets();

        //Try to load image file
        try
        {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);

        }
        catch (IOException ex)
        {
            Log.e("OC Music Events", "Cannot load image: " + imageFileName + ex);
        }

    }
}
