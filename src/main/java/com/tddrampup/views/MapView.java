package com.tddrampup.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.tddrampup.R;

/**
 * Created by WX009-PC on 2/25/14.
 */
public class MapView extends FrameLayout {

    @SuppressWarnings("unused")
    public MapView(Context context) {
        super(context);
        init();
    }

    @SuppressWarnings("unused")
    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @SuppressWarnings("unused")
    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        try {
            inflater.inflate(R.layout.map_view, this, true);
        } catch (InflateException ex) {
            // fragment's cause layout InflateExceptions in Robolectric
            FrameLayout mockMap = new FrameLayout(getContext());
            mockMap.setId(R.id.google_map);
            addView(mockMap);
        }
    }
}
