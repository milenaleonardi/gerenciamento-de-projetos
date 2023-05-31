package br.edu.up.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String setor;
    @OneToOne
    private Projeto projeto;
    @OneToMany
    private List<Membro> membros;

    public Equipe() {
    }

    public Equipe(int id, String nome, String setor, Projeto projeto, List<Membro> membros) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.projeto = projeto;
        this.membros = membros;
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }
}
