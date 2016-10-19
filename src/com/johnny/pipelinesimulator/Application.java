package com.johnny.pipelinesimulator;

import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.johnny.pipelinesimulator.Strategy.Functions;
import com.johnny.pipelinesimulator.Strategy.Instruction;
/**
 * Classe principal
 * @author Johnnylee
 *
 */
public class Application {
	
	public static void main(String[] args) {
		Functions f = new Functions();
		// TODO Auto-generated method stub
		String fileName = "";
		List<Instruction> instructionVector = null;
		
		JFileChooser fileChooser = new JFileChooser();
		File selectedFile = null;
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    selectedFile = fileChooser.getSelectedFile();
		    JOptionPane.showMessageDialog(null, "Selected file: " + selectedFile.getAbsolutePath());
		}
		instructionVector = f.readFile(selectedFile.getAbsolutePath());
		if( instructionVector == null){
			JOptionPane.showMessageDialog(null, "ERROR: File not found or Empty");
			System.exit(0);
		}
		
		JOptionPane.showMessageDialog(null, "Generating Pipeline...");
		
		f.analyseInstructions( instructionVector );
	}

}
