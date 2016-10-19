package com.johnny.pipelinesimulator.Interface;

public interface IInstructions {
	/**
	 * Retorna nome da instrucao
	 * @return name
	 */
	String getName();
	/**
	 * Retorna destino de onde a opera��o ser� armazenada (registrador)
	 * @return dest
	 */
	String getDest();
	/**
	 * Retorna primeira opera��o da instru��o
	 * @return op1
	 */
	String getOp1();
	/**
	 * Retorna segunda opera��o da instru��o
	 * @return op2
	 */
	String getOp2();
	
	/**
	 * Imprime instru��o
	 */
	void print();
}
