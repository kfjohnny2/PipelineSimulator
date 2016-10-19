package com.johnny.pipelinesimulator.Strategy;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.JOptionPane;

import com.johnny.pipelinesimulator.Interface.IFunctions;

/**
 * Classe de implementação dos métodos da interface de funções do simulador de pipeline
 * @author Johnnylee
 *
 */
public class Functions implements IFunctions {

	/**
	 * Coleção de Instruções global para armazenamento das mesmas
	 */
	private List<Instruction> result = new ArrayList<Instruction>();
	
	/**
	 * Fila de string para controle dos operandos da função
	 */
	private List<String> operators = new ArrayList<>();
	
	@Override
	public List<Instruction> readFile(String fileName) {
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(fileName);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				if(!strLine.isEmpty()){
					Instruction temporary = new Instruction(strLine);
					result.add(temporary);
				}
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			System.exit(0);
		}
		return result;
	}

	@Override
	public void analyseInstructions(List<Instruction> instructionVector) {
		// TODO Auto-generated method stub
		int t = 0;
		
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < instructionVector.size(); ) {
			if(i == 0){
				s.append(String.valueOf(i+1)).append(". [ ][ ][ ][ ][ ] - \n");
				operators.add(instructionVector.get(i).getDest());
				instructionVector.get(i).print();
				i++;
				t++;
			} else{
				if( t >= 4) operators.remove(operators.lastIndexOf(operators)+1);
	            if( operators.equals(instructionVector.get(i).getOp1()) || operators.equals(result.get(i).getOp2()) ){
	                operators.add("empty");
	                t++;
	            }
	            else{
	                for (int j = 0; j < t; j++)
	                    s.append("   ");
	                s.append(String.valueOf(i+1)).append( ". [ ][ ][ ][ ][ ] - \n");
	                operators.add( instructionVector.get(i).getDest() );
	                instructionVector.get(i).print();
	                i++;
	                t++;
	            }
			}
		}
		JOptionPane.showMessageDialog(null, s);
		
		if(t < 5) t=4;
		
		while(!operators.isEmpty()){
			operators.remove(operators.lastIndexOf(operators)+1);
			t++;
		}
		
		JOptionPane.showMessageDialog(null, "TOTAL CICLES: " + t);
	}

}
