package br.edu.up.front;

import br.edu.up.entidades.Membro;
import br.edu.up.persistencia.MembroDAO;

import java.util.List;

public class AppMembros {

    public AppMembros() {
        Membro membro = null;
        int opc;
        do {
            System.out.println("\n");
            System.out.println("*** MEMBROS ***");
            System.out.println("1 - Inserir novos membros");
            System.out.println("2 - Consultar membros");
            System.out.println("3 - Alterar membros");
            System.out.println("4 - Excluir membros");
            System.out.println("5 - Voltar");
            opc = Console.readInt("Digite sua opção: ");
            switch (opc) {
                case 1:
                    membro = new Membro();
                    System.out.println("\n\n*** INCLUSÃO DE MEMBRO ***");
                    membro.setNome(Console.readString("Nome: "));
                    membro.setCargo(Console.readString("Cargo: "));
                    membro.setTelefone(Console.readString("Telefone: "));
                    membro.setEmail(Console.readString("Email: "));
                    MembroDAO.adicionarMembro(membro);
                    break;
                case 2:
                    System.out.println("\n\n*** LISTAGEM DE MEMBROS ***");
                    membro = new Membro();
                    membro.setNome(Console.readString("Informe uma parte do nome que deseja listar: "));
                    List<Membro> membros = MembroDAO.getMembros(membro);
                    if (!membros.isEmpty()) {
                        System.out.println("----------------------------");
                        for (Membro x : membros) {
                        	System.out.println("Nome: " + x.getNome());
                        	System.out.println("Cargo: " + x.getCargo());
                        	System.out.println("Telefone: " + x.getTelefone());
                        	System.out.println("Email: " + x.getEmail());
                        }
                    } else {
                        System.out.println("Membro(s) não encontrado(s).");
                    }
                    break;
                case 3:
                    membro = new Membro();
                    System.out.println("*** ALTERAÇÃO DE CADASTRO ***");
                    membro.setNome(Console.readString("Nome: "));
                    membro.setCargo(Console.readString("Cargo: "));
                    membro.setTelefone(Console.readString("Telefone: "));
                    membro.setEmail(Console.readString("Email: "));
                    MembroDAO.alterarMembro(membro);
                    break;
                case 4:
                    System.out.println("\n\n*** EXCLUSÃO DE CADASTRO ***");
                    Membro objMembro = new Membro();
                    membro.setNome(Console.readString("Informe o nome: "));
                    membro = MembroDAO.procurarMembro(objMembro);
                    if (membro != null) {
                        System.out.println("----------------------------");
                        System.out.println("Nome: " + membro.getNome());
                        System.out.println("Cargo: " + membro.getCargo());
                        System.out.println("Telefone: " + membro.getTelefone());
                        System.out.println("Email: " + membro.getEmail());

                        char op = Console.readChar("Deseja excluir o membro? ");
                        if (op == 'S' || op == 's') {
                            if (MembroDAO.excluirMembro(membro)) {
                                System.out.println("O membro foi excluído.");
                            } else {
                                System.out.println("O membro não foi excluído.");
                            }
                        }
                    } else
                        System.out.println("Membro não cadastrado.");
            }
        } while (opc != 5);
    }

}
