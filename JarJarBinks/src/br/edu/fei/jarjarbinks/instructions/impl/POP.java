package br.edu.fei.jarjarbinks.instructions.impl;

import java.lang.reflect.Method;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Opcode;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.enums.TipoOrigemDestino;
import br.edu.fei.jarjarbinks.instructions.Instruction;
import br.edu.fei.jarjarbinks.ui.FrameLog;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class POP implements Instruction{
	private String opcodeResp = "1010";
	private String mnemonic = "KORN";
	private String mnemonicEquiv = "POP";
	private String op = "";
	
	@Override
	public void execute() throws Exception{
		Opcode opcode = new Opcode(CPU.mdr.getWord());

		Method registerMethod = null;
		
		CPU.mar.setWord(CPU.sp.getWord());
		CPU.mem.load();
		CPU.setAuxData(CPU.mdr.getWord());
		
		if(opcode.getDestiny() == TipoOrigemDestino.Memory){

			CPU.cu.fetch();
			CPU.setAuxAddr(CPU.mdr.getWord());
			op = String.format("%04X", CPU.mdr.getWord().toInt());
			
		}else if(opcode.getDestiny() == TipoOrigemDestino.Register){
			registerMethod = CPU.class.getMethod("set"+opcode.getDestinyRegister(), Word.class);
			op = opcode.getDestinyRegister().name();
		}

		if(registerMethod==null){
			CPU.mdr.setWord(CPU.getAuxData());
			CPU.mar.setWord(CPU.getAuxAddr());
			CPU.mem.store();
		}else{
			registerMethod.invoke(null, CPU.getAuxData());
		}
		
		CPU.sp.decSP();

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
