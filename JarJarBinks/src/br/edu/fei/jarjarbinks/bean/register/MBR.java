package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Byte;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.ui.MainWindow;

public class MBR extends Register{

	private Word word;
		
	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		MainWindow.frame.setMBR(Integer.toHexString(word.toInt()));
		System.out.println("MBR set to:"+Integer.toHexString(word.toInt()));
		this.word = word;
	}
}
