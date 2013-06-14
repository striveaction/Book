package com.book.view.online;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;

import com.actionbarsherlock.view.MenuItem;
import com.book.R;
import com.book.constant.Key;
import com.book.log.MyLog;
import com.book.view.BaseActivity;
import com.book.view.adapter.TabBarAdapter;
import com.book.view.fragment.DownLoadFragment;
import com.book.view.fragment.RankingFragment;
import com.book.view.fragment.RecommendFragment;
import com.book.view.fragment.SearchFragment;
import com.book.view.fragment.SortFragment;
import com.tab.widget.navigation.RollNavigationBar;

public class OnLineBookView extends BaseActivity {
    private static final String TAG = "OnLineBookView";

    private OnLineBookView mContext;

    private String[] title;

    private int[] tab_icon_normals = { R.drawable.icon_tab_0_default_normal, R.drawable.icon_tab_1_default_normal,
            R.drawable.icon_tab_2_default_normal, R.drawable.icon_tab_3_default_normal,
            R.drawable.icon_tab_4_default_normal };

    private int[] tab_icon_selecteds = { R.drawable.icon_tab_0_selected_normal, R.drawable.icon_tab_1_selected_normal,
            R.drawable.icon_tab_2_selected_normal, R.drawable.icon_tab_3_selected_normal,
            R.drawable.icon_tab_4_selected_normal };

    private RollNavigationBar mRollBar;

    private TabBarAdapter mTabAdapter;
    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.book_online);
        if(savedInstanceState != null)
            mContent = getSupportFragmentManager().getFragment(savedInstanceState, Key.FRAGMENT_CONTENT);
        if(mContent == null)
            mContent = new RecommendFragment();
        setContentView(R.layout.online_main_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_layout, mContent).commit();
        mContext = this;
        initView();
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getSupportFragmentManager().putFragment(outState, Key.FRAGMENT_CONTENT, mContent);
        super.onSaveInstanceState(outState);
    }

    private void initView() {
        mRollBar = (RollNavigationBar) findViewById(R.id.tab_bar);
        mRollBar.setSelecterMoveContinueTime(0.1f);
        mRollBar.setSelecterDrawableSource(R.drawable.tab_bottom_bg_selected);
        mRollBar.setSelectedChildPosition(0);
        setTabData();

    }

    private void setTabData() {
        title = getResources().getStringArray(R.array.tab_array);
        List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
        for (int i = 0; i < title.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Key.TAB_TITLE, title[i]);
            map.put(Key.TAB_ICON_NORMAL, tab_icon_normals[i]);
            map.put(Key.TAB_ICON_SELECTED, tab_icon_selecteds[i]);
            list.add(map);
        }
        mTabAdapter = new TabBarAdapter(mContext, list);
        mRollBar.setAdapter(mTabAdapter);
        mRollBar.setNavigationBarListener(new RollNavigationBar.NavigationBarListener() {

            @Override
            public void onNavigationBarClick(int position, View view, MotionEvent event) {

                switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    switch (position) {
                    case 0:
                        mContent = new RecommendFragment();
                        break;
                    case 1:
                        mContent = new RankingFragment();
                        break;
                    case 2:
                        mContent = new SortFragment();
                        break;
                    case 3:
                        mContent = new DownLoadFragment();
                        break;
                    case 4:
                        mContent = new SearchFragment();
                        break;

                    default:
                        break;
                    }
                    switchFragment(mContent);
                    break;

                default:
                    break;
                }
            }
        });
    }
    
    private void switchFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_layout, fragment).commit();
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            mContext.onBackPressed();
            break;

        default:
            break;
        }
        return super.onOptionsItemSelected(item);
    }

}
