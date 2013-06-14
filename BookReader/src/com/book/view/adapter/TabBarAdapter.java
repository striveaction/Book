package com.book.view.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.book.R;
import com.book.constant.Key;
import com.tab.widget.navigation.RollNavigationBar;
import com.tab.widget.navigation.adapter.RollNavigationBarAdapter;

/**
 * 
 * @Description: 书城底部菜单适配器
 * @author strive
 * @date 2013-6-13 下午7:34:11
 *
 */
public class TabBarAdapter extends RollNavigationBarAdapter {
    
    private Context mContext;
    private List<Map<String, Object>> list;
    private LayoutInflater mInflater;
    
    public TabBarAdapter(Context context, List<Map<String, Object>> list){
        this.mContext = context;
        this.list = list;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    @Override
    public int getCount() {
        
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mInflater.inflate(R.layout.online_tab_bottom_item, (ViewGroup) convertView);
        ImageView tabIcon = (ImageView) convertView.findViewById(R.id.iv_tab_icon);
        TextView tabTitle = (TextView) convertView.findViewById(R.id.tv_tab_title);
        RollNavigationBar mRollBar = (RollNavigationBar) parent;
        String title = (String) list.get(position).get(Key.TAB_TITLE);
        int normal_resId = (Integer) list.get(position).get(Key.TAB_ICON_NORMAL);
        int selected_resId = (Integer) list.get(position).get(Key.TAB_ICON_SELECTED);
        if(position == mRollBar.getSelectedChildPosition()){
            tabTitle.setTextColor(mContext.getResources().getColor(R.color.text_gray_color));
            tabIcon.setImageResource(selected_resId);
        }else{
            tabTitle.setTextColor(mContext.getResources().getColor(R.color.white));
            tabIcon.setImageResource(normal_resId);
        }
        tabTitle.setText(title);
        return convertView;
    }

}
