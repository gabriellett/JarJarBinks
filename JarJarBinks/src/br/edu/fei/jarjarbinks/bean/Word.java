package br.edu.fei.jarjarbinks.bean;

import br.edu.fei.jarjarbinks.exception.InvalidVarSize;
import br.edu.fei.jarjarbinks.util.Conversor;

public class Word {
	
	private Byte[] word = new Byte[2];

	public Word(Byte[] word){
		this.word[0] = word[0];
		this.word[1] = word[1];
	}
	
	public Word(int i) throws InvalidVarSize{
		if(i<0) throw new InvalidVarSize("val<0!");
		
		Byte byte1 = new Byte();
		Byte byte2 = new Byte();

		byte1.setValue((short)((i >> 8) & 0xFF));
		byte2.setValue((short)(i & 0xFF));
		
		Byte word[]= new Byte[]{byte1,byte2};
		
		this.word = word;
	}
	
	public Byte[] getWord() {
		return word;
	}

	public void setWord(Byte[] word) {
		this.word = word;
	}
	
	public int toInt(){
		return  (word[0].getValue()*256)+
				(word[1].getValue());
	}
	
	public static Word getZeroWord(){
		Byte byte1 = new Byte();
		Byte byte2 = new Byte();

		try{
			byte1.setValue((short)0);
			byte2.setValue((short)0);
		}catch(InvalidVarSize ivs){
			System.out.println("Invalid var size.");
		}
		
		Byte word[]= new Byte[]{byte1,byte2};
		
		return new Word(word);
	}
	
	public String toString(){
		return Conversor.fillOpcodeZero(Integer.toBinaryString(this.toInt()))+"|"+String.format("%04d", this.toInt())+"|"+String.format("%04X", this.toInt());
		
	}
}
