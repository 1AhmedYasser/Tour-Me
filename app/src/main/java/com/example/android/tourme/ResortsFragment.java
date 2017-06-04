package com.example.android.tourme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class ResortsFragment extends Fragment {

    public ResortsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // Create a list of resorts tours
        final ArrayList<Tour> ResortsTours = new ArrayList<>();
        ResortsTours.add(new Tour(R.string.desert_rose_resort, R.drawable.desert_rose_resort, R.string.DesertRose_Resort_Info, R.string.DesertRose_Resort_Location, R.string.DesertRose_Contact, new LatLng(27.097937, 33.835997)));
        ResortsTours.add(new Tour(R.string.movenpick_resort, R.drawable.movenpick_resort, R.string.Movenpick_Resort_Info, R.string.Movenpick_Resort_Location, R.string.Movenpick_Contact, new LatLng(27.395652, 33.684468)));
        ResortsTours.add(new Tour(R.string.old_palace_resort, R.drawable.old_palace_resort, R.string.OldPalace_Resort_Info, R.string.OldPalace_Resort_Location, R.string.OldPalace_Contact, new LatLng(27.048070, 33.887142)));
        ResortsTours.add(new Tour(R.string.sheraton_miramar_resort, R.drawable.sheraton_miramar_resort, R.string.SheratonMiramar_Resort_Info, R.string.SheratonMiramar_Resort_Location, R.string.SheratonMiramar_Contact, new LatLng(27.404876, 33.677872)));
        ResortsTours.add(new Tour(R.string.three_corners_rihana_resort, R.drawable.three_corners_rihana_resort, R.string.ThreeCornersRihana_Resort_Info, R.string.ThreeCornersRihana_Resort_Location, R.string.ThreeCornersRihana_Contact, new LatLng(27.399803, 33.672762)));
        ResortsTours.add(new Tour(R.string.the_grand_resort_hurghada, R.drawable.the_grand_resort_hurghada, R.string.TheGrand_Resort_Info, R.string.TheGrand_Resort_Location, R.string.TheGrand_Contact, new LatLng(27.174807, 33.823348)));
        ResortsTours.add(new Tour(R.string.sultan_gardens_resort, R.drawable.sultan_gardens_resort, R.string.SultanGardens_Resort_Info, R.string.SultanGardens_Resort_Location, R.string.SultanGardens_Contact, new LatLng(27.944275, 34.383039)));
        ResortsTours.add(new Tour(R.string.four_seasons_resort, R.drawable.four_seasons_resort, R.string.FourSeasons_Resort_Info, R.string.FourSeasons_Resort_Location, R.string.FourSeasons_Contact, new LatLng(27.956250, 34.392374)));
        ResortsTours.add(new Tour(R.string.delta_sharm_resort, R.drawable.delta_sharm_resort, R.string.DeltaSharm_Resort_Info, R.string.DeltaSharm_Resort_Location, R.string.DeltaSharm_Contact, new LatLng(27.885183, 34.304616)));
        ResortsTours.add(new Tour(R.string.baron_resort, R.drawable.baron_resort, R.string.Baron_Resort_Info, R.string.Baron_Resort_Location, R.string.Baron_Contact, new LatLng(27.971678, 34.420684)));

        // Create a tour adapter whose data source is a list of resorts tours.
        TourAdapter tourAdapter = new TourAdapter(getActivity(), ResortsTours);

        // Get the list view from the xml file and initialize the listView variable with it.
        ListView listView = (ListView) rootView.findViewById(R.id.tours_list);

        // Make the listView use the custom tour adapter.
        listView.setAdapter(tourAdapter);

        // Set a listener to the list to open the Info activity with the required information when an item is selected from the list.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tour selectedTour = ResortsTours.get(i);
                Intent intent = new Intent(getActivity(), InfoActivity.class);
                intent.putExtra("ImageId", selectedTour.getTourImageId());
                intent.putExtra("TourName", selectedTour.getTourNameId());
                intent.putExtra("InfoId", selectedTour.getTourInfoId());
                intent.putExtra("LocationId", selectedTour.getTourLocationId());
                intent.putExtra("ContactInfoId", selectedTour.getTourContactInfoId());
                intent.putExtra("MapLocation", selectedTour.getMapLocation());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
