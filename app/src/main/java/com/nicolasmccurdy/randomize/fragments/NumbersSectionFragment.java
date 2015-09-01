package com.nicolasmccurdy.randomize.fragments;

public class NumbersSectionFragment extends AbstractSectionFragment {
    @Override
    public void reload() {
        resultsView.setText(Integer.toString(random.nextInt(10) + 1));
    }
}
