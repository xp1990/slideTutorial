package com.avanti.slidetutorial.Fragments;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.avanti.slidetutorial.Adapters.RecyclerAdapter;
import com.avanti.slidetutorial.Beans.ProxMessage;
import com.avanti.slidetutorial.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by emichniak on 14/01/2015.
 */
public class SecondaryFragment extends BaseFragment{

    public SecondaryFragment() {
        myDataset = new LinkedList<>();

        ProxMessage p = new ProxMessage();
        p.setName("Mr Testy Test");
        p.setLocation("Near you. Real close");
        p.setMessage("Hello, over here!");
        myDataset.add(p);
    }

    //Define a static dataset!
    List<ProxMessage> myDataset;

    RecyclerView recList;
    RecyclerAdapter rAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState, R.layout.fragment_secondary);

        recList = (RecyclerView) rootView.findViewById(R.id.cardList);

        //TODO - Try different layout managers. Grid and StaggeredGrid
        LinearLayoutManager llm = new LinearLayoutManager(rootView.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        //Animator
        recList.setItemAnimator(new DefaultItemAnimator());

        rAdapter = new RecyclerAdapter(myDataset);
        recList.setAdapter(rAdapter);

        return rootView;
    }


}