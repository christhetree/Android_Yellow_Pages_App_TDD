package com.tddrampup.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.inject.Inject;
import com.tddrampup.R;
import com.tddrampup.adapters.ListingAdapter;
import com.tddrampup.models.Listing;
import com.tddrampup.serviceLayers.VolleyServiceLayer;
import com.tddrampup.serviceLayers.VolleyServiceLayerCallback;
import com.tddrampup.singletons.ListingsInterface;

import java.util.List;

import roboguice.fragment.RoboFragment;

/**
 * Created by WX009-PC on 2/19/14.
 */
public class ListFragment extends RoboFragment {

    private static final String API_KEY = "4nd67ycv3yeqtg97dku7m845";
    private static final String DEFAULT_WHAT = "Restaurants";
    private static final String DEFAULT_WHERE = "Toronto";

    private ListView mListView;
    private ListingAdapter mListingAdapter;
    private LayoutInflater mLayoutInflater;
    private VolleyServiceLayer volleyServiceLayer;
    private ProgressDialog mProgressDialog;
    private String mUrl;
    private boolean allowNetworkCall;

    public String mWhat;
    public String mWhere;
    //TODO don't make these public

    public onListViewItemClickedListener mListener;

    @Inject
    ListingsInterface mListings;

    public ListFragment() {
        mWhat = DEFAULT_WHAT;
        mWhere = DEFAULT_WHERE;
    }

    public ListFragment(final String what, final String where) {
        mWhat = what;
        mWhere = where;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUrl = "http://api.sandbox.yellowapi.com/FindBusiness/?what=" + mWhat + "&where=" + mWhere + "&pgLen=40&pg=1&dist=1&fmt=JSON&lang=en&UID=jkhlh&apikey=" + API_KEY;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mLayoutInflater = inflater;
        View rootView = mLayoutInflater.inflate(R.layout.list_fragment, container, false);
        mListView = (ListView) rootView.findViewById(R.id.list_view);
        mProgressDialog = new ProgressDialog(getActivity());

        mListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onListViewItemClicked(position);
            }
        });

        if (mWhat.equals(mListings.getWhatQuery()) && mWhere.equals(mListings.getWhereQuery())) {
            allowNetworkCall = false;
        } else {
            allowNetworkCall = true;
            mListings.setWhatQuery(mWhat);
            mListings.setWhereQuery(mWhere);
        }

        if (allowNetworkCall) {
            showLoading();
            volleyServiceLayer = new VolleyServiceLayer(rootView.getContext());
            volleyServiceLayer.volleyServiceLayerCallback = new Callback();
            volleyServiceLayer.GetListings(mUrl);
        }
        else {
            setupAdapter();
        }

        return rootView;
    }

    public interface onListViewItemClickedListener {
        public void onListViewItemClicked(int position);
    }

    private void showLoading() {
        mProgressDialog.setTitle("Loading:");
        mProgressDialog.setMessage("Fetching listings...");
        mProgressDialog.show();
    }

    private void hideLoading() {
        mProgressDialog.dismiss();
    }

    public boolean isProgressDialogShowing() {
        return mProgressDialog.isShowing();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof onListViewItemClickedListener) {
            mListener = (onListViewItemClickedListener) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    class Callback implements VolleyServiceLayerCallback {
        public void listCallbackCall(List<Listing> listings) {
            hideLoading();
            mListings.setListings(listings);
            setupAdapter();
        }

        @Override
        public void itemCallbackCall(Listing listing) {
            // do nothing
        }
    }

    private void setupAdapter(){
        mListingAdapter = new ListingAdapter(mLayoutInflater, mListings.getListings());
        mListView.setAdapter(mListingAdapter);
        mListingAdapter.notifyDataSetChanged();
    }
}
