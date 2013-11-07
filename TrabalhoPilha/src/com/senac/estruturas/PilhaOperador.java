package com.senac.estruturas;
import com.senac.estruturas.PilhaCheia;
import com.senac.estruturas.PilhaVazia;

public class PilhaOperador {

	private String[] dados;
	private int   topo;
	
	// recebe o tamanho do vetor
	public PilhaOperador (int tam)
	{
		// instancia o vetor de acordo com o tamanho
		dados = new String[tam];
		topo = 0;
	}

	public String peek () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		return dados[topo - 1]; 
	}

	public void push (String valor) throws PilhaCheia
	{
		// verifica se a pilha está cheia
		// se estiver dispara a exceção de pilha cheia
		if (isFull())
			throw new PilhaCheia();
		
		// senão, adiciona o valor no topo
		dados[topo] = valor;		
		System.out.println("Adicionou na pilha ["+ topo +"] = " + dados[topo]);

		// posteriormente incrementa o valor de topo
		topo++;

	}
	
	public String pop () throws PilhaVazia
	{
		// verifica se a pilha está vazia
		// caso estiver, dispara a exceção
		if (isEmpty())
			throw new PilhaVazia();
		
		// decrementar o valor de topo
		topo--;
		
		System.out.println("Retirou da pilha [" + dados[topo] + "] = Topo: " + topo);
		
		// retorna o valor do elemento
		return dados[topo];
	}
	
	public boolean isFull() {
		return topo == dados.length;
	}

	public boolean isEmpty() {
		return topo == 0;
	}
}
