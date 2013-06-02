package br.edu.fei.jarjarbinks.bean;

public class Bit {
	boolean bit;

	public Bit(){
		new Bit(false);
	}
	
	public Bit(boolean bit){
		this.bit = bit;
	}

	public void setZero(){
		bit=false;
	}
	
	public void setOne(){
		bit=true;
	}
	
	public int getBit(){
		if(bit){
			return 1;
		}else{
			return 0;
		}
	}
	
	public String toString(){
		if(bit){
			return "1";
		}
		
		return "0";
	}
	
}
