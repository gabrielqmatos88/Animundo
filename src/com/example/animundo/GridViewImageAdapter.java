package com.example.animundo;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.ponto.view.sample.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewImageAdapter extends BaseAdapter {

	
	private Activity _activity;
    private ArrayList<Integer> imagens;
    private HashMap<Integer, Integer> sons; 
    private int imageWidth;
    private SoundManager soundManager;
 
    public GridViewImageAdapter(Activity activity,
            int imageWidth) {
        this._activity = activity;
        preencherListaArquivos();
        this.imageWidth = imageWidth;
    }
    
    public void preencherListaArquivos()
    {
    	soundManager = SoundManager.getInstance();
    	soundManager.initSounds(_activity);
    	sons = new HashMap<Integer, Integer>();
    	imagens = new ArrayList<Integer>();
    	imagens.add(R.drawable.ovelha);
//    	imagens.add(R.drawable.aguia);
//    	imagens.add(R.drawable.cachorrobravo);
    	imagens.add(R.drawable.cachorrofeliz);
//    	imagens.add(R.drawable.cavalo);
    	imagens.add(R.drawable.cobra);
    	imagens.add(R.drawable.coruja);
    	imagens.add(R.drawable.elefante);
    	imagens.add(R.drawable.galinha);
//    	imagens.add(R.drawable.gato);
//    	imagens.add(R.drawable.girafa);
//    	imagens.add(R.drawable.gorila);
//    	imagens.add(R.drawable.hipopotamo);
//    	imagens.add(R.drawable.jumento);
    	imagens.add(R.drawable.leao);
    	imagens.add(R.drawable.lobo);
    	imagens.add(R.drawable.macaco);
    	
//    	imagens.add(R.drawable.panda);
//    	imagens.add(R.drawable.passaro);
    	imagens.add(R.drawable.pato);
//    	imagens.add(R.drawable.peru);
//    	imagens.add(R.drawable.porco);
//    	imagens.add(R.drawable.rato);
    	imagens.add(R.drawable.sapo);
//    	imagens.add(R.drawable.tigre);
//    	imagens.add(R.drawable.touro);
    	imagens.add(R.drawable.vaca);
    	imagens.add(R.drawable.urso);
//    	soundManager.addSound(R.drawable.aguia, R.raw.aguia);
    	soundManager.addSound(R.drawable.ovelha, R.raw.ovelha);
    	soundManager.addSound(R.drawable.cachorrofeliz, R.raw.cachorrofeliz);
    	soundManager.addSound(R.drawable.pato, R.raw.pato);
    	soundManager.addSound(R.drawable.sapo, R.raw.sapo);
    	soundManager.addSound(R.drawable.vaca, R.raw.vaca);
    	soundManager.addSound(R.drawable.urso, R.raw.urso);
    	soundManager.addSound(R.drawable.cobra, R.raw.cobra);
    	soundManager.addSound(R.drawable.coruja, R.raw.coruja);
    	soundManager.addSound(R.drawable.lobo, R.raw.lobo);
    	soundManager.addSound(R.drawable.macaco, R.raw.macaco);
    	soundManager.addSound(R.drawable.leao, R.raw.leao);
    	soundManager.addSound(R.drawable.galinha, R.raw.galinha);
    	soundManager.addSound(R.drawable.elefante, R.raw.elefante);
    	soundManager.addSound(R.drawable.gato, R.raw.gato);
    }
    
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imagens.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return imagens.get(pos);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView figura;
//		TextView descricao;
//		ViewHolder holder;
        if (convertView == null) {
//        	LayoutInflater inflater = (LayoutInflater)_activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        	convertView = inflater.inflate(R.layout.anima_grid_item, null);
//            figura =  (ImageView)convertView.findViewById(R.id.imagemAnimal);
//            descricao = (TextView)convertView.findViewById(R.id.nomeAnimal);
//            holder = new ViewHolder();
//            holder.figura = figura;
//            holder.descricao = descricao;
//            convertView.setTag(holder);
        	figura = new ImageView(_activity.getApplicationContext());
        } else {
//            imageView = (ImageView) convertView;
//        	holder = (ViewHolder)convertView.getTag();
        	figura = (ImageView)convertView;
        }
 
        // get screen dimensions
        Bitmap image = BitmapFactory.decodeResource(_activity.getResources(),imagens.get(position));
 
        figura.setScaleType(ImageView.ScaleType.CENTER_CROP);
        figura.setLayoutParams(new GridView.LayoutParams(imageWidth,
                imageWidth));
        figura.setImageBitmap(image);
        
        // image view click listener
        figura.setOnClickListener(new OnImageClickListener(position));
        return figura;
	}
	
	
//	static class ViewHolder
//	{
//		ImageView figura;
//		TextView descricao;
//	}
//	
	class OnImageClickListener implements OnClickListener {
		 
        int _postion;
 
        // constructor
        public OnImageClickListener(int position) {
            this._postion = position;
        }
 
        @Override
        public void onClick(View v) {
        	
        	soundManager.playSound(imagens.get(_postion), 1);   
        }
 
    }
	
	
	
	
//	 /*
//     * Resizing image size
//     */
//    public static Bitmap resizeImage(String filePath, int WIDTH, int HIGHT) {
//        try {
// 
////            File f = new File(filePath);
//            BitmapFactory.Options o = new BitmapFactory.Options();
//            o.inJustDecodeBounds = true;
////            BitmapFactory.decodeStream();
// 
//            final int REQUIRED_WIDTH = WIDTH;
//            final int REQUIRED_HIGHT = HIGHT;
//            int scale = 1;
//            while (o.outWidth / scale / 2 >= REQUIRED_WIDTH
//                    && o.outHeight / scale / 2 >= REQUIRED_HIGHT)
//                scale *= 2;
// 
//            BitmapFactory.Options o2 = new BitmapFactory.Options();
//            o2.inSampleSize = scale;
//            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
