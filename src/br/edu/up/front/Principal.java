package br.edu.up.front;

public class Principal {
    public static void main(String[] args) {
        int opc;
        do {
            System.out.println("\n");
            System.out.println("**** GERENCIAMENTO DE PROJETOS ****");
            System.out.println("1 - Membros");
            System.out.println("2 - Equipes");
            System.out.println("3 - Projetos");
            System.out.println("4 - Tarefas");
            System.out.println("5 - Sair");
            opc = Console.readInt("Digite sua opção: ");

            switch (opc) {
                case 1:
                    new AppMembros();
                    break;
                case 2:
                    new AppEquipes();
                    break;
                case 3:
                    new AppProjetos();
                    break;
                case 4:
                    new AppTarefas();
                    break;
            }

        } while (opc != 5);
    }
}
