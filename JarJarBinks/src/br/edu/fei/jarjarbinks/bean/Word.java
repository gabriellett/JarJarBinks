package br.edu.fei.jarjarbinks.bean;

import br.edu.fei.jarjarbinks.bean.Byte;
import br.edu.fei.jarjarbinks.exception.InvalidVarSize;

public class Word {
	
	private Byte[] word = new Byte[2];

	public Word(Byte[] word){
		this.word[0] = word[0];
		this.word[1] = word[1];
	}
	
	public Word(int i){
		byte res[] = new byte[2];
		res[0] = (byte) (i >> 8);
		res[1] = (byte) (i);
		
		Byte byte1 = new Byte();
		Byte byte2 = new Byte();

		try{
			byte1.setValue(res[0]);
			byte2.setValue(res[1]);
		}catch(InvalidVarSize ivs){
			System.out.println("Invalid var size.");
		}
		
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
}
