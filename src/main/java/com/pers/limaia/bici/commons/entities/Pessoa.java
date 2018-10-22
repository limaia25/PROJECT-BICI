package com.pers.limaia.bici.commons.entities;

import java.io.Serializable;

import com.pers.limaia.bici.commons.enums.GeneroEnum;

public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int idade;
	private GeneroEnum sexo;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public GeneroEnum getSexo() {
		return sexo;
	}
	
	public void setSexo(GeneroEnum sexo) {
		this.sexo = sexo;
	}
	
	
}
