package br.edu.fei.jarjarbinks.bean;

import br.edu.fei.jarjarbinks.exception.InvalidVarSize;

public class Byte {
	static final int MAX_VALUE = 255;
	static final int MIN_VALUE = 0;
	
	short value;
	
	public Byte(){
		value = (short) 0;
	}

	public short getValue() {
		return value;
	}

	public void setValue(short value) throws InvalidVarSize {
		if(value>MAX_VALUE || value<MIN_VALUE){
			throw new InvalidVarSize("Invalid Size, value content:"+value);
		}
		this.value = value;
	}
}
