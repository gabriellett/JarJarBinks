package br.edu.fei.jarjarbinks.instructions.impl;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Opcode;
import br.edu.fei.jarjarbinks.bean.register.Register;
import br.edu.fei.jarjarbinks.enums.AddressingMode;
import br.edu.fei.jarjarbinks.enums.OpcodeOrigemDestino;
import br.edu.fei.jarjarbinks.enums.TipoOrigemDestino;
import br.edu.fei.jarjarbinks.instructions.Instruction;

public class MOV implements Instruction{
	
	@Override
	public void execute() {
		Opcode opcode = new Opcode(CPU.mdr.getWord());
		
		CPU.cu.fetch();
		
		Register destiny = null;
		Register source = null;
		
		if(opcode.getAddressingMode() == AddressingMode.Imediate){

			if(opcode.getDestiny() == TipoOrigemDestino.Memory){
				CPU.setAux(CPU.mdr.getWord());
				CPU.cu.fetch();
			}else if(opcode.getDestiny() == TipoOrigemDestino.Register){
				CPU.class.getMethod("set"+opcode.getDestiny(), null)
			}
		}
		
		/*	break;
			
			case Direct:
				
				break;
			case Indirect:
				
				break;
		}*/
		
		
		System.out.println("TO:"+Integer.toHexString(CPU.mdr.getWord().toInt()));
		
		CPU.pc.nextInst();
		CPU.cu.fetch();
		CPU.mar.setWord(CPU.getDonatello().getWord());
		System.out.println("Value:"+Integer.toHexString(CPU.mdr.getWord().toInt()));
		CPU.mem.store();
		
	}

	@Override
	public boolean checkResponsability() {
		Opcode opcode = new Opcode(CPU.mdr.getWord());
		if("0001".equals(opcode.getInstruction())){
			return true;
		}else{
			return false;
		}
		
	}
}
