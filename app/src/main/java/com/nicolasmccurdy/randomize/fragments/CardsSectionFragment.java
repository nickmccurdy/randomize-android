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
    public String generate() {
        int rankIndex = random.nextInt(RANKS.length);
        int suitIndex = random.nextInt(SUITS.length);

        return RANKS[rankIndex] + " of " + SUITS[suitIndex];
    }
}
