package br.edu.fei.jarjarbinks.instructions;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Opcode;
import br.edu.fei.jarjarbinks.bean.register.AuxiliarRegister;
import br.edu.fei.jarjarbinks.enums.AddressingMode;
import br.edu.fei.jarjarbinks.enums.TipoOrigemDestino;

public class Common {
	
	static String op;
	
	public static boolean parseImediate(Opcode opcode) throws Exception{
		if(opcode.getAddressingMode() == AddressingMode.Imediate){

			// Ao minimo um fetch � obrigatorio no caso imediato
			CPU.cu.fetch();
			CPU.setAuxData(CPU.mdr.getWord());
			op = "#"+String.format("%04X", CPU.getAuxData().toInt());
			return true;
		}
		return false;
	}
	

	public static boolean parseDirect(Opcode opcode) throws Exception{
		if(opcode.getAddressingMode() == AddressingMode.Direct){

			if(opcode.getOrigin() == TipoOrigemDestino.Memory){

				CPU.cu.fetch();
				
				op = String.format("%04X", CPU.mdr.getWord().toInt());
				// Carrega valor do endere�o no reg aux
				CPU.mar.setWord(CPU.mdr.getWord());
				CPU.mem.load();
				CPU.setAuxData(CPU.mdr.getWord());
				
			}else if(opcode.getOrigin() == TipoOrigemDestino.Register){
				CPU.setAuxData(((AuxiliarRegister) CPU.class.getMethod("get"+opcode.getSourceRegister(), null).invoke(null, null)).getWord());
				op = opcode.getSourceRegister().name();
			}
			return true;
		}
		return false;
	}
	public static boolean parseIndirect(Opcode opcode) throws Exception{
		if(opcode.getAddressingMode() == AddressingMode.Indirect){
			if(opcode.getOrigin() == TipoOrigemDestino.Memory){

				CPU.cu.fetch();

				op = "@"+String.format("%04X", CPU.mdr.getWord().toInt());
				// Carrega valor do endere�o no reg aux
				CPU.mar.setWord(CPU.mdr.getWord());
				CPU.mem.load();
				CPU.mar.setWord(CPU.mdr.getWord());
				
			}else if(opcode.getOrigin() == TipoOrigemDestino.Register){
				CPU.mar.setWord(((AuxiliarRegister) CPU.class.getMethod("get"+opcode.getSourceRegister(), null).invoke(null, null)).getWord());
				op = "@"+opcode.getSourceRegister().name();
			}
			
			CPU.mem.load();
			CPU.setAuxData(CPU.mdr.getWord());
			
			return true;
		}
		return false;
	}
	public static String parseOrigin(Opcode opcode) throws Exception{
		
		op = "";
		
		if(parseImediate(opcode)) return op;
		if(parseDirect(opcode)) return  op;
		if(parseIndirect(opcode)) return op;
		
		return op;
		
	}
}
