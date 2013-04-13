package br.edu.fei.jarjarbinks.bean;

public class Bit {
	boolean bit;
	
	Bit(){
		this.setZero();
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
	
}
