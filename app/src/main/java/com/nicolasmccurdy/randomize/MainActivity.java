package com.nicolasmccurdy.randomize;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.nicolasmccurdy.randomize.fragments.CardsSectionFragment;
import com.nicolasmccurdy.randomize.fragments.CoinsSectionFragment;
import com.nicolasmccurdy.randomize.fragments.DiceSectionFragment;
import com.nicolasmccurdy.randomize.fragments.NumbersSectionFragment;
import com.nicolasmccurdy.randomize.fragments.PickSectionFragment;
import com.nicolasmccurdy.randomize.fragments.ShuffleSectionFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        // Set up the TabLayout with the ViewPager.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final String[] tabNames = getResources().getStringArray(R.array.tab_names);

        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:  return new DiceSectionFragment();
                case 1:  return new CoinsSectionFragment();
                case 2:  return new CardsSectionFragment();
                case 3:  return new NumbersSectionFragment();
                case 4:  return new PickSectionFragment();
                case 5:  return new ShuffleSectionFragment();
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            try {
                return tabNames[position];
            } catch (ArrayIndexOutOfBoundsException _) {
                return null;
            }
        }
    }

}
