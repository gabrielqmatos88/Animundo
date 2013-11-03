package com.example.animundo;

import android.graphics.Bitmap;

public class Animal {

	private String nome;
	private Bitmap imagem;
	private int soundId;
	private int imageId;
	
	public int getSoundId() {
		return soundId;
	}

	public void setSoundId(int soundId) {
		this.soundId = soundId;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public Animal(String nm,Bitmap figura)
	{
		nome = nm;
		imagem = figura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Bitmap getImagem() {
		return imagem;
	}

	public void setImagem(Bitmap imagem) {
		this.imagem = imagem;
	}
	
	
	
}
