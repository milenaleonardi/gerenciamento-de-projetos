package br.edu.up.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany
    private List<Tarefa> tarefas;
    @OneToOne
    private Equipe equipe;

    public Projeto() {
    }

    public Projeto(int id, String nome, List<Tarefa> tarefas, Equipe equipe) {
        this.id = id;
        this.nome = nome;
        this.tarefas = tarefas;
        this.equipe = equipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}

