package com.example.hellofragmentviewpager.fragmentinfragment;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hellofragmentviewpager.R;

import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "ThirdFragment";

    private RelativeLayout mActionBarBack;
    private Button mChangeToStaticFragment;
    private Button mChangePhoto;
    private AppCompatImageView mPhoto;
    private AppCompatTextView mPhotoInfo;
    private Photo mPhoto1;
    private Photo mPhoto2;
    private Photo mPhoto3;
    private List<Photo> mPhotosOriginal;
    private List<Photo> mPhotosCurrent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater
                .inflate(R.layout.third_fragment, container, false);

        mChangeToStaticFragment = (Button) view.findViewById(R.id.btn);
        mActionBarBack = view.findViewById(R.id.action_bar_back);
        mChangePhoto = view.findViewById(R.id.btn_change_image);
        mPhoto = view.findViewById(R.id.photo);
        mPhotoInfo = view.findViewById(R.id.photo_info);

        mChangeToStaticFragment.setOnClickListener(this);
        mActionBarBack.setOnClickListener(this);
        mChangePhoto.setOnClickListener(this);

        Linkify.addLinks(mPhotoInfo, Linkify.WEB_URLS);
        mPhotoInfo.setMovementMethod(LinkMovementMethod.getInstance());

        initData();
        return view;
    }

    private void initData() {
        mPhotosOriginal = new ArrayList<>();
        mPhotosCurrent = new ArrayList<>();
        mPhoto1 = new Photo(R.drawable.joel_de_vriend_unsplash, getString(R.string.photo_by_joel_de_vriend));
        mPhotosOriginal.add(mPhoto1);
        mPhoto2 = new Photo(R.drawable.joshua_rawson_harris__unsplash, getString(R.string.photo_by_joshua_rawson_harris));
        mPhotosOriginal.add(mPhoto2);
        mPhoto3 = new Photo(R.drawable.zane_lee_unsplash, getString(R.string.photo_by_zane_lee));
        mPhotosOriginal.add(mPhoto3);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.action_bar_back:
                if (mPhotosCurrent.size() != 0) {
                    Photo p = mPhotosOriginal.get(mPhotosCurrent.size() - 1);
                    mPhoto.setImageResource(p.getIdResImage());
                    mPhotoInfo.setText(Html.fromHtml(p.getPhotoBy()));
                    mPhotosCurrent.remove(p);
                } else {
                    getFragmentManager().popBackStack();
                }
                break;
            case R.id.btn:
                FragmentTransaction trans = getFragmentManager()
                        .beginTransaction();
                trans.replace(R.id.root_frame, new StaticFragment());
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
                break;
            case R.id.btn_change_image:
                changePhoto();
                break;

        }
    }

    private void changePhoto() {
        int size = mPhotosCurrent.size();
        if (size == 3) {
            return;
        }

        Photo p = mPhotosOriginal.get(size);
        mPhoto.setImageResource(p.getIdResImage());
        mPhotoInfo.setText(Html.fromHtml(p.getPhotoBy()));
        mPhotosCurrent.add(p);
    }
}
