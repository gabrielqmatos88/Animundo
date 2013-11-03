package com.example.animundo;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class GridItemAdapter extends ArrayAdapter<Animal> {

	public GridItemAdapter(Context context, int resource,
			int textViewResourceId, List<Animal> objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

}
