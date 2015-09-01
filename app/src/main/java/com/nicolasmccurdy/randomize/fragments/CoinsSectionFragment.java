package com.nicolasmccurdy.randomize.fragments;

public class CoinsSectionFragment extends AbstractSectionFragment {
    private static final String[] SIDES = {"heads", "tails"};

    @Override
    public String generate() {
        int sideIndex = random.nextInt(SIDES.length);
        return SIDES[sideIndex];
    }
}
