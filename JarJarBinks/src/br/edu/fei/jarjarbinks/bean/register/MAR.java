package br.edu.fei.jarjarbinks.bean.register;

import br.edu.fei.jarjarbinks.bean.Byte;
import br.edu.fei.jarjarbinks.bean.Word;

/**
 * Guarda endereço daonde os dados estão sendo lidos ou gravados
 * na memória
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
