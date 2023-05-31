package br.edu.up.entidades;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Planejamento {
    private Date dataInicio;
    private Date dataFim;
    private String status;

    public Planejamento() {
    }

    public Planejamento(Date dataInicio, Date dataFim, String status) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
