package com.example.hellofragmentviewpager.viewpager2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hellofragmentviewpager.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    private static final String TAG = "FirstFragment";

    // Store instance variables
    private String title;
    private int page;
    TextView tvLabel;
    private String content;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_view_pager_2, container, false);
        tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        tvLabel.setText("Page: " + page + " title: " + title + " content: " + content);

        Log.e(TAG, "onCreateView: page: " + page);
        return view;
    }

    public void updateContent(String content) {
        this.content = content;
        tvLabel.setText(content);
    }
}