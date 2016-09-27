package edu.orangecoastcollege.cs273.kfrederick5.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set adapter (which binds the ListView with the data in MusicEvent.java
        // Since Data is in array, we use an ArrayAdapter:

        setListAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,MusicEvent.titles));

        //Will cause crash: setContentView(R.layout.activity_event_list);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id)
    {
        // Get position, title, details
        // make intent
        // put string in intent
        // start activity
        String title = MusicEvent.titles[pos];
        String detail = MusicEvent.details[pos];

        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("Title", title);
        detailsIntent.putExtra("Detail", detail);
        startActivity(detailsIntent);


    }
}
