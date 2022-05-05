package model.etities.enums;

public enum Sexo {
	MASCULINO("M".charAt(0)),
	FEMINO("F".charAt(0))   ;
	
	private char code;
	
	private Sexo(char string) {
		this.code = string;
	}
	
	private char getCode() {
		return this.code;
	}
	
	public Sexo valueOf(char sexo) {
		for(Sexo sx : Sexo.values()) {
			if(sx.getCode() == sexo) {
				return sx;
			}
		}
		
		throw new IllegalArgumentException("M ou F");
	}
}
