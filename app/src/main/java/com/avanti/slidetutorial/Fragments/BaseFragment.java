package com.avanti.slidetutorial.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avanti.slidetutorial.R;

/**
 * Created by emichniak on 1/2015.
 */
public abstract class BaseFragment extends Fragment {

    protected ViewGroup rootView;
    protected LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;
    private int fragment_layout;

    protected final String TAG = getClass().getSimpleName();

    //    protected boolean isLoading = false;
//    protected boolean isError = false;
    protected ViewGroup loadingLayout;
//    protected String message;

    public void showWaitingMessage(String message, int milli){
        Log.d(TAG, "Showing Loading Message: "+message+" loading lay: "+loadingLayout);
        if (loadingLayout == null) {
            loadingLayout = (ViewGroup) inflater.inflate(R.layout.loading_error_layout, null, false);
            rootView.addView(loadingLayout,0);
        }
        loadingLayout.findViewById(R.id.loadingView).setVisibility(View.VISIBLE);
        ((TextView)loadingLayout.findViewById(R.id.loadingtext)).setText(message);
        hideViewsOnProgress(true);

        if(milli > 0) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    hideLoadingMessage();
                }
            }, milli);
        }
    }


    private void hideViewsOnProgress(boolean progress) {
        //hide all other views while loading...
        Log.d(TAG, "show loading, child views: "+rootView.getChildCount());
        for (int i=0; i< rootView.getChildCount(); i++){
            View v = rootView.getChildAt(i);
            if (progress) { //progress -> hide all views except loading
                if (v == loadingLayout) {
                    Log.d(TAG, "skipping hide view on : " + v);
                } else {
                    Log.d(TAG, "hiding view : " + v);
                    v.setVisibility(View.GONE);
                    v.setEnabled(false);
                }
            }else{ // no progress -> show everything
                v.setVisibility(View.VISIBLE);
                v.setEnabled(true);
            }
        }
    }

    public void hideLoadingMessage(){
        if (loadingLayout != null){
            rootView.removeView(loadingLayout);
            loadingLayout = null;
        }
        hideViewsOnProgress(false);
    }

    public void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, int fragment_layout) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;
        this.fragment_layout = fragment_layout;
        this.rootView = (ViewGroup)inflater.inflate(fragment_layout, container, false);
    }


}
