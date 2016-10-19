package com.johnny.pipelinesimulator.Interface;

public interface IInstructions {
	/**
	 * Retorna nome da instrucao
	 * @return name
	 */
	String getName();
	/**
	 * Retorna destino de onde a operação será armazenada (registrador)
	 * @return dest
	 */
	String getDest();
	/**
	 * Retorna primeira operação da instrução
	 * @return op1
	 */
	String getOp1();
	/**
	 * Retorna segunda operação da instrução
	 * @return op2
	 */
	String getOp2();
	
	/**
	 * Imprime instrução
	 */
	void print();
}
