package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Bit;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class PSW extends Register{
	Bit carry = new Bit();
	Bit parity = new Bit();
	Bit zero = new Bit();
	Bit sign = new Bit();
	Bit trap = new Bit();
	Bit interrupt = new Bit();
	Bit direction = new Bit();
	Bit overflow = new Bit();
	
	private void updatePSW(){
		String PSWBinary = "";
		PSWBinary+=carry.toString();
		PSWBinary+=parity.toString();
		PSWBinary+=zero.toString();
		PSWBinary+=sign.toString();
		PSWBinary+=trap.toString();
		PSWBinary+=interrupt.toString();
		PSWBinary+=direction.toString();
		PSWBinary+=overflow.toString();
		MainWindow.frame.setPSW(PSWBinary);
	}
	
	public Bit getCarry() {
		return carry;
	}
	public void setCarry(Bit carry) {
		this.carry = carry;
		updatePSW();
	}
	public Bit getParity() {
		return parity;
	}
	public void setParity(Bit parity) {
		this.parity = parity;
		updatePSW();
	}
	public Bit getZero() {
		return zero;
	}
	public void setZero(Bit zero) {
		this.zero = zero;
		updatePSW();
	}
	public Bit getSign() {
		return sign;
	}
	public void setSign(Bit sign) {
		this.sign = sign;
		updatePSW();
	}
	public Bit getTrap() {
		return trap;
	}
	public void setTrap(Bit trap) {
		this.trap = trap;
		updatePSW();
	}
	public Bit getInterrupt() {
		return interrupt;
	}
	public void setInterrupt(Bit interrupt) {
		this.interrupt = interrupt;
		updatePSW();
	}
	public Bit getDirection() {
		return direction;
	}
	public void setDirection(Bit direction) {
		this.direction = direction;
		updatePSW();
	}
	public Bit getOverflow() {
		return overflow;
	}
	public void setOverflow(Bit overflow) {
		this.overflow = overflow;
		updatePSW();
	}
	
	
}
