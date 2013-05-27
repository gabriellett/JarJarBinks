package br.edu.fei.jarjarbinks.enums;

import br.edu.fei.jarjarbinks.enums.TipoOrigemDestino;

public enum OpcodeOrigemDestino {

	RegReg("00",TipoOrigemDestino.Register,TipoOrigemDestino.Register),
	RegMem("01",TipoOrigemDestino.Register,TipoOrigemDestino.Memory),
	MemReg("10",TipoOrigemDestino.Memory,TipoOrigemDestino.Register),
	MemMem("11",TipoOrigemDestino.Memory,TipoOrigemDestino.Memory);
	
	private String opcode;
	private TipoOrigemDestino origem;
	private TipoOrigemDestino destino;
	
	OpcodeOrigemDestino(String opcode, TipoOrigemDestino tipoOrigem, TipoOrigemDestino tipoDestino){
		this.opcode = opcode;
		this.origem = tipoOrigem;
		this.destino = tipoDestino;
	}

	public String getOpcode() {
		return opcode;
	}

	public TipoOrigemDestino getOrigem() {
		return origem;
	}

	public TipoOrigemDestino getDestino() {
		return destino;
	}
	
	public static OpcodeOrigemDestino parse(String opcode){
		
		if("00".equalsIgnoreCase(opcode)){
			return RegReg;
		}else if("01".equalsIgnoreCase(opcode)){
			return RegMem;
		}else if("10".equalsIgnoreCase(opcode)){
			return MemReg;
		}else if("11".equalsIgnoreCase(opcode)){
			return MemMem;
		}else{
			return null;
		}
	}

}
