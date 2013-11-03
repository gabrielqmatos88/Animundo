package com.example.animundo;

import android.graphics.Bitmap;

public class Animal {

	private String nome;
	private Bitmap imagem;
	
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
