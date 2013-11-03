package com.example.animundo;

import com.example.ponto.view.sample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class MainActivity extends Activity {

	static int TIME_DELAY_SPLASH = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				
				Intent i = new Intent(MainActivity.this, AppActvity.class);
                startActivity(i);
				finish();
			}
		},TIME_DELAY_SPLASH);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
