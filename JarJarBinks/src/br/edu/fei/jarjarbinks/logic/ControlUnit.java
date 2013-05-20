package br.edu.fei.jarjarbinks.logic;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Word;

public class ControlUnit {
	
	private void fetch(){
		CPU.mar.setWord(CPU.pc.getWord());
		CPU.mem.load();
	}
	
	private void decode(){
		String opcode = Integer.toBinaryString(CPU.mdr.getWord().toInt());
		while(opcode.length()<16){
			opcode = "0"+opcode;
		}
		
		//MOV
		if("0001".equals(opcode.substring(0,4))){
			
			fetch();
			CPU.pc.incOne();
			System.out.println("TO:"+Integer.toHexString(CPU.mdr.getWord().toInt()));
			CPU.donatello.setWord(CPU.mdr.getWord());
			CPU.pc.incOne();
			fetch();
			CPU.mar.setWord(CPU.donatello.getWord());
			System.out.println("Value:"+Integer.toHexString(CPU.mdr.getWord().toInt()));
			CPU.mem.store();
		}
	}
	
	private void execute(){
		
	}
	public void executeNextInst(){
		fetch();
		decode();
	}
}
