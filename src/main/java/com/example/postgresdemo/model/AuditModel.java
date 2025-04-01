package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe astratta che fornisce funzionalità di audit (creazione e aggiornamento) per le entità.
 * La classe gestisce automaticamente i timestamp di creazione e modifica di un'entità.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public abstract class AuditModel implements Serializable {

    /**
     * Data e ora di creazione dell'entità.
     * Questo campo non può essere aggiornato dopo la creazione.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    /**
     * Data e ora dell'ultimo aggiornamento dell'entità.
     * Questo campo viene aggiornato automaticamente ogni volta che l'entità viene modificata.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    /**
     * Restituisce la data di creazione dell'entità.
     *
     * @return La data di creazione.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Imposta la data di creazione dell'entità.
     *
     * @param createdAt La data di creazione da impostare.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Restituisce la data dell'ultimo aggiornamento dell'entità.
     *
     * @return La data dell'ultimo aggiornamento.
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Imposta la data dell'ultimo aggiornamento dell'entità.
     *
     * @param updatedAt La data dell'ultimo aggiornamento da impostare.
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
