package br.edu.up.persistencia;

import br.edu.up.entidades.Membro;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MembroDAO {
    public static boolean adicionarMembro(Membro membro) {
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(membro);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static List<Membro> getMembros(Membro membro){
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Membro where nome like :param");
        consulta.setParameter("param", "%" + membro.getNome() + "%");
        List<Membro> membros = consulta.getResultList();
        return membros;
    }
    public static boolean alterarMembro(Membro membro){
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(membro);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static boolean excluirMembro(Membro membro){
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(membro);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static Membro procurarMembro(Membro membro){
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Membro where nome = :paramNome");
        consulta.setParameter("paramNome", membro.getNome());
        List<Membro> membros = consulta.getResultList();
        if(membros.isEmpty()){
            return membros.get(0);
        }
        return null;
    }
}
