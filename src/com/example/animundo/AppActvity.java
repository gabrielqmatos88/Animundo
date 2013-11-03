package com.example.animundo;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.ponto.view.sample.R;

public class AppActvity extends Activity {

    private GridItemAdapter gridAdapter;
    private GridView gridView;
    private ArrayList<Animal> animais;
    private SoundManager soundManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_actvity);
		soundManager = SoundManager.getInstance();
		soundManager.initSounds(getBaseContext());
		animais = new ArrayList<Animal>();
		InicializarAnimais();
		gridView = (GridView) findViewById(R.id.gridView);

		gridAdapter = new GridItemAdapter(getApplicationContext(),R.layout.anima_grid_item,animais);
		gridView.setAdapter(gridAdapter);
		
		gridView.setOnItemClickListener(
				new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int posicao, long arg3) {
						Animal animal = animais.get(posicao);
						soundManager.playSound(animal.getImageId(), 1);
					}
		});
	}
	
	
	private void InicializarAnimais()
	{
		CriarAnimal("Cachorro", R.drawable.cachorrofeliz, R.raw.cachorroraiva);
		CriarAnimal("Gato", R.drawable.gato, R.raw.gato);
		CriarAnimal("Águia", R.drawable.aguia, R.raw.aguia);
		CriarAnimal("Cão Bravo", R.drawable.cachorrobravo, R.raw.cachorrofeliz);
		CriarAnimal("Cavalo", R.drawable.cavalo, R.raw.cavalo);
		CriarAnimal("Cobra", R.drawable.cobra, R.raw.cobra);
		CriarAnimal("Coruja", R.drawable.coruja, R.raw.coruja);
		CriarAnimal("Elefante", R.drawable.elefante, R.raw.elefante);
		CriarAnimal("Galinha", R.drawable.galinha, R.raw.galinha);
		CriarAnimal("Gorila", R.drawable.gorila, R.raw.gorila);
		CriarAnimal("Leao", R.drawable.leao, R.raw.leao);
		CriarAnimal("Lobo", R.drawable.lobo, R.raw.lobo);
		CriarAnimal("Macaco", R.drawable.macaco, R.raw.macaco);
		CriarAnimal("Ovelha", R.drawable.ovelha, R.raw.ovelha);
		CriarAnimal("Passaro", R.drawable.passaro, R.raw.passaro);
		CriarAnimal("Pato", R.drawable.pato, R.raw.pato);
		CriarAnimal("Porco", R.drawable.porco, R.raw.porco);
		CriarAnimal("Sapo", R.drawable.sapo, R.raw.sapo);
		CriarAnimal("Urso", R.drawable.urso, R.raw.urso);
		CriarAnimal("Vaca", R.drawable.vaca, R.raw.vaca);
		//Adicionar um novo animal, seu nome, drawable imagem do animal  e raw do arquivo de audio
	}
	
	private void CriarAnimal(String nome,int imagemId,int soundId)
	{
		Bitmap figura = BitmapFactory.decodeResource(this.getResources(),imagemId);
		Animal animal = new Animal(nome, figura);
		animal.setImageId(imagemId);
		animal.setSoundId(soundId);
		animais.add(animal);
		soundManager.addSound(imagemId, soundId);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.app_actvity, menu);
		return true;
	}

}
