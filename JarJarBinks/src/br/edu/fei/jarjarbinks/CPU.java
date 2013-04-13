package br.edu.fei.jarjarbinks;

import br.edu.fei.jarjarbinks.bean.register.AuxiliarRegister;
import br.edu.fei.jarjarbinks.bean.register.MAR;
import br.edu.fei.jarjarbinks.bean.register.MBR;
import br.edu.fei.jarjarbinks.bean.register.MDR;
import br.edu.fei.jarjarbinks.bean.register.PC;
import br.edu.fei.jarjarbinks.bean.register.PSW;
import br.edu.fei.jarjarbinks.logic.ArithmeticLogicUnit;

public class CPU {
	
	private static final CPU INSTANCE = new CPU();
	
	public static final PSW psw = new PSW();
	public static final PC pc = new PC();
	public static final MBR mbr = new MBR();
	public static final MAR mar = new MAR();
	public static final MDR mdr = new MDR();

	/* Registers */
	public static final AuxiliarRegister michelangelo = new AuxiliarRegister();
	public static final AuxiliarRegister donatello    = new AuxiliarRegister();
	public static final AuxiliarRegister rafael       = new AuxiliarRegister();
	public static final AuxiliarRegister leonardo     = new AuxiliarRegister();
	
	/* Acumulators */
	public static final AuxiliarRegister acme         = new AuxiliarRegister();
	public static final AuxiliarRegister america	  = new AuxiliarRegister();
	
	public static final ArithmeticLogicUnit alu = new ArithmeticLogicUnit();
	
	private CPU(){
		/* DO_NOTHING */
	}
	
	public CPU getCPU(){
		return this.INSTANCE;
	}
}
