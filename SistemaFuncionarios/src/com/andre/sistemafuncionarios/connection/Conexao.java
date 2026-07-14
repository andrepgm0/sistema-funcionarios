package com.andre.sistemafuncionarios.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String url = "jdbc:mysql://localhost:3306/funcionario_db";
	private static final String usuario = "andre";
	private static final String senha = "testesql123@";
	
	public static Connection conectar() {
		
		try {
			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			
			System.out.println("Erro ao conectar com o banco");
			e.printStackTrace();
			return null;
		}
	}
}
