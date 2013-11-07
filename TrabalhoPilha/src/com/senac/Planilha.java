package com.senac;

import static java.lang.System.out;

import java.util.Scanner;

import com.senac.algoritmos.AvaliadorArimetico;
import com.senac.algoritmos.AvaliadorRPN;


public class Planilha {
	public static void main(String[] args) throws Exception {
		
		Scanner dados = new Scanner(System.in);

		System.out.println("Digite a express�o:");
		String leitura = dados.nextLine();
				
		System.out.println("RESULTADO DA EXPRESS�O: " + AvaliadorRPN.avalia(AvaliadorArimetico.ConverteRPN(leitura)));
		
				
	}
}
