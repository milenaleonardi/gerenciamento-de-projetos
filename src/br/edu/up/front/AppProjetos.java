package br.edu.up.front;

import br.edu.up.entidades.*;
import br.edu.up.persistencia.EquipeDAO;
import br.edu.up.persistencia.MembroDAO;
import br.edu.up.persistencia.ProjetoDAO;
import br.edu.up.persistencia.TarefaDAO;

import java.util.List;

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
            opc = Console.readInt("Digite sua opção: ");
            
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
        Equipe equipe = null;
        Tarefa tarefa = null;
        String op;
        
        projeto = new Projeto();
        projeto.setNome(Console.readString("\n\nNome do projeto: "));
        if(ProjetoDAO.procurarProjeto(projeto) == null) {
        	equipe = new Equipe();
        	equipe.setNome(Console.readString("Digite o nome da equipe: "));
        	equipe = EquipeDAO.procurarEquipe(equipe);
        	if(equipe != null) {
        		projeto.setEquipe(equipe);
        		System.out.println("Equipe: " + projeto.getEquipe().getNome());
        		do {
	        		tarefa = new Tarefa();
	        		tarefa.setNome(Console.readString("Digite o nome da tarefa: "));
	        		tarefa = TarefaDAO.procurarTarefa(tarefa);
	        		if(tarefa != null) {
						projeto.getTarefas().add(tarefa);
					}
					else {
						System.out.println("\n\nTarefa não cadastrada...");
					}
					op = Console.readString("Adicionar outra tarefa? ");
				} while(op == "S" || op == "s" || op == "sim");
        		if ( TarefaDAO.adicionarTarefa(tarefa)) {
        			System.out.println("\n\nTarefa adicionada...");
				}
				else {
					System.out.println("\n\nNão foi possível adicionar a tarefa....");
				}
        	}
	        		
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
            System.out.println("Equipe: " + projeto.getEquipe().getNome());
			System.out.println("Lista de tarefas ---> ");
			for(Tarefa tarefa: projeto.getTarefas()) {
				System.out.println("     Tarefa: " + tarefa.getNome());
			}
			System.out.println("----------------------------------------");
		}
		else {
			System.out.println("\n\nProjeto não cadastrado...");
		}
    }
    
    private static void excluirProjeto() {
    	System.out.println("\n\n*** EXCLUSÃO DE PROJETO ***");
        projeto = new Projeto();
        projeto.setNome(Console.readString("Informe o nome: "));
        projeto = ProjetoDAO.procurarProjeto(projeto);
        if (projeto != null) {
            System.out.println("----------------------------");
            System.out.println("ID: " + projeto.getId());
            System.out.println("Nome: " + projeto.getNome());
            System.out.println("Equipe: " + projeto.getEquipe().getNome());
			System.out.println("Lista de tarefas ---> ");
			for(Tarefa tarefa: projeto.getTarefas()) {
				System.out.println("     Tarefa: " + tarefa.getNome());
			}
        
            String op = Console.readString("Deseja excluir o projeto? ");
            if (op == "S" || op == "s" || op == "sim") {
                if (ProjetoDAO.excluirProjeto(projeto)) {
                    System.out.println("O projeto foi excluído.");
                } else {
                    System.out.println("O projeto não foi excluído.");
                }
                
            } else {
            	System.out.println("Projeto não cadastrada.");
         	}
        }
    }
}
