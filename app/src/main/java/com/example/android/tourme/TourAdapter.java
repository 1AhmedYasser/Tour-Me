package com.example.android.tourme;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link TourAdapter} is an {@link ArrayAdapter} that can provide the layout for each  tour list item
 * based on a data source, which is a list of {@link Tour} objects.
 */
public class TourAdapter extends ArrayAdapter<Tour> {

    /**
     * Create a new {@link TourAdapter} object.
     * A {@link TourAdapter} Constructor.
     *
     * @param context is the current app context.
     * @param Tours   : the list of tours to be displayed to the user.
     */
    public TourAdapter(Context context, ArrayList<Tour> Tours) {
        super(context, 0, Tours);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view.
        View TourItem = convertView;
        if (TourItem == null) {
            TourItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.tour_item, parent, false);
        }

        // Get the Tour object located at this position in the list.
        Tour currentTour = getItem(position);

        // Get the CardView in the tour_item.xml layout.
        CardView listCard = (CardView) TourItem.findViewById(R.id.Card_List_Item);

        // Set the list animation on each item of the list.
        listCard.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.list_item_animation));

        // Get the Tour Name in the tour_item.xml layout.
        TextView TourName = (TextView) TourItem.findViewById(R.id.tour_item_text);

        // Get the tour name from the currentTour object and set the text view text with it.
        TourName.setText(currentTour.getTourNameId());

        // Get the Tour Image in the tour_item.xml layout.
        ImageView TourImage = (ImageView) TourItem.findViewById(R.id.tour_item_image);

        // Get the image resource from the currentTour object and set the tour image resource with it.
        TourImage.setImageResource(currentTour.getTourImageId());

        // returns the whole tour item layout.
        return TourItem;
    }
}
