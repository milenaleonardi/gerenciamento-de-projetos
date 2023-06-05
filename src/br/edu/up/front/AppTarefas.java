package br.edu.up.front;

import br.edu.up.entidades.*;
import br.edu.up.persistencia.TarefaDAO;

import java.util.List;

    public class AppTarefas {
        public AppTarefas() {

            Tarefa tarefa = null;
            int opc;
            do {
                System.out.println("\n");
                System.out.println("*** TAREFAS ***");
                System.out.println("1 - Inserir nova tarefa");
                System.out.println("2 - Consultar tarefa");
                System.out.println("3 - Alterar tarefa");
                System.out.println("4 - Excluir tarefa");
                System.out.println("5 - Voltar");
                opc = Console.readInt("Digite sua opção: ");
                switch (opc) {
                    case 1:
                        tarefa = new Tarefa();

                        System.out.println("\n\n*** INCLUSÃO DE TAREFA ***");
                        tarefa.setNome(Console.readString("Nome: "));
                        tarefa.setDescricao(Console.readString("Descrição: "));

                        TarefaDAO.adicionarTarefa(tarefa);
                        break;
                    case 2:
                        System.out.println("\n\n*** LISTAGEM DE TAREFAS ***");
                        tarefa = new Tarefa();
                        tarefa.setNome(Console.readString("Informe o nome da tarefa que deseja listar: "));
                        List<Tarefa> tarefas = TarefaDAO.getTarefas(tarefa);
                        if (!tarefas.isEmpty()) {
                            System.out.println("----------------------------");
                            for (Tarefa x : tarefas) {
                                System.out.println("Nome: " + x.getNome());
                                System.out.println("Descrição: " + x.getDescricao());
                            }
                        } else {
                            System.out.println("Tarefa(s) não encontrada(s).");
                        }
                        break;
                    case 3:
                        tarefa = new Tarefa();

                        System.out.println("*** ALTERAÇÃO DE TAREFA ***");
                        tarefa.setNome(Console.readString("Nome: "));
                        tarefa.setDescricao(Console.readString("Descrição: "));

                        TarefaDAO.alterarTarefa(tarefa);
                        break;
                    case 4:
                        System.out.println("\n\n*** EXCLUSÃO DE TAREFA ***");
                        Tarefa objTarefa = new Tarefa();
                        objTarefa.setNome(Console.readString("Informe o nome: "));
                        tarefa = TarefaDAO.procurarTarefa(objTarefa);
                        if (tarefa != null) {
                            System.out.println("----------------------------");
                            System.out.println("Nome: " + tarefa.getNome());
                            System.out.println("Descrição: " + tarefa.getDescricao());

                            char op = Console.readChar("Deseja excluir a tarefa? ");
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

            }while (opc != 5);

        }

        }