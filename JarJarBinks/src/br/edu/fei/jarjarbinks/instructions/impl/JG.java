package br.edu.fei.jarjarbinks.instructions.impl;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Opcode;
import br.edu.fei.jarjarbinks.instructions.Common;
import br.edu.fei.jarjarbinks.instructions.Instruction;
import br.edu.fei.jarjarbinks.logic.ArithmeticLogicUnit;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class JG implements Instruction{
	private String opcodeResp = "1000";
	private String mnemonic = "AFRO";
	private String mnemonicEquiv = "JG";
	
	@Override
	public void execute() throws Exception{
		Opcode opcode = new Opcode(CPU.mdr.getWord());
		
		CPU.cu.fetch();
		CPU.setAuxAddr(CPU.mdr.getWord());
		
		Common.parseOrigin(opcode);

		ArithmeticLogicUnit.aux1 = CPU.getAuxData();
		if(ArithmeticLogicUnit.greaterThanAcc()){
			CPU.pc.setWord(CPU.getAuxAddr());
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
