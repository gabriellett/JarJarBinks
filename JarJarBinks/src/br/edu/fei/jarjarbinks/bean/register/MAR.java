package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Byte;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.ui.MainWindow;

/**
 * Guarda endereço daonde os dados estão sendo lidos ou gravados
 * na memória
 * @author Gabriel
 *
 */
public class MAR extends Register{

	private Word word;
		
	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		MainWindow.frame.setMAR(Integer.toHexString(word.toInt()));
		System.out.println("MAR set to:"+Integer.toHexString(word.toInt()));
		this.word = word;
	}
}
