package br.edu.fei.jarjarbinks;

import br.edu.fei.jarjarbinks.bean.Memory;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.bean.register.AuxiliarRegister;
import br.edu.fei.jarjarbinks.bean.register.MAR;
import br.edu.fei.jarjarbinks.bean.register.MBR;
import br.edu.fei.jarjarbinks.bean.register.MDR;
import br.edu.fei.jarjarbinks.bean.register.PC;
import br.edu.fei.jarjarbinks.bean.register.PSW;
import br.edu.fei.jarjarbinks.logic.ArithmeticLogicUnit;
import br.edu.fei.jarjarbinks.logic.ControlUnit;
import br.edu.fei.jarjarbinks.ui.MainWindow;
import br.edu.fei.jarjarbinks.util.Conversor;

public class CPU {
	
	private static final CPU INSTANCE = new CPU();
	
	public static final Memory mem = new Memory();
	
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
	public static final ControlUnit cu = new ControlUnit();
	
	public static boolean isInitialized = false;
	
	private static MainWindow janela;
	
	private CPU(){
		/* DO_NOTHING */
	}
		
	public static void initialize(){
		String tabelaCodeSegment[][] = MainWindow.frame.getTabelaCodeSegment();
		for(int i=0; i<tabelaCodeSegment.length;i++){
			if(MainWindow.frame.txtCodeSegment.getModel().getValueAt(i,1)!=null){
				int a = Integer.valueOf(((String)MainWindow.frame.txtCodeSegment.getModel().getValueAt(i,1)).replaceAll(" ", ""),2);
				Word wa = new Word(a);
				mem.setByte(wa.getWord()[0],257+(2*i) );
				mem.setByte(wa.getWord()[1],258+(2*i) );
			}
		}
		
		pc.setWord(new Word(0x0101));
		System.out.println(pc.getWord().toInt());
		isInitialized = true;
	}
	
	public static void execute(){
		//if(!isInitialized) 
		initialize();
		cu.executeNextInst();
	}
}
