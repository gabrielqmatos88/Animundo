package com.example.animundo;

import java.util.ArrayList;

import com.example.ponto.view.sample.R;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.widget.GridView;

public class AppActvity extends Activity {

	private ArrayList<String> imagePaths = new ArrayList<String>();
    private GridViewImageAdapter adapter;
    private GridView gridView;
    private int columnWidth;
    private Utils utils;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_actvity);
		utils = new Utils(this);
		gridView = (GridView) findViewById(R.id.gridView);
		InitilizeGridLayout();
		adapter = new GridViewImageAdapter(AppActvity.this,columnWidth);
		gridView.setAdapter(adapter);
	}
	
	 private void InitilizeGridLayout() {
	        Resources r = getResources();
	        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
	                10, r.getDisplayMetrics());
	 
	        columnWidth = (int) ((utils.getScreenWidth() - (4 * padding)) / 3);
	 
	        gridView.setNumColumns(3);
	        gridView.setColumnWidth(columnWidth);
	        gridView.setStretchMode(GridView.NO_STRETCH);
	        gridView.setPadding((int) padding, (int) padding, (int) padding,
	                (int) padding);
	        gridView.setHorizontalSpacing((int) padding);
	        gridView.setVerticalSpacing((int) padding);
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.app_actvity, menu);
		return true;
	}

}
