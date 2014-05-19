package com.tddrampup.adapters;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.inject.Inject;
import com.tddrampup.R;
import com.tddrampup.RobolectricTestRunnerWithInjection;
import com.tddrampup.singletons.ListingsInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.fest.assertions.api.ANDROID.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;

/**
* Created by WX009-PC on 2/19/14.
*/
@RunWith(RobolectricTestRunnerWithInjection.class)
public class ListingAdapterTest {
    private Activity mActivity;
    private ListingAdapter mListingAdapter;

    @Inject
    ListingsInterface mListings;

    @Before
    public void setUp() throws Exception {
        mActivity = Robolectric.buildActivity(Activity.class).create().visible().get();
        mListingAdapter = new ListingAdapter(mActivity.getLayoutInflater(), mListings.getListings());
    }

    @Test
    public void getCount_shouldReturnListSize() throws Exception {
        assertThat(mListingAdapter).hasCount(1);
    }

    @Test
    public void getItem_shouldReturnInfo() throws Exception {
        View view = mListingAdapter.getView(0, null, null);
        assertThat((TextView)view.findViewById(R.id.listing_title)).hasText("One");
    }

    @Test
    public void getItemId_shouldReturnZero() throws Exception {
        assertThat(mListingAdapter.getItemId(0)).isEqualTo((long) 0);
    }
}
