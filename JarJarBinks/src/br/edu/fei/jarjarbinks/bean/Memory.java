package br.edu.fei.jarjarbinks.bean;

import java.util.ArrayList;

public class Memory {
	
	ArrayList<Byte> memArr;
	
	Memory(){
		memArr = new ArrayList<Byte>(65536);
	}
	
	public Byte getByte(int position){
		return memArr.get(position);
	}
	
	public void setByte(Byte byteValue, int position){
		memArr.set(position, byteValue);
	}
	
	public Word getWord(int position){
		return new Word(new Byte[]{memArr.get(position),memArr.get(position+1)});
		
	}
	
	public void setWord(int position, Word word){
		memArr.set(position, word.getWord()[0]);
		memArr.set(position+1, word.getWord()[1]);
	}
}
