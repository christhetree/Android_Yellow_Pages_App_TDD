package com.tddrampup.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tddrampup.R;
import com.tddrampup.models.Listing;

import java.util.List;

/**
 * Created by WX009-PC on 2/19/14.
 */
public class ListingAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private List<Listing> mListings;

    public ListingAdapter(LayoutInflater layoutInflater, List<Listing> listings) {
        mLayoutInflater = layoutInflater;
        mListings = listings;
    }

    @Override
    public int getCount() {
        return mListings.size();
    }

    @Override
    public Object getItem(int i) {
        return mListings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null) {
            viewHolder = new ViewHolder();
            view = mLayoutInflater.inflate(R.layout.row_listview, null);
            viewHolder.listingTitle = (TextView) view.findViewById(R.id.listing_title);
            viewHolder.listingAddress = (TextView) view.findViewById(R.id.listing_address);
            viewHolder.listingCity = (TextView) view.findViewById(R.id.listing_city);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Listing listing = mListings.get(i);
        viewHolder.listingTitle.setText(listing.getName());
        viewHolder.listingAddress.setText(listing.getAddress().getStreet());
        viewHolder.listingCity.setText(listing.getAddress().getCity());
        return view;
    }

    private class ViewHolder {
        TextView listingTitle;
        TextView listingAddress;
        TextView listingCity;
    }
}
