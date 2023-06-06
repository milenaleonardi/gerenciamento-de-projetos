package br.edu.up.front;

import br.edu.up.entidades.Membro;
import br.edu.up.persistencia.MembroDAO;

import java.util.List;

public class AppMembros {
	
	static Membro membro = null;
	
    public AppMembros() {
        
        int opc;
        do {
            System.out.println("\n\n");
            System.out.println("*** MEMBROS ***");
            System.out.println("1 - Novo membro");
            System.out.println("2 - Consultar membro");
            System.out.println("3 - Excluir membro");
            System.out.println("4 - Voltar");
            opc = Console.readInt("Digite sua opção: ");
            switch (opc) {
                case 1:
                    incluirMembro();
                    break;
                case 2:
                    consultarMembro();
                    break;
                case 3:
                    excluirMembro();
                    break;
            }
        } while (opc != 4);
    }
    
    private static void incluirMembro() {
    	System.out.println("\n\n*** CADASTRAR NOVO MEMBRO ***");
    	membro = new Membro();
        membro.setNome(Console.readString("\n\nNome: "));
        if(MembroDAO.procurarMembro(membro) == null) {
	        membro.setCargo(Console.readString("Cargo: "));
	        membro.setTelefone(Console.readString("Telefone: "));
	        membro.setEmail(Console.readString("Email: "));
	        MembroDAO.adicionarMembro(membro);
	        System.out.println("\n\nCadastro bem sucedido!");
		}
		else {
			System.out.println("\n\nMembro já cadastrado.");
		}
	}
	        

    private static void consultarMembro() {
    	System.out.println("\n\n*** CONSULTA DE MEMBROS ***");
        membro = new Membro();
        membro.setNome(Console.readString("Informe o nome que deseja consultar: "));
        membro = MembroDAO.procurarMembro(membro);
        if (membro != null) {
            System.out.println("\n\n----------------------------");
            System.out.println("ID: " + membro.getId());
            System.out.println("Nome: " + membro.getNome());
           	System.out.println("Cargo: " + membro.getCargo());
           	System.out.println("Telefone: " + membro.getTelefone());
           	System.out.println("Email: " + membro.getEmail());
        } else {
            System.out.println("Membro não encontrado.");
        }
    }
    
    private static void excluirMembro() {
    	System.out.println("\n\n*** EXCLUIR CADASTRO DE MEMBRO ***");
        membro = new Membro();
        membro.setNome(Console.readString("Informe o nome: "));
        membro = MembroDAO.procurarMembro(membro);
        if (membro != null) {
            System.out.println("----------------------------");
            System.out.println("ID: " + membro.getId());
            System.out.println("Nome: " + membro.getNome());
            System.out.println("Cargo: " + membro.getCargo());
            System.out.println("Telefone: " + membro.getTelefone());
            System.out.println("Email: " + membro.getEmail());
            System.out.println("----------------------------");

            char op = Console.readChar("\n\nConfirma a exclusão do membro? ");
            if (op == 'S' || op == 's') {
                if (MembroDAO.excluirMembro(membro)) {
                    System.out.println("\n\nO membro foi excluído.");
                } else {
                    System.out.println("\n\nO membro não foi excluído.");
                }
            }
        } else
            System.out.println("\n\nMembro não encontrado.");
    }
}
