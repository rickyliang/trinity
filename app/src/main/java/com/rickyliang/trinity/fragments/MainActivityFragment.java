package com.rickyliang.trinity.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.rickyliang.trinity.R;
import com.rickyliang.trinity.activities.MainActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private MainActivity mParentActivity;

    private Button mButton;

    public static MainActivityFragment newInstance() { return new MainActivityFragment(); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mParentActivity = (MainActivity) getActivity();
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeViews();
    }

    private void initializeViews() {
        mButton = (Button) mParentActivity.findViewById(R.id.next_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation goForward = AnimationUtils.loadAnimation(mParentActivity, R.anim.slide_out_left);
                goForward.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        FragmentTransaction fragmentTransaction =
                                mParentActivity.getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, 0,
                                R.anim.slide_in_left, 0);
                        fragmentTransaction.replace(R.id.container, AnimatedFragment.newInstance(), null);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                mParentActivity.findViewById(R.id.main_fragment).startAnimation(goForward);
            }
        });
    }

}
