package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class PC extends Register{

	private Word word;
		
	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		MainWindow.frame.setPC(Integer.toHexString(word.toInt()));
		System.out.println("PC set to:"+Integer.toHexString(word.toInt()));
		this.word = word;
	}
	
	public void nextInst(){
		// Aponta para proxima word
		this.setWord(new Word(word.toInt()+2));
	}
}
