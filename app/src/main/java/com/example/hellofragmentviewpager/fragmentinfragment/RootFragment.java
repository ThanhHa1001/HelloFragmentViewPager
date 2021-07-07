package com.example.hellofragmentviewpager.fragmentinfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hellofragmentviewpager.R;

import java.util.List;

public class RootFragment extends Fragment {

    private static final String TAG = "RootFragment";

    private RelativeLayout mLayoutActionBar;
    private RelativeLayout mActionBarBack;
    private AppCompatTextView mActionBarTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Inflate the layout for this fragment */
        View view = inflater.inflate(R.layout.root_fragment, container, false);
        mLayoutActionBar = view.findViewById(R.id.layout_action_bar);
        mActionBarBack = view.findViewById(R.id.action_bar_back);
        mActionBarTitle = view.findViewById(R.id.action_bar_title);
        mActionBarTitle.setText(R.string.first_fragment);

        mActionBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();
        /*
         * When this container fragment is created, we fill it with our first
         * "real" fragment
         */
        transaction.replace(R.id.root_frame, new FirstFragment());

        transaction.commit();

        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Log.e(TAG, "onBackStackChanged: ");
                if (getFragmentManager() != null) {
                    List<Fragment> fragments = getFragmentManager().getFragments();
                    Log.e(TAG, "onBackStackChanged: " + fragments);
                    Log.e(TAG, "onBackStackChanged: " + fragments.get(fragments.size() - 1).getClass().getSimpleName());
                    String nameFragment = fragments.get(fragments.size() - 1).getClass().getSimpleName();

                    mLayoutActionBar.setVisibility(View.VISIBLE);
                    if (nameFragment.equals(FirstFragment.class.getSimpleName())) {
                        mActionBarTitle.setText(R.string.first_fragment);
                    } else if (nameFragment.equals(SecondFragment.class.getSimpleName())) {
                        mActionBarTitle.setText(R.string.second_fragment);
                    } else if (nameFragment.equals(ThirdFragment.class.getSimpleName())) {
                        mActionBarTitle.setText(R.string.third_fragment);
                        mLayoutActionBar.setVisibility(View.GONE);
                    } else if (nameFragment.equals(StaticFragment.class.getSimpleName())) {
                        mActionBarTitle.setText(R.string.static_fragment);
                    }
                }
            }
        });
        return view;
    }

}

