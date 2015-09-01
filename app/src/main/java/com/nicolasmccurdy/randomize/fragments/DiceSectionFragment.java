package com.nicolasmccurdy.randomize.fragments;

public class DiceSectionFragment extends AbstractSectionFragment {
    @Override
    public String generate() {
        return Integer.toString(random.nextInt(6) + 1);
    }
}
