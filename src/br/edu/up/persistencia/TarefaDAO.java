package br.edu.up.persistencia;

import br.edu.up.entidades.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TarefaDAO {
    public static boolean adicionarTarefa(Tarefa tarefa) {
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(tarefa);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static List<Tarefa> getTarefas(Tarefa tarefa){
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Tarefa where nome like :param");
        consulta.setParameter("param", "%" + tarefa.getNome() + "%");
        List<Tarefa> tarefas = consulta.getResultList();
        return tarefas;
    }
    public static boolean alterarTarefa(Tarefa tarefa){
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(tarefa);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static boolean excluirTarefa(Tarefa tarefa){
        try{
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(tarefa);
            manager.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static Tarefa procurarTarefa(Tarefa tarefa){
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Tarefa where nome = :paramNome");
        consulta.setParameter("paramNome", tarefa.getNome());
        List<Tarefa> tarefas = consulta.getResultList();
        if(tarefas.isEmpty()){
            return tarefas.get(0);
        }
        return null;
    }
}
