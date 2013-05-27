package br.edu.fei.jarjarbinks.enums;

public enum AddressingMode {
	Imediate("00"),
	Direct("01"),
	Indirect("10");
	
	private String code;
	
	private AddressingMode(String code) {
		this.code = code;
	}
	
	public static AddressingMode parse(String code){

		if("00".equalsIgnoreCase(code)){
			return Imediate;
		}else if("01".equalsIgnoreCase(code)){
			return Direct;
		}else if("10".equalsIgnoreCase(code)){
			return Indirect;
		}
		return null;
	}

}

