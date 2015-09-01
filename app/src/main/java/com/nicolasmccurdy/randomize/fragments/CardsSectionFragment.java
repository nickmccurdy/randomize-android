package com.nicolasmccurdy.randomize.fragments;

public class CardsSectionFragment extends AbstractSectionFragment {
    private static final String[] RANKS = {
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

    private static final String[] SUITS = {"hearts", "diamonds", "clubs", "spades"};

    @Override
    public void reload() {
        int rankIndex = random.nextInt(RANKS.length);
        int suitIndex = random.nextInt(SUITS.length);

        resultsView.setText(RANKS[rankIndex] + " of " + SUITS[suitIndex]);
    }
}
