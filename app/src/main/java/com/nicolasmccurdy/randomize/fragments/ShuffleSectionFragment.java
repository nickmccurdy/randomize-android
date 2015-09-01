package com.nicolasmccurdy.randomize.fragments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleSectionFragment extends AbstractSectionFragment {
    static final String[] FAB_FOUR = {"John", "Paul", "George", "Ringo"};

    @Override
    public void reload() {
        List<String> fabFourList = Arrays.asList(FAB_FOUR);
        Collections.shuffle(fabFourList, random);
        resultsView.setText(fabFourList.toString());
    }
}
