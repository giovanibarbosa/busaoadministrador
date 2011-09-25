package br.edu.ufcg.dsc.exceptions;

public class ParametroInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParametroInvalidoException() {
		super();
	}

	public ParametroInvalidoException(String detailMessage) {
		super(detailMessage);
	}

}
