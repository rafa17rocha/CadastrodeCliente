package br.usjt.arqsis.cadastrodecliente;

import com.orm.SugarRecord;

public class Cliente extends SugarRecord<Cliente>
{
	private String nome;
	private int idade;
	private String cpf;
	private String telefone;

	public Cliente()
	{
	}

	public Cliente(String nome, int idade, String cpf, String telefone)
	{
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public int getIdade()
	{
		return idade;
	}

	public void setIdade(int idade)
	{
		this.idade = idade;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
}
