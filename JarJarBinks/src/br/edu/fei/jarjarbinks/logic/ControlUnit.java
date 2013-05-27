package br.edu.fei.jarjarbinks.logic;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.instructions.Instruction;
import br.edu.fei.jarjarbinks.instructions.impl.MOV;

public class ControlUnit {
	
	public void fetch(){
		CPU.mar.setWord(CPU.pc.getWord());
		CPU.mem.load();
	}
	
	public Instruction decode(){
		String opcode = Integer.toBinaryString(CPU.mdr.getWord().toInt());
		while(opcode.length()<16){
			opcode = "0"+opcode;
		}
		
		Instruction inst = new MOV();
		if(inst.checkResponsability()){
			return inst;
		}
		
		return null;
		
	}
	
	private void execute(Instruction inst){
		inst.execute();
		
	}
	public void executeNextInst(){
		
		fetch();
		CPU.pc.nextInst();
		Instruction inst = decode();
		execute(inst);
	}
}
