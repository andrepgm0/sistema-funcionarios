package com.andre.sistemafuncionarios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.andre.sistemafuncionarios.connection.Conexao;


public class FuncionarioDAO {

    public void cadastrarFuncionario(Scanner entrada) throws SQLException {


        System.out.print("Informe o nome do funcionário: ");
        String nome = entrada.nextLine();

        System.out.print("Informe o CPF do funcionário: ");
        String cpf = entrada.nextLine();

        System.out.print("Informe o email do funcionário: ");
        String email = entrada.nextLine();

        System.out.print("Informe o cargo do funcionário: ");
        String cargo = entrada.nextLine();

        System.out.print("Informe o salário do funcionário: ");
        double salario = entrada.nextDouble();
        entrada.nextLine();

        String sql = "INSERT INTO funcionario (nome, cpf, email, cargo, salario) VALUES (?, ?, ?, ?, ?)";

        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, nome);
        stmt.setString(2, cpf);
        stmt.setString(3, email);
        stmt.setString(4, cargo);
        stmt.setDouble(5, salario);

        stmt.executeUpdate();

        System.out.println("\nFuncionário adicionado com sucesso!");

        stmt.close();
        conexao.close();

    }
    
    public void atualizarFuncionario(Scanner entrada) throws SQLException {


	    System.out.print("Informe o ID do funcionário: ");
	    int id = entrada.nextInt();
	    entrada.nextLine();

	    String select = "SELECT id, nome FROM funcionario WHERE id = ?";
	    String update = "UPDATE funcionario SET nome = ? WHERE id = ?";

	    Connection conexao = Conexao.conectar();

	    PreparedStatement stmt = conexao.prepareStatement(select);
	    stmt.setInt(1, id);

	    ResultSet r = stmt.executeQuery();

	    if (r.next()) {

	        Funcionario funcionario = new Funcionario(r.getInt(1), r.getString(2));

	        System.out.println("O nome atual é: " + funcionario.getNome());

	        entrada.nextLine();

	        System.out.print("Informe o novo nome: ");
	        String novoNome = entrada.nextLine();

	        stmt.close();

	        stmt = conexao.prepareStatement(update);

	        stmt.setString(1, novoNome);
	        stmt.setInt(2, id);

	        stmt.executeUpdate();

	        System.out.println("Funcionário alterado com sucesso!");

	    } else {

	        System.out.println("Funcionário não encontrado.");

	    }

	    r.close();
	    stmt.close();
	    conexao.close();

	}
    
    public void excluirFuncionario(Scanner entrada) throws SQLException {


	    System.out.print("Informe o ID do funcionário: ");
	    int id = entrada.nextInt();
	    entrada.nextLine();

	    Connection conexao = Conexao.conectar();

	    String sql = "DELETE FROM funcionario WHERE id = ?";

	    PreparedStatement stmt = conexao.prepareStatement(sql);

	    stmt.setInt(1, id);

	    if (stmt.executeUpdate() > 0) {

	        System.out.println("Funcionário excluído com sucesso!");

	    } else {

	        System.out.println("Funcionário não encontrado!");

	    }

	    stmt.close();
	    conexao.close();
	}
    
    public void listarFuncionarios() throws SQLException {

	    Connection conexao = Conexao.conectar();

	    String sql = "SELECT * FROM funcionario";

	    Statement stmt = conexao.createStatement();

	    ResultSet resultado = stmt.executeQuery(sql);

	    List<Funcionario> funcionarios = new ArrayList<>();

	    while (resultado.next()) {

	        int id = resultado.getInt("id");
	        String nome = resultado.getString("nome");
	        String cpf = resultado.getString("cpf");
	        String email = resultado.getString("email");
	        String cargo = resultado.getString("cargo");
	        double salario = resultado.getDouble("salario");

	        funcionarios.add(new Funcionario(id, nome, cpf, email, cargo, salario));

	    }

	    for (Funcionario funcionario : funcionarios) {

	        System.out.println(
	                funcionario.getId() + " | "
	                + funcionario.getNome() + " | "
	                + funcionario.getCpf() + " | "
	                + funcionario.getEmail() + " | "
	                + funcionario.getCargo() + " | R$ "
	                + funcionario.getSalario());

	    }

	    resultado.close();
	    stmt.close();
	    conexao.close();

	}
}