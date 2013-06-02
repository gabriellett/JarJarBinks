package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Word;
import br.edu.fei.jarjarbinks.exception.InvalidVarSize;
import br.edu.fei.jarjarbinks.ui.MainWindow;

/**
 * Guarda endereço daonde os dados estão sendo lidos ou gravados
 * na memória
 * @author Gabriel
 *
 */
public class SP extends Register{

	private Word word;
		
	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		MainWindow.frame.setSP(String.format("%04X", word.toInt()));
		System.out.println("SP set to:"+String.format("%04X", word.toInt()));
		this.word = word;
	}
	
	public void incSP() throws InvalidVarSize{
		this.setWord(new Word(word.toInt()+1));
	}
	
	public void decSP() throws InvalidVarSize{
		this.setWord(new Word(word.toInt()-1));
	}
}
