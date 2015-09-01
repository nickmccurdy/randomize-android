package com.nicolasmccurdy.randomize.fragments;

public class PickSectionFragment extends AbstractSectionFragment {
    private static final String[] FAB_FOUR = {"John", "Paul", "George", "Ringo"};

    @Override
    public String generate() {
        return FAB_FOUR[random.nextInt(FAB_FOUR.length)];
    }
}
