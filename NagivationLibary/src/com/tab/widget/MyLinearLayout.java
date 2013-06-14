package com.tab.widget;

import com.tab.common.ViewSizeAndPosition;
import com.tab.widget.impl.CommonViewQuality;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class MyLinearLayout extends LinearLayout implements
		CommonViewQuality {
	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ViewSizeAndPosition getViewSizeAndPosition() {
		int width = getRight() - getLeft();
		int height = getBottom() - getTop();
		ViewSizeAndPosition vsp = new ViewSizeAndPosition();
		vsp.setWidth(width);
		vsp.setHeight(height);
		vsp.setLeft(getLeft());
		vsp.setTop(getTop());
		vsp.setRight(getRight());
		vsp.setBottom(getBottom());
		return vsp;
	}
}
