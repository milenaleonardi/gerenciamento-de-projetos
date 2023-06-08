package br.edu.up.front;

import br.edu.up.entidades.*;
import br.edu.up.persistencia.ProjetoDAO;

public class AppProjetos {
	
	static Projeto projeto = null;
	
	public AppProjetos() {
        
        int opc;
        do {
            System.out.println("\n");
            System.out.println("*** PROJETOS ***");
            System.out.println("1 - Novo projeto");
            System.out.println("2 - Consultar projeto");
            System.out.println("3 - Excluir projeto");
            System.out.println("4 - Voltar");
            opc = Console.readInt("Digite sua opcao: ");
            
            switch (opc) {
                case 1:
                    incluirProjeto();
                    break;
                case 2:
                    consultarProjeto();
                    break;
                case 3:
                    excluirProjeto();
                    break;
            } 
           } while (opc != 4);
    }
    
    private static void incluirProjeto() {
    	System.out.println("\n\n*** CADASTRAR PROJETO ***");
        Tarefa tarefa = null;
        String op;
        
        projeto = new Projeto();
        projeto.setNome(Console.readString("\n\nNome do projeto: "));
        if(ProjetoDAO.procurarProjeto(projeto) == null) {
        		do {
        			tarefa = new Tarefa();
                    tarefa.setNome(Console.readString("\n\nNome da tarefa: "));
                    tarefa.setDescricao(Console.readString("\nDescricao: "));
                    projeto.getTarefas().add(tarefa);
					op = Console.readString("Adicionar outra tarefa? ");
				} while (op.equals("S") || op.equals("s") || op.equals("sim"));
        		if(ProjetoDAO.adicionarProjeto(projeto) == true) {
        			System.out.println("Projeto cadastrado com sucesso.");
        		} else {
        			System.out.println("Projeto nao foi cadastrado.");
        		}
        	} else {
        		System.out.println("Projeto ja cadastrado.");
        	}
       	}
    
    private static void consultarProjeto() {
    	System.out.println("\n\n*** CONSULTA DE PROJETO ***");
        projeto = new Projeto();
        projeto.setNome(Console.readString("Informe o nome do projeto que deseja consultar: "));
        projeto = ProjetoDAO.procurarProjeto(projeto);
        if (projeto != null) {
            System.out.println("----------------------------");
            System.out.println("ID: " + projeto.getId());
            System.out.println("Nome: " + projeto.getNome());
			System.out.println("Lista de tarefas ---> ");
			for(Tarefa tarefa: projeto.getTarefas()) {
				System.out.println("     Tarefa: " + tarefa.toString());
			}
			System.out.println("----------------------------------------");
		}
		else {
			System.out.println("\n\nProjeto nao cadastrado...");
		}
    }
    
    private static void excluirProjeto() {
    	System.out.println("\n\n*** EXCLUSAO DE PROJETO ***");
        projeto = new Projeto();
        projeto.setNome(Console.readString("Informe o nome: "));
        projeto = ProjetoDAO.procurarProjeto(projeto);
        if (projeto != null) {
            System.out.println("----------------------------");
            System.out.println("ID: " + projeto.getId());
            System.out.println("Nome: " + projeto.getNome());
			System.out.println("Lista de tarefas ---> ");
			for(Tarefa tarefa: projeto.getTarefas()) {
				System.out.println("     Tarefa: " + tarefa.toString());
			}
        
            String op = Console.readString("Deseja excluir o projeto? ");
            if (op == "S" || op == "s" || op == "sim") {
                if (ProjetoDAO.excluirProjeto(projeto)) {
                    System.out.println("O projeto foi excluido com sucesso.");
                } else {
                    System.out.println("O projeto nao foi excluido.");
                }
                
            } else {
            	System.out.println("Projeto nao cadastrado.");
         	}
        }
    }
}
