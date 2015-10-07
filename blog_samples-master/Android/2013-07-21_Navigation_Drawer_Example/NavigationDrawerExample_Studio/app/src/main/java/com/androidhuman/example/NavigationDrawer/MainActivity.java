package com.androidhuman.example.NavigationDrawer;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MainActivity extends Activity {

	private String[] navItems = {"Brown", "Cadet Blue", "Dark Olive Green", 
									"Dark Orange", "Golden Rod"};
	private ListView lvNavList;
	private FrameLayout flContainer;
	
	private DrawerLayout dlDrawer;
	private ActionBarDrawerToggle dtToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lvNavList = (ListView)findViewById(R.id.lv_activity_main_nav_list);
		flContainer = (FrameLayout)findViewById(R.id.fl_activity_main_container);
		
		lvNavList.setAdapter(
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navItems));
		lvNavList.setOnItemClickListener(new DrawerItemClickListener());
		
		dlDrawer = (DrawerLayout)findViewById(R.id.dl_activity_main_drawer);
		dtToggle = new ActionBarDrawerToggle(this, dlDrawer, 
				R.drawable.ic_drawer, R.string.open_drawer, R.string.close_drawer){

					@Override
					public void onDrawerClosed(View drawerView) {
						super.onDrawerClosed(drawerView);
					}

					@Override
					public void onDrawerOpened(View drawerView) {
						super.onDrawerOpened(drawerView);
					}
			
		};
		dlDrawer.setDrawerListener(dtToggle);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	protected void onPostCreate(Bundle savedInstanceState){
		super.onPostCreate(savedInstanceState);
		dtToggle.syncState();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(dtToggle.onOptionsItemSelected(item)){
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		dtToggle.onConfigurationChanged(newConfig);
	}



	private class DrawerItemClickListener implements ListView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> adapter, View view, int position,
				long id) {
			switch(position){
			case 0:
				flContainer.setBackgroundColor(Color.parseColor("#A52A2A"));
				break;
			case 1:
				flContainer.setBackgroundColor(Color.parseColor("#5F9EA0"));
				break;
			case 2:
				flContainer.setBackgroundColor(Color.parseColor("#556B2F"));
				break;
			case 3:
				flContainer.setBackgroundColor(Color.parseColor("#FF8C00"));
				break;
			case 4:
				flContainer.setBackgroundColor(Color.parseColor("#DAA520"));
				break;
			}
			dlDrawer.closeDrawer(lvNavList);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}
