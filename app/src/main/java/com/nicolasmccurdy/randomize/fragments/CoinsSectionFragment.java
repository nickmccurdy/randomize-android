package com.nicolasmccurdy.randomize.fragments;

public class CoinsSectionFragment extends AbstractSectionFragment {
    private static final String[] SIDES = {"heads", "tails"};

    @Override
    public void reload() {
        int sideIndex = random.nextInt(SIDES.length);
        resultsView.setText(SIDES[sideIndex]);
    }
}
