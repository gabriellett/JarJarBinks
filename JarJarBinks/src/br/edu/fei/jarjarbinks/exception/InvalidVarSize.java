package br.edu.fei.jarjarbinks.exception;

/**
 * Exception thrown when the given variable size is invalid :)
 * @author Jarjarbinks Group
 *
 */
public class InvalidVarSize extends Exception{

	/** SERIAL NO */
	private static final long serialVersionUID = 585921573517071753L;

	public InvalidVarSize(String msg){
		super(msg);
	}
}
