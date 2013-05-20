package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Byte;
import br.edu.fei.jarjarbinks.bean.Word;

/**
 * Guarda temporariamente dados que estãos sendo recebidos e enviados para memória
 * @author Gabriel
 *
 */
public class MDR extends Register{

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
}
