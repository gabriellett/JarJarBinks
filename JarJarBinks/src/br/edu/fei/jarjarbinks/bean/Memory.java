package br.edu.fei.jarjarbinks.bean;

import java.util.HashMap;

import br.edu.fei.jarjarbinks.CPU;
import br.edu.fei.jarjarbinks.ui.MainWindow;

/**
 * 0~~255: Memoria Programa 
 * |- 0~~32: Memoria Interna
 * |- 33~~255: Memoria Externa
 * 255~~65536: Code Segment
 * @author Gabriel Lett Viviani
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
	
	public void setByte(int position, Byte byteValue){
		memArr.put(position, byteValue);
	}
	
	public Word getWord(int position){
		return new Word(new Byte[]{memArr.get(position*2),memArr.get((2*position)+1)});
		
	}
	
	public void setWord(int position, Word word){
		if(position<=255){
			//Update modelo
			MainWindow.frame.txtMemoria.getModel().setValueAt(String.format("%02X", word.toInt()), position/16,(position%16)+1);
			
			MainWindow.frame.txtMemoria.revalidate();
			MainWindow.frame.txtMemoria.repaint();
		}
		memArr.put(position*2, word.getWord()[0]);
		memArr.put((position*2)+1, word.getWord()[1]);
	}
	
	public void load(){
		System.out.println("MEM load  :"+ String.format("%04X",CPU.mar.getWord().toInt()));
		CPU.mdr.setWord(this.getWord(CPU.mar.getWord().toInt()));
	}
	
	public void store(){
		System.out.println("MEM store :"+ String.format("%04X",CPU.mdr.getWord().toInt())+" on "+ String.format("%04X",CPU.mar.getWord().toInt()));
		this.setWord(CPU.mar.getWord().toInt(),CPU.mdr.getWord());
	}
}
