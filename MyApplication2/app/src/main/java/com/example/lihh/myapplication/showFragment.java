package com.example.lihh.myapplication;


import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class showFragment extends android.support.v4.app.Fragment {
    TextView textView;
    public static final String ARGUMENT = "section_number";
    public showFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.START);
        Bundle args = getArguments();
        textView.setText(args.getInt(ARGUMENT)+"");
        textView.setTextSize(30);
        return textView;
    }

}
