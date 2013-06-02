package br.edu.fei.jarjarbinks.instructions;


public interface Instruction {
	
	public void execute() throws Exception;
	
	public boolean checkResponsability();
}
