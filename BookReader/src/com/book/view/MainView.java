package com.book.view;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.view.MenuItem;
import com.book.R;
import com.book.view.online.OnLineBookView;

public class MainView extends BaseActivity {
	
	private MainView mContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainview);
		mContext = this;
		setTitle(R.string.bookshelf);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		getSupportMenuInflater().inflate(R.menu.bookshelfview_menu, menu);
		setContentView(R.layout.bookshelf_main_view);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			mContext.onBackPressed();
			break;
		case R.id.online:
			startActivity(new Intent(mContext, OnLineBookView.class));
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	

}
