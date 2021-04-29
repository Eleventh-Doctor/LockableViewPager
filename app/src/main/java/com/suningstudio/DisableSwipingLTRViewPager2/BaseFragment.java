package com.suningstudio.DisableSwipingLTRViewPager2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseFragment extends Fragment {
    private String title;

    public BaseFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BaseFragment newInstance(String title) {
        BaseFragment fragment = new BaseFragment();
        Bundle args = new Bundle();
        args.putString("Title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            title = getArguments().getString("Title");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        TextView tvContent = view.findViewById(R.id.tv_content);
        if (title != null){
            tvContent.setText(title);
        }
        return view;
    }
}