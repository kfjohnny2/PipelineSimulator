package com.johnny.pipelinesimulator.Interface;

import java.util.List;

import com.johnny.pipelinesimulator.Strategy.Instruction;

public interface IFunctions {
	/**
	 * Leitura e constru��o da lista de instru��es para a fun��o
	 * @param fileName Caminho e nome do arquivo retornado a partir de um seletor de arquivos.
	 * @return List<Instruction> result Lista de instru��es
	 */
	List<Instruction> readFile(String fileName);
	
	/**
	 * Analisa a lista de instru��es e imprime o pipeline de acordo com as regras de conflitos na execu��o de instru��es.
	 * @param instructionVector cole��o de instru��es
	 */
	void analyseInstructions(List<Instruction> instructionVector);
}
