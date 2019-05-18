package com.example.lab_2_4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Demo class
 *
 * @author chenshuoke
 * @date 2019/4
 */
public class FragmentGrid extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInsanceState) {
        return inflater.inflate(R.layout.fragment_5, null);
    }
}
