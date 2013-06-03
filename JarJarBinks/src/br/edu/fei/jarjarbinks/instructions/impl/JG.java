package br.edu.fei.jarjarbinks.instructions.impl;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Opcode;
import br.edu.fei.jarjarbinks.instructions.Common;
import br.edu.fei.jarjarbinks.instructions.Instruction;
import br.edu.fei.jarjarbinks.logic.ArithmeticLogicUnit;
import br.edu.fei.jarjarbinks.ui.FrameLog;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class JG implements Instruction{
	private String opcodeResp = "1000";
	private String mnemonic = "AFRO";
	private String mnemonicEquiv = "JG";
	private String op1 = "";
	private String op2 = "";
	
	@Override
	public void execute() throws Exception{
		Opcode opcode = new Opcode(CPU.mdr.getWord());
		
		CPU.cu.fetch();
		CPU.setAuxAddr(CPU.mdr.getWord());
		op1 = String.format("%04X", CPU.mdr.getWord().toInt());
		
		op2 = Common.parseOrigin(opcode);

		ArithmeticLogicUnit.aux1 = CPU.getAuxData();
		if(ArithmeticLogicUnit.greaterThanAcc()){
			CPU.pc.setWord(CPU.getAuxAddr());
		}
		
		MainWindow.frame.setLastInst(mnemonic+" ("+mnemonicEquiv+") "+op1+","+op2);
		FrameLog.frame.addInstruction(mnemonic+" ("+mnemonicEquiv+") "+op1+","+op2);
	}

	@Override
	public boolean checkResponsability() {
		Opcode opcode = new Opcode(CPU.mdr.getWord());
		if(opcodeResp.equals(opcode.getInstruction())){
			return true;
		}else{
			return false;
		}
	}
}
