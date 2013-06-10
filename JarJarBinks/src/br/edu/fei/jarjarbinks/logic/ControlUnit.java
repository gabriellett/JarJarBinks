package br.edu.fei.jarjarbinks.logic;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.exception.InvalidVarSize;
import br.edu.fei.jarjarbinks.instructions.Instruction;
import br.edu.fei.jarjarbinks.util.ClassUtils;

public class ControlUnit {
	
	public String[] instructions = {"ADD","AND","JG","JL","JMP","JZ","MOV","NOT","OR","POP","PUSH","SUB"};
	
	public void fetch() throws InvalidVarSize{
		CPU.mar.setWord(CPU.pc.getWord());
		CPU.mem.load();
		CPU.pc.nextInst();
	}
	
	
	
	public Instruction decode(){
		
		Instruction inst = null;
		try{
			for(String str: instructions){
				Class clazz = Class.forName("br.edu.fei.jarjarbinks.instructions.impl" + '.' + str); 
				inst = (Instruction) clazz.newInstance();
				if(inst.checkResponsability()){
					return inst;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	private void execute(Instruction inst) {
		try{
			inst.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void executeNextInst() throws InvalidVarSize{
		fetch();
		Instruction inst = decode();
		execute(inst);
	}
}
