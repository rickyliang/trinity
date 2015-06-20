package com.rickyliang.trinity.utility;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.rickyliang.trinity.R;

/**
 * Created by Ricky on 6/16/2015.
 */
public class Utility {

    public static void animateReplaceFragment(FragmentActivity activity, Fragment fragment, int id) {
        animateReplaceFragment(activity, fragment, id, null);
    }

    public static void animateReplaceFragment(FragmentActivity activity, Fragment fragment, int id, String tag) {
        commit(activity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right).replace(id, fragment, tag));
    }

    public static void animateBackStackFragment(FragmentActivity activity, Fragment fragment, int id, String tag) {
        commit(activity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right).replace(id, fragment, tag).addToBackStack(tag));
    }

    public static void replaceFragment(FragmentActivity activity, Fragment fragment, int id) {
        replaceFragment(activity, fragment, id, null);
    }

    public static void replaceFragment(FragmentActivity activity, Fragment fragment, int id, String tag) {
        commit(activity.getSupportFragmentManager().beginTransaction().replace(id, fragment, tag));
    }

    public static void backStackFragment(FragmentActivity activity, Fragment fragment, int id, String tag) {
        commit(activity.getSupportFragmentManager().beginTransaction().replace(id, fragment, tag).addToBackStack(tag));
    }

    public static void commit(android.support.v4.app.FragmentTransaction transaction) { transaction.commitAllowingStateLoss(); }
}
