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

public class EntertainmentFragment extends Fragment {

    public EntertainmentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // Create a list of entertainment tours
        final ArrayList<Tour> EntertainmentTours = new ArrayList<>();
        EntertainmentTours.add(new Tour(R.string.dream_park, R.drawable.dream_park, R.string.DreamPark_Info, R.string.DreamPark_Location, R.string.DreamPark_Contact, new LatLng(29.965944, 31.057882)));
        EntertainmentTours.add(new Tour(R.string.al_azhar_park, R.drawable.al_azhar_park, R.string.AlAzharPark_Info, R.string.AlAzharPark_Location, R.string.AlAzharPark_Contact, new LatLng(30.040972, 31.265218)));
        EntertainmentTours.add(new Tour(R.string.adrenalin_paintball, R.drawable.adrenalin_paintball, R.string.AdrenalinPaintball_Info, R.string.AdrenalinPaintball_Location, R.string.AdrenalinPaintball_Contact, new LatLng(30.027196, 30.936078)));
        EntertainmentTours.add(new Tour(R.string.el_reef_el_araby, R.drawable.el_reef_el_araby, R.string.ElReefElAraby_Info, R.string.ElReefElAraby_Location, R.string.ElReefElAraby_Contact, new LatLng(29.924192, 31.187199)));
        EntertainmentTours.add(new Tour(R.string.africa_safari_park, R.drawable.africa_safari_park, R.string.AfricaSafariPark_Info, R.string.AfricaSafariPark_Location, R.string.AfricaSafariPark_Contact, new LatLng(30.763558, 29.979565)));
        EntertainmentTours.add(new Tour(R.string.giza_zoo, R.drawable.giza_zoo, R.string.GizaZoo_Info, R.string.GizaZoo_Location, R.string.GizaZoo_Contact, new LatLng(30.022630, 31.213639)));
        EntertainmentTours.add(new Tour(R.string.hinthunt, R.drawable.hinthunt, R.string.HintHunt_Info, R.string.HintHunt_Location, R.string.HintHunt_Contact, new LatLng(30.091677, 31.384380)));
        EntertainmentTours.add(new Tour(R.string.mindmaze, R.drawable.mindmaze, R.string.MindMaze_Info, R.string.MindMaze_Location, R.string.MindMaze_Contact, new LatLng(29.957102, 31.275732)));
        EntertainmentTours.add(new Tour(R.string.escape_room_egypt, R.drawable.escape_room_egypt, R.string.EscapeRoom_Info, R.string.EscapeRoom_Location, R.string.EscapeRoom_Contact, new LatLng(30.086866, 31.346906)));
        EntertainmentTours.add(new Tour(R.string.genena_mall, R.drawable.genena_mall, R.string.GenenaMall_Info, R.string.GenenaMall_Location, R.string.GenenaMall_Contact, new LatLng(30.061009, 31.332171)));

        // Create a tour adapter whose data source is a list of entertainment tours.
        TourAdapter tourAdapter = new TourAdapter(getActivity(), EntertainmentTours);

        // Get the list view from the xml file and initialize the listView variable with it.
        ListView listView = (ListView) rootView.findViewById(R.id.tours_list);

        // Make the listView use the custom tour adapter.
        listView.setAdapter(tourAdapter);

        // Set a listener to the list to open the Info activity with the required information when an item is selected from the list.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Tour selectedTour = EntertainmentTours.get(i);
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
