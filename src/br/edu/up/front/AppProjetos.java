package br.edu.up.front;

import br.edu.up.entidades.*;
import br.edu.up.persistencia.EquipeDAO;
import br.edu.up.persistencia.ProjetoDAO;
import br.edu.up.persistencia.TarefaDAO;

import java.util.List;

public class AppProjetos {
    public AppProjetos() {
        Projeto projeto = null;
        int opc;
        do {
            System.out.println("\n");
            System.out.println("*** PROJETOS ***");
            System.out.println("1 - Inserir novo projeto");
            System.out.println("2 - Consultar projeto");
            System.out.println("3 - Alterar projeto");
            System.out.println("4 - Excluir projeto");
            System.out.println("5 - Voltar");
            opc = Console.readInt("Digite sua opção: ");
            switch (opc) {
                case 1:
//                    projeto = new Projeto();
//                    Tarefa tarefa = new Tarefa();
//                    Equipe equipe = new Equipe();
//
//                    System.out.println("\n\n*** INCLUSÃO DE PROJETO ***");
//                    projeto.setNome(Console.readString("Nome: "));
//
//                    String tarefaNome = (Console.readString("Tarefa: "));
//                    tarefa = TarefaDAO.getTarefas(tarefaNome);
//                    if (tarefa != null) {
//                        projeto.setTarefas(tarefa);
//                    } else {
//                        System.out.println("Tarefa não encontrado");
//                        break;
//                    }
//
//                    String equipeNome = (Console.readString("Equipe: "));
//                    equipe = EquipeDAO.getEquipe(equipeNome);
//                    if (equipe != null) {
//                        projeto.setEquipe(equipe);
//                    } else {
//                        System.out.println("Equipe não encontrada");
//                        break;
//                    }
//
//                    ProjetoDAO.adicionarProjeto(projeto);
//                    break;
                case 2:
                    System.out.println("\n\n*** LISTAGEM DE PROJETO ***");
                    projeto = new Projeto();
                    projeto.setNome(Console.readString("Informe o nome do projeto que deseja listar: "));
                    List<Projeto> projetos = ProjetoDAO.getProjetos(projeto);
                    if (!projetos.isEmpty()) {
                        System.out.println("----------------------------");
                        for (Projeto x : projetos) {
                            System.out.println("Nome: " + x.getNome());
                            System.out.println("Equipe: " + x.getEquipe().getNome());
                            System.out.println("Tarefas: " + x.getTarefas().toString());
                        }
                    } else {
                        System.out.println("Projeto(s) não encontrado(s).");
                    }
                    break;
                case 3:
//                    projeto = new Projeto();
//                    System.out.println("*** ALTERAÇÃO DE PROJETO ***");
//                    projeto.setNome(Console.readString("Nome: "));
//                    String projetoNomeAlterar = Console.readString("Equipe: ");
//                    projeto.setEquipe(EquipeDAO.getEquipe(projetoNomeAlterar));
//                    String projetoNomeAlterar = Console.readString("Tarefa: ");
//                    projeto.setTarefas(TarefaDAO.getTarefas(projetoNomeAlterar));
//
//                    planejamento.setDataInicio(Console.readString("Data Inicio: "));
//                    planejamento.setDataFim(Console.readString("Data Fim: "));
//                    planejamento.setStatus(Console.readString("Status: "));
//                    ProjetoDAO.alterarProjeto(projeto);
//                    break;
                case 4:
                    System.out.println("\n\n*** EXCLUSÃO DE PROJETO ***");
                    Projeto objProjeto = new Projeto();
                    projeto.setNome(Console.readString("Informe o nome: "));
                    projeto = ProjetoDAO.procurarProjeto(objProjeto);
                    if (projeto != null) {
                        System.out.println("----------------------------");
                        System.out.println("Nome: " + projeto.getNome());
                        System.out.println("Equipe: " + projeto.getEquipe().getNome());
                        System.out.println("Tarefas: " + projeto.getTarefas().toString());

                        char op = Console.readChar("Deseja excluir o projeto? ");
                        if (op == 'S' || op == 's') {
                            if (ProjetoDAO.excluirProjeto(projeto)) {
                                System.out.println("O projeto foi excluídao.");
                            } else {
                                System.out.println("O projeto não foi excluído.");
                            }
                        }
                    } else
                        System.out.println("Objeto não cadastrada.");
            }
        } while (opc != 5);
    }
}

