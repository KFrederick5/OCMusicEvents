package edu.orangecoastcollege.cs273.kfrederick5.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    /**
     * Displays a list of upcoming concert events by the artist names.
     * These list items are clickable
     * @param savedInstanceState calls for any saved information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set adapter (which binds the ListView with the data in MusicEvent.java
        // Since Data is in array, we use an ArrayAdapter:
        setListAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,MusicEvent.titles));

        //Will cause crash: setContentView(R.layout.activity_event_list);
    }

    /**
     * Makes the items in the list react when clicked on.
     * @param l relates to the list view
     * @param v relates to the view being used
     * @param pos relates to the position of the users input
     * @param id relates to the id of the users input
     */
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
