package com.example.android.tourme;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TourTypeAdapter extends FragmentPagerAdapter {

    // Context of the app
    private Context mContext;

    /**
     * Create a new {@link TourTypeAdapter} object.
     * A {@link TourTypeAdapter} Constructor.
     *
     * @param context is the context of the app.
     * @param fm      is the fragment manager that keeps each fragment state in the adapter across swipes.
     */
    public TourTypeAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * This method returns the fragment that should be displayed for the given page number.
     *
     * @param position : page position.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new EntertainmentFragment();
        } else if (position == 1) {
            return new RestaurantsFragment();
        } else if (position == 2) {
            return new HistoricalSitesFragment();
        } else {
            return new ResortsFragment();
        }
    }

    /**
     * This method returns the total number of pages to be displayed in the app in runtime.
     *
     * @return int : The number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    /**
     * This method returns the fragment title
     *
     * @param position : page position.
     * @return CharSequence : the page title.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.Entertainment);
        } else if (position == 1) {
            return mContext.getString(R.string.Resturants);
        } else if (position == 2) {
            return mContext.getString(R.string.Historical);
        } else {
            return mContext.getString(R.string.Resorts);
        }
    }
}
