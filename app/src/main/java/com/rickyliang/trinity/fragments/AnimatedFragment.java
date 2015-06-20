package com.rickyliang.trinity.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.rickyliang.trinity.R;
import com.rickyliang.trinity.activities.MainActivity;

public class AnimatedFragment extends Fragment {

    private MainActivity mParentActivity;

    public static AnimatedFragment newInstance() { return new AnimatedFragment(); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mParentActivity = (MainActivity) getActivity();
        return inflater.inflate(R.layout.fragment_animated, container, false);
    }

//    @Override
//    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//        return enter ? AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right) : AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_left);
//    }

    public void back() {
        Animation goBack = AnimationUtils.loadAnimation(mParentActivity, R.anim.slide_out_right);
        goBack.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mParentActivity.getSupportFragmentManager().popBackStack();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mParentActivity.findViewById(R.id.animated_fragment).startAnimation(goBack);
    }

}
