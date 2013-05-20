package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Byte;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.util.Conversor;

public class PC extends Register{

	private Word word;
	
	public Byte getByte(){
		return word.getWord()[0];
	}
	
	public void setByte(Byte value){
		word.setWord(new Byte[]{value,new Byte()});
	}
	
	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}
	
	public void incOne(){
		this.setWord(new Word(word.toInt()+1));
	}
}
