package br.edu.fei.jarjarbinks.bean;

import br.edu.fei.jarjarbinks.enums.AddressingMode;
import br.edu.fei.jarjarbinks.enums.OpcodeOrigemDestino;
import br.edu.fei.jarjarbinks.enums.RegisterEnum;
import br.edu.fei.jarjarbinks.enums.TipoOrigemDestino;
import br.edu.fei.jarjarbinks.util.Conversor;

public class Opcode {
	
	private String fullOpcode;
	private String instruction;
	private AddressingMode addressingMode;
	private OpcodeOrigemDestino originDestiny;
	private RegisterEnum sourceRegister;
	private RegisterEnum destinyRegister;
	
	public Opcode(Word word){
		fullOpcode = Conversor.fillOpcodeZero(Integer.toBinaryString(word.toInt()));
		
		
		this.setInstruction(fullOpcode.substring(0,4));
		this.setAddressingMode(AddressingMode.parse(fullOpcode.substring(4, 6)));
		this.setOriginDestiny(OpcodeOrigemDestino.parse(fullOpcode.substring(6, 8)));
		this.setSourceRegister(RegisterEnum.parse(fullOpcode.substring(8,12)));
		this.setDestinyRegister(RegisterEnum.parse(fullOpcode.substring(12, 16)));
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
