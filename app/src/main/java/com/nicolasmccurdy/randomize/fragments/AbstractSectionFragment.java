package com.nicolasmccurdy.randomize.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nicolasmccurdy.randomize.R;

import java.util.Random;

public abstract class AbstractSectionFragment extends Fragment {
    static final Random random = new Random();

    private TextView resultsView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        resultsView = (TextView) rootView.findViewById(R.id.results);

        reload();
        return rootView;
    }

    protected abstract String generate();

    public void reload() {
        resultsView.setText(generate());
    }
}
