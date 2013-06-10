package br.edu.fei.jarjarbinks.instructions.impl;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Bit;
import br.edu.fei.jarjarbinks.bean.Opcode;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.instructions.Common;
import br.edu.fei.jarjarbinks.instructions.Instruction;
import br.edu.fei.jarjarbinks.ui.FrameLog;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class PUSH implements Instruction{
	private String opcodeResp = "1001";
	private String mnemonic = "EMPURRE";
	private String mnemonicEquiv = "PUSH";
	private String op = "";
	
	@Override
	public void execute() throws Exception{
		Opcode opcode = new Opcode(CPU.mdr.getWord());
		
		boolean overflow = false;
		if(CPU.sp.getWord()==null){
			CPU.sp.setWord(new Word(0x0000));
		}else if(CPU.sp.getWord().toInt()!=0x000F){
			CPU.sp.incSP();
		}else{
			overflow = true;
		}
		
		op = Common.parseOrigin(opcode);
		
		CPU.mar.setWord(CPU.sp.getWord());
		CPU.mdr.setWord(CPU.getAuxData());
		if(overflow){
			CPU.psw.setOverflow(new Bit(true));
		}else{
			CPU.mem.store();
		}
		
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
	
	@Override
	public String getDescription() {
		return mnemonic+" ("+mnemonicEquiv+") :"+opcodeResp;
	}
}
