package com.andre.sistemafuncionarios.main;

import com.andre.sistemafuncionarios.dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

		   public static void main(String[] args) {

		        Scanner entrada = new Scanner(System.in);
		        FuncionarioDAO dao = new FuncionarioDAO();

		        int opcao;

		        do {

		            System.out.println("\n==============================");
		            System.out.println("  SISTEMA DE FUNCIONÁRIOS");
		            System.out.println("==============================");
		            System.out.println("1 - Cadastrar funcionário");
		            System.out.println("2 - Listar funcionários");
		            System.out.println("3 - Atualizar funcionário");
		            System.out.println("4 - Excluir funcionário");
		            System.out.println("0 - Sair");
		            System.out.print("Escolha uma opção: ");

		            opcao = entrada.nextInt();
		            entrada.nextLine();

		            try {

		                switch (opcao) {

		                case 1:
		                    dao.cadastrarFuncionario(entrada);
		                    break;

		                case 2:
		                	System.out.println("\n ===== FUNCIONÁRIOS CADASTRADOS ===== \n");
		                    dao.listarFuncionarios();
		                    break;

		                case 3:
		                    dao.atualizarFuncionario(entrada);
		                    break;

		                case 4:
		                    dao.excluirFuncionario(entrada);
		                    break;

		                case 0:
		                    System.out.println("Encerrando o sistema...");
		                    break;

		                default:
		                    System.out.println("Opção inválida!");
		                }

		            } catch (SQLException e) {
		                System.out.println("Erro: " + e.getMessage());
		            }

		        } while (opcao != 0);

		        entrada.close();

		    }
	
		}