package br.edu.fei.jarjarbinks.bean;

import br.edu.fei.jarjarbinks.enums.AddressingMode;
import br.edu.fei.jarjarbinks.enums.OpcodeOrigemDestino;
import br.edu.fei.jarjarbinks.enums.RegisterEnum;
import br.edu.fei.jarjarbinks.enums.TipoOrigemDestino;

public class Opcode {
	
	private String instruction;
	private AddressingMode addressingMode;
	private OpcodeOrigemDestino originDestiny;
	private RegisterEnum sourceRegister;
	private RegisterEnum destinyRegister;
	
	public Opcode(Word word){
		String opcode = Integer.toBinaryString(word.toInt());
		while(opcode.length()<16){
			opcode = "0"+opcode;
		}
		
		this.setInstruction(opcode.substring(0,4));
		this.setAddressingMode(AddressingMode.parse(opcode.substring(4, 6)));
		this.setOriginDestiny(OpcodeOrigemDestino.parse(opcode.substring(6, 8)));
		this.setSourceRegister(RegisterEnum.parse(opcode.substring(8,12)));
		this.setDestinyRegister(RegisterEnum.parse(opcode.substring(12, 16)));
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public OpcodeOrigemDestino getOriginDestiny() {
		return originDestiny;
	}

	public void setOriginDestiny(OpcodeOrigemDestino originDestiny) {
		this.originDestiny = originDestiny;
	}

	public RegisterEnum getSourceRegister() {
		return sourceRegister;
	}

	public void setSourceRegister(RegisterEnum sourceRegister) {
		this.sourceRegister = sourceRegister;
	}

	public RegisterEnum getDestinyRegister() {
		return destinyRegister;
	}

	public void setDestinyRegister(RegisterEnum destinyRegister) {
		this.destinyRegister = destinyRegister;
	}

	public AddressingMode getAddressingMode() {
		return addressingMode;
	}

	public void setAddressingMode(AddressingMode addressingMode) {
		this.addressingMode = addressingMode;
	}

	public TipoOrigemDestino getDestiny(){
		return this.getOriginDestiny().getDestino();
	}
	public TipoOrigemDestino getOrigin(){
		return this.getOriginDestiny().getOrigem();
	}

	
}
