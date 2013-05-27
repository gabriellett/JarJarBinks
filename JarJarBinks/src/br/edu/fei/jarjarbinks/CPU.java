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
	
	/* CPU internal register */
	private static final AuxiliarRegister auxReg = new AuxiliarRegister();

	/* Registers */
	private static final AuxiliarRegister michelangelo = new AuxiliarRegister();
	private static final AuxiliarRegister donatello    = new AuxiliarRegister();
	private static final AuxiliarRegister rafael       = new AuxiliarRegister();
	private static final AuxiliarRegister leonardo     = new AuxiliarRegister();

	/* Acumulators */
	private static final AuxiliarRegister acme         = new AuxiliarRegister();
	private static final AuxiliarRegister america	  = new AuxiliarRegister();
	
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
				System.out.println("CS "+i+":"+a);
				System.out.println("CS "+i+":"+Integer.toBinaryString(a));
				System.out.println("CS "+i+":"+Integer.toHexString(a));
				Word wa = new Word(a);
				mem.setWord(257+(2*i),wa);
				//mem.setByte(257+(2*i),wa.getWord()[0] );
				//mem.setByte(258+(2*i),wa.getWord()[1] );
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
	public static AuxiliarRegister getMichelangelo() {
		return michelangelo;
	}

	public static AuxiliarRegister getDonatello() {
		return donatello;
	}

	public static AuxiliarRegister getRafael() {
		return rafael;
	}

	public static AuxiliarRegister getLeonardo() {
		return leonardo;
	}

	public static AuxiliarRegister getAcme() {
		return acme;
	}

	public static AuxiliarRegister getAmerica() {
		return america;
	}
	
	public static void setMichelangelo(Word word) {
		MainWindow.frame.setR1(Integer.toHexString(word.toInt()));
		michelangelo.setWord(word);
	}

	public static void setDonatello(Word word) {
		MainWindow.frame.setR2(Integer.toHexString(word.toInt()));
		donatello.setWord(word);
	}

	public static void setRafael(Word word) {
		MainWindow.frame.setR3(Integer.toHexString(word.toInt()));
		rafael.setWord(word);
	}

	public static void setLeonardo(Word word) {
		MainWindow.frame.setR4(Integer.toHexString(word.toInt()));
		leonardo.setWord(word);
	}

	public static void setAcme(Word word) {
		MainWindow.frame.setACC(Integer.toHexString(word.toInt()));
		acme.setWord(word);
	}

	public static void setAmerica(Word word) {
		MainWindow.frame.setB(Integer.toHexString(word.toInt()));
		america.setWord(word);
	}
	
	public static void setAux(Word word) {
		auxReg.setWord(word);
	}
}
