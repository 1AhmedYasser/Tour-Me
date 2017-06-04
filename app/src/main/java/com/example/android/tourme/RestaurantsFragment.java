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

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // Create a list of Restaurants tours
        final ArrayList<Tour> RestaurantsTours = new ArrayList<>();
        RestaurantsTours.add(new Tour(R.string.al_khal, R.drawable.al_khal, R.string.AlKhal_Restaurant_Info, R.string.AlKhal_Restaurant_Location, R.string.AlKhal_Contact, new LatLng(30.072455, 31.347942)));
        RestaurantsTours.add(new Tour(R.string.entrecote_steak_house, R.drawable.entrecote_steak_house, R.string.EntrecoteSteakHouse_Restaurant_Info, R.string.EntrecoteSteakHouse_Restaurant_Location, R.string.EntrecoteSteakHouse_Contact, new LatLng(27.962544, 34.393675)));
        RestaurantsTours.add(new Tour(R.string.holmes_burgers, R.drawable.holmes_burgers, R.string.HolmesBurgers_Restaurant_Info, R.string.HolmesBurgers_Restaurant_Location, R.string.HolmesBurgers_Contact, new LatLng(31.245969, 29.972308)));
        RestaurantsTours.add(new Tour(R.string.Sabaya, R.drawable.lebanese_mezzah, R.string.Sabaya_Restaurant_Info, R.string.Sabaya_Restaurant_Location, R.string.Sabaya_Contact, new LatLng(30.042808, 31.231670)));
        RestaurantsTours.add(new Tour(R.string.Potasta, R.drawable.mozzarella_sticks, R.string.Potasta_Restaurant_Info, R.string.Potasta_Restaurant_Location, R.string.Potasta_Contact, new LatLng(31.229523, 29.948702)));
        RestaurantsTours.add(new Tour(R.string.pizza_roma, R.drawable.pizza_pasta, R.string.PizzaRoma_Restaurant_Info, R.string.PizzaRoma_Restaurant_Location, R.string.PizzaRoma_Contact, new LatLng(25.688493, 32.634656)));
        RestaurantsTours.add(new Tour(R.string.la_fleur, R.drawable.la_fleur, R.string.LaFleur_Restaurant_Info, R.string.LaFleur_Restaurant_Location, R.string.LaFleur_Contact, new LatLng(27.911402, 34.326879)));
        RestaurantsTours.add(new Tour(R.string.ll_frantoio, R.drawable.ll_frantoio, R.string.Il_Frantoio_Restaurant_Info, R.string.Il_Frantoio_Restaurant_Location, R.string.Il_Frantoio_Contact, new LatLng(27.956126, 34.392695)));
        RestaurantsTours.add(new Tour(R.string.shark_resturant, R.drawable.shark_resturant, R.string.Shark_Restaurant_Info, R.string.Shark_Restaurant_Info, R.string.Shark_Contact, new LatLng(28.498217, 34.517859)));
        RestaurantsTours.add(new Tour(R.string.the_lantern_room, R.drawable.the_lantern_room, R.string.TheLanternRoom_Restaurant_Info, R.string.TheLanternRoom_Restaurant_Location, R.string.TheLanternRoom_Contact, new LatLng(25.687525, 32.632426)));

        // Create a tour adapter whose data source is a list of restaurants tours.
        TourAdapter tourAdapter = new TourAdapter(getActivity(), RestaurantsTours);

        // Get the list view from the xml file and initialize the listView variable with it.
        ListView listView = (ListView) rootView.findViewById(R.id.tours_list);

        // Make the listView use the custom tour adapter.
        listView.setAdapter(tourAdapter);

        // Set a listener to the list to open the Info activity with the required information when an item is selected from the list.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tour selectedTour = RestaurantsTours.get(i);
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
