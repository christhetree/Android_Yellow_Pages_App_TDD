package com.tddrampup.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tddrampup.R;

import roboguice.fragment.RoboFragment;

/**
 * Created by WX009-PC on 2/19/14.
 */
public class HomeFragment extends RoboFragment {

    public onItemClickedListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);

        final Button listButton = (Button) rootView.findViewById(R.id.list_button);
        final Button mapButton = (Button) rootView.findViewById(R.id.map_button);
        final Button searchButton = (Button) rootView.findViewById(R.id.search_button);
        final EditText what = (EditText) rootView.findViewById(R.id.what_editText);
        final EditText where = (EditText) rootView.findViewById(R.id.where_editText);

        listButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mListener.onListButtonClicked();
            }
        });
        mapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mListener.onMapButtonClicked();
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mListener.onSearchButtonClicked();
            }
        });
        searchButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                what.setText("Restaurants");
                where.setText("Toronto");
                return false;
            }
        });

        return rootView;
    }

    public interface onItemClickedListener {
        public void onListButtonClicked();
        public void onMapButtonClicked();
        public void onSearchButtonClicked();
     }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof onItemClickedListener) {
            mListener = (onItemClickedListener) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}