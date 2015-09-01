package com.nicolasmccurdy.randomize.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nicolasmccurdy.randomize.R;

import java.util.Random;

public abstract class AbstractSectionFragment extends Fragment {
    final Random random = new Random();

    TextView resultsView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        resultsView = (TextView) rootView.findViewById(R.id.results);

        Button button = (Button) rootView.findViewById(R.id.reload_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                reload();
            }
        });

        reload();
        return rootView;
    }

    abstract String generate();

    void reload() {
        resultsView.setText(generate());
    }
}
