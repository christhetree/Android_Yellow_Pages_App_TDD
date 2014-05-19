package com.tddrampup.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;

import com.tddrampup.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import roboguice.activity.RoboFragmentActivity;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class HomeFragmentTest {

    private RoboFragmentActivity mActivity;
    private HomeFragment mHomeFragment;
    private Button listButton;
    private Button mapButton;
    private Button searchButton;

    private void addFragment() {
        FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        mHomeFragment = new HomeFragment();
        fragmentTransaction.add(mHomeFragment, null);
        fragmentTransaction.commit();
    }

    private void removeFragment() {
        FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(mHomeFragment);
        fragmentTransaction.commit();
    }

    @Before
    public void setUp() throws Exception {
        mActivity = Robolectric.buildActivity(RoboFragmentActivity.class).create().start().visible().get();
        addFragment();
        mHomeFragment.mListener = mock(HomeFragment.onItemClickedListener.class);
        listButton = (Button) mHomeFragment.getView().findViewById(R.id.list_button);
        mapButton = (Button) mHomeFragment.getView().findViewById(R.id.map_button);
        searchButton = (Button) mHomeFragment.getView().findViewById(R.id.search_button);
    }

    @Test
    public void onAttach_shouldAttachOnItemClickedListener() throws Exception {
        assertThat(mHomeFragment.mListener).isNotNull();
    }

    @Test
    public void onDetach_shouldClearOnItemClickListenerAndUnattachFragment() throws Exception {
        removeFragment();
        assertThat(mHomeFragment.mListener).isNull();
        assertThat(mHomeFragment.isAdded()).isFalse();
    }

    @Test
    public void ListButtonClick_shouldCallListClickListener() throws Exception {
        listButton.performClick();
        verify(mHomeFragment.mListener).onListButtonClicked();
    }

    @Test
    public void MapButtonClick_shouldCallMapClickListener() throws Exception {
        mapButton.performClick();
        verify(mHomeFragment.mListener).onMapButtonClicked();
    }

    @Test
    public void SearchButtonClick_shouldCallSearchClickListener() throws Exception {
        searchButton.performClick();
        verify(mHomeFragment.mListener).onSearchButtonClicked();
    }
}
