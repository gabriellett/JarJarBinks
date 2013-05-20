package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Bit;

public class PSW extends Register{
	Bit carry;
	Bit parity;
	Bit carryAux;
	Bit zero;
	Bit sign;
	Bit trap;
	Bit interrupt;
	Bit direction;
	Bit overflow;
	
	public Bit getCarry() {
		return carry;
	}
	public void setCarry(Bit carry) {
		this.carry = carry;
	}
	public Bit getParity() {
		return parity;
	}
	public void setParity(Bit parity) {
		this.parity = parity;
	}
	public Bit getCarryAux() {
		return carryAux;
	}
	public void setCarryAux(Bit carryAux) {
		this.carryAux = carryAux;
	}
	public Bit getZero() {
		return zero;
	}
	public void setZero(Bit zero) {
		this.zero = zero;
	}
	public Bit getSign() {
		return sign;
	}
	public void setSign(Bit sign) {
		this.sign = sign;
	}
	public Bit getTrap() {
		return trap;
	}
	public void setTrap(Bit trap) {
		this.trap = trap;
	}
	public Bit getInterrupt() {
		return interrupt;
	}
	public void setInterrupt(Bit interrupt) {
		this.interrupt = interrupt;
	}
	public Bit getDirection() {
		return direction;
	}
	public void setDirection(Bit direction) {
		this.direction = direction;
	}
	public Bit getOverflow() {
		return overflow;
	}
	public void setOverflow(Bit overflow) {
		this.overflow = overflow;
	}
	
	
}
