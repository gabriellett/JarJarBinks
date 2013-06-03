package br.edu.fei.jarjarbinks.enums;

public enum RegisterEnum {
	
	Michelangelo("000"),
	Donatello("001"),
	Rafael("010"),
	Leonardo("011"),
	Acme("100"),
	America("101"),
	SP("110"),
	PSW("111");

	String code;
	
	RegisterEnum(String code){
		this.code = code;
	}
	
	public static RegisterEnum parse(String code){
		if("0000".equalsIgnoreCase(code)){
			return Michelangelo;
		}else if("0001".equalsIgnoreCase(code)){
			return Donatello;
		}else if("0010".equalsIgnoreCase(code)){
			return Rafael;
		}else if("0011".equalsIgnoreCase(code)){
			return Leonardo;
		}else if("0100".equalsIgnoreCase(code)){
			return Acme;
		}else if("0101".equalsIgnoreCase(code)){
			return America;
		}else if("0110".equalsIgnoreCase(code)){
			return SP;
		}else if("0111".equalsIgnoreCase(code)){
			return PSW;
		}else {
			return null;
		}
	}
}
