package com.nicolasmccurdy.randomize.fragments;

public class NumbersSectionFragment extends AbstractSectionFragment {
    @Override
    public String generate() {
         return Integer.toString(random.nextInt(10) + 1);
    }
}
