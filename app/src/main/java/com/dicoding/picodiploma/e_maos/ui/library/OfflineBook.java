package com.dicoding.picodiploma.e_maos.ui.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.dicoding.picodiploma.e_maos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class OfflineBook extends Fragment {

    public OfflineBook() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offline_book, container, false);
    }
}
