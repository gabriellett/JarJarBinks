package br.edu.fei.jarjarbinks.instructions.impl;

import java.lang.reflect.Method;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Opcode;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.enums.TipoOrigemDestino;
import br.edu.fei.jarjarbinks.instructions.Common;
import br.edu.fei.jarjarbinks.instructions.Instruction;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class MOV implements Instruction{
	private String opcodeResp = "0001";
	private String mnemonic = "SCANIA";
	private String mnemonicEquiv = "MOV";
	
	@Override
	public void execute() throws Exception{
		Opcode opcode = new Opcode(CPU.mdr.getWord());
		
		Method registerMethod = null;
		
		if(opcode.getDestiny() == TipoOrigemDestino.Memory){

			CPU.cu.fetch();
			CPU.setAuxAddr(CPU.mdr.getWord());
			
		}else if(opcode.getDestiny() == TipoOrigemDestino.Register){
			registerMethod = CPU.class.getMethod("set"+opcode.getDestinyRegister(), Word.class);
		}
		
		Common.parseOrigin(opcode);
		
		if(registerMethod==null){
			CPU.mdr.setWord(CPU.getAuxData());
			CPU.mar.setWord(CPU.getAuxAddr());
			CPU.mem.store();
		}else{
			registerMethod.invoke(null, CPU.getAuxData());
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
