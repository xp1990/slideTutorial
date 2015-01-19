package com.avanti.slidetutorial.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.avanti.slidetutorial.R;

/**
 * Created by emichniak on 14/01/2015.
 */
public class MainFragment extends BaseFragment{


    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState, R.layout.fragment_main);

        final TextView t = (TextView) rootView.findViewById(R.id.text1);
        t.setText(String.valueOf(0));

        ImageView i = (ImageView) rootView.findViewById(R.id.imageView);
        i.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    final int num = Integer.parseInt(t.getText().toString()) + 1;
                    t.setText(String.valueOf(num));
                    showWaitingMessage("Next num will be:" + num, 1000);
                }
                return true;
            }
        });
        return rootView;
    }
}
