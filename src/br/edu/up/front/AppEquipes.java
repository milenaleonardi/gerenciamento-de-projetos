package br.edu.up.front;

import br.edu.up.entidades.Equipe;
import br.edu.up.entidades.Membro;
import br.edu.up.entidades.Projeto;
import br.edu.up.persistencia.EquipeDAO;
import br.edu.up.persistencia.MembroDAO;
import br.edu.up.persistencia.ProjetoDAO;


public class AppEquipes {

    static Equipe equipe = null;
	
    public AppEquipes() {
        int opc;
        do {
            System.out.println("\n\n");
            System.out.println("*** EQUIPES ***");
            System.out.println("1 - Nova equipe");
            System.out.println("2 - Consultar equipe");
            System.out.println("3 - Excluir equipe");
            System.out.println("4 - Voltar");
            opc = Console.readInt("Digite sua opção: ");
            switch (opc) {
                case 1:
                	incluirEquipe();
                    break;
                case 2:
                    consultarEquipe();
                    break;
                case 3:
                    excluirEquipe();
                    break;
            }

        }while (opc != 4) ;
    }
    
    private static void incluirEquipe() {
    	System.out.println("\n\n*** CADASTRAR NOVA EQUIPE ***");
        Projeto projeto = null;
        Membro membro = null;
        String op;
        
        equipe = new Equipe();
        equipe.setNome(Console.readString("\n\nNome da equipe: "));
        if(EquipeDAO.procurarEquipe(equipe) == null) {
        	projeto = new Projeto();
        	projeto.setNome(Console.readString("Digite o nome do projeto: "));
        	projeto = ProjetoDAO.procurarProjeto(projeto);
        	if(projeto != null) {
        		equipe.setProjeto(projeto);
        		System.out.println("Projeto --> ");
        		System.out.println("     ID: " + projeto.getId());
        		System.out.println("     Nome: " + projeto.getNome());
        		do {
	        		membro = new Membro();
	        		membro.setNome(Console.readString("Digite o nome do membro: "));
	        		membro = MembroDAO.procurarMembro(membro);
	        		if(membro != null) {
						equipe.getMembros().add(membro);
					}
					else {
						System.out.println("\n\nMembro não cadastrado...");
					}
					op = Console.readString("Mais ítens? ");
				} while(op == "S" || op == "s" || op == "sim");
        		if ( EquipeDAO.adicionarEquipe(equipe)) {
        			System.out.println("\n\nEquipe adicionada...");
				}
				else {
					System.out.println("\n\nNão foi possível adicionar a equipe....");
				}
        	}
	        		
       	}
     }

    private static void consultarEquipe() {
    	System.out.println("\n\n*** CONSULTA DE EQUIPE ***");
        equipe = new Equipe();
        equipe.setNome(Console.readString("Informe o nome da equipe que deseja consultar: "));
        equipe = EquipeDAO.procurarEquipe(equipe);
        if (equipe != null) {
            System.out.println("----------------------------");
            System.out.println("ID: " + equipe.getId());
            System.out.println("Nome: " + equipe.getNome());
            System.out.println("Setor: " + equipe.getSetor());
            System.out.println("Projeto: " + equipe.getProjeto().getNome());
			System.out.println("----------------------------------------");
			System.out.println("Membros ---> ");
			for(Membro membro: equipe.getMembros()) {
				System.out.println("     Nome: " + membro.getNome());
			}
			System.out.println("----------------------------------------");
		}
		else {
			System.out.println("\n\nEquipe não cadastrada...");
		}
	}
    
    private static void excluirEquipe() {
    	System.out.println("\n\n*** EXCLUSÃO DE EQUIPE ***");
        equipe = new Equipe();
        equipe.setNome(Console.readString("Informe o nome: "));
        equipe = EquipeDAO.procurarEquipe(equipe);
        if (equipe != null) {
            System.out.println("----------------------------");
            System.out.println("Nome: " + equipe.getNome());
            System.out.println("Setor: " + equipe.getSetor());
            System.out.println("Projeto: " + equipe.getProjeto().getNome());
            System.out.println("Membros ---> ");
			for(Membro membro: equipe.getMembros()) {
				System.out.println("     Nome: " + membro.getNome());
			}

            String op = Console.readString("Deseja excluir a equipe? ");
            if (op == "S" || op == "s" || op == "sim") {
                if (EquipeDAO.excluirEquipe(equipe)) {
                    System.out.println("A equipe foi excluída.");
                } else {
                    System.out.println("A equipe não foi excluída.");
                }
            }
        } else
            System.out.println("Equipe não cadastrada.");
    }
}