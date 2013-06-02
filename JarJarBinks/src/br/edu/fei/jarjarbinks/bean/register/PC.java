package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.exception.InvalidVarSize;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class PC extends Register{

	private Word word;
		
	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		MainWindow.frame.setPC(String.format("%04X", word.toInt()));
		
		MainWindow.frame.txtCodeSegment.setRowSelectionInterval((word.toInt()-256), (word.toInt()-256));

		System.out.println("PC  set to:"+String.format("%04X", word.toInt()));
		this.word = word;
	}
	
	public void nextInst() throws InvalidVarSize{
		// Aponta para proxima word
		this.setWord(new Word(word.toInt()+1));
	}
}
