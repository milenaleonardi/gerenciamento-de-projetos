package br.edu.up.persistencia;

import br.edu.up.entidades.Equipe;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EquipeDAO {
    public static boolean adicionarEquipe(Equipe equipe) {
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(equipe);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static List<Equipe> getEquipe(Equipe equipe){
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Equipe where nome like :param");
        consulta.setParameter("param", "%" + equipe.getNome() + "%");
        List<Equipe> equipes = consulta.getResultList();
        return equipes;
    }
    public static boolean alterarEquipe(Equipe equipe){
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(equipe);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static boolean excluirEquipe(Equipe equipe){
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(equipe);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static Equipe procurarEquipe(Equipe equipe){
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Membro where nome = :paramNome");
        consulta.setParameter("paramNome", equipe.getNome());
        List<Equipe> equipes = consulta.getResultList();
        if(equipes.isEmpty()){
            return equipes.get(0);
        }
        return null;
    }
}
