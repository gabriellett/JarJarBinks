package br.edu.fei.jarjarbinks.bean;

import java.util.HashMap;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.ui.MainWindow;

/**
 * 0~~255: Memoria Programa 
 * |- 0~~32: Memoria Interna
 * |- 33~~255: Memoria Externa
 * 255~~65536: Code Segment
 * @author Gabriel
 *
 */
public class Memory {
	
	HashMap<Integer,Byte> memArr;
	
	public Memory(){
		memArr = new HashMap<Integer,Byte>();
	}
	
	public Byte getByte(int position){
		return memArr.get(position);
	}
	
	public void setByte(Byte byteValue, int position){
		memArr.put(position, byteValue);
	}
	
	public Word getWord(int position){
		return new Word(new Byte[]{memArr.get(position),memArr.get(position+1)});
		
	}
	
	public void setWord(int position, Word word){
		if(position<=256){
			//Update modelo
			MainWindow.frame.txtMemoria.getModel().setValueAt(Integer.toHexString(word.toInt()), position/16,position-(position/16));
		}
		memArr.put(position, word.getWord()[0]);
		memArr.put(position+1, word.getWord()[1]);
	}
	
	public void load(){
		CPU.mdr.setWord(this.getWord(CPU.mar.getWord().toInt()));
	}
	
	public void store(){
		this.setWord(CPU.mar.getWord().toInt(),CPU.mdr.getWord());
	}
}
