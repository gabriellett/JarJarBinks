package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.util.Conversor;

public class PC extends Register{

	private Word[] word;
	
	public Word[] getContents() {
		return word;
	}

	public void setContents(Word[] word) {
		this.word = word;
	}
	
	public void incOne(){
		this.setContents(Conversor.twoWordCreator(Conversor.twoWordToInt(word)+1));
	}
}
