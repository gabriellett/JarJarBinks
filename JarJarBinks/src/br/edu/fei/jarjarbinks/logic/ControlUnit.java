package br.edu.fei.jarjarbinks.logic;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.util.Conversor;

public class ControlUnit {
	
	private void fetch(){
		CPU.mar.setContents(CPU.pc.getContents());
		CPU.mem.load();
	}
	
	private void decode(){
		String opcode = Integer.toBinaryString(CPU.mdr.getWord().toInt());
		while(opcode.length()<16){
			opcode = "0"+opcode;
		}
		
		//MOV
		if("0001".equals(opcode.substring(0,4))){
			CPU.pc.incOne();
			fetch();
			CPU.mar.setContents(Conversor.twoWordCreator(CPU.mdr.getWord().toInt()));
			System.out.println("TO:"+Integer.toHexString(Conversor.twoWordToInt(CPU.mar.getContents())));
			CPU.pc.incOne();
			CPU.donatello.setWord(CPU.mdr.getWord());
			fetch();
			CPU.mar.setContents(new Word[]{Word.getZeroWord(),CPU.donatello.getWord()});
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
