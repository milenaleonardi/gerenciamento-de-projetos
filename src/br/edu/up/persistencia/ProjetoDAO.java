package br.edu.up.persistencia;

import br.edu.up.entidades.Membro;
import br.edu.up.entidades.Projeto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProjetoDAO {
    public static boolean adicionarProjeto(Projeto projeto) {
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(projeto);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static List<Projeto> getProjetos(Projeto projeto){
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Projeto where nome like :param");
        consulta.setParameter("param", "%" + projeto.getNome() + "%");
        List<Projeto> projetos = consulta.getResultList();
        return projetos;
    }


    public static boolean alterarProjeto(Projeto projeto){
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(projeto);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static boolean excluirProjeto(Projeto projeto){
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(projeto);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static Projeto procurarProjeto(Projeto projeto){
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Projeto where nome = :paramNome");
        consulta.setParameter("paramNome", projeto.getNome());
        List<Projeto> projetos = consulta.getResultList();
        if(projetos.isEmpty()){
            return projetos.get(0);
        }
        return null;
    }

}
