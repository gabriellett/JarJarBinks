package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Byte;
import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.ui.MainWindow;

/**
 * Guarda temporariamente dados que estãos sendo recebidos e enviados para memória
 * @author Gabriel
 *
 */
public class MDR extends Register{

	private Word word;
	
	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		MainWindow.frame.setMDR(Integer.toHexString(word.toInt()));
		System.out.println("MDR set to:"+Integer.toHexString(word.toInt()));
		this.word = word;
	}
}
