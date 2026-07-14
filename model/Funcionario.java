package com.andre.sistemafuncionarios.model;

public class Funcionario {

	private int id;
	private String nome;
	private String cargo;
	private String cpf;
	private double salario;
	private String email;
	
	public Funcionario (int id, String nome, String cpf, 
			String email, String cargo, double salario) {
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.cpf = cpf;
		this.salario = salario;
		this.email = email;
		
	}
	
	public Funcionario(int id, String nome) {
	    this.id = id;
	    this.nome = nome;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
