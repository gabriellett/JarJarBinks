package br.edu.fei.jarjarbinks.logic;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.bean.Bit;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.exception.InvalidVarSize;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class ArithmeticLogicUnit {

	public static Word aux1;
	public static Word aux2;
	
	public static Word add() throws InvalidVarSize{
		int auxVal = aux1.toInt();
		int accVal = CPU.getAcme().getWord().toInt();
		
		try{
			return new Word(auxVal+accVal);
		}catch(InvalidVarSize ivs){
			CPU.psw.setCarry(new Bit(true));
			return new Word(0);
		}
	}
	
	public static Word sub() throws InvalidVarSize{
		int auxVal = aux1.toInt();
		int accVal = CPU.getAcme().getWord().toInt();

		int res = auxVal-accVal;
		if(res<0){
			CPU.psw.setSign(new Bit(true));
			res *=-1;
		}
		try{
			return new Word(res);
		}catch(InvalidVarSize ivs){
			CPU.psw.setCarry(new Bit(true));
			return new Word(0);
		}
	}

	public static Word not() throws InvalidVarSize{

		String a = (Integer.toBinaryString(aux1.toInt()));
		a = a.replaceAll("0","a");
		a = a.replaceAll("1","0");
		a = a.replaceAll("a","1");
		
		int val = Integer.valueOf(a,2);
		return new Word(val);
	}
	public static Word and() throws InvalidVarSize{
		return new Word(aux1.toInt() | CPU.getAcme().getWord().toInt());
	}
	public static Word or() throws InvalidVarSize{
		return new Word(aux1.toInt() & CPU.getAcme().getWord().toInt());
	}
	
	public static boolean greaterThanAcc(){
		return(aux1.toInt()>CPU.getAcme().getWord().toInt());
	}
	
	public static boolean lessThanAcc(){
		return(aux1.toInt()<CPU.getAcme().getWord().toInt());
		
	}
}
