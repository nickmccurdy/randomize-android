package com.nicolasmccurdy.randomize.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nicolasmccurdy.randomize.R;

public class HelloWorldSectionFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView dummyTextView = (TextView) rootView.findViewById(R.id.results);
        dummyTextView.setText("Hello, world!");
        return rootView;
    }
}
