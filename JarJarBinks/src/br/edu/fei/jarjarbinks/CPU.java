package br.edu.fei.jarjarbinks;

import br.edu.fei.jarjarbinks.bean.Memory;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.bean.register.AuxiliarRegister;
import br.edu.fei.jarjarbinks.bean.register.MAR;
import br.edu.fei.jarjarbinks.bean.register.MBR;
import br.edu.fei.jarjarbinks.bean.register.MDR;
import br.edu.fei.jarjarbinks.bean.register.PC;
import br.edu.fei.jarjarbinks.bean.register.PSW;
import br.edu.fei.jarjarbinks.bean.register.SP;
import br.edu.fei.jarjarbinks.exception.InvalidVarSize;
import br.edu.fei.jarjarbinks.logic.ArithmeticLogicUnit;
import br.edu.fei.jarjarbinks.logic.ControlUnit;
import br.edu.fei.jarjarbinks.ui.MainWindow;
import br.edu.fei.jarjarbinks.util.Conversor;

public class CPU extends Thread{
	
	public static final Memory mem = new Memory();
	
	public static final PSW psw = new PSW();
	public static final PC pc = new PC();
	public static final MBR mbr = new MBR();
	public static final MAR mar = new MAR();
	public static final MDR mdr = new MDR();
	public static final SP sp = new SP();
	
	/* CPU internal register */
	private static final AuxiliarRegister auxRegAddr = new AuxiliarRegister();
	private static final AuxiliarRegister auxRegData = new AuxiliarRegister();

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
	
	public static void initialize() throws InvalidVarSize{
		String tabelaCodeSegment[][] = MainWindow.frame.getTabelaCodeSegment();
		System.out.println("CS VAL [ADDR]:     OPCODE     |INTEG|HEXA");
		
		for(int line=0; line<tabelaCodeSegment.length;line++){
			if(MainWindow.frame.existsCodeLine(line)){
				
				Word word = MainWindow.frame.getWordFromCodeSegment(line);
				mem.setWord(256+line,word);
			}
		}
		
		pc.setWord(new Word(0x0100));
		
		isInitialized = true;
	}
	
	public void run(){
		try{
			if(!isInitialized){
				initialize();
				if(CPU.psw.getTrap().getBit()==1)return;
			}
			while(true){
				cu.executeNextInst();
				if(CPU.psw.getTrap().getBit()==1){
					return;
				}else{
					sleep(MainWindow.frame.getTxtSleep());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
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
		MainWindow.frame.setR1(String.format("%04X", word.toInt()));
		michelangelo.setWord(word);
	}

	public static void setDonatello(Word word) {
		MainWindow.frame.setR2(String.format("%04X", word.toInt()));
		donatello.setWord(word);
	}

	public static void setRafael(Word word) {
		MainWindow.frame.setR3(String.format("%04X", word.toInt()));
		rafael.setWord(word);
	}

	public static void setLeonardo(Word word) {
		MainWindow.frame.setR4(String.format("%04X", word.toInt()));
		leonardo.setWord(word);
	}

	public static void setAcme(Word word) {
		MainWindow.frame.setACC(String.format("%04X", word.toInt()));
		acme.setWord(word);
	}

	public static void setAmerica(Word word) {
		MainWindow.frame.setB(String.format("%04X", word.toInt()));
		america.setWord(word);
	}

	public static void setSP(Word word){
		MainWindow.frame.setB(String.format("%04X", word.toInt()));
		sp.setWord(word);
		
	}
	public static void getSP(Word word){
		sp.getWord();
	}

	public static void setAuxAddr(Word word) {
		auxRegAddr.setWord(word);
	}
	
	public static Word getAuxAddr() {
		return auxRegAddr.getWord();
	}
	
	public static void setAuxData(Word word) {
		auxRegData.setWord(word);
	}
	
	public static Word getAuxData() {
		return auxRegData.getWord();
	}
}
