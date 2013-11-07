package com.senac.algoritmos;

import java.util.Scanner;

import com.senac.estruturas.PilhaCheia;
import com.senac.estruturas.PilhaOperador;
import com.senac.estruturas.PilhaVazia;


public class AvaliadorArimetico {
	
	public static String ConverteRPN (String expressao) throws PilhaCheia, PilhaVazia, InvalidOperator
	{	
		
		PilhaOperador pilha = new PilhaOperador(50);
		String saida = "";
		//int indiceSaida = 0;
		
		Scanner sc = new Scanner(expressao);
		int prioridade;
		// enquanto tiver dados de entrada da leitura, continua no laço
		while (sc.hasNext()) {
			// verifica se o valor é inteiro
			if (sc.hasNextInt()) {
				saida += " " + String.format("%d", sc.nextInt());
				
			} 
			// se não for inteiro, é sinal que é um operador
			else {
				String entrada = sc.next();
				
				if (entrada.equals(")")){
					String op;
					op = pilha.pop();
										
					while (!op.equals("("))
					{
						saida += " " + op;
						op = pilha.pop();
					}
						
				}
				else {
					try {
						if (pilha.isEmpty() || pilha.peek().equals("(") || prioridade(entrada) > prioridade(pilha.peek())   )
							pilha.push(entrada);

						
						else {
							String op;
							op = pilha.pop();
							
							while ( !pilha.isEmpty() && !pilha.peek().equals("(") && prioridade(entrada) <= prioridade(pilha.peek()))
							{
								op = pilha.pop();
								saida += " " + op;
							}
							pilha.push(entrada);
						}
					} catch (Exception e) {
						
						e.printStackTrace();
					}								
				}	
			}
			System.out.println("---------");
		}
		
		while (!pilha.isEmpty())
		{
			String op = pilha.pop();
		//	if (!op.equals("("))
				saida += " " + op;
			
		}
		// retorna o valor que está no topo
		// que é o resultado correspondente a operação total
		return saida;
					
	}

	private static double executaOperador(char op, double lhs, double rhs) throws InvalidOperator
	{
		// analisar qual o operador e qual a operação deve ser feita
		switch (op) {
			case '+': return lhs + rhs;
			case '-': return lhs - rhs;
			case '*': return lhs * rhs;
			case '/': return lhs / rhs;
			default: throw new InvalidOperator(op);
		}
	}
	
	private static Scanner teclado = new Scanner(System.in);
	
	private static int prioridade(String op)
			throws Exception{
				switch(op.charAt(0)){
					case '+': return 1;
					case '-': return 1;
					case '*': return 2;
					case '/': return 2;
					case '(': return 3;
					
				}
				throw new Exception("operador invalido");
			}	
	

}
