package com.book.view.fragment;

import com.book.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * @Description: TODO
 * @author strive
 * @date 2013-6-14 上午1:01:16
 *
 */
public class SortFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.online_fragment_soft, null);
        return view;
    }
}
