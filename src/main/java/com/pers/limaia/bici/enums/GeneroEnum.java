package com.pers.limaia.bici.enums;

public enum GeneroEnum {

	MASCULINO(10,"Masculino"),
	FEMININO(20,"Feminino");
	
	private int codigo;
	private String descricao;
	
	private GeneroEnum(int codigo, String descricao) {
		this.codigo=codigo;
		this.descricao=descricao;
	}
}
