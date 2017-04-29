package com.example.wojtek.tabbed;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Page1 extends Fragment implements View.OnClickListener {

    communicateToActivity mCallBack;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_page1, container, false);
        button = (Button) v.findViewById(R.id.button2);
        button.setOnClickListener(this);
        return v;

    }


    @Override
    public void onClick(View v) {
        Log.d("onclick", "wysyłam page 1");

        mCallBack.sendMessage("page 1");
    }

    public interface communicateToActivity {
        public void sendMessage(String msg);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallBack = (communicateToActivity) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " zaimplementuj communicateToActivity");
        }
    }

}
