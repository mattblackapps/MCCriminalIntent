package com.matthewcoggin.sd2550.mccriminalintent;


import android.support.v4.app.Fragment;

/**
 * Created by matthew on 8/8/16.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
