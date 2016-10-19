package com.johnny.pipelinesimulator.Interface;

import java.util.List;

import com.johnny.pipelinesimulator.Strategy.Instruction;

public interface IFunctions {
	/**
	 * Leitura e construção da lista de instruções para a função
	 * @param fileName Caminho e nome do arquivo retornado a partir de um seletor de arquivos.
	 * @return List<Instruction> result Lista de instruções
	 */
	List<Instruction> readFile(String fileName);
	
	/**
	 * Analisa a lista de instruções e imprime o pipeline de acordo com as regras de conflitos na execução de instruções.
	 * @param instructionVector coleção de instruções
	 */
	void analyseInstructions(List<Instruction> instructionVector);
}
