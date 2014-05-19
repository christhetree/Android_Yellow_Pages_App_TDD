package com.tddrampup.activities;

import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;

import com.google.inject.Inject;
import com.tddrampup.R;
import com.tddrampup.RobolectricTestRunnerWithInjection;
import com.tddrampup.fragments.HomeFragment;
import com.tddrampup.fragments.ListFragment;
import com.tddrampup.singletons.ListingsInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowHandler;
import org.robolectric.shadows.ShadowToast;

import static org.fest.assertions.api.ANDROID.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunnerWithInjection.class)
public class MainActivityTest {
    private MainActivity mMainActivity;

    @Inject
    ListingsInterface mListings;

    @Before
    public void setUp() throws Exception {
        mMainActivity = Robolectric.buildActivity(MainActivity.class).create().start().visible().get();
    }

    @Test
    public void onCreate_shouldDisplayHomeFragment() throws Exception {
        HomeFragment homeFragment = (HomeFragment) mMainActivity.getSupportFragmentManager().findFragmentByTag("MY_HOME_FRAGMENT");
        assertThat(homeFragment).isVisible();
    }

    @Test
    public void onListButtonClicked_shouldOpenListFragment() throws Exception {
        Button listButton = (Button) mMainActivity.findViewById(R.id.list_button);
        listButton.performClick();
        Fragment listFragment = mMainActivity.getSupportFragmentManager().findFragmentByTag("MY_LIST_FRAGMENT");
        assertThat(listFragment).isVisible();
        assertThat(((ListFragment) listFragment).mWhat).isEqualTo("Restaurants");
        assertThat(((ListFragment) listFragment).mWhere).isEqualTo("Toronto");
    }

    @Test
    public void onMapButtonClicked_shouldOpenMapFragment() throws Exception {
        Button mapButton = (Button) mMainActivity.findViewById(R.id.map_button);
        mapButton.performClick();
        Fragment mapFragment = mMainActivity.getSupportFragmentManager().findFragmentByTag("MY_GOOGLE_MAP_FRAGMENT");
        assertThat(mapFragment).isVisible();
    }

    @Test
    public void onSearchButtonClicked_shouldDisplayToastIfEditTextsAreEmpty() {
        Button searchButton = (Button) mMainActivity.findViewById(R.id.search_button);
        searchButton.performClick();
        ShadowHandler.idleMainLooper();
        assertThat(ShadowToast.getTextOfLatestToast()).isEqualTo("Please fill in both fields!");
    }

    @Test
    public void onSearchButtonClicked_shouldOpenListFragmentIfEditTextsAreNotEmpty() throws Exception {
        EditText whatEditText = (EditText) mMainActivity.findViewById(R.id.what_editText);
        EditText whereEditText = (EditText) mMainActivity.findViewById(R.id.where_editText);

        whatEditText.setText("a");
        whereEditText.setText("b");

        Button searchButton = (Button) mMainActivity.findViewById(R.id.search_button);
        searchButton.performClick();
        Fragment searchFragment = mMainActivity.getSupportFragmentManager().findFragmentByTag("MY_SEARCH_FRAGMENT");
        assertThat(searchFragment).isVisible();

        assertThat(((ListFragment) searchFragment).mWhat).isEqualTo("a");
        assertThat(((ListFragment) searchFragment).mWhere).isEqualTo("b");
    }

    @Test
    public void itemCallbackCall_shouldOpenDetailFragment() throws Exception {
        mMainActivity.new Callback().itemCallbackCall(mListings.getListings().get(0));
        Fragment detailFragment = mMainActivity.getSupportFragmentManager().findFragmentByTag("MY_DETAIL_FRAGMENT");
        assertThat(detailFragment).isVisible();
    }

    @Test
    public void loadingLifecycle_shouldShowAndHideLoadingProgressDialog() throws Exception {
        mMainActivity.onListViewItemClicked(0);
        assertThat(mMainActivity.isProgressDialogShowing()).isTrue();
        mMainActivity.new Callback().itemCallbackCall(mMainActivity.mListings.getListings().get(0));
        assertThat(mMainActivity.isProgressDialogShowing()).isFalse();
    }
}
