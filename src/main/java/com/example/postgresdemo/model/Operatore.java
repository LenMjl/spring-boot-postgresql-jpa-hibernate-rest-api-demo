package com.example.postgresdemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Entity che rappresenta l'operatore.
 */
@Entity
@Table(name = "operatore")
public class Operatore {

    /**
     * Identificativo univoco dell'operatore.
     */
    @Id
    @Column(name = "id_operatore")
    private Integer idOperatore;

    /**
     * Nome dell'operatore, campo obbligatorio e massimo 20 caratteri.
     */
    @NotBlank
    @Size(max = 20)
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    /**
     * Email dell'operatore, massimo 50 caratteri.
     */
    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    /**
     * Password dell'operatore, massimo 200 caratteri.
     */
    @Size(max = 200)
    @Column(name = "password", length = 200)
    private String password;

    // Getter e Setter

    public Integer getIdOperatore() {
        return idOperatore;
    }

    public void setIdOperatore(Integer idOperatore) {
        this.idOperatore = idOperatore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
