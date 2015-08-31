package com.nicolasmccurdy.randomize;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        final String[] tabNames = getResources().getStringArray(R.array.tab_names);

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:  return new DiceSectionFragment();
                case 1:  return new CoinsSectionFragment();
                case 2:  return new CardsSectionFragment();
                case 3:  return new NumbersSectionFragment();
                default: return new HelloWorldSectionFragment();
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

    public static class DiceSectionFragment extends AbstractSectionFragment {
        @Override
        public void reload() {
            resultsView.setText(Integer.toString(random.nextInt(6) + 1));
        }
    }

    public static class CoinsSectionFragment extends AbstractSectionFragment {
        static final String[] SIDES = { "heads", "tails" };

        @Override
        public void reload() {
            int sideIndex = random.nextInt(SIDES.length);
            resultsView.setText(SIDES[sideIndex]);
        }
    }

    public static class CardsSectionFragment extends AbstractSectionFragment {
        static final String[] RANKS = {
                "ace",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "jack",
                "queen",
                "king"
        };

        static final String[] SUITS = { "hearts", "diamonds", "clubs", "spades" };

        @Override
        public void reload() {
            int rankIndex = random.nextInt(RANKS.length);
            int suitIndex = random.nextInt(SUITS.length);

            resultsView.setText(RANKS[rankIndex] + " of " + SUITS[suitIndex]);
        }
    }

    public static class NumbersSectionFragment extends AbstractSectionFragment {
        @Override
        public void reload() {
            resultsView.setText(Integer.toString(random.nextInt(10) + 1));
        }
    }

    public static class HelloWorldSectionFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView dummyTextView = (TextView) rootView.findViewById(R.id.results);
            dummyTextView.setText("Hello, world!");
            return rootView;
        }
    }

}
