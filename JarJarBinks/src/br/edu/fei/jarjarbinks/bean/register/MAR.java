package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.ui.MainWindow;

/**
 * Guarda endere�o daonde os dados est�o sendo lidos ou gravados
 * na mem�ria
 * @author Gabriel
 *
 */
public class MAR extends Register{

	private Word word;
		
	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		MainWindow.frame.setMAR(String.format("%04X", word.toInt()));
		System.out.println("MAR set to:"+String.format("%04X", word.toInt()));
		this.word = word;
	}
}
