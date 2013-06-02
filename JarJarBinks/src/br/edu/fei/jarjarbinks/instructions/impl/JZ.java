package br.edu.fei.jarjarbinks.instructions.impl;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Opcode;
import br.edu.fei.jarjarbinks.instructions.Instruction;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class JZ implements Instruction{
	private String opcodeResp = "0111";
	private String mnemonic = "JAMIL";
	private String mnemonicEquiv = "JZ";
	
	@Override
	public void execute() throws Exception{

		CPU.cu.fetch();
		if(CPU.getAcme().getWord().toInt()==0x0000){
			CPU.pc.setWord(CPU.mdr.getWord());
		}
		
	}

	@Override
	public boolean checkResponsability() {
		Opcode opcode = new Opcode(CPU.mdr.getWord());
		if(opcodeResp.equals(opcode.getInstruction())){
			MainWindow.frame.setLastInst(mnemonic+" ("+mnemonicEquiv+")");
			return true;
		}else{
			return false;
		}
	}
}
