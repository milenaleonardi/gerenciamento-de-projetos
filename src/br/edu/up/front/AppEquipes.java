package br.edu.up.front;

import br.edu.up.entidades.Equipe;
import br.edu.up.entidades.Membro;
import br.edu.up.entidades.Projeto;
import br.edu.up.persistencia.EquipeDAO;
import br.edu.up.persistencia.MembroDAO;
import br.edu.up.persistencia.ProjetoDAO;

import java.util.List;

public class AppEquipes {
    public AppEquipes() {
        Equipe equipe = null;
        int opc;
        do {
            System.out.println("\n");
            System.out.println("*** EQUIPES ***");
            System.out.println("1 - Inserir nova equipe");
            System.out.println("2 - Consultar equipe");
            System.out.println("3 - Alterar equipe");
            System.out.println("4 - Excluir equipe");
            System.out.println("5 - Voltar");
            opc = Console.readInt("Digite sua opção: ");
            switch (opc) {
                case 1:
//                    equipe = new Equipe();
//                    Projeto projeto = new Projeto();
//                    Membro membro = new Membro();
//
//                    System.out.println("\n\n*** INCLUSÃO DE EQUIPE ***");
//                    equipe.setNome(Console.readString("Nome: "));
//                    equipe.setSetor(Console.readString("Setor: "));
//
//                    String projetoNome = (Console.readString("Projeto: "));
//                    projeto = ProjetoDAO.getProjetos(projetoNome);
//                    if (projeto != null) {
//                        equipe.setProjeto(projeto);
//                    } else {
//                        System.out.println("Projeto não encontrado");
//                        break;
//                    }
//
//                    String membroNome = (Console.readString("Membro: "));
//                    membro = MembroDAO.getMembros(membroNome);
//                    if (membro != null) {
//                        equipe.setMembros(MembroDAO.getMembros(membro));
//                    } else {
//                        System.out.println("Membro não encontrado.");
//                        break;
//                    }
//                    EquipeDAO.adicionarEquipe(equipe);
//                    break;
                case 2:
                    System.out.println("\n\n*** LISTAGEM DE EQUIPE ***");
                    equipe = new Equipe();
                    equipe.setNome(Console.readString("Informe o nome da equipe que deseja listar: "));
                    List<Equipe> equipes = EquipeDAO.getEquipe(equipe);
                    if (!equipes.isEmpty()) {
                        System.out.println("----------------------------");
                        for (Equipe x : equipes) {
                            System.out.println("Nome: " + x.getNome());
                            System.out.println("Cargo: " + x.getSetor());
                            System.out.println("Projeto: " + x.getProjeto().getNome());
                            System.out.println("Membros: " + x.getMembros().toString());
                        }
                    } else {
                        System.out.println("Equipe(s) não encontrada(s).");
                    }
                    break;
                case 3:
//                    equipe = new Equipe();
//                    System.out.println("*** ALTERAÇÃO DE EQUIPE ***");
//                    equipe.setNome(Console.readString("Nome: "));
//                    equipe.setSetor(Console.readString("Setor: "));
//                    String projetoNomeAlterar = Console.readString("Projeto: ");
//                    equipe.setProjeto(ProjetoDAO.getProjetos(projetoNomeAlterar));
//                    String membroNomeAlterar = Console.readString("Membros: ");
//                    equipe.getMembros().add(MembroDAO.getMembros(membroNomeAlterar));
//                    EquipeDAO.alterarEquipe(equipe);
//                    break;
                case 4:
                    System.out.println("\n\n*** EXCLUSÃO DE EQUIPE ***");
                    Equipe objEquipe = new Equipe();
                    equipe.setNome(Console.readString("Informe o nome: "));
                    equipe = EquipeDAO.procurarEquipe(objEquipe);
                    if (equipe != null) {
                        System.out.println("----------------------------");
                        System.out.println("Nome: " + equipe.getNome());
                        System.out.println("Setor: " + equipe.getSetor());
                        System.out.println("Projeto: " + equipe.getProjeto().getNome());
                        System.out.println("Membros: " + equipe.getMembros().toString());

                        char op = Console.readChar("Deseja excluir a equipe? ");
                        if (op == 'S' || op == 's') {
                            if (EquipeDAO.excluirEquipe(equipe)) {
                                System.out.println("A equipe foi excluída.");
                            } else {
                                System.out.println("A equipe não foi excluída.");
                            }
                        }
                    } else
                        System.out.println("Equipe não cadastrada.");
                    break;
            }

        }while (opc != 5) ;
    }

}