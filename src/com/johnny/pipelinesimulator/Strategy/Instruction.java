package com.johnny.pipelinesimulator.Strategy;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.johnny.pipelinesimulator.Interface.IInstructions;

/**
 * Classe de implementa��o de instru��es
 * @author Johnnylee
 *
 */
public class Instruction implements IInstructions{
	private String name;
	private String dest;
	private String op1;
	private String op2;
	
	/**
	 * Construtor da classe monta toda a classe aplicando as regras de pipeline com 5 ciclos fazendo todas as verifica��es (carecendo de Jumps)
	 * @param instLine
	 */
	public Instruction(String instLine) {
		this.name = "devoid";
		this.dest = "devoid";
		this.op1 = "devoid";
		this.op2 = "devoid";
		
		String aux = "";
		ArrayList<String> tokenized = new ArrayList<>();
//		for(int i = 1; i <= instLine.length()-1; i++){
		for (int i = 0; i < instLine.length()-1; i++) {
			if(instLine.charAt(i) == ' ' || instLine.charAt(i) == ','){
				continue;
			} else{
				while(instLine.charAt(i) != ' ' 
						&& instLine.charAt(i) != ','  
						&& i < instLine.length()-1){
					aux += String.valueOf(instLine.charAt(i++));
				}
				tokenized.add(aux);
				aux = "";
			}
		}
		
		if(tokenized.get(0).equals("addi") || tokenized.get(0).equals("subi")){
			if(tokenized.size() < 3){
				JOptionPane.showMessageDialog(null, "Invalid instruction format for " + tokenized.get(0).toString() + "\n");
			} else{
				name = tokenized.get(0);
				dest = tokenized.get(1);
				op1 = tokenized.get(2);
			}
		}else if(tokenized.get(0).equals("add") || tokenized.get(0).equals("sub") || tokenized.get(0).equals("and") 
				|| tokenized.get(0).equals("and") || tokenized.get(0).equals("or") || tokenized.get(0).equals("slt")){
			if(tokenized.size() < 4){
				JOptionPane.showMessageDialog(null, "Invalid instruction format for " + tokenized.get(0).toString() + "\n");
			} else{
				name = tokenized.get(0);
				dest = tokenized.get(1);
				op1 = tokenized.get(2);
				op2 = tokenized.get(3);
			}
		} else if(tokenized.get(0).equals("ori") || tokenized.get(0).equals("sll") || tokenized.get(0).equals("slr")){
			if(tokenized.size() < 3){
				JOptionPane.showMessageDialog(null, "Invalid instruction format for " + tokenized.get(0).toString() + "\n");
			} else{
				name = tokenized.get(0);
				dest = tokenized.get(1);
				op1 = tokenized.get(2);
			}
		} else if (tokenized.get(0).equals("lw") || tokenized.get(0).equals("sw")){
			if(tokenized.size() < 3){
				JOptionPane.showMessageDialog(null, "Invalid instruction format for " + tokenized.get(0).toString() + "\n");
			} else{
				String valor1 = "";
				String valor2 = "";
				int j = 0;
				
				while(tokenized.get(2).charAt(j) != '(' && j < tokenized.get(2).length()-1){
					valor1 += tokenized.get(2).charAt(j++);
				}
				
				j++;
				
				while(tokenized.get(2).charAt(j) != ')' && j < tokenized.get(2).length()-1){
					valor2 += tokenized.get(2).charAt(j++);
				}
				
				if(tokenized.get(0).equals("lw")){
					name = tokenized.get(0);
					dest = tokenized.get(1);
					op1 = valor2;
				} else{
					name = tokenized.get(0);
					op1 = tokenized.get(1);
					dest = valor2;
				}
			}
		} else if(tokenized.get(0).equals("beq") || tokenized.get(0).equals("bne")){
			if(tokenized.size() < 4){
				JOptionPane.showMessageDialog(null, "Invalid instruction format for " + tokenized.get(0).toString() + "\n");
			} else{
				name = tokenized.get(0);
				dest = tokenized.get(1);
				op1 = tokenized.get(3);
			}
		} else if(tokenized.get(0).equals("mfhi") || tokenized.get(0).equals("mflo")){
			if(tokenized.size()<2){
				JOptionPane.showMessageDialog(null, "Invalid instruction format for " + tokenized.get(0).toString() + "\n");
			} else{
				name = tokenized.get(0);
	            dest = tokenized.get(1);
			}
		} else if (tokenized.get(0).equals("div") ||  tokenized.get(0).equals("mult") || tokenized.get(0).equals("mul")) {
	        if(tokenized.size() < 3)
	        {
				JOptionPane.showMessageDialog(null, "Invalid instruction format for " + tokenized.get(0).toString() + "\n");
	        }
	        else
	        {
	            name = tokenized.get(0);
	            dest = "lo";
	            op1 = tokenized.get(1);
	            op2 = tokenized.get(2);
	        }
		}else if (tokenized.get(0).equals("j")) {
			if (tokenized.size() < 2) {
				JOptionPane.showMessageDialog(null, "Invalid instruction format for " + tokenized.get(0).toString() + "\n");
			} else {
				name = tokenized.get(0);
			}
		} else if(tokenized.get(0).equals("syscall")){
			if(tokenized.size() < 1){
				JOptionPane.showMessageDialog(null, "Invalid instruction format for " + tokenized.get(0).toString() + "\n");
			} else{
				name = tokenized.get(0);
				dest = "$v0";
				op1 = "$v0";
				op2 = "$a0";
			}
		}else{
			if(tokenized.size() < 4){
				JOptionPane.showMessageDialog(null, "Invalid instruction format for " + tokenized.get(0).toString() + "\n");
			} else{
	            name = tokenized.get(0);
	            dest = tokenized.get(1);
	            op1 = tokenized.get(2);
	            op2 = tokenized.get(3);
			}
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getDest() {
		// TODO Auto-generated method stub
		return dest;
	}

	@Override
	public String getOp1() {
		// TODO Auto-generated method stub
		return op1;
	}

	@Override
	public String getOp2() {
		// TODO Auto-generated method stub
		return op2;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		StringBuilder s = new StringBuilder();
		s.append("[").append(name).append(" ").append(dest).append(" ")
        .append(op1).append(" " ).append(op2).append("]" ).append("\n");
		JOptionPane.showMessageDialog(null, s);
	}

}
