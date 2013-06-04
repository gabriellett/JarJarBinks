package br.edu.fei.jarjarbinks.util;

public class Conversor {
	
	public static String fillOpcodeZero(String opcode){
		while(opcode.length()<16){
			opcode = "0"+opcode;
		}
		
		return opcode;
	}
}
