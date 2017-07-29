/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author crisley
 */
@Entity
@Table(name = "Corretor")
public class Corretor extends Pessoa implements Serializable{
    
    @Column(name = "nomeUsuario")
    @NotNull(message = "O nome de usuário não pode ser nulo")
    @NotBlank(message = "O nome de usuário não pode ficar em branco")
    private String nomeUsuario;
    
    @Column(name = "password")
    @NotNull(message = "O password não pode ser nulo")
    @NotBlank(message = "O password não pode ficar em branco")
    private String password;
    
    @Column(name = "percentualComissao", columnDefinition = "numeric(10,2)")
    @NotNull(message = "O password não pode ser nulo")
    private Double percentualComissao;
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    
    
}
