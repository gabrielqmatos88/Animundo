package com.example.animundo;

import java.util.ArrayList;
import java.util.List;

import com.example.ponto.view.sample.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridItemAdapter extends ArrayAdapter<Animal> {

	Context context;
	int layoutResourceId;
	ArrayList<Animal> data = new ArrayList<Animal>();
	
	public GridItemAdapter(Context context,
			int layoutResourceId, ArrayList<Animal> dados) {
		
		super(context, layoutResourceId, dados);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		data = dados;
	}
	
	@Override
	public Animal getItem(int position) {
		
		return data.get(position);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
		
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View row = convertView;
		RecordHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(layoutResourceId,null);

			holder = new RecordHolder();
			holder.txtTitle = (TextView) row.findViewById(R.id.nomeAnimal);
			holder.imageItem = (ImageView) row.findViewById(R.id.imagemAnimal);
			row.setTag(holder);
		} else {
			holder = (RecordHolder) row.getTag();
		}

		Animal item = data.get(position);
		holder.txtTitle.setText(item.getNome());
		holder.imageItem.setImageBitmap(item.getImagem());
		return row;
	}
	
	static class RecordHolder {
		TextView txtTitle;
		ImageView imageItem;

	}

}
