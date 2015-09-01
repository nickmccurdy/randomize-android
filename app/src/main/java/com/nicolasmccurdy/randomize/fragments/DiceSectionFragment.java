package com.nicolasmccurdy.randomize.fragments;

public class DiceSectionFragment extends AbstractSectionFragment {
    @Override
    public void reload() {
        resultsView.setText(Integer.toString(random.nextInt(6) + 1));
    }
}
