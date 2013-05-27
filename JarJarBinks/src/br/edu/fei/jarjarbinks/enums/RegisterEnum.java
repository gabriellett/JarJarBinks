package br.edu.fei.jarjarbinks.enums;

public enum RegisterEnum {
	
	Michelangelo("000"),
	Donatello("001"),
	Rafael("010"),
	Leonardo("011"),
	Acme("100"),
	America("101");

	String code;
	
	RegisterEnum(String code){
		this.code = code;
	}
	
	public static RegisterEnum parse(String code){
		if("000".equalsIgnoreCase(code)){
			return Michelangelo;
		}else if("001".equalsIgnoreCase(code)){
			return Donatello;
		}else if("010".equalsIgnoreCase(code)){
			return Rafael;
		}else if("011".equalsIgnoreCase(code)){
			return Leonardo;
		}else if("100".equalsIgnoreCase(code)){
			return Acme;
		}else if("101".equalsIgnoreCase(code)){
			return America;
		}else {
			return null;
		}
	}
}
