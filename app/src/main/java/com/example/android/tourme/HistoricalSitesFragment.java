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

public class HistoricalSitesFragment extends Fragment {

    public HistoricalSitesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // Create a list of historical sites tours
        final ArrayList<Tour> HistoricalSitesTours = new ArrayList<>();
        HistoricalSitesTours.add(new Tour(R.string.pyramids_of_giza, R.drawable.pyramids_of_giza, R.string.PyramidsOfGiza_HistoricalSite_Info, R.string.PyramidsOfGiza_HistoricalSite_Location, R.string.PyramidsOfGiza_Contact, new LatLng(29.979234, 31.134202)));
        HistoricalSitesTours.add(new Tour(R.string.luxor_temple, R.drawable.luxor_temple, R.string.LuxorTemple_HistoricalSite_Info, R.string.LuxorTemple_HistoricalSite_Location, R.string.LuxorTemple_Contact, new LatLng(25.699492, 32.639062)));
        HistoricalSitesTours.add(new Tour(R.string.qaitbay_citadel, R.drawable.qaitbay_citadel, R.string.FortQaitbey_HistoricalSite_Info, R.string.FortQaitbey_HistoricalSite_Location, R.string.FortQaitbey_Contact, new LatLng(31.213974, 29.885595)));
        HistoricalSitesTours.add(new Tour(R.string.memphis, R.drawable.memphis, R.string.Memphis_HistoricalSite_Info, R.string.Memphis_HistoricalSite_Location, R.string.Memphis_Contact, new LatLng(29.705209, 31.224333)));
        HistoricalSitesTours.add(new Tour(R.string.valley_of_the_kings, R.drawable.valley_of_the_kings, R.string.ValleyOfTheKings_HistoricalSite_Info, R.string.ValleyOfTheKings_HistoricalSite_Location, R.string.ValleyOfTheKings_Contact, new LatLng(25.740125, 32.601379)));
        HistoricalSitesTours.add(new Tour(R.string.sakkara_pyramid, R.drawable.sakkara_pyramid, R.string.SakkaraPyramid_HistoricalSite_Info, R.string.SakkaraPyramid_HistoricalSite_Location, R.string.SakkaraPyramid_Contact, new LatLng(29.871323, 31.216522)));
        HistoricalSitesTours.add(new Tour(R.string.temple_of_philae, R.drawable.temple_of_philae, R.string.TempleOfPhilae_HistoricalSite_Info, R.string.TempleOfPhilae_HistoricalSite_Location, R.string.TempleOfPhilae_Contact, new LatLng(24.012766, 32.877573)));
        HistoricalSitesTours.add(new Tour(R.string.temple_of_karnak, R.drawable.temple_of_karnak, R.string.TempleOfKarnak_HistoricalSite_Info, R.string.TempleOfKarnak_HistoricalSite_Location, R.string.TempleOfKarnak_Contact, new LatLng(25.718815, 32.657260)));
        HistoricalSitesTours.add(new Tour(R.string.pompey_pillar, R.drawable.pompey_pillar, R.string.PompeysPillar_HistoricalSite_Info, R.string.PompeysPillar_HistoricalSite_Location, R.string.PompeysPillar_Contact, new LatLng(31.182482, 29.896357)));
        HistoricalSitesTours.add(new Tour(R.string.catacombs_of_kom_el_shoqafa, R.drawable.catacombs_of_kom_el_shoqafa, R.string.CatacombsOfKomElShoqafa_HistoricalSite_Info, R.string.CatacombsOfKomElShoqafa_HistoricalSite_Location, R.string.CatacombsOfKomElShoqafa_Contact, new LatLng(31.179288, 29.893171)));

        // Create a tour adapter whose data source is a list of historical sites tours.
        TourAdapter tourAdapter = new TourAdapter(getActivity(), HistoricalSitesTours);

        // Get the list view from the xml file and initialize the listView variable with it.
        ListView listView = (ListView) rootView.findViewById(R.id.tours_list);

        // Make the listView use the custom tour adapter.
        listView.setAdapter(tourAdapter);

        // Set a listener to the list to open the Info activity with the required information when an item is selected from the list.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tour selectedTour = HistoricalSitesTours.get(i);
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
