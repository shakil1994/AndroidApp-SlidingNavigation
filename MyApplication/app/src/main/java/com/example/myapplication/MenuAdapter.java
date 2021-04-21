package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import nl.psdcompany.duonavigationdrawer.views.DuoOptionView;

public class MenuAdapter extends BaseAdapter {
    private ArrayList<String> mOptions = new ArrayList<>();
    //private ArrayList<DuoOptionView> mOptionViews = new ArrayList<>();

    MenuAdapter(ArrayList<String> options) {
        mOptions = options;
    }

    @Override
    public int getCount() {
        return mOptions.size();
    }

    @Override
    public Object getItem(int position) {
        return mOptions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String option = mOptions.get(position);

        // Using the DuoOptionView to easily recreate the demo
        final DuoOptionView optionView;
        if (convertView == null) {
            optionView = new DuoOptionView(parent.getContext());
        } else {
            optionView = (DuoOptionView) convertView;
        }

        ImageView imageView = optionView.getRootView().findViewById(R.id.duo_view_option_selector);
        //imageView.setImageResource(R.drawable.ic_circle);
        imageView.setImageResource(R.color.white);
        //imageView.setVisibility(View.INVISIBLE);

        // Using the DuoOptionView's default selectors
        optionView.bind(option, null, null);

        // Adding the views to an array list to handle view selection
        //mOptionViews.add(optionView);

        return optionView;
    }
}
