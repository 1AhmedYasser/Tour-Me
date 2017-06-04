package com.example.android.tourme;

import com.google.android.gms.maps.model.LatLng;

/**
 * {@link Tour} represents a Tour for the user.
 * It contains the tour name,image,info,location, contact info and the map location for each tour.
 */
public class Tour {

    // Declare the tour name,image,info,location, contact info and the map location.
    private int mTourNameId;
    private int mTourImageId;
    private int mTourInfoId;
    private int mTourLocationId;
    private int mTourContactInfoId;
    private LatLng mTourMapLocation;

    /**
     * {@link Tour} Constructor : Initialize the tour variables by the required information passed to it form the selected fragment.
     */
    public Tour(int TourNameId, int TourImageId, int InfoId, int LocationID, int ContactInfoId, LatLng MapLocation) {

        mTourNameId = TourNameId;
        mTourImageId = TourImageId;
        mTourInfoId = InfoId;
        mTourLocationId = LocationID;
        mTourContactInfoId = ContactInfoId;
        mTourMapLocation = MapLocation;
    }

    /**
     * This method returns the string tour name ID for the tour.
     *
     * @return int : The tour name Id.
     */
    public int getTourNameId() {
        return mTourNameId;
    }

    /**
     * This method returns the tour image resource ID for the tour.
     *
     * @return int : The tour image resource Id.
     */
    public int getTourImageId() {
        return mTourImageId;
    }

    /**
     * This method returns the string tour information ID for the tour.
     *
     * @return int : The tour info Id.
     */
    public int getTourInfoId() {
        return mTourInfoId;
    }

    /**
     * This method returns the string tour location ID for the tour.
     *
     * @return int : The tour location Id.
     */
    public int getTourLocationId() {
        return mTourLocationId;
    }

    /**
     * This method returns the string tour contact information ID for the tour.
     *
     * @return int : The tour contact information Id.
     */
    public int getTourContactInfoId() {
        return mTourContactInfoId;
    }

    /**
     * This method returns the tour map Latitude and longitude.
     *
     * @return LatLng : The tour map Latitude and longitude.
     */
    public LatLng getMapLocation() {
        return mTourMapLocation;
    }
}
