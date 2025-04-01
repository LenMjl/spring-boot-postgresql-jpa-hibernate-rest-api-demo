package com.example.postgresdemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Entity che rappresenta un gruppo di ticket.
 */
@Entity
@Table(name = "ticketgroup")
public class TicketGroup {

    /**
     * Identificativo univoco del ticket.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer idTicket;


    /**
     * Tempo di apertura del ticket, campo obbligatorio.
     */
    @NotNull
    @Column(name = "t_open", nullable = false)
    private Integer tOpen;

    /**
     * Tempo di chiusura del ticket.
     */
    @Column(name = "t_close")
    private Integer tClose;

    /**
     * Saldo iniziale.
     */
    @Column(name = "saldo_i")
    private Integer saldoI;

    /**
     * Data del ticket.
     */
    @Column(name = "data")
    private LocalDate data;

    /**
     * Operatore associato al ticket.
     */
    @ManyToOne
    @JoinColumn(name = "id_operatore", referencedColumnName = "id_operatore")
    private Operatore operatore;

    /**
     * Numero del gruppo.
     */
    @Column(name = "ngruppo")
    private Integer nGruppo;

    /**
     * Numero del referente.
     */
    @Column(name = "nreferente")
    private Integer nReferente;

    // Getter e Setter

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getTOpen() {
        return tOpen;
    }

    public void setTOpen(Integer tOpen) {
        this.tOpen = tOpen;
    }

    public Integer getTClose() {
        return tClose;
    }

    public void setTClose(Integer tClose) {
        this.tClose = tClose;
    }

    public Integer getSaldoI() {
        return saldoI;
    }

    public void setSaldoI(Integer saldoI) {
        this.saldoI = saldoI;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Operatore getOperatore() {
        return operatore;
    }

    public void setOperatore(Operatore operatore) {
        this.operatore = operatore;
    }

    public Integer getNGruppo() {
        return nGruppo;
    }

    public void setNGruppo(Integer nGruppo) {
        this.nGruppo = nGruppo;
    }

    public Integer getNReferente() {
        return nReferente;
    }

    public void setNReferente(Integer nReferente) {
        this.nReferente = nReferente;
    }
}
