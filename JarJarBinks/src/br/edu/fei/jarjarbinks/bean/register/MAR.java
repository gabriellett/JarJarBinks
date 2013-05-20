package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Byte;
import br.edu.fei.jarjarbinks.bean.Word;

/**
 * Guarda endere�o daonde os dados est�o sendo lidos ou gravados
 * na mem�ria
 * @author Gabriel
 *
 */
public class MAR extends Register{

	private Word[] word;
	
	public Word[] getContents() {
		return word;
	}

	public void setContents(Word[] word) {
		this.word = word;
	}
}
