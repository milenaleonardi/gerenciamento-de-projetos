package br.edu.up.front;

import br.edu.up.entidades.*;
import br.edu.up.persistencia.TarefaDAO;


    public class AppTarefas {

    	static Tarefa tarefa = null;
    	
        public AppTarefas() {

            int opc;
            do {
                System.out.println("\n\n");
                System.out.println("*** TAREFAS ***");
                System.out.println("1 - Nova tarefa");
                System.out.println("2 - Consultar tarefa");
                System.out.println("3 - Excluir tarefa");
                System.out.println("4 - Voltar");
                opc = Console.readInt("Digite sua opção: ");
                switch (opc) {
                    case 1:
                        incluirTarefa();
                        break;
                    case 2:
                        consultarTarefa();
                        break;
                    case 3:
                        excluirTarefa();
                        break;
                }

            }while (opc != 4);
        }
        
        private static void incluirTarefa() {
        	System.out.println("\n\n*** CADASTRAR NOVA TAREFA ***");
        	tarefa = new Tarefa();
            tarefa.setNome(Console.readString("\n\nNome da tarefa: "));
            if(TarefaDAO.procurarTarefa(tarefa) == null) {
                tarefa.setDescricao(Console.readString("Descrição: "));
                TarefaDAO.adicionarTarefa(tarefa);
                System.out.println("\n\nCadastro bem sucedido...");
			}
			else {
				System.out.println("\n\nTarefa já cadastrada...");
			}
		}
            
        
        private static void consultarTarefa() {
        	System.out.println("\n\n*** CONSULTAR TAREFAS ***");
            tarefa = new Tarefa();
            tarefa.setNome(Console.readString("Informe o nome da tarefa que deseja listar: "));
            tarefa = TarefaDAO.procurarTarefa(tarefa);
            if (tarefa != null) {
                System.out.println("----------------------------");
                System.out.println("ID: " + tarefa.getId());
                System.out.println("Nome: " + tarefa.getNome());
                System.out.println("Descrição: " + tarefa.getDescricao());
                }
            else {
                System.out.println("Tarefa(s) não encontrada(s).");
            }
        }
        
        
        private static void excluirTarefa() {
        	System.out.println("\n\n*** EXCLUSÃO DE TAREFA ***");
            tarefa = new Tarefa();
            tarefa.setNome(Console.readString("Informe o nome: "));
            tarefa = TarefaDAO.procurarTarefa(tarefa);
            if (tarefa != null) {
                System.out.println("\n\n----------------------------");
                System.out.println("ID: " + tarefa.getId());
                System.out.println("Nome: " + tarefa.getNome());
                System.out.println("Descrição: " + tarefa.getDescricao());
                System.out.println("----------------------------");

                char op = Console.readChar("Confirma a exclusão da tarefa? ");
                if (op == 'S' || op == 's') {
                    if (TarefaDAO.excluirTarefa(tarefa)) {
                        System.out.println("A tarefa foi excluída.");
                    } else {
                        System.out.println("A tarefa não foi excluída.");
                    }
                }
            } else
                System.out.println("Tarefa não cadastrada.");
        }

 }