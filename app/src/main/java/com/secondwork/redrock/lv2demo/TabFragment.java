package com.secondwork.redrock.lv2demo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;


public class TabFragment extends Fragment {
    public static final String TITLE_TAG = "tabTitle";
    public static final String IMAGE_TAG="imageID";
    public static TabFragment newInstance(int tabTitle,int ID) {
        Bundle args = new Bundle();
        TabFragment fragment = new TabFragment();
        args.putString(TITLE_TAG, "这是第"+(tabTitle+1)+"个页面");
        args.putString(IMAGE_TAG, String.valueOf(ID));
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        TextView tv = view.findViewById(R.id.tv);
        ImageView iv = view.findViewById(R.id.iv);
        if (getArguments() != null) {
            tv.setText(getArguments().getString(TITLE_TAG));
            iv.setImageResource(Integer.parseInt(Objects.requireNonNull(getArguments().getString(IMAGE_TAG))));
        }
        return view;
    }
}
