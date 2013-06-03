package br.edu.fei.jarjarbinks.instructions.impl;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Opcode;
import br.edu.fei.jarjarbinks.instructions.Common;
import br.edu.fei.jarjarbinks.instructions.Instruction;
import br.edu.fei.jarjarbinks.logic.ArithmeticLogicUnit;
import br.edu.fei.jarjarbinks.ui.FrameLog;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class OR implements Instruction{
	private String opcodeResp = "0101";
	private String mnemonic = "KNORR";
	private String mnemonicEquiv = "OR";
	private String op = "";
	
	@Override
	public void execute() throws Exception{
		Opcode opcode = new Opcode(CPU.mdr.getWord());
		
		op = Common.parseOrigin(opcode);
		
		ArithmeticLogicUnit.aux1 = CPU.getAuxData();
		CPU.setAcme(ArithmeticLogicUnit.or());

		MainWindow.frame.setLastInst(mnemonic+" ("+mnemonicEquiv+") "+op);
		FrameLog.frame.addInstruction(mnemonic+" ("+mnemonicEquiv+") "+op);
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
