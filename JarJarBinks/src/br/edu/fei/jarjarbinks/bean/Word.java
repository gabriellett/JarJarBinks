package br.edu.fei.jarjarbinks.bean;

public class Word {
	Byte[] word = new Byte[2];

	Word(Byte[] word){
		this.setWord(word);
	}
	
	public Byte[] getWord() {
		return word;
	}

	public void setWord(Byte[] word) {
		this.word = word;
	}
}
