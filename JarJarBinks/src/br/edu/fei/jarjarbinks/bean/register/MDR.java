package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.ui.MainWindow;
import br.edu.fei.jarjarbinks.util.Conversor;

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
		MainWindow.frame.setMDR(String.format("%04X", word.toInt()));
		System.out.println("MDR set to:"+String.format("%04X", word.toInt())+"["+Conversor.fillOpcodeZero(Integer.toBinaryString(word.toInt())+"]"));
		this.word = word;
	}
}
