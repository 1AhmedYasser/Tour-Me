package com.example.android.tourme;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

public class InfoActivity extends AppCompatActivity {

    // Declare a global Map location variable of type LatLng.
    LatLng MapLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Get the location button ,info text , location text and contact info text from activity_info.xml.
        Button locationButton = (Button) findViewById(R.id.LocationButton);
        TextView InfoText = (TextView) findViewById(R.id.info_card);
        TextView LocationText = (TextView) findViewById(R.id.location_card);
        TextView ContactInfoText = (TextView) findViewById(R.id.ContactInfo_card);

        // Get the intent and extract all its passed data and put them in the appropriate variables with the appropriate types.
        Intent intent = getIntent();
        int ImageId = intent.getIntExtra("ImageId", -1);
        int TourNameId = intent.getIntExtra("TourName", -1);
        int InfoId = intent.getIntExtra("InfoId", -1);
        int LocationId = intent.getIntExtra("LocationId", -1);
        int ContactInfoId = intent.getIntExtra("ContactInfoId", -1);
        Bundle ExtraInfo = intent.getExtras();
        MapLocation = (LatLng) ExtraInfo.get("MapLocation");


        // Get the collapsing toolbar layout and set its collapsed and expanded text appearance with a custom style in the styles.xml.
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.CollapsingToolBar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedCollapsingToolbarTextAppearance);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedCollapsingToolbarTextAppearance);

        // Create a new Text view variable and pass to it the tour name and then populate the layout title with it.
        TextView TourName = new TextView(this);
        TourName.setText(TourNameId);
        collapsingToolbarLayout.setTitle(TourName.getText());

        // Get the Collapsing image from activity_info.xml and populate the layout image with the passed tour image.
        ImageView CollapsingImage = (ImageView) findViewById(R.id.CollapsingImage);
        CollapsingImage.setImageResource(ImageId);

        // Set the information text with the passed tour information text.
        InfoText.setText(InfoId);

        // Set the location text with the passed tour location text.
        LocationText.setText(LocationId);

        // Set the information text with the passed tour information text.
        ContactInfoText.setText(ContactInfoId);

        // Open the map activity and pass to it the required latitude and longitude.
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, Map.class);
                intent.putExtra("MapLocation", MapLocation);
                startActivity(intent);
            }
        });
    }
}
